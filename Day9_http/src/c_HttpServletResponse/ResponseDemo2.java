package c_HttpServletResponse;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * ����- �����ض���
 *���൱�ڳ�������תҳ�棩
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
