package c_HttpServletResponse;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 *  定时刷新 
 * @author zlty
 *
 */
public class ResponseDemo3 extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setHeader("refresh", "1");//隔1秒后刷新页面
		resp.setHeader("refresh","3;url=/Day9_http/adv.html");//隔指定秒数跳转至指定页面
		
	}
}
