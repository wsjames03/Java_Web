package cn.zq.web3;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

@WebServlet(name = "SessionTest1Servlet",urlPatterns = "/SessionTest1Servlet")
public class SessionTest1Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //1 如何获得session
        String bookName = URLDecoder.decode(request.getParameter("book"),"UTF-8");
        HttpSession session = request.getSession();

        LinkedHashMap<String,Integer> cart =null;
        if(session.getAttribute("cart")!=null){
            cart = (LinkedHashMap<String,Integer>)session.getAttribute("cart");
        }else{
            cart = new LinkedHashMap<>();
        }

        if (cart.containsKey(bookName)){
            Integer bookNum = cart.get(bookName);
            bookNum+=1;
            cart.put(bookName,bookNum);
        }else{
            cart.put(bookName,1);
        }

        session.setAttribute("cart",cart);
        response.sendRedirect(request.getContextPath()+"/shopping.jsp");
//        request.getRequestDispatcher("/shopping.jsp").forward(request,response);
        //2 如何操作session
        //			session.setAttribute(arg0, arg1)
        //			session.getAttribute(arg0)
        //			session.removeAttribute(arg0)
        //			session.getAttributeNames()
    }
}
