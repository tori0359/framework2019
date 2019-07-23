package com.bit.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import com.bit.framework.Controller;

public class MainController implements Controller {
	@Override
	public String execute(HttpServletRequest req) throws SQLException {
		return "main";
	}
}
