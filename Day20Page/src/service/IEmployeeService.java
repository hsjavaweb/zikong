package service;

import Entity.Employee;
import Utils.PageBean;

public interface IEmployeeService {
	/**
	 *  ��ҳ��ѯ���� 
	 */
	
	public void getAll(PageBean<Employee> pb);
	}
