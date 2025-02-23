public class Booking {
    private Customer customer;
    private Room room;

    public Booking(Customer customer, Room room) {
        this.customer = customer;
        this.room = room;
        this.room.bookRoom();
    }

    public void checkOut() {
        this.room.freeRoom();
    }

    @Override
    public String toString() {
        return customer.toString() + " | " + room.toString();
    }
}