package itcast.javaUtils.auto;
import itcast.javaUtils.JdbcUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;

import java.sql.PreparedStatement;
public class InsertDemo {
	Connection conn=null;
	PreparedStatement stmt=null;
	ResultSet rs=null;
	public void GetAutoIncrement(){
		String sql="insert into student2 (name,gender) values (?,?);";
		try {
			conn=JdbcUtils.getConnection();
			stmt=(PreparedStatement) conn.prepareStatement(sql);
			stmt.setString(1, "�߽���");
			stmt.setString(2, "��ʦ");
			stmt.executeUpdate(); 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			JdbcUtils.close(null,stmt,(com.mysql.jdbc.Connection) conn);
		}
	}
	@Test
	public void GetAutoIncrement2(){
		String sql="insert into student2 (name,gender) values (?,?);";
		try {
			conn=JdbcUtils.getConnection();
			//����ָ�������������С�
			stmt=(PreparedStatement) conn.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
			stmt.setString(1, "�ݼ�");
			stmt.setString(2, "Ů");
			stmt.executeUpdate();
			//��ִ����Ϻ󣬷�����������
			ResultSet rs=stmt.getGeneratedKeys();
			while(rs.next()){
				System.out.println("�ղŲ�����������"+rs.getInt(1));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JdbcUtils.close(rs,stmt,conn);
		}
	}
}
