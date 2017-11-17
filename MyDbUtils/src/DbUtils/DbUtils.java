package DbUtils;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import Entity.Admin;
public class DbUtils {
	private static Connection conn;
	public DbUtils(Connection conn){
		this.conn=conn;
	}
	public DbUtils(){
	}
	public static Object getBykey(Class type,String where){
		StringBuilder sb=new StringBuilder();
		Object obj=null;//构造type的实例
		Field[] fields = type.getFields();//获取字段
		Method[] methods = type.getMethods();	//获取方法名
		String tableName = type.getSimpleName();	//获取表名
		for(int i=0;i<fields.length;i++){
			//暴力读取 
			fields[i].setAccessible(true);
			//获取每个字段的名称
			String fieldsName=fields[i].getName();
			sb.append(fieldsName+",");
		}
		String sql="select * from "+tableName+" "+where;// 拼接成SQL语句
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while(rs.next()){
			obj=type.newInstance();
			for(Method method :methods){//遍历对象的方法
				String methodName=method.getName();
				if(methodName.startsWith("set")){//如果方法里面是以set开头
					//获取字段名称 
					String columName=methodName.substring(3, methodName.length());
					//得到方法的参数类型
					Class[] parameterTypes = method.getParameterTypes();
					if(parameterTypes[0]==String.class){
						method.invoke(obj,rs.getString(columName));
					}
					if(parameterTypes[0]==int.class){
						method.invoke(obj,rs.getInt(columName));
					}
				}
			}
		}
		
		}catch (Exception e) {
			e.printStackTrace();
		}
		return obj; 	
	}
	
	public boolean insert(Object type) throws Exception{
	Class<? extends Object> clazz = type.getClass();
	StringBuilder sb = new StringBuilder();
	StringBuffer sb2=new StringBuffer();
	String fieldsName=null;
	Object obj =null;
	Field[] fields = clazz.getDeclaredFields();
	for(int i=0;i<fields.length;i++){
		sb.append(fields[i].getName()+",");
	}
	String sb1 = sb.substring(0, sb.length()-1);
	//String sql="insert into "+clazz.getSimpleName()+" ("+sb1+") where   ";
	//通过放射使用get方法得到对象的值
	Method[] methods = clazz.getDeclaredMethods();
	for(Method m:methods){ 
		obj=clazz.newInstance();
		String methodName = m.getName();
		if(methodName.startsWith("get")){
			//String columName=methodName.substring(3, methodName.length());
			m.setAccessible(true);
			sb2.append("'"+m.invoke(type)+"'"+",");
		}
	}
	String objValue=sb2.substring(0, sb2.length()-1);
	String sql="insert into "+clazz.getSimpleName()+" ("+sb1+") values ("+objValue+");";
	// 执行SQL语句
	PreparedStatement ps = conn.prepareStatement(sql);
	boolean flag = ps.execute();
	return !flag;
	}
	
	public boolean update(Object type){
		Class<? extends Object> clazz = type.getClass();
		StringBuilder sb = new StringBuilder();
		String fieldsName=null;
		Object obj =null;
		Field[] fields = clazz.getDeclaredFields();
		for(int i=0;i<fields.length;i++){
			sb.append(fields[i].getName()+",");
		}
		String sb1 = sb.substring(0, sb.length()-1);
		String sql="update "+clazz.getSimpleName()+"";
		return false;
	}
	
	public List<Object> getAll(Class type){	
		Field[] fields = type.getFields();
		Method[] methods = type.getDeclaredMethods();
		List<Object> list = new ArrayList<Object>();
		Object obj = null;
		String sql = "select * from "+type.getSimpleName();
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while(rs.next()){
			obj=type.newInstance();
			for(Method method :methods){//遍历对象的方法
				String methodName=method.getName();
				if(methodName.startsWith("set")){//如果方法里面是以set开头
					//获取字段名称 
					String columName=methodName.substring(3, methodName.length());
					//得到方法的参数类型
					Class[] parameterTypes = method.getParameterTypes();
					if(parameterTypes[0]==String.class){
						method.invoke(obj,rs.getString(columName));
					}
					if(parameterTypes[0]==int.class){
						method.invoke(obj,rs.getInt(columName));
					}
				}
			}
			list.add(obj);
		}
	}catch (Exception e) {			
			e.printStackTrace();
		}
		return list;
	}
	public boolean delByKey(Class type, Integer id) throws Exception {
        String sql= "delete from " +type.getSimpleName()+" where id="+id;
        PreparedStatement ps = conn.prepareStatement(sql);
		return ps.execute();
    }
}
