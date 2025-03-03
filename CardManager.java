import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CardManager {
    private List<AccessCard> cards = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public void cardMenu() {
        while (true) {
            System.out.println("\nCard Management");
            System.out.println("1. Add Card");
            System.out.println("2. Edit Card");
            System.out.println("3. Delete Card");
            System.out.println("4. Go back");
            System.out.print("Choose Menu (1-4): ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addCard();
                    break;
                case 2:
                    editCard();
                    break;
                case 3:
                    deleteCard();
                    break;
                case 4:
                    return;
                default:
                    System.out.println("❌ Incorrect Option ❌");
            }
        }
    }

    public void addCard() {
        System.out.println("\nAdd New Card");
        System.out.print("Name: ");
        String owner = scanner.nextLine();

        System.out.println("Choose Role: [Cleaning, VIP, Admin, Guest, Maintenance]");
        System.out.print("Role: ");
        String role = scanner.nextLine();

        System.out.print("Enter Expiration Date (dd-mm-yyyy): ");
        String expiryDate = scanner.nextLine();

        AccessCard card = new AccessCard(owner, role, expiryDate);
        cards.add(card);

        Logger.log("Added Card: " + card);
        System.out.println("Card was Successfully Create! ✅");
    }

    public void editCard() {
        if (cards.isEmpty()) {
            System.out.println("❌ No Card to Edit! ❌");
            return;
        }

        showCards();
        System.out.print("Select The Card Number You Want to Edit (0 = Go Back): ");
        int index = scanner.nextInt();
        scanner.nextLine();

        if (index == 0) {
            System.out.println("Back to Card Management Page...");
            return;
        }

        if (index < 1 || index > cards.size()) {
            System.out.println("❌ Card Number is Incorrect ❌");
            return;
        }

        AccessCard card = cards.get(index - 1);
        System.out.println("Card Edit: " + card);

        System.out.print("Change to New Role (Leave Blank if Not Change): ");
        String newRole = scanner.nextLine();
        if (!newRole.isEmpty()) {
            card.setRole(newRole);
        }

        System.out.print("Enter New Expiration Date (Leave Blank if Not Change): ");
        String newExpiryDate = scanner.nextLine();
        if (!newExpiryDate.isEmpty()) {
            card.setExpiryDate(newExpiryDate);
        }

        Logger.log("Edited Card: " + card);
        System.out.println("Card Edit Complete ✅");
    }

    public void deleteCard() {
        if (cards.isEmpty()) {
            System.out.println("❌ No Card to Delete ❌");
            return;
        }

        showCards();
        System.out.print("Select The Card Number to Delete (0 = Go Back): ");
        int index = scanner.nextInt();
        scanner.nextLine();

        if (index == 0) {
            System.out.println("Back to Card Management Page...");
            return;
        }

        if (index < 1 || index > cards.size()) {
            System.out.println("❌ Card Number is Incorrect ❌");
            return;
        }

        AccessCard removedCard = cards.remove(index - 1);
        Logger.log("🗑️ Deleted Card: " + removedCard);
        System.out.println("The Card Has Been Deleted ✅");
    }

    private void showCards() {
        System.out.println("\nList of All Cards:");
        for (int i = 0; i < cards.size(); i++) {
            System.out.println((i + 1) + ". " + cards.get(i));
        }
    }
}