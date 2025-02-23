import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Hotel hotel = HotelFactory.createHotel(); // ใช้ Factory
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Hotel Management System");
            System.out.println("1. Show Rooms");
            System.out.println("2. Book Room");
            System.out.println("3. Show Bookings");
            System.out.println("4. Exit");
            System.out.print("Select option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    hotel.showRooms();
                    break;
                case 2:
                    System.out.print("Enter customer name: ");
                    String name = scanner.next();
                    System.out.print("Enter phone number: ");
                    String phone = scanner.next();
                    System.out.print("Enter room number: ");
                    int roomNumber = scanner.nextInt();
                    hotel.bookRoom(new Customer(name, phone), roomNumber);
                    break;
                case 3:
                    hotel.showBookings();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }
}