package com.bit.framework;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//Ŀ�ǵ� ����, ����Ʈ���� ���
public class DispatcherServlet extends HttpServlet{
	
//	Map<String, Controller> map = new HashMap<String, Controller>();
	
	@Override
	public void init() throws ServletException {
		Properties prop = new Properties();
		Class<? extends DispatcherServlet> clz = getClass();
		ClassLoader loader = clz.getClassLoader();
		InputStream is = loader.getResourceAsStream("bit.properties");
		
		try {
			//������Ƽ ����
			prop.load(is);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Set keys =  prop.keySet();
		Iterator<String> ite = keys.iterator();
		while(ite.hasNext()){
			String key = ite.next();
			String clInfo = prop.getProperty(key);
			BitHandlerMapping.setMap(key, clInfo);
		}
	}//! ������Ƽ ���� end

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		doDo(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		doDo(req, resp);
	}
	
	public void doDo(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException{
		System.out.println("doDo ȣ��...");
		
		String root = req.getContextPath();
//		System.out.println("->"+root);
		String path = req.getRequestURI().substring(root.length());
		System.out.println("->"+path);
		
		//handleMapping
		Controller controller= null;
		controller = BitHandlerMapping.getContoller(path);

		
		String viewName = null;
		try {
			viewName = controller.execute(req);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		//viewResolver
		String prefix= "/WEB-INF/view/";
		String suffix= ".jsp";
		
		if(viewName.startsWith("redirect:")){
			resp.sendRedirect(root+viewName.substring("redirect:".length()));
		}else{	
			viewName=prefix+viewName+suffix;
			req.getRequestDispatcher(viewName).forward(req, resp);
		}
	}
}

//��ü�� �̸� ���ΰ� ��û�� ���� ������ ȣ���ؼ� ���
//Map<String, String> map = new HashMap<String, String>();
//map.put("/index.bit", "com.bit.controller.IndexController");
//map.put("/main.bit", "com.bit.controller.MainController");
//map.put("/list.bit", "com.bit.controller.ListController");
//map.put("/add.bit", "com.bit.controller.AddController");
//map.put("/insert.bit", "com.bit.controller.InsertController");


//jsp ����ȣ�� ���� = WEB-INF - view�� jsp ������ ����, controller���� ������ �� �ֵ��� ȣ��!
//if(path.equals("/index.bit")){
//	controller = new com.bit.controller.IndexController();
//	clInfo = "com.bit.controller.IndexController";		
//}else if(path.equals("/main.bit")){
//	clInfo = "com.bit.controller.MainController";
//}else if(path.equals("/list.bit")){
//	clInfo = "com.bit.controller.ListController";
//}else if(path.equals("/add.bit")){
//	clInfo = "com.bit.controller.AddController";
//}else if(path.equals("/insert.bit")){
//	clInfo = "com.bit.controller.InsertController";
//}
