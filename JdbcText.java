package e_longtext;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.io.Reader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import org.junit.Test;
import itcast.JdbcUtil;
public class App_blob {
	private Connection con;
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	

	@Test
	// 1. �������������� 
	public void testSaveText() {
		String sql = "insert into test(img) values(?)";
		try {
			// ����
			con = JdbcUtil.getConnection();
			// pstmt ����
			pstmt = con.prepareStatement(sql);
			// ��ȡͼƬ��
			InputStream in = App_text.class.getResourceAsStream("nini.jpg");
			pstmt.setBinaryStream(1, in);
			
			// ִ�б���ͼƬ
			pstmt.execute();
			
			// �ر�
			in.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.closeAll(con, pstmt, null);
		}
	}
	
	@Test
	// 2. ��ȡ���ı���������   ( ��longblob)
	public void testGetAsText() {
		String sql = "select img from  test where id=2;";
		try {
			// ����
			con = JdbcUtil.getConnection();
			// pstmt ����
			pstmt = con.prepareStatement(sql);
			// ��ȡ
			rs = pstmt.executeQuery();
			if (rs.next()) {
				// ��ȡͼƬ��
				InputStream in = rs.getBinaryStream("img");
				// ͼƬ�����
				FileOutputStream out = new FileOutputStream(new File("D://ǰ��//ǰ����վ//images:nini.jpg"));
				int len = -1;
				byte b[] = new byte[1024];
				while ((len = in.read(b)) != -1) {
					out.write(b, 0, len);
				}
				// �ر�
				out.close();
				in.close();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.closeAll(con, pstmt, null);
		}
	}
}
