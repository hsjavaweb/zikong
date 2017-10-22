package a_servlet;

import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet{
	Date date=new Date();
	DateFormat dateformat=DateFormat.getDateInstance(DateFormat.LONG);
	String Date=dateformat.format(date);
		@Override
		public void doGet(HttpServletRequest req, HttpServletResponse resp)
				throws ServletException, IOException {
			resp.setContentType("text/html;charset=utf-8");
			resp.getWriter().write("这是第一个servlet程序。当前时间为："+Date);
		}
}
