package oopsProject;

import java.sql.*;
import java.util.Date;

public class BookingDAO {
    public int getBookedCount(int busNo, Date date) throws SQLException {

        String query = "select count(PassengerName) from booking where busNum = ? and bookingDate = ?";
        Connection con = DBConn.getConn();
        PreparedStatement pst = con.prepareStatement(query);
        pst.setInt(1, busNo);

        // Here converting java.util.Date into java.sql.Date bcoz sql ku Date puriyura marika irukanum..
        java.sql.Date sqlDate = new java.sql.Date(date.getTime());
        pst.setDate(2, sqlDate);

        ResultSet rs = pst.executeQuery();
        rs.next();

        return rs.getInt(1);
    }
    public void addBooking(Booking booking) throws SQLException{
        String query = "INSERT INTO booking (PassengerName, age, busNum, bookingDate, bookingId) VALUES (?, ?, ?, ?, ?)";
        Connection con = DBConn.getConn();
        PreparedStatement pst = con.prepareStatement(query);
        pst.setString(1, booking.PassengerName);
        pst.setInt(2, booking.age);
        pst.setInt(3, booking.busNum);

        java.sql.Date sqldate = new java.sql.Date(booking.bookingDate.getTime());
        pst.setDate(4, sqldate);

        pst.setString(5, booking.bookingId);


        pst.executeUpdate();
    }
}
