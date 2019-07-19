<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	String[] strs = {"ab","abc", "abcd", "abcde"};
	//pageContext.setAttribute("strs", strs);

/*
 	ArrayList<String> alist = new ArrayList<String>();	
	alist.add("ab");
	alist.add("abc");
	alist.add("abcd");
	alist.add("abcde");
	pageContext.setAttribute("list", alist); 
*/
/*
	HashSet<String> hset = new HashSet<String>();
	hset.add("a");
	hset.add("ab");
	hset.add("abc");
	hset.add("abcd");
	pageContext.setAttribute("list", hset);
*/
	HashMap<String,String> hmap = new HashMap<String, String>();
	hmap.put("key1", "val1");
	hmap.put("key2", "val2");
	hmap.put("key3", "val3");
	hmap.put("key4", "val4");
	pageContext.setAttribute("map", hmap);
	
	com.bit.entity.JavaBean bean=null;
	bean= new com.bit.entity.JavaBean();
	
	bean.setSu1(1234);
	bean.setSu2(3.14);
	bean.setCh('A');
	bean.setBoo(true);
	bean.setMsg("bean object");
	bean.setNalja(new java.util.Date());
	pageContext.setAttribute("bean", bean);
	
%>
	<h1>자료구조 표현</h1>
	<!-- 
	<dl>
		<dt>0</dt>
		<dd>${list.get(0) }</dd>
	</dl>
	<dl>
		<dt>1</dt>
		<dd>${list.get(1) }</dd>
	</dl>
	<dl>
		<dt>2</dt>
		<dd>${list.get(2) }</dd>
	</dl>
	<dl>
		<dt>3</dt>
		<dd>${list.get(3) }</dd>
	</dl>
	 -->
	<!-- 순서가 없는 hashset을 사용하고 싶으면 jstl을 사용해야 한다. 
		el은 단순한 표현식... 객체 자체는 전달이 가능 (list) -->
	<!-- 
	<dl>
		<dt>0</dt>
		<dd>${map.key1 }</dd>
	</dl>
	<dl>
		<dt>1</dt>
		<dd>${map.key2 }</dd>
	</dl>
	<dl>
		<dt>2</dt>
		<dd>${map.key3 }</dd>
	</dl>
	<dl>
		<dt>3</dt>
		<dd>${map.key4 }</dd>
	</dl>
	 -->
	 <!-- el을 사용할때 getter, setter의 약속된 규칙을 사용해야 하는 이유. 만약 다르면 오류가 떨어진다. 
	 		bean.su1 == bean.getSu1()을 가지고 오는것과 같다.
	  -->
	<ul>
		<li>${bean.su1 }</li>
		<li>${bean.su2 }</li>
		<li>${bean.ch }</li>
		<li>${bean.boo }</li>
		<li>${bean.msg }</li>
		<li>${bean.nalja }</li>
		<!-- .toString()을 하면 값을 출력한다. -->
		<li>${bean }</li>
	</ul> 
</body>
</html>