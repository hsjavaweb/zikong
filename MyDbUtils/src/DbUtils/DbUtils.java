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
		Object obj=null;//����type��ʵ��
		Field[] fields = type.getFields();//��ȡ�ֶ�
		Method[] methods = type.getMethods();	//��ȡ������
		String tableName = type.getSimpleName();	//��ȡ����
		for(int i=0;i<fields.length;i++){
			//������ȡ 
			fields[i].setAccessible(true);
			//��ȡÿ���ֶε�����
			String fieldsName=fields[i].getName();
			sb.append(fieldsName+",");
		}
		String sql="select * from "+tableName+" "+where;// ƴ�ӳ�SQL���
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while(rs.next()){
			obj=type.newInstance();
			for(Method method :methods){//��������ķ���
				String methodName=method.getName();
				if(methodName.startsWith("set")){//���������������set��ͷ
					//��ȡ�ֶ����� 
					String columName=methodName.substring(3, methodName.length());
					//�õ������Ĳ�������
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
	//ͨ������ʹ��get�����õ������ֵ
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
	// ִ��SQL���
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
			for(Method method :methods){//��������ķ���
				String methodName=method.getName();
				if(methodName.startsWith("set")){//���������������set��ͷ
					//��ȡ�ֶ����� 
					String columName=methodName.substring(3, methodName.length());
					//�õ������Ĳ�������
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
