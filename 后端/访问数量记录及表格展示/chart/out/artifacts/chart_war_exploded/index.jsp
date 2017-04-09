<%@ page import="java.net.InetAddress" %><%--
  Created by IntelliJ IDEA.
  User: allen
  Date: 2017/4/9
  Time: 18:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  你的IP为：<%
    InetAddress address = InetAddress.getLocalHost();
    String ip= address.getHostAddress();
    out.print(ip);
  %><br>

  点击次数：
  访问次数：
  </body>
</html>
