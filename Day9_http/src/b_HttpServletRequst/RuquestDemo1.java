package b_HttpServletRequst;

import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RuquestDemo1 extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		test2(req);
		
	}
	/**
	 * 请求行
	 * @param request
	 */
	public void test1(HttpServletRequest request){
		System.out.println("请求方式"+request.getMethod());
		System.out.println("URL"+request.getRequestURI());
		System.out.println("URI"+request.getRequestURI());
		System.out.println("HTTP传输协议的版本"+request.getProtocol());
	}
	/**
	 * 请求头
	 * @param request
	 */
	public void test2(HttpServletRequest request) {
		String host=request.getHeader("Host");//根据头名称的到头的内容
		System.out.println(host);
		Enumeration<String> enums =request.getHeaderNames();
		while(enums.hasMoreElements()){
			String name=enums.nextElement();
			String vaule=request.getHeader(name);
			System.out.println(name+":"+vaule);
		}
	}
	public  void test3(HttpServletRequest request) {
		
		
	}

	@Override
	/**
	 * 
	 * 请求实体的内容
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse resp)
			throws ServletException, IOException {
		InputStream in=request.getInputStream();
		byte[] buf=new byte[1024];
		int ch=0;
		while((ch=in.read(buf))!=-1){
			String str=new String(buf,0,ch);
			System.out.println(str);
		}
	}
}
