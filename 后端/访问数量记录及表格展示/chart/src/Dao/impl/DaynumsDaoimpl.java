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
}
