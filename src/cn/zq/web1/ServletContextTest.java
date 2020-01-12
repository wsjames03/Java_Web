package cn.zq.web1;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


/*
该对象代表当前 WEB 应用: 可以认为 ServletContext 是当前 WEB 应用的一个大管家. 可以从中获取到当前 WEB 应用的各个方面的信息
 */
@WebServlet(name = "ServletContextTest",urlPatterns = "/ServletContextTest")
public class ServletContextTest extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //1.获取初始化参数
//        System.out.println("1.获取初始化参数");
        ServletContext sct = request.getServletContext();
        String user2 = request.getServletContext().getInitParameter("user");
        System.out.println("user is "+user2);
        System.out.println();

        //2.获取当前WEB应用的某一文件在服务器上的绝对路径
//        System.out.println("2.获取当前WEB应用的某一文件在服务器上的绝对路径");
        String realPath = sct.getRealPath("/note.txt");
        System.out.println(realPath);
        System.out.println();

        //3.获取当前WEB应用的名称
        //System.out.println("3.获取当前WEB应用的名称");
        System.out.println(sct.getContextPath());
        System.out.println();

        //4.获取当前WEB应用的某一个文件输入流
        InputStream is = sct.getResourceAsStream("/jdbc.properties");
        Properties properties = new Properties();
        properties.load(is);

        System.out.println("name:"+properties.getProperty("name"));
        System.out.println("user:"+properties.getProperty("user"));
        System.out.println("password:"+properties.getProperty("password"));
        System.out.println();

        //classLoader
        try {
            ClassLoader classLoader = getClass().getClassLoader();
            InputStream is2 = classLoader.getResourceAsStream("jdbc2.properties");
            Properties properties2 = new Properties();
            properties2.load(is2);

            System.out.println("name:"+properties2.getProperty("name"));
            System.out.println("user:"+properties2.getProperty("user"));
            System.out.println("password:"+properties2.getProperty("password"));
            System.out.println();
        } catch (Exception e){
            e.printStackTrace();
        }


    }
}
