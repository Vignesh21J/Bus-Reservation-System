package oopsProject;

import java.sql.*;

public class DBConn {
    private static final String url = "jdbc:mysql://localhost:3306/myBusResv";
    private static final String user = "root";  // your MySQL username
    private static final String password = "root";  // your MySQL password

    public static Connection getConn() throws SQLException{
        return DriverManager.getConnection(url, user, password);
    }
}
