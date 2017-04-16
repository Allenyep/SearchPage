<%@ page import="java.net.InetAddress" %>
<%@ page import="java.sql.Timestamp" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %><%--
  Created by IntelliJ IDEA.
  User: allen
  Date: 2017/4/9
  Time: 18:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
  <head>
    <title>index</title>
  </head>
  <body>

  <c:set var="Count" value="${Count+1}" scope="session"></c:set>
  你的IP为：<%
    InetAddress address = InetAddress.getLocalHost();
    String ip= address.getHostAddress();
//    request.setAttribute("ip",ip);
    session.setAttribute("ip",ip);
    session.setAttribute("ipnums",session.getAttribute("Count"));

    Timestamp ts=new Timestamp(new Date().getTime());
    SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
    session.setAttribute("date",ts);
//    format.format(ts);
  %>

  <%=format.format(ts)%><br>
  点击次数：${Count}
  访问次数：${ip}<br>
  <%=session.getAttribute("Count")%>
  </body>
</html>
