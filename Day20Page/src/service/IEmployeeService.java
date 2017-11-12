package service;

import Entity.Employee;
import Utils.PageBean;

public interface IEmployeeService {
	/**
	 *  分页查询数据 
	 */
	
	public void getAll(PageBean<Employee> pb);
	}
