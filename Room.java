public class Room {
    private int roomNumber;
    private String type;
    private boolean isAvailable;

    public void freeRoom() {
        this.isAvailable = true;
    }

    public Room(int roomNumber, String type) {
        this.roomNumber = roomNumber;
        this.type = type;
        this.isAvailable = true;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public String getType() {
        return type;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void bookRoom() {
        this.isAvailable = false;
    }

    @Override
    public String toString() {
        return "Rooms " + roomNumber + " (" + type + ")";
    }

}