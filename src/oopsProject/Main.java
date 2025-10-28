package oopsProject;


import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

//        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            System.out.println("Driver loaded successfully!");
//        }
//        catch (Exception e) {
//            System.err.println("Error Message: " + e.getMessage());
//        }

        BusDAO busdao = new BusDAO();
        try {
            busdao.displayBusInfo();
        }
        catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }

        Scanner sc = new Scanner(System.in);
        int userChoice = 1;

        while(userChoice == 1) {
            System.out.println("Enter 1 to Book Tickets OR 2 to Exit!");
            userChoice = sc.nextInt();

            if(userChoice == 1) {
                Booking booking = new Booking();
                System.out.println("Booking...");

                try {
                    if (booking.isAvailable()) {
                        BookingDAO bookingDAO = new BookingDAO();
                        bookingDAO.addBooking(booking);

                        System.out.println("Ticket Purchased Successfully!!..");
                        System.out.println("Your Booking Id: " + booking.getBookingId());
                    } else {
                        System.out.println("This Bus is Full..!");
                    }
                }
                catch (Exception e) {
                    System.err.println("Error: " + e.getMessage());
                }
            }

        }
    }
}
