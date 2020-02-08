package cn.zq.web2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Map;

@WebServlet(name = "RequestTest1Servlet",urlPatterns = "/RequestTest1Servlet")
public class RequestTest1Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        doGet(request,response);
        //获得表单提交上来的键值对
        //因为Post解码是在第一次调用getParameter之前,那么解决乱码只需要在调用该方法之前设置编码:
        request.setCharacterEncoding("UTF-8");
//        String name = request.getParameter("name");
//        String age = request.getParameter("age");
//        System.out.println("name:"+name+", age:"+age);

        Map<String,String[]> map = request.getParameterMap();

        for (Map.Entry<String,String[]> en:map.entrySet()){
            String key = en.getKey();
            String[] values = en.getValue();
            System.out.println(key+"==>"+ Arrays.toString(values));
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //控制浏览器使用什么编码表解码
        response.setContentType("text/html;charset=utf-8");//==>会自动调用setCharacterEncoding
        PrintWriter pw = response.getWriter();
//        requestGet(request,response,pw);
        requestParameters(request);




    }

    protected static void requestGet(HttpServletRequest request,HttpServletResponse response,PrintWriter printWriter){

        printWriter.println("request.getContextPath(): "+request.getContextPath());
        printWriter.println("</br>");
        printWriter.println("request.getContentLength(): "+request.getContentLength());
        printWriter.println("</br>");
        printWriter.println("request.getContentType() "+request.getContentType());
        printWriter.println("</br>");
        printWriter.println("request.getMethod() "+request.getMethod());
        printWriter.println("</br>");
        printWriter.println("request.getLocale() "+request.getLocale());
        printWriter.println("</br>");
        printWriter.println("request.getQueryString() "+request.getQueryString());
        printWriter.println("</br>");
        printWriter.println("request.getRequestURI() "+request.getRequestURI());
        printWriter.println("</br>");
        printWriter.println("request.getRequestURL() "+request.getRequestURL());
        printWriter.println("</br>");
        printWriter.println("request.getServletPath() "+request.getServletPath());
        printWriter.println("</br>");
        printWriter.println("request.getServerName() "+request.getServerName());
        printWriter.println("</br>");
        printWriter.println("request.getServerPort() "+request.getServerPort());
        printWriter.println("</br>");
        printWriter.println("request.getRemoteHost() "+request.getRemoteHost());
        printWriter.println("</br>");
        printWriter.println("request.getRemoteAddr() "+request.getRemoteAddr());
        printWriter.println("</br>");
//        printWriter.println("request.getHeader() "+request.getHeader());
//        printWriter.println("</br>");
    }
    protected static void requestParameters(HttpServletRequest request) {
        //获得表单提交上来的键值对
        String name = request.getParameter("name");
        String age = request.getParameter("age");
        System.out.println("name:"+name+", age:"+age);


    }
}
