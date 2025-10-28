import java.util.Scanner;

public class Main {

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

            choice = sc.nextInt();  // user input

            switch (choice) {
                case 1:
                    System.out.println("Starting the game...");

                    break;
                case 2:
                    System.out.println("Game settings coming soon...");
                    break;
                case 3:
                    System.out.println("Exiting the game. Stay slippery 💧");
                    break;
                default:
                    System.out.println("Invalid option. Try again!");
            }

        } while (choice != 3); // loop until user chooses Quit


    }
}
