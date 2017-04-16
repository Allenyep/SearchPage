package Utils;

import Dao.impl.IPDaoimpl;
import Entity.IP;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.sql.SQLException;
import java.util.Locale;

/**
 * Created by allen on 2017/4/15.
 */

@WebListener
public class testListener implements HttpSessionListener {

    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        //创建Session时获取IP地址存入数据库，先查询数据库信息如果有相同IP，对应IPnums++
        System.out.println("sessionCreated");
        httpSessionEvent.getSession().setMaxInactiveInterval(30);//设置Session时间
    }


    /**
     * session销毁时将访问量计入数据库
     * @param httpSessionEvent
     */
    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        //根据前台统计PV传回PVnums然后写入数据库
        System.out.println("sessionDestroyed");
        String ipadd=(String) httpSessionEvent.getSession().getAttribute("ip");
        Long Stripnums= (Long) httpSessionEvent.getSession().getAttribute("ipnums");
        int ipnums= Math.toIntExact(Stripnums);
        System.out.println("ip is "+ipadd+" and nums is "+ ipnums);

        IPDaoimpl ipl=new IPDaoimpl();
        IP ipentity=new IP(ipadd,ipnums);
        try {
            if(ipl.findByIP(ipadd)!=null){
//                ipnums=ipl.findByIP(ipadd).getNumber()+ipnums;
                ipentity.setNumber(ipl.findByIP(ipadd).getNumber()+ipnums);
                ipl.update(ipentity);
            }else {
                ipl.insert(ipentity);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
