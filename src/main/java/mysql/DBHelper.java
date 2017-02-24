package mysql;

import java.io.IOException;
import java.sql.*;
import java.util.Properties;

/**
 * DBHelper
 *
 * @author liuruichao
 * @date 15/9/6 下午1:26
 */
public final class DBHelper {
    private static final String driverClass;
    private static final String url;
    private static final String username;
    private static final String password;
    private static final int PORT = 3306;

    static {
        Properties props = new Properties();
        try {
            props.load(DBHelper.class.getClassLoader().getResourceAsStream("jdbc.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        driverClass = props.getProperty("driverClass");
        url = props.getProperty("jdbcUrl");
        username = props.getProperty("user");
        password = props.getProperty("password");
    }

    public static Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName(driverClass);
            conn = DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }

    public static void closeConn(Connection conn, Statement state, ResultSet rs) {
        try {
            if (rs != null) rs.close();
            if (state != null) state.close();
            if (conn != null) conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
