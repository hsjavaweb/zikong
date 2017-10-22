package c_HttpServletResponse;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 案例- 请求重定向
 *（相当于超链接跳转页面）
 * @author zlty
 *
 */
public class ResponseDemo2 extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		/*resp.setStatus(302);
		resp.setHeader("location", "/Day9_http/adv.html");*/
		resp.sendRedirect("/Day9_http/adv.html");
	}
}
