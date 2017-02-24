package com.shu.DAO;


import com.shu.entity.Booktype;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookTypeDAO extends DAO{
    //获取查询结果列表
    private static List<Booktype> getList(String sql){
        List<Booktype> booktypeList = new ArrayList<Booktype>();
        ResultSet rs = DAO.query(sql);
        try{
            while (rs.next()){
                Booktype booktype = new Booktype();
                booktype.setId(rs.getInt("id"));
                booktype.setTypename(rs.getString("typename"));
                booktypeList.add(booktype);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        DAO.close();
        return booktypeList;
    }

    //更新，插入或删除操作
    private static int executeUpdate(String sql){
        int i;
        i = DAO.update(sql);
        DAO.close();
        return i;
    }

    //查找所有书籍类型信息
    public static List<Booktype> selectBookType(){
        String sql = "select * from booktype";
        return getList(sql);
    }

    //根据id查找书籍类型信息
    public static List<Booktype> selectBookTypeById(int typeId){
        String sql = "select * from booktype where id = " + typeId ;
        return getList(sql);
    }

    //根据name查找书籍类型信息
    public static List<Booktype> selectBookTypeByName(String typeName){
        String sql = "select * from booktype where typename like '%" + typeName + "%'" ;
        return getList(sql);
    }

    //插入书籍类型
    public static int insertBookType(int id, String name){
        String sql = "insert into booktype values(" + id + "," + name + ")";
        return executeUpdate(sql);
    }

    //修改书籍类型
    public static int updateBookType(int id, String name){
        String sql = "update booktype set id=" + id + ",typename="
                + name +" where id=" + id;
        return executeUpdate(sql);
    }

    //删除读者类型
    public static int deleteReaderType(int id){
        String sql = "delete from booktype where id=" + id;
        return executeUpdate(sql);
    }
}
