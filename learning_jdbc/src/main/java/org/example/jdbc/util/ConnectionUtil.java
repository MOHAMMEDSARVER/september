package org.example.jdbc.util;

import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class ConnectionUtil {
    private volatile static ConnectionUtil obj;
    private Properties props;


    private static final String URL = "url";
    private static final String USERNAME = "username";
    private static final String PASSWORD = "password";
    private static final String FILE_PATH = "/application.properties";

    private ConnectionUtil() {
        props = new Properties();
        try {
            props.load(ConnectionUtil.class.getResourceAsStream(FILE_PATH));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static ConnectionUtil getInstance() {
        if (obj == null) {
            synchronized (ConnectionUtil.class) {
                if (obj == null) {
                    obj = new ConnectionUtil();
                }
            }
        }
        return obj;
    }

    public Connection getConnectio() {
        Connection con = null;
        try {

            con = DriverManager.getConnection(props.getProperty(URL),
                    props.getProperty(USERNAME),
                    props.getProperty(PASSWORD));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return con;
    }

    public void close(Statement st, Connection con) {
        close(null, st, con);
    }

    public void close(ResultSet rs, Statement st, Connection con) {
        try {
            if (rs != null)
                rs.close();
            if (st != null)
                st.close();
            if (con != null)
                con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
