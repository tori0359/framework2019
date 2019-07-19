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
	<h1>jstl(JavaServerPages Standard Tag Library)</h1>
	<ul>
		<li><c:out value="1234"></c:out></li>
		<li><c:out value="java"></c:out></li>
		<!-- jstl out은 필수속성으로 value값을 가져야 한다. 
		value의값이 없으면($(null)) 텍스트노드가 value에 해당한다.
		-->
		<li><c:out value="${null}">jstl</c:out></li>
		<!-- var : 변수 value : 값 scope : 범위(default:page)-->
		<c:set var="msg" value="abcd" ></c:set>
		<ul>
			<li>${pageScope.msg }</li>
			<li>${requestScope.msg }</li>
			<li>${sessionScope.msg }</li>
			<li>${applicationScope.msg }</li>
			<li><c:out value="${msg }"></c:out></li>
		</ul>
		<br/>
		<jsp:useBean id="bean" class="com.bit.entity.JavaBean" scope="page"/>
		<!-- el없이 bean만 사용하면 문자열 bean이 되는것! -->
		<c:set target="${bean}" property="su1" value="1223"/>
		<c:set target="${bean}" property="su2" value="3.14"/>
		<c:set target="${bean}" property="ch" value="@"/>
		<c:set target="${bean}" property="boo" value="true"/>
		<c:set target="${bean}" property="msg" value="Java Bean"/>
		<c:set target="${bean}" property="nalja" value="<%=new java.util.Date() %>"/>
		<ul>
			<li>${bean.su1 }</li>
			<li>${bean.su2 }</li>
			<li>${bean.ch }</li>
			<li>${bean.boo }</li>
			<li>${bean.nalja }</li>
		</ul>
	</ul>
</body>
</html>