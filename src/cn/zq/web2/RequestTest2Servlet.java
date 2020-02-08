package cn.zq.web2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "RequestTest2Servlet",urlPatterns = "/RequestTest2Servlet")
public class RequestTest2Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.获得表单提交的用户名和密码
        String name = request.getParameter("name");
        String password = request.getParameter("password");

        //2.判断是否正确,,只有等于 james 1234才成功
        if((!isNullOrEmpty(name)&&name.equals("james"))&&
                (!isNullOrEmpty(password))&&password.equals("1234")){
        //成功==>转发到成功页面
                request.getRequestDispatcher("/success.jsp").forward(request,response);
        }else{
        //失败==>转发到失败页面
            request.getRequestDispatcher("/fail.jsp").forward(request,response);
        }
        //请求包含
            request.getRequestDispatcher("/RequestTest1Servlet").include(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    protected static Boolean isNullOrEmpty(String s){
        if (s==null || s.trim().isEmpty()){
            return true;
        }
        return false;
    }
}
