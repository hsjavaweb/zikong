package b_HttpServletRequst;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * ע�⣺tomcat���������Ȼ����servlet��service������Ȼ����service�������ٸ�������ʽ���ֱ���ö�Ӧ��doXX����
 * �����磬�����GET����ʽ����service�����е���doGet������
 * 
 *   ��Ϊ�������ʽ��GET ��POST�����Ա�дservlet����ֻ��Ҫ����doGet��doPost���ɣ�������
 * @author zlty
 *
 */
public class RequestDemo2 extends HttpServlet {
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("GET��ʽ����");
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("post"+"����");
	}
	
}
