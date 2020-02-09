<%--
  Created by IntelliJ IDEA.
  User: james
  Date: 2020/02/09
  Time: 17:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--<%--%>
<%--    String brand = "";--%>
<%--    Cookie[] cookies = request.getCookies();--%>
<%--    if (cookies!=null && cookies.length>0){--%>
<%--        for (Cookie c :cookies){--%>
<%--            if (c.getName().equals("brand")){--%>
<%--                brand = c.getValue()+","+brand;--%>
<%--            }--%>
<%--        }--%>
<%--    }--%>
<%--%>--%>
<a href="<%=request.getContextPath()%>/CookieTest3Servlet?name=dell">dell</a>
<a href="<%=request.getContextPath()%>/CookieTest3Servlet?name=lenovo">lenovo</a>
<a href="<%=request.getContextPath()%>/CookieTest3Servlet?name=apple">apple</a>
<a href="<%=request.getContextPath()%>/CookieTest3Servlet?name=acer">acer</a>
<a href="<%=request.getContextPath()%>/CookieTest3Servlet?name=hasee">hasee</a>
<a href="<%=request.getContextPath()%>/CookieTest3Servlet?name=asus">asus</a>
    浏览历史:<%=request.getAttribute("brand")%>
</body>
</html>
