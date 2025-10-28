package oopsProject;

import java.security.SecureRandom;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Scanner;

public class Booking {
    String PassengerName;
    int age;
    int busNum;
    java.util.Date bookingDate;
    String bookingId;

    Booking() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Your Name: ");
        PassengerName = sc.next();

        System.out.println("Enter Your Age: ");
        age = sc.nextInt();

        System.out.println("Enter Your Preferred Bus Number: ");
        busNum = sc.nextInt();

        System.out.println("Enter your Journey Date: ");
        String journeyDate = sc.next();

        // Convert String date to Date date
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

        try {
            bookingDate = sdf.parse(journeyDate);
        }
        catch (Exception e){
            throw new RuntimeException(e);
        }

        bookingId = generateUniqueBookingId();
    }


    private static Set<String> usedBookingIds = new HashSet<>();

    private String generateUniqueBookingId() {
        SecureRandom scr = new SecureRandom();
        String id;

        do {
            StringBuilder sb = new StringBuilder("ID-");
            for(int i = 0; i < 6; i++) {
                sb.append(scr.nextInt(10));
            }
            id = sb.toString();
        } while(usedBookingIds.contains(id));

        usedBookingIds.add(id);
        return id;
    }

    public String getBookingId() {
        return bookingId;
    }

    public boolean isAvailable() throws SQLException {
        int availableSeats = 0;
        BusDAO busdao = new BusDAO();
        availableSeats = busdao.getCapacity(busNum);

        int bookedSeats = 0;
        BookingDAO bookingdao = new BookingDAO();
        bookedSeats = bookingdao.getBookedCount(busNum, bookingDate);

        return (bookedSeats < availableSeats);
    }
}
