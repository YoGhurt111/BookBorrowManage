package com.shu.DAO;


import com.shu.entity.Borrowbook;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BookBorrowDAO extends DAO{
    //获取查询结果列表
    private static List<Borrowbook> getList(String sql){
        List<Borrowbook> bookBorrowList = new ArrayList<Borrowbook>();
        ResultSet rs = DAO.query(sql);
        try{
            while (rs.next()){
                Borrowbook bookBorrow = new Borrowbook();
                bookBorrow.setReaderid(rs.getString("readerid"));
                bookBorrow.setIsbn(rs.getString("ISBN"));
                bookBorrow.setBorrowdate(rs.getDate("borrowdate"));
                bookBorrow.setReturndate(rs.getDate("returndate"));
                bookBorrow.setFine(rs.getDouble("fine"));
                bookBorrowList.add(bookBorrow);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        DAO.close();
        return bookBorrowList;
    }

    //更新，插入或删除操作
    private static int executeUpdate(String sql){
        int i;
        i = DAO.update(sql);
        DAO.close();
        return i;
    }

    //查找所有借阅信息
    public static List<Borrowbook> selectAll(){
        String sql = "select * from borrowbook";
        return getList(sql);
    }

    //根据ISBN查找借阅信息
    public static List<Borrowbook> selectByISBn(String bookId){
        String sql = "select * from borrowbook where ISBN = '%" + bookId + "%'" ;
        return getList(sql);
    }

    //根据readerId查找借阅信息
    public static List<Borrowbook> selectByReaderId(String readerId){
        String sql = "select * from borrowbook where readerid = '%" + readerId + "%'" ;
        return getList(sql);
    }


    //插入借阅信息
    public static int insertBookBorrow(String readerId, String bookId, Date borrowDate, Date returnDate, double fine){
        String sql = "insert into borrowbook values(" + readerId + "," + bookId + "," + borrowDate + ","
                + returnDate + "," + fine + ")";
        return executeUpdate(sql);
    }

    //修改借阅信息
    public static int updateBookBorrow(String readerId, String bookId, Date borrowDate, Date returnDate, double fine){
        String sql = "update borrowbook set readerid=" + readerId + ",ISBN="
                + bookId + ",borrowdate=" + borrowDate + ",returndate=" + returnDate
                + ",fine=" + fine + "where readerid=" + readerId;
        return executeUpdate(sql);
    }

    //删除借阅信息
    public static int deleteBookBorrow(String readerId, String bookId){
        String sql = "delete from borrowbook where readerid=" + readerId + "and ISBN=" + bookId;
        return executeUpdate(sql);
    }
}
