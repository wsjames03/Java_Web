package cn.zq.web3;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CookieTest4Servlet",urlPatterns = "/CookieTest4Servlet")
public class CookieTest4Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    // 1.获得用户名
        String name = request.getParameter("name");
        String remember = request.getParameter("remember");

        //新建Cookie
        Cookie cookie = new Cookie("name",name);

     //2.判断remember
        //null 没有勾选
        //yes
    if(remember!=null && remember.equals("yes")){
        cookie.setMaxAge(60*60*24*7);
    }else{
        cookie.setMaxAge(0);
    }
    // 3.将Cookie添加到response
      response.addCookie(cookie);
    // 4.跳转到成功界面
       request.getRequestDispatcher("/index.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie cookie = new Cookie("er","18");
        //1>设置一个正数,标示最大有效时间.单位是秒
        //cookie.setMaxAge(60*60);
        //2>设置为-1 , 就是相当于默认有效时间, 浏览器关闭就消失.
                //cookie.setMaxAge(-1);
        cookie.setMaxAge(3600);
        cookie.setPath(request.getServletPath());
        response.addCookie(cookie);

      /*  4.cookie中的域 (了解)
        	想要以下三个 主机和主机下的项目能共享一个cookie.
        		www.baidu.com
        		music.baidu.com
        		map.baidu.com
        	完成两步即可:
        		1.设置cookie的域为 ".baidu.com"
        		2.设置cookie路径 为: "/"
        	以上就是跨主机访问cookie.不常用.*/
      //cookie.setDomain(".baidu.com");

    }
}
