import java.time.LocalDate;

public class Booking {
    private Customer customer;
    private Room room;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private int duration;

    public Booking(Customer customer, Room room) {
        this.customer = customer;
        this.room = room;
        this.room.bookRoom();

        Logger.log("🛏️ Booking Created: " + customer.getName() + " | Room: " + room.getRoomNumber());
    }


    public Room getRoom() {
        return room;
    }

    public Customer getCustomer() {
        return customer;
    }

    @Override
    public String toString() {
        return customer.toString() + " | " + room.toString();
    }
}