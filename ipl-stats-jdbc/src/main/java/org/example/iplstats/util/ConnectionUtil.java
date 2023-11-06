package org.example.iplstats.util;

import javax.imageio.IIOException;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class ConnectionUtil {
    private Properties prop;
    private volatile static ConnectionUtil obj;

    private static final String URL = "url";
    private static final String USERNAME = "username";
    private static final String PASSWORD = "password";
    private static final String FILE_PATH = "/application.properties";

    private ConnectionUtil() {
        prop = new Properties();
        try {
            prop.load(ConnectionUtil.class.getResourceAsStream(FILE_PATH));
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    public static ConnectionUtil getInstance() {
        if (obj == null) {
            synchronized (ConnectionUtil.class) {
                if (obj == null)
                    obj = new ConnectionUtil();
            }
        }
        return obj;
    }

    public Connection getConnection() {
        Connection con = null;
        try {

            con = DriverManager.getConnection(prop.getProperty(URL),
                    prop.getProperty(USERNAME),
                    prop.getProperty(PASSWORD));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return con;
    }

    public void close(ResultSet rs, Connection con, Statement st) {
        try {
            if (rs != null)
                rs.close();
            if (con != null)
                con.close();
            if (st != null)
                st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
