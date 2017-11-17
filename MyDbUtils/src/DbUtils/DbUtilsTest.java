package DbUtils;
import DbUtils.DbUtils;
import Entity.Admin;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import JDBCUtils.JDBCUtils;

public class DbUtilsTest {
	public static void main(String[] args) throws Exception {
		
	}
	public void testGetBykey() throws Exception{
		Connection conn=JDBCUtils.getConnection();
		DbUtils dbutils=new DbUtils(conn);
		Object admin = dbutils.getBykey(Admin.class,"where username='curry'");
	}
	public void testInsert() throws Exception{
		Connection conn=JDBCUtils.getConnection();
		DbUtils dbutils=new DbUtils(conn);
		Admin admin=new Admin();
		admin.setUserName("456");
		admin.setPwd("123");
		System.out.println(dbutils.insert(admin));
	}
	public void testUpdate() throws Exception{
		Connection conn=JDBCUtils.getConnection();
		DbUtils dbutils=new DbUtils(conn);
		
	}
	public void testGetAll() throws Exception{
		Connection conn=JDBCUtils.getConnection();
		DbUtils dbutils=new DbUtils(conn);
		List<Object> list = dbutils.getAll(Admin.class);
		for (Object object : list) {
			System.out.println(object);
		}
	}
	public void testDel() throws Exception{
		Connection conn=JDBCUtils.getConnection();
		DbUtils dbutils=new DbUtils(conn);
		System.out.println(dbutils.delByKey(Admin.class, 80));
	}
}
