package Servlet;

import Dao.impl.DaynumsDaoimpl;
import Entity.Daynums;
import net.sf.json.JSONArray;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
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
            //获取list封装成JSON  参考页面http://blog.csdn.net/yy280458609/article/details/7736334
            JSONArray jsonArray=JSONArray.fromObject(list);
            System.out.println(jsonArray.toString());
            /*
            接口制作 参考页面http://www.cnblogs.com/haochengjava/p/5084413.html
            * */
            resp.setContentType("text/html;charset=utf-8");//设置编码
            PrintWriter pw=resp.getWriter();
            pw.write(jsonArray.toString());//输出
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("chartJson");
    }
}
