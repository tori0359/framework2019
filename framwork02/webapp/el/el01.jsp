<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- el은 output을 내기 위한 표현식 -->
	<h1>EL 표현식</h1>
	<table>
		<tr>
			<th>출력</th>
			<th>JAVA</th>
			<th>EL</th>
		</tr>
		<tr>
			<td>String</td>
			<td><%="ABCD"%></td>
			<!-- el은 표현식이다. -->
			<td>${"ABCD" }</td>
		</tr>
		<tr>
			<td>String</td>
			<td><%out.print("abcd");%></td>
			<!--el은 java의 문법으로서 작동한다.  -->
			<td>${'abcd' }</td>
		</tr>
		<tr>
			<td>숫자(정수-나눗셈)</td>
			<td><%=5/2%></td>
			<!--el숫자는 사칙연산은 가능, 나눗셈은 el은 실수로 반환 -->
			<!-- el div -> / -->
			<!--  <td>${5 div 2 }</td>-->
		</tr>
		<tr>
			<td>실수(연산)</td>
			<td><%=3.000000000000001-1.0000000000000009%></td>
			<!--el 실수는  -->
			<td>${3.000000000000001-1.0000000000000009 }</td>
		</tr>
		<tr>
			<td>true/false</td>
			<td><%=3==3%></td>
			<td>${3==3 }</td>
		</tr>
		<tr>
			<td>true/false(==)</td>
			<td><%=3==2%></td>
			<td>${3 eq 2 }</td>
		</tr>
		<tr>
			<td>true/false(>)</td>
			<td><%=3 > 4%></td>
			<td>${3 gt 4 }</td>
		</tr>
		<tr>
			<td>true/false(<)</td>
			<td><%=3 < 4%></td>
			<td>${3 lt 4 }</td>
		</tr>
		<tr>
			<td>true/false(>=)</td>
			<td><%=3 >= 4%></td>
			<!-- gt eq -> ge -->
			<td>${3 ge 4 }</td>
		</tr>
		<tr>
			<td>true/false(<=)</td>
			<td><%=3 <= 4%></td>
			<!-- lt eq -> le -->
			<td>${3 le 4 }</td>
		</tr>
		<tr>
			<td>null</td>
			<td><%
				String msg = null;
				out.print(msg);
			%></td>
			<!-- el에서는 null이면 표현을 안해준다. -->
			<td>${msg}</td>
		</tr>
	</table>
</body>
</html>