public class HotelFactory {
    public static Hotel createHotel() {
        Hotel hotel = new Hotel();
        String[] roomTypes = {"Standard", "Deluxe", "Suite"};

        for (int floor = 1; floor <= 3; floor++) {
            for (int i = 1; i <= 3; i++) {
                int roomNumber = (floor * 100) + i;
                String roomType = roomTypes[(i - 1) % roomTypes.length];
                hotel.addRoom(floor, new Room(roomNumber, roomType));
            }
        }
        return hotel;
    }
}