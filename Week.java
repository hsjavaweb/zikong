1.Dom4j_writer
package Dom4j_writer;
import java.io.File;
import java.io.FileOutputStream;
import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import org.junit.Test;
/**
 * 
 * 修改xml内容
 * 增加：文档，标签 ，属性
 * 修改：属性值，文本
 * 删除：标签，属性
 *
 *
 *
 * @author zlty
 *
 */
public class Demo3 {

	/**
	 * 增加：文档，标签 ，属性
	 */
	
	public void test1() throws Exception{
		Document doc=DocumentHelper.createDocument();
		
		Element rootElem=doc.addElement("contactList");
		Element contactElem=rootElem.addElement("contact");
		/**
		 * 增加属性
		 * 
		 */
		contactElem.addAttribute("id", "001");
		contactElem.addAttribute("name","eric"); 
		//把修改后的document对象写到xml文件对象中
		FileOutputStream out=new FileOutputStream("d:/contact4.xml");
		OutputFormat format=OutputFormat.createPrettyPrint();
		format.setEncoding("utf-8");
		XMLWriter writer=new XMLWriter(out,format);
		writer.write(doc);
		writer.close();
		}
	/**
	 * 
	 * 修改：属性值，文本
	 * @throws Exception
	 */@Test
	public void test2() throws Exception{
		Document doc=new SAXReader().read(new File("./src/contact.xml"));
		/**
		 * 1.1  得到标签对象
		 * 1.2 得到属性对象
		 * 1.3 修改属性值
		 */
		/*
		Element contactElem=doc.getRootElement().element("contact");
		Attribute idAttr=contactElem.attribute("id");
		idAttr.setValue("003");*/
		
		/**
		 * 方案二：修改属性值
		 * 
		 */
		/*Element contactElem=doc.getRootElement().element("contact");
		contactElem.addAttribute("id","003");//1.2 通过增加同名属性的方法，修改属性值
		*/
		/**
		 * 修改文本 1.得到标签对象 2.修改文本
		 */
		Element nameElem=doc.getRootElement().element("contact").element("name");
		nameElem.setText("李四");
		
		
		FileOutputStream out=new FileOutputStream("d:/contact4.xml");
		OutputFormat format=OutputFormat.createPrettyPrint();
		format.setEncoding("utf-8");
		XMLWriter writer=new XMLWriter();
		writer.write(doc);
		writer.close();
	}
	
	/**
	 * 删除：标签，属性
	 * @return 
	 * @throws Exception
	 */
	
	public void test3() throws Exception{
		Document doc =new SAXReader().read(new File("./src/contact.xml"));
		/**
		 * 1.删除标签     1.1 得到标签对象  1.2 删除标签对象    
		 */
		Element ageElem=(Element) doc.getRootElement().element("contact").elements("age").get(1);
		Attribute idAttr=ageElem.attribute("id");
		idAttr.detach();
		FileOutputStream out = new FileOutputStream("e:/contact.xml");
		OutputFormat format = OutputFormat.createPrettyPrint();
		format.setEncoding("utf-8");
		XMLWriter writer = new XMLWriter(out,format);
		writer.write(doc);
		writer.close();
	}
}
2.SAXReader
package SAXReader.sax;

import java.io.File;
import java.util.Iterator;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

/**
 * 使用sax解析把 xml文档封装成对象
 * @author zlty
 *
 */
public class SAXReaderDemo3 {
	public static void main(String[] args) throws Exception {
		SAXParser parser=SAXParserFactory.newInstance().newSAXParser();
		MyDefaultHandler3 handle=new MyDefaultHandler3();
		parser.parse(new File("./src/contact.xml"),handle);
		List<Contact> list=handle.getList();
		for (Contact contact : list) {
			System.out.println(contact);
		}
	}
}
package SAXReader.sax;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
/**
 * SAX处理程序
 * @author zlty
 *
 */
public class MyDefaultHandler3 extends DefaultHandler {
	private List<Contact> list=new ArrayList<Contact>();
	
	
	public List<Contact> getList(){
		return list;
	}
	private Contact contact;
	
	private String curTag;
	
	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		curTag = qName;
		if("contact".equals(qName)){
			contact=new Contact();
			contact.setId(attributes.getValue("id"));
		}
	}
	
	
	@Override
	public void characters(char[] ch, int start, int length)
			throws SAXException {
		String content=new String(ch,start,length);
		if("name".equals(curTag)){
			contact.setName(content);
		}
		if("phone".equals(curTag)){
			contact.setPhone(content);
		}
		if("age".equals(curTag)){
			contact.setAge(content);
		}
		if("email".equals(curTag)){
			contact.setEmail(content);
		}
		if("qq".equals(curTag)){
			contact.setQq(content);
		}
	}
	
	
	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		curTag=null;
		if("contact".equals(qName)){
			list.add(contact);
		}
	}
}
3.HttpServletRequst
package b_HttpServletRequst;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequestDemo5 extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		/*System.out.println(req.getMethod());
		String name=req.getParameter("name");
		String password=req.getParameter("password");
		System.out.println(name+"="+password);
		System.out.println("=============================");*/
		/*System.out.println("Get方式");
		String vaules=req.getQueryString();
		System.out.println(vaules);*/
		/**
		 * 设置参数查询的编码
		 * 该方法只能对请求实体内容的数据编码起作用。POST提交的数据在实体内容中，所以该方法对POST方法有效！
		 * GET方法的参数放在URI后面，所以对GET方式无效！！！
		 */
		req.setCharacterEncoding("utf-8");
		
		
		
		/**
		 * 统一获取请求参数的名字
		 * 
		 */
		String name=req.getParameter("name");
		String password=req.getParameter("password");
		if("GET".equals(req.getMethod())){
			name=new String(name.getBytes("iso-8859-1"),"utf-8");
			password=new String(password.getBytes("iso-8859-1"),"utf-8");
			//重新编码，在设置指定的解码方式
		}
		System.out.println(name+password);
		System.out.println("----------------");
		
		Enumeration<String> enums=req.getParameterNames();
		int ch=0;
		while(enums.hasMoreElements()){
			String paramName=enums.nextElement();
			if("habit".equals(paramName)){
			String[] habit=req.getParameterValues(paramName);
				for(String i:habit){
					if("GET".equals(req.getMethod())){
						i=new String(i.getBytes("iso-8859-1"),"utf-8");
					}
					System.out.println(i+".");
				}
			}else{
				String paramValue=req.getParameter(paramName);
				if("GET".equals(req.getMethod())){
					paramValue=new String(paramValue.getBytes("iso-8859-1"),"utf-8");
				}
				System.out.println(paramName+"="+paramValue);
			}
		}
		
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		/*InputStream in=req.getInputStream();
		byte[] buf=new byte[1024];
		int ch=0;
		while((ch=in.read(buf))!=-1){
			System.out.println(new String(buf,0,ch));
		}*/
	this.doGet(req,resp);
	}
}

4.HttpServletResponse
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


