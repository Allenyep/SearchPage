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
}
