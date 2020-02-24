package cn.zq.web3;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "SessionTest2Servlet",urlPatterns = "/SessionTest2Servlet")
public class SessionTest2Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        System.out.println(new Date(session.getCreationTime()).toLocaleString());
        System.out.println(new Date(session.getLastAccessedTime()).toLocaleString());
        System.out.println(session.getId());
        System.out.println(session.getMaxInactiveInterval());
        System.out.println(session.isNew());

    }
}
