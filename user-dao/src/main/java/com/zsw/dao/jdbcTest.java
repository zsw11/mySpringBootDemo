package com.zsw.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author zsw
 * @date 2021/3/1 15:58
 * @description :
 */
public class jdbcTest {

    public static void main(String[] args) throws SQLException {
        String url = "jdbc:mysql://localhost:3306/gen_test?useUnicode=true&characterEncoding=utf8&characterSetResults=utf8&useSSL=false";
        String uname = "root";
        String passwd = "123456";

        Connection con = null;
        PreparedStatement ps=null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url,uname,passwd);
            //设置是否自动提交,默认是true
            con.setAutoCommit(false);

            //转出操作
            String sql = "update account set money=money-1000 where name=?";
            ps = con.prepareStatement(sql);
            ps.setString(1, "bbb");

            ps.executeUpdate();
            //异常代码
            int i = 1 / 0;

            //转入操作
            sql = "update account set money=money+1000 where name=?";
            ps = con.prepareStatement(sql);
            ps.setString(1, "ccc");
            ps.executeUpdate();

            //手动提交事务
            con.commit();

        } catch (Exception e) {
            try {
                con.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        }finally {
            con.close();
            ps.close();
        }
    }
}
