import java.util.Scanner;

public class Game {
    private Player player;
    private Scanner sc = new Scanner(System.in);
    int wave = 1;
    int maxWaves = 10; // <-- story mode ends at wave 10

    public void start() {
        Weapon pistol = new Weapon("Pistol", 15);
        player = new Player(100, pistol);
        player.addAmmo(20); // starting ammo

        System.out.println("💀 Welcome to The Last Stand: Oily Apocalypse 💀");
        int wave = 1;

        while (player.getHealth() > 0 && wave <= maxWaves) {
            Zombie z;
            if (Math.random() < 0.6) {
                z = new Walker();
            } else {
                z = new Runner();
            }

            System.out.println("\nWave " + wave + " - A " + z.getType() + " appears!");


            while (z.getHealth() > 0 && player.getHealth() > 0) {
                System.out.println("Your HP: " + player.getHealth() +
                        " | Weapon: " + player.getWeaponName());
                System.out.println("Zombie HP: " + z.getHealth());
                System.out.println("Ammo: " + player.getAmmo()); // ✅ Ammo display

                System.out.println("[A]ttack [H]eal (+15) [M]edkit (+30) [R]eload [I]nventory");

                String choice = sc.nextLine();

                if (choice.equalsIgnoreCase("A")) {
                    player.attack(z);
                } else if (choice.equalsIgnoreCase("H")) {
                    player.heal();
                } else if (choice.equalsIgnoreCase("R")) {
                    player.reload();
                } else if (choice.equalsIgnoreCase("I")) {
                    player.getInventory().showInventory();

                }
                else if (choice.equalsIgnoreCase("M")) {
                    player.useMedkit();

                }

            }

            if (player.getHealth() > 0) {
                System.out.println("You survived wave " + wave + "! 💪");
                wave++;
            } else {
                System.out.println("\n💀 You were killed in wave " + wave + "!");

                // === Game Over Menu ===
                System.out.println("\n===== GAME OVER =====");
                System.out.println("You reached Wave " + wave);
                System.out.println("1. Retry");
                System.out.println("2. Quit");
                System.out.print("Choose: ");

                int choice = sc.nextInt();
                sc.nextLine(); // clear buffer

                if (choice == 1) {
                    // 🔁 Restart the game from scratch
                    System.out.println("Restarting game...");
                    start();
                    return; // stop the old game instance
                } else if (choice == 2) {
                    System.out.println("Exiting to main menu...");
                    return; // return control to Main.java
                } else {
                    System.out.println("Invalid input, returning to menu...");
                    return;
                }
            }


            // Weapon upgrades by level
                if (wave == 3) player.setWeapon(new Weapon("Shotgun", 25));
                else if (wave == 5) player.setWeapon(new Weapon("Assault Rifle", 35));
                else if (wave == 8) player.setWeapon(new Weapon("Flamethrower", 50));
            }

            // === Random Loot Drop ===
            // === Random Loot Drop ===
            int lootChance = (int) (Math.random() * 100);

            if (lootChance < 40) { // 40%
                player.getInventory().addItem("Ammo Pack");
            } else if (lootChance < 70) { // 30%
                player.getInventory().addItem("Medkit");
            } else {
                System.out.println("No loot found this time...");
            }
        // === END OF GAME LOOP ===
        if (player.getHealth() > 0 && wave > 10) {
            System.out.println("\n🌕 You survived all 10 waves!");
            System.out.println("The oily apocalypse fades under the moonlight...");
            System.out.println("You are the last survivor. 🏆");
        } else {
            System.out.println("\nYou died... the oily zombies win 💧🧟‍♂️");
        }
// === END OF GAME LOOP ===
        // === END OF GAME LOOP ===
        if (player.getHealth() > 0 && wave > 10) {
            System.out.println("\n🌕 You survived all 10 waves!");
            System.out.println("The oily apocalypse fades under the moonlight...");
            System.out.println("You are the last survivor. 🏆");
        } else {
            System.out.println("\nYou died... the oily zombies win 💧🧟‍♂️");
        }


    }
    }

