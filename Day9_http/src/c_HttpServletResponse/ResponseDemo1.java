package c_HttpServletResponse;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 
 * 设置相应信息
 * @author zlty
 *
 */
public class ResponseDemo1 extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		/**
		 * 通过response对象改变响应信息
		 */
		//响应行
		/*resp.setStatus(404);
		resp.sendError(404)*/;
		//响应头
		resp.setHeader("server", "111");
		//响应实体内容（流浪器直接能够看到的内容就是实体内容） 
		resp.getOutputStream().write("hello".getBytes());//字符串变成字节数组
	}
	/**
	 * 4)tomcat服务器把response对象的内容转换成响应格式内容，再发送给浏览器解析。
	 */
}
