package Dao;

import Entity.Employee;
import Utils.PageBean;

public interface IEmployeeDao {
	/**
	 *分页查询数据 
	 */
	public void getAll(PageBean<Employee> pb);
	/**
	 * 记录总记录数
	 */
	public int getTotalCount();
}
