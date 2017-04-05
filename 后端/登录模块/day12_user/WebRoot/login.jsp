<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	request.setCharacterEncoding("utf-8");
	response.setCharacterEncoding("utf-8");
%>
${msg }
	<form action="${pageContext.request.contextPath }/servlet/loginServlet" method="post">
		用户名：<input type="text" name="username" required/><br/>
		密码：<input type="password" name="password" required/><br/>
		输入验证码:<input type="text" name="code" required><img onclick="changeCode()" src="servlet/CodeServlet" alt="验证码"><br/>
		<input type="submit" value="登录"/><br/>
		
	</form>
	
</body>
<script type="text/javascript">
    function changeCode(){
        //得到图片元素
        var img = document.getElementsByTagName("img")[0];
        //img.setAttribute("src","/day09_00_HttpServletResponservlet/demo4");//XML Dom 语法
        img.src = "servlet/CodeServlet?time="+new Date().getTime();
    }
</script>
</html>