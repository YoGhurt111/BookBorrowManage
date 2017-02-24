package com.shu.DAO;


import java.sql.*;

public class DAO {
    private static String className = "com.mysql.jdbc.Driver";
    private static String url = "jdbc:mysql://localhost:3306/book_borrow?useUnicode=true&characterEncoding=utf-8&useSSL=false";
    private static String user = "root";
    private static String password = "123456";
    private static PreparedStatement stmt;
    private static Connection conn;

    //连接数据库
    DAO(){
        if (conn == null) {
            try {
                Class.forName(className);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            try {
                conn = DriverManager.getConnection(url, user, password);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        else
            return;
    }

    //查询
    public static ResultSet query(String sql){
        if (conn == null){
            new DAO();
        }
        try{
            stmt = conn.prepareStatement(sql);
            return stmt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    //更新，插入与删除操作
    public static int update(String sql){
        if (conn == null){
            new DAO();
        }
        try{
            stmt = conn.prepareStatement(sql);
            return stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }

    //关闭连接
    public static void close(){
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            conn = null;
        }
    }

}
