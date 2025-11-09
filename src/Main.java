// ===== MAIN MENU =====
import java.util.Scanner;

public class Main {
    public static void showOptions(Scanner sc) {
        int optionChoice;

        do {
            System.out.println("\n===== OPTIONS =====");
            System.out.println("1. Show Controls");
            System.out.println("2. Credits");
            System.out.println("3. Back to Main Menu");
            System.out.print("Choose: ");

            optionChoice = sc.nextInt();
            sc.nextLine();

            switch (optionChoice) {
                case 1:
                    System.out.println("\n🎮 CONTROLS:");
                    System.out.println("A = Attack");
                    System.out.println("W = Weakspot Strike");
                    System.out.println("H = Heal (+15 HP)");
                    System.out.println("M = Use Medkit (+30 HP)");
                    System.out.println("R = Reload");
                    System.out.println("I = Check Inventory");
                    break;
                case 2:
                    System.out.println("\n👤 Game by Axel & ChatGPT");
                    System.out.println("💀 The Last Stand: Oily Apocalypse 💀");
                    break;
                case 3:
                    System.out.println("Returning to main menu...");
                    break;
                default:
                    System.out.println("Invalid input!");
            }
        } while (optionChoice != 3);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Game game = new Game();
        int choice;

        do {
            System.out.println("\n===== OILY APOCALYPSE MENU =====");
            System.out.println("1. Enter the Game");
            System.out.println("2. Options");
            System.out.println("3. Quit");
            System.out.print("Choose an option: ");

            choice = sc.nextInt();
            sc.nextLine(); // clears newline buffer

            switch (choice) {
                case 1:
                    System.out.println("Starting the game...");
                    game.start();
                    break;
                case 2:
                    showOptions(sc);
                    break;
                case 3:
                    System.out.println("Exiting the game. Stay slippery 💧");
                    break;
                default:
                    System.out.println("Invalid option. Try again!");
            }

        } while (choice != 3);

        sc.close();
    }
}
