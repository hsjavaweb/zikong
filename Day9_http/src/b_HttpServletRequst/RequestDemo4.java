package b_HttpServletRequst;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * ��ֹ�Ƿ����ӣ� 
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
		 * �жϷǷ����ӣ�
		 * 	1��ֱ�ӷ��ʵĻ�referer=null
		 *  2�������ǰ���������Թ��   
		 */
		if(referer==null || !referer.contains("/day09/adv.html")){
			resp.getWriter().write("��ǰ�ǷǷ����ӣ���ص���ҳ��<a href='/Day9_http/adv.html'>��ҳ</a>");
		}else{
			//��ȷ������
			resp.getWriter().write("��Դ��������...");
		}
	}
}
