<%@ page import="java.util.Map" %><%--
  Created by IntelliJ IDEA.
  User: james
  Date: 2020/02/08
  Time: 21:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
对不起,密码验证失败
<a href="<%=request.getContextPath()%>/LoginTest.jsp">重新登录</a>

<%
    Map<String,String> error = (Map<String, String>) request.getAttribute("error");

    if (error.size()>0){
        for (Map.Entry<String,String> en : error.entrySet()){
            out.print(en.getValue()+"<br>");
        }
    }
%>
</body>
</html>
