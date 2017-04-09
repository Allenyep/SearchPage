package Servlet;

import Dao.impl.IPDaoimpl;
import Entity.IP;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.InetAddress;

/**
 * Created by allen on 2017/4/9.
 */
@WebServlet("/IPServlet")
public class IPServlet extends HttpServlet{
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        InetAddress address = InetAddress.getLocalHost();
        String ip= address.getHostAddress();
        int nums=0;
        IP ipenty = null;
        IPDaoimpl ipd=new IPDaoimpl();
        try {
           ipenty=ipd.findByIP(ip);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(ipenty!=null){
            nums=(int)ipenty.getNumber()+1;
            ipenty.setNumber(nums);
            try {
                ipd.update(ipenty);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if(ipenty==null){
            ipenty=new IP(ip,nums);
            try {
                ipd.insert(ipenty);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        req.setAttribute("ip",ip);
        req.setAttribute("nums",nums);
        req.getRequestDispatcher("/testip.jsp").forward(req,resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.print("doget");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.print("dopost");
    }
}
