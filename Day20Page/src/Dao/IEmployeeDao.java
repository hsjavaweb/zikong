package Dao;

import Entity.Employee;
import Utils.PageBean;

public interface IEmployeeDao {
	/**
	 *��ҳ��ѯ���� 
	 */
	public void getAll(PageBean<Employee> pb);
	/**
	 * ��¼�ܼ�¼��
	 */
	public int getTotalCount();
}
