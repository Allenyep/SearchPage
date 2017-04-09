package Dao;

import Entity.IP;

/**
 * Created by allen on 2017/4/9.
 */
public interface IPDao {
    /*
    刷新IP访问次数
    * */
    public void update(IP ip) throws Exception;

    /*
    添加IP
    * */
    public void insert(IP ip)throws Exception;

    /*
    * 查询IP
    * */
    public IP findByIP(String ip)throws Exception;
}
