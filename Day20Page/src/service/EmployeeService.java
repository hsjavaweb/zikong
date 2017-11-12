package service;

import Dao.EmployeeDao;
import Dao.IEmployeeDao;
import Entity.Employee;
import Utils.PageBean;

public class EmployeeService implements IEmployeeService {
	
	
	IEmployeeDao employeeDao=new EmployeeDao();
	@Override
	public void getAll(PageBean<Employee> pb) {
		try{
			employeeDao.getAll(pb);
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	}

}
