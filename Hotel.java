import java.util.ArrayList;

public class Hotel {
    private ArrayList<Room> rooms = new ArrayList<>();
    private ArrayList<Booking> bookings = new ArrayList<>();

    public void addRoom(Room room) {
        rooms.add(room);
    }

    public void showRooms() {
        for (Room room : rooms) {
            System.out.println(room);
        }
    }

    public void bookRoom(Customer customer, int roomNumber) {
        for (Room room : rooms) {
            if (room.getRoomNumber() == roomNumber && room.isAvailable()) {
                Booking booking = new Booking(customer, room);
                bookings.add(booking);
                Logger.log("Room " + roomNumber + " booked by " + customer.getName());
                System.out.println("✅ Room booked successfully!");
                return;
            }
        }
        System.out.println("❌ Room is not available!");
    }

    public void showBookings() {
        for (Booking booking : bookings) {
            System.out.println(booking);
        }
    }
}