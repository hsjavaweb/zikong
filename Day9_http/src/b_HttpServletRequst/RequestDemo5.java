package b_HttpServletRequst;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequestDemo5 extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		/*System.out.println(req.getMethod());
		String name=req.getParameter("name");
		String password=req.getParameter("password");
		System.out.println(name+"="+password);
		System.out.println("=============================");*/
		/*System.out.println("Get方式");
		String vaules=req.getQueryString();
		System.out.println(vaules);*/
		/**
		 * 设置参数查询的编码
		 * 该方法只能对请求实体内容的数据编码起作用。POST提交的数据在实体内容中，所以该方法对POST方法有效！
		 * GET方法的参数放在URI后面，所以对GET方式无效！！！
		 */
		req.setCharacterEncoding("utf-8");
		
		
		
		/**
		 * 统一获取请求参数的名字
		 * 
		 */
		String name=req.getParameter("name");
		String password=req.getParameter("password");
		/*if("GET".equals(req.getMethod())){
			name=new String(name.getBytes("iso-8859-1"),"utf-8");
			password=new String(password.getBytes("iso-8859-1"),"utf-8");
			//重新编码，在设置指定的解码方式
		}*/
		System.out.println(name+password);
		System.out.println("----------------");
		
		Enumeration<String> enums=req.getParameterNames();
		int ch=0;
		while(enums.hasMoreElements()){
			String paramName=enums.nextElement();
			if("habit".equals(paramName)){
			String[] habit=req.getParameterValues(paramName);
				for(String i:habit){
					/*if("GET".equals(req.getMethod())){
						i=new String(i.getBytes("iso-8859-1"),"utf-8");
					}*/
					System.out.println(i+".");
				}
				System.out.println();
			}else{
				String paramValue=req.getParameter(paramName);
				/*if("GET".equals(req.getMethod())){
					paramValue=new String(paramValue.getBytes("iso-8859-1"),"utf-8");
				}*/
				System.out.println(paramName+"="+paramValue);
			}
		}
		
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		/*InputStream in=req.getInputStream();
		byte[] buf=new byte[1024];
		int ch=0;
		while((ch=in.read(buf))!=-1){
			System.out.println(new String(buf,0,ch));
		}*/
	this.doGet(req,resp);
	}
}
