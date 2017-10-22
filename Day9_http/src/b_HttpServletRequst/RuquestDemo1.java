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
	 * ������
	 * @param request
	 */
	public void test1(HttpServletRequest request){
		System.out.println("����ʽ"+request.getMethod());
		System.out.println("URL"+request.getRequestURI());
		System.out.println("URI"+request.getRequestURI());
		System.out.println("HTTP����Э��İ汾"+request.getProtocol());
	}
	/**
	 * ����ͷ
	 * @param request
	 */
	public void test2(HttpServletRequest request) {
		String host=request.getHeader("Host");//����ͷ���Ƶĵ�ͷ������
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
	 * ����ʵ�������
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
