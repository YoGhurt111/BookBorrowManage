package com.shu.DAO;



import com.shu.entity.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAO extends DAO{
    //获取查询结果列表
    private static List<User> getList(String sql){
        List<User> userList = new ArrayList<User>();
        ResultSet rs = DAO.query(sql);
        try{
            while (rs.next()){
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setPassword(rs.getString("password"));
                userList.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        DAO.close();
        return userList;
    }

    //更新，插入或删除操作
    private static int executeUpdate(String sql){
        int i;
        i = DAO.update(sql);
        DAO.close();
        return i;
    }

    //查找所有用户类型信息
    public static List<User> selectUser(){
        String sql = "select * from users";
        return getList(sql);
    }

    //根据userId查找用户类型信息
    public static List<User> selectUserById(int userId){
        String sql = "select * from users where id = " + userId ;
        return getList(sql);
    }

    //根据userName查找用户类型信息
    public static List<User> selectUserByName(String userName){
        String sql = "select * from users where name like '%" + userName + "%'" ;
        return getList(sql);
    }

    //插入用户类型
    public static int insertUser(int id, String name, String password){
        String sql = "insert into users values(" + id + "," + name + "," + password + ")";
        return executeUpdate(sql);
    }

    //修改用户类型
    public static int updateUser(int id, String name, String password){
        String sql = "update users set id=" + id + ",name="
                + name + ",password=" + password + " where id="
                + id;
        return executeUpdate(sql);
    }

    //删除读者类型
    public static int deleteUser(int id){
        String sql = "delete from users where id=" + id;
        return executeUpdate(sql);
    }
}
