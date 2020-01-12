package cn.zq.web1;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Map;

@WebServlet(name = "LoginServlet",urlPatterns = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//            doGet(request,response);
        //获取请求的参数
        String user = request.getParameter("user");
        String password = request.getParameter("password");

        System.out.println(user+","+password);
        String[] hobbies = request.getParameterValues("interesting");

        for (String hobby : hobbies) {
            System.out.println(hobby);
        }

        Enumeration<String> names = request.getParameterNames();
        while (names.hasMoreElements()){
            String name = names.nextElement();
            String val = request.getParameter(name);
            System.out.println("**"+name+":"+val);
        }

        Map<String,String[]>  map = request.getParameterMap();
        for (Map.Entry<String,String[]> entry:map.entrySet()){
            System.out.println("##"+entry.getKey()+":"+ Arrays.asList(entry.getValue()));
        }

        //获取请求的url
        String requestURI =request.getRequestURI();
        System.out.println(requestURI);
        //获取请求的方式
        String method =request.getMethod();
        System.out.println(method);

        String servletPath= request.getServletPath();
        System.out.println(servletPath);

//        设置响应的内容类型:
        response.setContentType("application/msword");
        PrintWriter pw = response.getWriter();

        pw.println("HELLO WORLD");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //获取get请求  带参数的那个网址
         String queryString= request.getQueryString();
    }
}
