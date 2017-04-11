<%--
  Created by IntelliJ IDEA.
  User: allen
  Date: 2017/4/9
  Time: 20:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>IP</title>
</head>
<body>
    IP地址<%=request.getAttribute("ip")%>
    访问数<%=request.getAttribute("nums")%>
</body>
</html>
