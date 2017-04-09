package Servlet;

import Dao.impl.DaynumsDaoimpl;
import Entity.Daynums;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by allen on 2017/4/9.
 */
@WebServlet("/ChartServlet")
public class ChartServlet extends HttpServlet{
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        DaynumsDaoimpl dnd=new DaynumsDaoimpl();
        List<Daynums> list=null;
        try {
            list=dnd.selectAll();
            //TODO 获取list封装成JSON  参考页面http://blog.csdn.net/yy280458609/article/details/7736334
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
