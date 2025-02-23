public class HotelFactory {
    public static Hotel createHotel() {
        Hotel hotel = new Hotel();
        hotel.addRoom(new Room(101, "Standard"));
        hotel.addRoom(new Room(102, "Deluxe"));
        hotel.addRoom(new Room(103, "Suite"));
        return hotel;
    }
}