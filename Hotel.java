import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Hotel {
    private List<List<Room>> floors = new ArrayList<>();
    private List<Booking> bookings = new ArrayList<>();

    public Hotel() {
        for (int floor = 1; floor <= 3; floor++) {
            List<Room> floorRooms = new ArrayList<>();
            for (int i = 1; i <= 3; i++) {
                int roomNumber = (floor * 100) + i;  //
            }
            floors.add(floorRooms);
        }
    }

    public void customerBookingMenu() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n01 Standard , 02 Deluxe , 03 Suite:");
            showRooms();
            System.out.print("Select Room to Booking. (0 = Go Back): ");
            int roomNumber = scanner.nextInt();
            scanner.nextLine();

            if (roomNumber == 0) {
                System.out.println("Back to Role Select Page......");
                return;
            }

            System.out.print("Enter Your Name: ");
            String name = scanner.nextLine();
            System.out.print("Phone Number: ");
            String phone = scanner.nextLine();

            Customer customer = new Customer(name, phone);
            bookRoom(customer, roomNumber);

            System.out.println("Successfully Booking a Room ✅");
            return;
        }
    }

    public void showRooms() {
        for (int floor = 0; floor < floors.size(); floor++) {
            System.out.println("Floor " + (floor + 1));
            for (Room room : floors.get(floor)) {
                System.out.println("   Room " + room.getRoomNumber() + " - " + (room.isAvailable() ? "🟢 Available" : "🔴 Booked"));
            }
        }
    }

    public void bookRoom(Customer customer, int roomNumber) {
        for (List<Room> floorRooms : floors) {
            for (Room room : floorRooms) {
                if (room.getRoomNumber() == roomNumber && room.isAvailable()) {
                    Booking newBooking = new Booking(customer, room);
                    bookings.add(newBooking);

                    Logger.log("✅ Room " + roomNumber + " Booked by " + customer.getName());
                    System.out.println("✅ Room " + roomNumber + " Booked by " + customer.getName());
                    return;
                }
            }
        }
        System.out.println("❌ This Room Can't Booking ❌");
    }

    public void addRoom(int floor, Room room) {
        if (floor >= 1 && floor <= floors.size()) {
            floors.get(floor - 1).add(room);
        } else {
            System.out.println("❌ The Room Doesn't Exist in The Hotel ❌");
        }
    }

    public void cancelBooking() {
        Scanner scanner = new Scanner(System.in);

        if (bookings.isEmpty()) {
            System.out.println("❌ No Bookings to Cancel ❌");
            return;
        }

        System.out.println("\n📌 Current Bookings List:");
        for (int i = 0; i < bookings.size(); i++) {
            System.out.println((i + 1) + ". " + bookings.get(i));
        }

        System.out.print("Select The Bookings Number to Cancel (0 = Go Back): ");
        int choice = scanner.nextInt();

        if (choice > 0 && choice <= bookings.size()) {
            Booking removed = bookings.remove(choice - 1);
            removed.getRoom().freeRoom();

            Logger.log("❌ Booking Canceled: " + removed.getCustomer().getName() + " | Room: " + removed.getRoom().getRoomNumber());
            System.out.println("Booking canceled successfully ✅");
        } else {
            System.out.println("❌ The selected Booking was not found ❌");
        }
    }


}