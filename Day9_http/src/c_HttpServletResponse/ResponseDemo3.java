package c_HttpServletResponse;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 *  ��ʱˢ�� 
 * @author zlty
 *
 */
public class ResponseDemo3 extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setHeader("refresh", "1");//��1���ˢ��ҳ��
		resp.setHeader("refresh","3;url=/Day9_http/adv.html");//��ָ��������ת��ָ��ҳ��
		
	}
}
