package c_HttpServletResponse;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 
 * ������Ӧ��Ϣ
 * @author zlty
 *
 */
public class ResponseDemo1 extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		/**
		 * ͨ��response����ı���Ӧ��Ϣ
		 */
		//��Ӧ��
		/*resp.setStatus(404);
		resp.sendError(404)*/;
		//��Ӧͷ
		resp.setHeader("server", "111");
		//��Ӧʵ�����ݣ�������ֱ���ܹ����������ݾ���ʵ�����ݣ� 
		resp.getOutputStream().write("hello".getBytes());//�ַ�������ֽ�����
	}
	/**
	 * 4)tomcat��������response���������ת������Ӧ��ʽ���ݣ��ٷ��͸������������
	 */
}
