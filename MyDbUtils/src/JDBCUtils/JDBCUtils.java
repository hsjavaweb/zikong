package JDBCUtils;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;
public class JDBCUtils {
	private static String url="jdbc:mysql://localhost:3306/php_one"; 
	private static String user="root";                               
	private static String password="948520";                         
	private JDBCUtils(){
	}
	static {
		try{
			Class.forName("com.mysql.jdbc.Driver");
		}catch(ClassNotFoundException e){
			throw new ExceptionInInitializerError(e);
		}
	}
	public static Connection getConnection() throws SQLException{
		return (Connection) DriverManager.getConnection(url, user, password);
		
	}
	public static void close(ResultSet rs,Statement st,Connection conn){
		try{                                  
			if(rs!=null){                     
				 rs.close();                  
			}                    
		}catch (SQLException e){
			e.printStackTrace();
		}
		finally{                             
			try{                              
				if(conn!=null){               
					conn.close();             
				}                             
			}
			catch (SQLException e){
				e.printStackTrace();
			}finally{                          
				if(st!=null)           
					try{
						st.close();    
					}catch(SQLException e){
						e.printStackTrace();
					}                          
			}                                 
		}                                     
		                                      
	}
}