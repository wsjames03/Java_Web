package cn.zq.web2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static cn.zq.web2.RequestTest2Servlet.isNullOrEmpty;

@WebServlet(name = "RequestTest2Servlet",urlPatterns = "/RequestTest3Servlet")
public class RequestTest3Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.获得表单提交的用户名和密码
        String name = request.getParameter("name");
        String password = request.getParameter("password");

        Map<String,String> error = new HashMap<>();

        //2.判断是否正确,,只有等于 james 1234才成功
        if((isNullOrEmpty(name)||(!name.equals("james")))){
            //失败==>转发到失败页面
            error.put("name","用户名有误");
        }else if((isNullOrEmpty(password)||(!name.equals("password")))){
            //失败==>转发到失败页面
            error.put("name","密码有误");
        }

        request.setAttribute("error",error);

        if(error.size()>0){
            request.getRequestDispatcher("/fail.jsp").forward(request,response);
        }
        else{
            //成功==>转发到成功页面
            request.getRequestDispatcher("/success.jsp").forward(request,response);

        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

}
