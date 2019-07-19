<%@page import="java.util.HashMap"%>
<%@page import="java.util.HashSet"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>제어문-반복문</h1>
	<c:forEach begin="1" end="10" step="2" var="idx" varStatus="status">
		<p>${idx }출력${status.count }</p>
	</c:forEach>
	<hr/>
	<%
		/*
		ArrayList<String> list = new ArrayList<String>();
		list.add("item1");
		list.add("item2");
		list.add("item3");
		list.add("item4");
		list.add("item5");
		pageContext.setAttribute("alist", list);
		*/
		/*
		HashSet<String> hset = new HashSet<String>();
		hset.add("set1");
		hset.add("set3");
		hset.add("set2");
		hset.add("set2");
		hset.add("set1");
		pageContext.setAttribute("alist", hset);
		*/
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("key1", "val1");
		map.put("key2", "val2");
		map.put("key3", "val3");
		map.put("key4", "val4");
		map.put("key5", "val5");
		pageContext.setAttribute("alist", map);
	%>
	<ul>
		<c:forEach items="${alist }" var="msg" varStatus="status">
			<li>${status.index}-${msg.key}:${msg.value }</li>
		</c:forEach>
	</ul>
</body>
</html>