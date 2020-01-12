<%@ page import="cn.zq.web1.Person" %><%-- Created by IntelliJ IDEA. --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title></title>
  </head>
  <body>
    <%
      Person person = new Person();
      System.out.println(person.getInfo()+"  James");
      out.println(person.getInfo()+"  James Zhou");
    %>

    <a href="<%=request.getContextPath()%>/HelloServlet">HelloServlet</a>
<%--Helloworld--%>
  </body>
</html>