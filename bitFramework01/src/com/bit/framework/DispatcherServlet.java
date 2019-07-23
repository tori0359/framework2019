package com.bit.framework;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DispatcherServlet extends HttpServlet{
	
	Map<String, String> map = new HashMap<String, String>();
	
	@Override
	public void init() throws ServletException {
		map.put("/index.bit", "com.bit.controller.IndexController");
		map.put("/main.bit", "com.bit.controller.MainController");
		map.put("/list.bit", "com.bit.controller.ListController");
		map.put("/add.bit", "com.bit.controller.AddController");
		map.put("/insert.bit", "com.bit.controller.InsertController");
	}

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
		System.out.println("doDo 호출...");
		
		String root = req.getContextPath();
//		System.out.println("->"+root);
		String path = req.getRequestURI().substring(root.length());
		System.out.println("->"+path);
		
		//handleMapping
		
		Controller controller= null;
		String clInfo=null;

		clInfo = map.get(path);
		
		try {
			Class clazz = Class.forName(clInfo);
			controller= (Controller)clazz.newInstance();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		
		String viewName = null;
		try {
			viewName = controller.execute(req);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if(viewName.startsWith("redirect:")){
			resp.sendRedirect(root+viewName.substring("redirect:".length()));
		}else{	
			String prefix= "/WEB-INF/view/";
			String suffix= ".jsp";
			viewName=prefix+viewName+suffix;
			req.getRequestDispatcher(viewName).forward(req, resp);
		}
	}
}




//jsp 직접호출 제어 = WEB-INF - view에 jsp 파일을 저장, controller에서 접근할 수 있도록 호출!
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
