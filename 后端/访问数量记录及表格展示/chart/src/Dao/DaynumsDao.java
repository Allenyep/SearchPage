package Dao;

import Entity.Daynums;

import java.util.List;

/**
 * Created by allen on 2017/4/9.
 */
public interface DaynumsDao {
    /*
    * 读取所有数据
    * */
    public List<Daynums> selectAll() throws Exception;


    /*
    *
    * 根据日期查询数据
    * */
    public Daynums selectBydate(String date)throws Exception;

    /*
    * 更新日期中的数据
    * */
    public void update(Daynums dayn)throws Exception;

    /*
    * 插入某日数据
    * */
    public void insert(Daynums dayn)throws Exception;


}
