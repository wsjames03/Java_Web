package cn.zq.web3;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CookieTest3Servlet",urlPatterns = "/CookieTest3Servlet")
public class CookieTest3Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        String brand = request.getParameter("name");
        Cookie brands = null;
        Cookie[] cookies = request.getCookies();
        if (cookies!=null && cookies.length>0){
            for (Cookie c :cookies){
                if (c.getName().equals("brand")){
                    brands=c;
                }
            }
        }
        Cookie newBrand =null;
        if(brands!=null){
            if(!brands.getValue().contains(brand)){
             newBrand = new Cookie("brand",brands.getValue()+"#"+brand);}
            else{
                newBrand = new Cookie("brand",brands.getValue());
            }
        }else{
            newBrand = new Cookie("brand",brand);
        }


        response.addCookie(newBrand);
        request.setAttribute("brand",newBrand.getValue());
        request.getRequestDispatcher("/list.jsp").forward(request,response);
    }
}
