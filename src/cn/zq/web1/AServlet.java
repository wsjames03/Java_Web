package cn.zq.web1;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

//AServlet?user=james2&password=8888
//@WebServlet(name = "AServlet",urlPatterns = "/AServlet")
public class AServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        // 1：getServletContext()取得的是 <context-param>配置的参数
        //  getServletConfig()取得的是 <servlet> <init-param>配置的参数

        ServletConfig sc = getServletConfig();
        String user = sc.getInitParameter("user");
        String password = sc.getInitParameter("password");
        System.out.println("user is "+user);
        System.out.println("password is "+password);

       /* 2： getServletContext()应用于整个web App,而getServletConfig()仅应用于当前Servlet。
       但是ServletConfig对象拥有ServletContext的引用。所以可以通过getServletConfig()来获得web App的 初始值*/
        String user2 = request.getServletContext().getInitParameter("user");
        //String password1 = request.getServletContext().getInitParameter("password");
        System.out.println("user is "+user2);

        //AServlet?user=james2&password=8888  url里面解析的参数
        String user3 = request.getParameter("user");
        System.out.println("user is "+user3);

        PrintWriter pw = response.getWriter();

        Enumeration<String> names = sc.getInitParameterNames();
        while (names.hasMoreElements()){
            String name = names.nextElement();
            String value =sc.getInitParameter(name);
            pw.println("The init param is :"+name+"="+value/*+"<br>"*/);
//            pw.print("<br/>");
        }


    }
}
