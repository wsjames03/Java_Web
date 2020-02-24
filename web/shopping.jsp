<%@ page import="java.net.URLEncoder" %><%--
  Created by IntelliJ IDEA.
  User: james
  Date: 2020/02/11
  Time: 17:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<table border="1">
    <tr>
        <th>商品</th>
        <th>加入购物车</th>
    </tr>
    <tr>
        <td>三国演义</td>
        <td><a href="${pageContext.request.contextPath}/SessionTest1Servlet?book=<%=URLEncoder.encode("三国演义","UTF-8")%>">
            加入购物车</a>
        </td>
    </tr>
    <tr>
        <td>红楼梦</td>
         <td><a href="${pageContext.request.contextPath}/SessionTest1Servlet?book=<%=URLEncoder.encode("红楼梦","UTF-8")%>">
             加入购物车</a>
        </td>
    </tr>
    <tr>
        <td>西游记</td>
        <td><a href="${pageContext.request.contextPath}/SessionTest1Servlet?book=<%=URLEncoder.encode("西游记","UTF-8")%>">
            加入购物车
        </a>
        </td>
    </tr>
    <tr>
        <td>水浒传</td>
        <td><a href="${pageContext.request.contextPath}/SessionTest1Servlet?book=<%=URLEncoder.encode("水浒传","UTF-8")%>">
            加入购物车
        </a>
        </td>
    </tr>
</table>

<a href="${pageContext.request.contextPath}/cart.jsp">查看购物车</a>
</body>
</html>
