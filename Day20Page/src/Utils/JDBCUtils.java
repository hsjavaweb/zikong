package Utils;

import javax.sql.DataSource;

import org.apache.commons.dbutils.QueryRunner;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class JDBCUtils {
	/**
	 * 1.初始化C3p0连接池
	 */
	private static DataSource dataSource;
	static{
		dataSource=new ComboPooledDataSource();
	}
	/**
	 * 创建queryRunner对象，传入连接池对象
	 * 在创建queryrunner对象的时候，如果传入了数据源对象
	 * 那么在使用queryRunner对象方法的时候，就不需要传入连接对象
	 * 会自动从数据源中获取连接（不急关闭连接）
	 * @return
	 */
	public static QueryRunner getQueryRuner(){
		return new QueryRunner(dataSource);
	}
}
