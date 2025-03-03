import java.util.Scanner;

public class Main {
    private static Hotel hotel = HotelFactory.createHotel();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Authentication auth = new Authentication();

        while (true) {
            System.out.println("\n👹️ Welcome to Old Trafford Hotel System 👹");
            System.out.println("1. Admin");
            System.out.println("2. Customer");
            System.out.print("Choose Role (1-2): ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {
                System.out.print("Enter Password: ");
                String password = scanner.nextLine();
                if (auth.login("Admin", password)) {
                    System.out.println(" Login Successful (Admin) ✅");
                    adminMenu();
                } else {
                    System.out.println("❌ Password is Incorrect ❌");
                }
            } else if (choice == 2) {
                System.out.println("Go to Booking Page...");
                hotel.customerBookingMenu();
            } else {
                System.out.println("❌ Incorrect Option ❌");
            }
        }
    }

    public static void adminMenu() {
        Scanner scanner = new Scanner(System.in);
        CardManager cardManager = new CardManager();

        while (true) {
            System.out.println("\nAdmin Menu ");
            System.out.println("1. Card Management");
            System.out.println("2. Cancel Booking");
            System.out.println("3. View Logs");
            System.out.println("4. Logout");
            System.out.print("Choose Menu (1-4): ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    cardManager.cardMenu();
                    break;
                case 2:
                    hotel.cancelBooking();
                    break;
                case 3:
                    Logger.showLogs();
                    break;
                case 4:
                    System.out.println("Log out Admin...");
                    return;
                default:
                    System.out.println("❌ Incorrect Option ❌");
            }
        }
    }
}