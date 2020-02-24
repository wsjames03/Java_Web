<%@ page import="java.util.Enumeration" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.LinkedHashMap" %><%--
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
        <th>商品名字</th>
        <th>商品数量</th>
    </tr>
    <%
        Map<String,Integer> cart =(LinkedHashMap<String,Integer>)request.getSession().getAttribute("cart");
        if (cart!=null && cart.size()>0){
        for (Map.Entry<String,Integer> en : cart.entrySet()){
            String bookName =en.getKey();
            Integer bookNum =en.getValue();
            out.print("<tr><td>"+bookName+"</td><td>"+bookNum.toString()+"</td></tr>");
           }
        }else{
            out.print("购物车为空");
        }
    %>

</table>
<a href="${pageContext.request.contextPath}/shopping.jsp">返回主页</a>
</body>
</html>
