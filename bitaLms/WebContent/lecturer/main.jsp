<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="../css/frame.css"/>
<script type="text/javascript" src="../js/jquery-1.12.4.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		
		
	})
</script>
</head>
<body>
	<div>
		<div id="header">
			<h1>강사화면</h1>
		</div>
		<div id="menu">
		<% String root = request.getContextPath();%>
			<ul>
				<li><a href="<%=root %>/stdAdmin/attandance.bit">학생관리</a></li>
				<li><a href="<%=root %>/question.bit">1:1 문의</a></li>
			</ul>
		</div>
		<div id="content">
			<h2>메인 페이지</h2>
		</div>
		<div id="footer">
			Copyright &copy; 비트캠프 All rights 
		</div>
	
	</div>
	
</body>
</html>