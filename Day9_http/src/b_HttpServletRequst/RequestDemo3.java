package b_HttpServletRequst;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 
 * 获取浏览器的类型
 * @author zlty
 *
 */
public class RequestDemo3 extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setContentType("text/html;charset=utf-8");
		//获取请求头
		String user=req.getHeader("user-agent");
		System.out.println(user);
		if(user.contains("Firefox")){
			resp.getWriter().write("你正在使用火狐");
		}else if(user.contains("Chrome")){
			resp.getWriter().write("谷歌");
		}
	}
}
