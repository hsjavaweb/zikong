package Dao;

import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import Entity.Employee;
import Utils.JDBCUtils;
import Utils.PageBean;

public class EmployeeDao implements IEmployeeDao {

	@Override
	public void getAll(PageBean<Employee> pb) {
		//2.��ѯ�ܼ�¼�������õ�PB������
		int totalCount=this.getTotalCount();
		pb.setTotalCount(totalCount);
		if(pb.getCurrentPage()<=0){
			pb.setCurrentPage(1);
		}else if(pb.getCurrentPage()>pb.getTotalCount()){
			pb.setCurrentPage(pb.getCurrentPage());
			//�ѵ�ǰҳ����Ϊ���ҳ��
		}
		//1.��ȡ��ǰҳ��
		// �Ͱ���ѯ����ʼ��,���ص����� 
		int currentPage=pb.getCurrentPage();
		int index=(currentPage-1)*pb.getPageCount();
		int count = pb.getPageCount();	
		String sql="select * from employee limit ?,?";
		try {
			QueryRunner qr=JDBCUtils.getQueryRuner();
			List<Employee> pageData=qr.query(sql,new BeanListHandler<Employee>(Employee.class),index,count);
			pb.setPageData(pageData);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
	}

	@Override
	public int getTotalCount() {
		String sql="select count(*) from employee";
		try {
			QueryRunner qr = JDBCUtils.getQueryRuner();
			Long count=qr.query(sql,new ScalarHandler<Long>());
			return count.intValue();
		} catch (Exception e) {
			throw new RuntimeException();
		}
	}

}
