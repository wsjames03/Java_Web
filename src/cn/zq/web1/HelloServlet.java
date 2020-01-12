package cn.zq.web1;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name= "HelloServlet ",urlPatterns = "/HelloServlet")
/*WebServlet(name = "servlet1", urlPatterns = {"/url1", "/url2","url3/*"}, loadOnStartup = 1,
        initParams = {
                @WebInitParam(name = "name", value="hot")
        })*/
public class HelloServlet implements Servlet {

    public HelloServlet() {
        System.out.println("HelloServlet's constructor");
    }

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("init");
    }

    @Override
    public ServletConfig getServletConfig() {
        System.out.println("getServletConfig");
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        PrintWriter out = servletResponse.getWriter();
        System.out.println("Service");
        out.println("Enter the HelloServlet successful ");
    }

    @Override
    public String getServletInfo() {
        System.out.println("getServletInfo");
       return null;
    }

    @Override
    public void destroy() {
        System.out.println("destory ...");
    }
}
