package Dao.impl;

import Dao.IPDao;
import Entity.IP;
import Utils.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Created by allen on 2017/4/9.
 */
public class IPDaoimpl implements IPDao{

    @Override
    public void update(IP ip) throws Exception {
        Connection conn=null;
        PreparedStatement ps=null;

        try {
            conn=DBUtils.getConnection();
            ps = conn.prepareStatement("UPDATE iplist SET nums = ? WHERE ip = ?");
            ps.setString(1,String.valueOf(ip.getNumber()));
            ps.setString(2,ip.getIp());

            int i=ps.executeUpdate();

        }catch (Exception e){
           e.printStackTrace();
        }finally {
            DBUtils.closeConnection();
        }

    }

    @Override
    public void insert(IP ip) throws Exception {
        Connection conn=null;
        PreparedStatement ps=null;

        try {
            conn=DBUtils.getConnection();
            ps = conn.prepareStatement("INSERT INTO iplist(ip,nums) VALUES(?,?)");
            ps.setString(1,ip.getIp());
            ps.setString(2,String.valueOf(ip.getNumber()));

            int i=ps.executeUpdate();

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DBUtils.closeConnection();
        }
    }

    @Override
    public IP findByIP(String ip) throws Exception {
        Connection conn=null;
        PreparedStatement ps=null;

        try {
            conn=DBUtils.getConnection();
            ps=conn.prepareStatement("SELECT ip,nums FROM iplist WHERE ip=?");
            ps.setString(1,ip);
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
                IP ip1=new IP(rs.getString(1),Integer.valueOf(rs.getString(2)));
                return ip1;
            }
            return null;

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DBUtils.closeConnection();
        }

        return null;
    }
}
