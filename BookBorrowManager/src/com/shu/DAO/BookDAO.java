package com.shu.DAO;


import com.shu.entity.Book;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BookDAO extends DAO{
    //获取查询结果列表
    private static List<Book> getList(String sql){
        List<Book> bookList = new ArrayList<Book>();
        ResultSet rs = DAO.query(sql);
        try{
            while (rs.next()){
                Book book = new Book();
                book.setIsbn(rs.getString("ISBN"));
                book.setTypeid(rs.getString("typeid"));
                book.setBookname(rs.getString("bookname"));
                book.setPrinttime(rs.getInt("printtime"));
                book.setAuthor(rs.getString("author"));
                book.setPublish(rs.getString("publish"));
                book.setPublishdate(rs.getDate("publishdate"));
                book.setUnitprice(rs.getDouble("unitprice"));
                bookList.add(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        DAO.close();
        return bookList;
    }

    //更新，插入或删除操作
    private static int executeUpdate(String sql){
        int i;
        i = DAO.update(sql);
        DAO.close();
        return i;
    }

    //查找所有书籍信息
    public static List<Book> selectBook(){
        String sql = "select * from book";
        return getList(sql);
    }

    //根据ISBN查找书籍信息
    public static List<Book> selectBookByISBN(String ISBN){
        String sql = "select * from book where ISBN = '%" + ISBN + "%'" ;
        return getList(sql);
    }

    //根据typeid查找书籍信息
    public static List<Book> selectBookByTypeId(String typeId){
        String sql = "select * from book where typeid = '%" + typeId + "%'" ;
        return getList(sql);
    }

    //根据bookname查找书籍信息
    public static List<Book> selectBookByBookName(String bookName){
        String sql = "select * from book where bookname like '%" + bookName + "%'" ;
        return getList(sql);
    }

    //插入书籍
    public static int insertBook(String id, String typeId, String bookName, String author, String publish, Date publishDate, int printTime, double unitPrice){
        String sql = "insert into book values(" + id + "," + typeId + "," + bookName + ","
                + author + "," + publish + "," + publishDate + "," + printTime + ","
                + unitPrice + ")";
        return executeUpdate(sql);
    }

    //修改书籍
    public static int updateBook(String id, String typeId, String bookName, String author, String publish, Date publishDate, int printTime, double unitPrice){
        String sql = "update book set ISBN=" + id + ",typeid="
                + typeId + ",bookname=" + bookName + ",author="
                + author + ",publish=" + publish + ",publishdate="
                + publishDate + ",printtime=" + printTime + ",unitprice="
                + unitPrice + "where ISBN=" + id;
        return executeUpdate(sql);
    }

    //删除书籍
    public static int deleteBook(String id){
        String sql = "delete from book where ISBN=" + id;
        return executeUpdate(sql);
    }
}
