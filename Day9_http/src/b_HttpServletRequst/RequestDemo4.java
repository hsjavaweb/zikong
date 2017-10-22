package b_HttpServletRequst;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 防止非法链接！ 
 * @author zlty
 *
 */
public class RequestDemo4 extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		String referer=req.getHeader("referer");
		System.out.println(referer);
		/**
		 * 判断非法链接：
		 * 	1）直接访问的话referer=null
		 *  2）如果当前请求不是来自广告   
		 */
		if(referer==null || !referer.contains("/day09/adv.html")){
			resp.getWriter().write("当前是非法链接，请回到首页。<a href='/Day9_http/adv.html'>首页</a>");
		}else{
			//正确的链接
			resp.getWriter().write("资源正在下载...");
		}
	}
}
