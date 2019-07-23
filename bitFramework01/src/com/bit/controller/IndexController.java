package com.bit.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import com.bit.framework.Controller;


public class IndexController implements Controller{

	@Override
	public String execute(HttpServletRequest req) throws SQLException {
		req.setAttribute("msg", "Hello World");
		return "index";
	}
	
}
