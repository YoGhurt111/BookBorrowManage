package com.shu.DAO;


import com.shu.entity.Readertype;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ReaderTypeDAO {

    //获取查询结果列表
    private static List<Readertype> getList(String sql){
        List<Readertype> readerTypeList = new ArrayList<Readertype>();
        ResultSet rs = DAO.query(sql);
        try{
            while (rs.next()){
                Readertype readerType = new Readertype();
                readerType.setId(rs.getInt("id"));
                readerType.setTypename(rs.getString("typename"));
                readerType.setMaxborrownum(rs.getInt("maxborrownum"));
                readerType.setLimitday(rs.getInt("limitday"));
                readerTypeList.add(readerType);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        DAO.close();
        return readerTypeList;
    }

    //更新，插入或删除操作
    private static int executeUpdate(String sql){
        int i;
        i = DAO.update(sql);
        DAO.close();
        return i;
    }

    //查找所有读者类型信息
    public static List<Readertype> selectReaderType(){
        String sql = "select * from readertype";
        return getList(sql);
    }

    //根据readerTypeId查找读者类型信息
    public static List<Readertype> selectReaderTypeById(int typeId){
        String sql = "select * from readertype where id = " + typeId ;
        return getList(sql);
    }

    //根据readerTypeName查找读者类型信息
    public static List<Readertype> selectReaderTypeByName(String typeName){
        String sql = "select * from readertype where typename like '%" + typeName + "%'" ;
        return getList(sql);
    }

    //插入读者类型
    public static int insertReaderType(int id, String name, int num, int limit){
        String sql = "insert into readertype values(" + id + "," + name + "," + num + ","
                + limit + ")";
        return executeUpdate(sql);
    }

    //修改读者类型
    public static int updateReaderType(int id, String name, int num, int limit){
        String sql = "update readertype set id=" + id + ",typename="
                + name + ",maxborrownum=" + num + ",limitday=" + limit + "where id="
                + id;
        return executeUpdate(sql);
    }

    //删除读者类型
    public static int deleteReaderType(int id){
        String sql = "delete from readertype where id=" + id;
        return executeUpdate(sql);
    }
}
