package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Entity.Employee;
import Utils.PageBean;

import service.EmployeeService;
import service.IEmployeeService;

public class IndexServlet extends HttpServlet {
	private IEmployeeService employeeService=new EmployeeService();
	private String uri;
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try{
			String currPage=request.getParameter("currentPage");
			if(currPage==null||"".equals(currPage.trim())){
				currPage="1";
			}
			int currentPage=Integer.parseInt(currPage);
			PageBean<Employee> pageBean = new PageBean<Employee>();
			pageBean.setCurrentPage(currentPage);
			employeeService.getAll(pageBean);
			request.setAttribute("pageBean", pageBean);
			uri="/list.jsp";
		}catch(Exception e){
			e.printStackTrace();
			uri="/error.jsp";
		}
		request.getRequestDispatcher(uri).forward(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
