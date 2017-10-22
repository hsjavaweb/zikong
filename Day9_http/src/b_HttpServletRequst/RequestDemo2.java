package b_HttpServletRequst;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 注意：tomcat服务器首先会调用servlet的service方法，然后在service方法中再根据请求方式来分别调用对应的doXX方法
 * （例如，如果是GET请求方式，在service方法中调用doGet方法）
 * 
 *   因为最常的请求方式是GET 和POST，所以编写servlet程序，只需要覆盖doGet和doPost即可！！！！
 * @author zlty
 *
 */
public class RequestDemo2 extends HttpServlet {
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("GET方式运行");
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("post"+"运行");
	}
	
}
