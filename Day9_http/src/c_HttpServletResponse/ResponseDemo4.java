package c_HttpServletResponse;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * content-type作用
 * @author zlty
 *
 */
public class ResponseDemo4 extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		/*resp.setCharacterEncoding("utf-8");
		resp.setHeader("content", "text/html");
		resp.setHeader("content-type", "image/jpg");
		resp.setContentType("text/html;charset=utf-8");
		resp.getOutputStream().write("<html><head><title>this is tilte</title></head><body>中国</body></html>".getBytes("utf-8"));*/
		File file=new File("c:/6.jpg");
		FileInputStream in=new FileInputStream(file);
		byte[] buf=new byte[1024];
		int ch=0;
		while((ch=in.read(buf))!=-1){
			resp.getOutputStream().write(buf, 0, ch);
		}
	}
}
