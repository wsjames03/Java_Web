<%@ page import="cn.zq.web1.Person" %>
<%@ page import="java.util.Map" %><%-- Created by IntelliJ IDEA. --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<%
    Person person = new Person();
    System.out.println(person.getInfo() + "  James");
    out.println(person.getInfo() + "  James Zhou");
%>

<a href="<%=request.getContextPath()%>/HelloServlet">HelloServlet</a>

<form action="<%=request.getContextPath()%>/RequestTest2Servlet" method="post">

    用户名:<input type="text" name="name"/><br>
    密码:<input type="password" name="password"/><br>
    <input type="submit">

</form>
<hr/>
<form action="<%=request.getContextPath()%>/RequestTest3Servlet" method="post">

    用户名:<input type="text" name="name"/><br>
    密码:<input type="password" name="password"/><br>
    <input type="submit">

</form>

<%--Helloworld--%>
</body>
</html>