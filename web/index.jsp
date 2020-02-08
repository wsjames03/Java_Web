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

    <form action="<%=request.getContextPath()%>/RequestTest1Servlet" method="post">

      姓名:<input type="text" name="name" /><br>
      年龄:<input type="text" name="age" /><br>
      爱好:
      吃饭<input type="checkbox" name="hobbies" value="eating">
      睡觉<input type="checkbox" name="hobbies" value="sleeping">
      游泳<input type="checkbox" name="hobbies" value="swimming">
      <input type="submit">

    </form>

<%--Helloworld--%>
  </body>
</html>