package Utils;

import javax.sql.DataSource;

import org.apache.commons.dbutils.QueryRunner;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class JDBCUtils {
	/**
	 * 1.��ʼ��C3p0���ӳ�
	 */
	private static DataSource dataSource;
	static{
		dataSource=new ComboPooledDataSource();
	}
	/**
	 * ����queryRunner���󣬴������ӳض���
	 * �ڴ���queryrunner�����ʱ���������������Դ����
	 * ��ô��ʹ��queryRunner���󷽷���ʱ�򣬾Ͳ���Ҫ�������Ӷ���
	 * ���Զ�������Դ�л�ȡ���ӣ������ر����ӣ�
	 * @return
	 */
	public static QueryRunner getQueryRuner(){
		return new QueryRunner(dataSource);
	}
}
