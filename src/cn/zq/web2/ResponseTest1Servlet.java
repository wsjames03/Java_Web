package cn.zq.web2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

@WebServlet(name = "ResponseTest1Servlet",urlPatterns = "/ResponseTest1Servlet")
public class ResponseTest1Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//        sendNotFound(request,response); //例一: 手动向浏览器发送404
//        sendRedirect1(request,response);//重定向1
//        sendRedirect2(request,response);//重定向2
//        setRefresh(request,response);//Refresh头.刷新
//        sendByStream(request,response);//发送字节流. 发送中文.
//        sendByWriter(request,response);//发送字符流. 发送中文.
//        sendPhotoByStream(request,response);//使用字节流发送图片
          sendFileByStream(request,response);//使用字节流发送下载文件

    }

    private void sendFileByStream(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("");//告诉浏览器发送给他的流的MIME类型



        //1.获取要下载的文件的绝对路径
        String realPath = this.getServletContext().getRealPath("/water.jpg");
        //2.获取要下载的文件名
        String fileName = realPath.substring(realPath.lastIndexOf("//")+1);
        //3.设置content-disposition响应头控制浏览器以下载的形式打开文件
        response.setHeader("content-disposition", "attachment;filename="+fileName);

        InputStream is1 = new FileInputStream(realPath);

        //通过response获得输出字节流
        OutputStream os = response.getOutputStream();
        //两个流对接
        byte[] buf = new byte[1024];
        int len = 0;
        while ((len = is1.read(buf))>0){
            os.write(buf,0,len);
            os.flush();
        }
        is1.close();
        os.close();
    }

    private void sendPhotoByStream(HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.setContentType("image/jpeg");//告诉浏览器发送给他的流的MIME类型

        //获得图片的输入流
        //InputStream is1 = new FileInputStream(this.getServletContext().getRealPath("/water.jpg"));
        InputStream is1 = this.getServletContext().getResourceAsStream("/water.jpg");
        //通过response获得输出字节流
        OutputStream os = response.getOutputStream();
        //两个流对接
        byte[] buf = new byte[1024];
        int len = 0;
        while ((len = is1.read(buf))>0){
            os.write(buf,0,len);
            os.flush();
        }
        is1.close();
        os.close();
    }

    private void sendByWriter(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //控制浏览器使用什么编码表解码
        response.setContentType("text/html;charset=utf-8");//==>会自动调用setCharacterEncoding
        //控制字符流的使用编码
//        response.setCharacterEncoding("UTF-8");

        //1.获得字符流
        PrintWriter pw = response.getWriter();

        //2.发送中文
        pw.print("你好，世界");

    }

    private void sendByStream(HttpServletRequest request, HttpServletResponse response) throws IOException {

        //1.获得输出字字符流
        OutputStream os = response.getOutputStream();
        //2.输出中文
        os.write("你好，世界".getBytes("UTF-8"));
        //3.告诉浏览器使用的编码
     //  os.write("<meta http-equiv='Content-Type' content='text/html;charset=gbk'>".getBytes());
        response.setContentType("text/html;charset=utf-8");
    }

    private void setRefresh(HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.setContentType("text/html;charset=utf-8");

        //1.设置响应头Refresh,跳转到HelloServlet
        response.setHeader("Refresh","5;url="+request.getServletContext().getContextPath()+"/HelloServlet");

        //2.使用字符流发送提示，5秒跳转
        response.getWriter().print("您将在5秒后跳转到HelloServlet");
    }

    protected void sendNotFound(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //response.setStatus(response.SC_NOT_FOUND);
        response.sendError(response.SC_NOT_FOUND,"就不告诉你");
    }

    protected void sendRedirect1(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //重定向
        //1返回状态码为302
        response.setStatus(302);
        //告诉浏览器去哪里找新地址
        response.setHeader("Location","http://www.baidu.com");
    }

    protected void sendRedirect2(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect(request.getContextPath()+"/HelloServlet");
    }


}
