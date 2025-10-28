package oopsProject;

import java.sql.*;

public class BusDAO {

    public void displayBusInfo() throws SQLException {
        Connection con = DBConn.getConn();
        String query = "select * from bus";

        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(query);

        while (rs.next()) {
            System.out.println("Bus Number: " + rs.getInt(1));

            if(rs.getInt(2) == 0) {
                System.out.println("Ac: NO");
            } else {
                System.out.println("Ac: YES");
            }

            System.out.println("Seat Available: " + rs.getInt(3));

            System.out.println("========================================");
        }
    }

    public int getCapacity(int id) throws SQLException {

        String query = "select capacity from bus where busNumber = " + id;

        Connection con = DBConn.getConn();
        Statement st = con.createStatement();

        ResultSet rs = st.executeQuery(query);

        rs.next();
        return rs.getInt(1);
    }

}
