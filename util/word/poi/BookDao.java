package com.yabushan.test.util.word.poi;


import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;


public class BookDao {

    private String driverClass = "com.mysql.jdbc.Driver";
    private String url = "jdbc:mysql://localhost:3306/db_Database02";
    private String user = "root";
    private String password = "111";

    public BookDao() {
        try {
            Class.forName(driverClass).newInstance();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List getBooks() throws Exception {
        List list = new ArrayList();
        Statement stmt = null;
        ResultSet rs = null;
        Connection conn = getConn();
        try {
            String sql = "SELECT * FROM tb_databasetoexcel";
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                BookBean book = new BookBean();
                book.setISBN(rs.getString("ISBN"));
                book.setBookName(rs.getString("bookName"));
                book.setPrice(rs.getFloat("price"));
                book.setPublishing(rs.getString("publishing"));
                book.setDate(rs.getDate("date"));
                book.setWriter(rs.getString("writer"));
                list.add(book);
            }
        } catch (SQLException ex) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, ex);
        } finally {
            close(rs, stmt, conn);
        }
        return list;
    }

    private Connection getConn() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user, password);
        } catch (SQLException ex) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, ex);
        }
        return conn;
    }

    private void close(ResultSet rs, Statement stmt, Connection conn) {
        try {
            if (rs != null) {
                rs.close();
            }
            if (stmt != null) {
                stmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, ex);
        }
    }
}
