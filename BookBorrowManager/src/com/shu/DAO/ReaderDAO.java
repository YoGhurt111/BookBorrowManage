package com.shu.DAO;

import com.shu.entity.Reader;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ReaderDAO extends DAO{

    //获取查询结果列表
    private static List<Reader> getList(String sql){
        List<Reader> readerList = new ArrayList<Reader>();
        ResultSet rs = DAO.query(sql);
        try{
            while (rs.next()){
                Reader reader = new Reader();
                reader.setReaderid(rs.getString("readerid"));
                reader.setName(rs.getString("name"));
                reader.setType(rs.getInt("type"));
                reader.setAge(rs.getInt("age"));
                reader.setSex(rs.getString("sex"));
                reader.setDept(rs.getString("department"));
                reader.setPhone(rs.getString("phoneNumber"));
                reader.setRegdate(rs.getDate("registerDate"));
                readerList.add(reader);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        DAO.close();
        return readerList;
    }

    //更新，插入或删除操作
    private static int executeUpdate(String sql){
        int i;
        i = DAO.update(sql);
        DAO.close();
        return i;
    }

    //查找所有读者信息
    public static List<Reader> selectReader(){
        String sql = "select * from reader";
        return getList(sql);
    }

    //根据readerId查找读者信息
    public static List<Reader> selectReaderById(String readerId){
        String sql = "select * from reader where readerid = '%" + readerId + "%'" ;
        return getList(sql);
    }

    //根据name查找读者信息
    public static List<Reader> selectReaderByName(String readerName){
        String sql = "select * from reader where name like '%" + readerName + "%'" ;
        return getList(sql);
    }

    //插入读者
    public static int insertReader(String id, String name, String readerTypeId, int age, String sex, String phoneNumber, String department, Date registerDate){
        String sql = "insert into reader values(" + id + "," + readerTypeId + "," + name + ","
                + age + "," + sex + "," + phoneNumber + "," + department + ","
                + registerDate + ")";
        return executeUpdate(sql);
    }

    //修改读者
    public static int updateReader(String id, String name, int type, int age, String sex, String phoneNumber, String department, Date registerDate){
        String sql = "update reader set readerid=" + id + ",name="
                + name + ",type=" + type + ",age="
                + age + ",sex=" + sex + ",age=" + age + ",phone="
                + phoneNumber + ",dept=" + department + ",regdate="
                + registerDate +"where readerid=" + id;
        return executeUpdate(sql);
    }

    //删除读者
    public static int deleteReader(String id){
        String sql = "delete from reader where readerid=" + id;
        return executeUpdate(sql);
    }
}
