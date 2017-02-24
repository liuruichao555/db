package mysql.query;

import mysql.DBHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * QueryTest1
 *
 * @author liuruichao
 * @date 15/9/6 下午3:46
 */
public class QueryTest1 {
    public static void main(String[] args) throws SQLException {
        Connection conn = DBHelper.getConnection();
        PreparedStatement pstate = conn.prepareStatement("select * from test_index where username = ? and realname = ?");
        pstate.setString(1, "liuruichao");
        pstate.setString(2, "刘瑞超1");
        long start = System.currentTimeMillis();
        ResultSet rs = pstate.executeQuery();
        System.out.println(rs);
        long end = System.currentTimeMillis();
        System.out.println(end - start);
        DBHelper.closeConn(conn, pstate, null);
    }
}
