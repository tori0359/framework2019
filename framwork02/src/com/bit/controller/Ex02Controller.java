package com.bit.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/el/el03.html")
public class Ex02Controller extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String msg="controller msg";
		//scope�� �켱���� page > request > session > application
		//requestscope�� ���.
		req.setAttribute("msg", msg);
		req.getRequestDispatcher("el02.jsp").forward(req, resp);
	}
	
}
