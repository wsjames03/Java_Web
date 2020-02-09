<%--
  Created by IntelliJ IDEA.
  User: james
  Date: 2020/02/09
  Time: 19:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<%
     //1.获得浏览器发送过来的cookie
    Cookie[] cookies = request.getCookies();
    String userName = "";
    //2.遍历找到保存用户名的
    if(cookies!=null && cookies.length>0){
    for (Cookie c : cookies){
        if (c.getName().equals("name")){
            userName = c.getValue();
        }
      }
    }
    //3.如果找到取得它的值
    //4.把值设置到 用户名所在的input
%>
<body>
<form action="<%=request.getContextPath()%>/CookieTest4Servlet" method="post">
    用户名:<input type="text" name="name" value=<%=userName%>><br/>
    密码:<input type="password" name="password"><br/>
    记住用户名(一周):<input type="checkbox" name="remember" value="yes"  <%=userName.length()==0?"":"checked"%>><br/>
    <input type="submit" value="登录">
</form>

</body>
</html>
