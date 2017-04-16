package Dao.impl;

import Dao.DaynumsDao;
import Entity.Daynums;
import Utils.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by allen on 2017/4/9.
 */
public class DaynumsDaoimpl implements DaynumsDao {
    @Override
    public List<Daynums> selectAll() throws Exception {
        Connection conn=null;
        PreparedStatement ps=null;
        List<Daynums> list=new ArrayList<Daynums>();
        Daynums dn=null;
        try {
            conn= DBUtils.getConnection();
            ps=conn.prepareStatement("SELECT ipdate,nums FROM daynums");
            ResultSet rs=ps.executeQuery();
            while (rs.next()){
                dn=new Daynums(rs.getString(1),Integer.valueOf(rs.getString(2)));
                list.add(dn);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DBUtils.closeConnection();
        }
        return list;
    }

    @Override
    public Daynums selectBydate(String date) throws Exception {
        Connection conn=null;
        PreparedStatement ps=null;
        Daynums dn=null;
        try {
            conn= DBUtils.getConnection();
            ps=conn.prepareStatement("SELECT ipdate,nums FROM daynums WHERE ipdate=?");
            ps.setString(1,date);
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
                dn=new Daynums(rs.getString(1),Integer.parseInt(rs.getString(2)));
                return dn;
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DBUtils.closeConnection();
        }
        return null;
    }

    @Override
    public void update(Daynums dayn) throws Exception {
        Connection conn=null;
        PreparedStatement ps=null;
        try {
            conn=DBUtils.getConnection();
            ps=conn.prepareStatement("UPDATE daynums SET nums=? WHERE ipdate=?");
            ps.setString(1, String.valueOf(dayn.getDaynums()));
            ps.setString(2,dayn.getDay());
            int result=ps.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DBUtils.closeConnection();
        }
    }

    @Override
    public void insert(Daynums dayn) throws Exception {
        Connection conn=null;
        PreparedStatement ps=null;
        try {
            conn=DBUtils.getConnection();
            ps=conn.prepareStatement("INSERT INTO daynums (ipdate,nums)VALUES (?,?)");
            ps.setString(1,dayn.getDay());
            ps.setString(2, String.valueOf(dayn.getDaynums()));
            int result=ps.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DBUtils.closeConnection();
        }
    }


}
