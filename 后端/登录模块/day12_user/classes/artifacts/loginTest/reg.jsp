<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="${pageContext.request.contextPath }/servlet/regServlet" method="post">
		用户名：<input type="text" name="username" required value="${uf.username }"/>${uf.msg.username }${error }<br/>
		密码：<input type="password" name="password" />${uf.msg.password }<br/>
		确认密码：<input type="password" name="repassword"/>${uf.msg.repassword }<br/>
		油箱：<input type="email" name="email" value="${uf.email }"/>${uf.msg.email }<br/>
		生日：<input type="text" name="birthday" value="${uf.birthday }"/>${uf.msg.birthday }<br/>
		<input type="submit" value="注册"/><br/>
	</form>
</body>
</html>