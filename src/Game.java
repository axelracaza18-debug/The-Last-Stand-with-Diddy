// ===== GAME LOGIC =====
import java.util.Scanner;

public class Game {
    private Player player;
    private Scanner sc = new Scanner(System.in);
    private int wave = 1;
    private final int maxWaves = 10;

    public void start() {
        Weapon pistol = new Weapon("Pistol", 15);
        player = new Player(100, pistol);
        player.addAmmo(20);

        System.out.println("💀 Welcome to The Last Stand: Oily Apocalypse 💀");

        while (player.getHealth() > 0 && wave <= maxWaves) {
            Zombie z;

            // 🧟 Boss at final wave
            if (wave == maxWaves) {
                z = new BossZombie(wave);
                System.out.println("\n⚠️ FINAL WAVE! A DIDDY BOSS APPROACHES! ⚠️");
            } else if (Math.random() < 0.6) {
                z = new Walker();
            } else {
                z = new Runner();
            }

            System.out.println("\nWave " + wave + " - A " + z.getType() + " appears!");

            // === Combat loop ===
            while (z.getHealth() > 0 && player.getHealth() > 0) {
                System.out.println("\nYour HP: " + player.getHealth() +
                        " | Weapon: " + player.getWeaponName());
                System.out.println("Zombie HP: " + z.getHealth());
                System.out.println("Ammo: " + player.getAmmo());

                System.out.println("[A] Attack  [W] Weakspot Strike  [H] Heal  [M] Medkit  [R] Reload  [I] Inventory");
                String choice = sc.nextLine().trim();

                switch (choice.toUpperCase()) {
                    case "A" -> player.attack(z);
                    case "H" -> player.heal();
                    case "M" -> player.useMedkit();
                    case "R" -> player.reload();
                    case "I" -> {
                        player.getInventory().showInventory();
                        continue;
                    }
                    case "W" -> handleWeakspot(z);
                    default -> System.out.println("Invalid action. The zombie takes advantage!");
                }

                // 🧟 Zombie attacks back if alive
                if (z.getHealth() > 0 && player.getHealth() > 0) {
                    z.attack(player);
                }
            }

            // === After combat ===
            if (player.getHealth() > 0) {
                System.out.println("✅ You survived wave " + wave + "!");
                handleLootDrop();

                // Weapon upgrades
                if (wave == 3) player.setWeapon(new Weapon("Shotgun", 25));
                else if (wave == 5) player.setWeapon(new Weapon("Assault Rifle", 35));
                else if (wave == 8) player.setWeapon(new Weapon("Flamethrower", 50));

                wave++;
            } else {
                gameOverMenu();
                return;
            }
        }

        // === Game End ===
        if (player.getHealth() > 0) {
            System.out.println("\n🌕 You survived all 10 waves!");
            System.out.println("The oily apocalypse fades under the moonlight...");
            System.out.println("You are the last survivor. 🏆");
        } else {
            System.out.println("\nYou died... the oily zombies win 💧🧟‍♂️");
        }
    }

    private void handleLootDrop() {
        int lootChance = (int) (Math.random() * 100);

        if (lootChance < 40) {
            player.getInventory().addItem("Ammo Pack");
        } else if (lootChance < 70) {
            player.getInventory().addItem("Medkit");
        } else {
            System.out.println("No loot found this time...");
        }
    }

    private void handleWeakspot(Zombie z) {
        if (z instanceof BossZombie) {
            boolean success = Math.random() < 0.5;
            if (success) {
                player.weakspotStrike(z);
            } else {
                System.out.println("⛔ Weakspot failed! The boss counters!");
                int counter = ((BossZombie) z).attackPower + 15;
                player.takeDamage(counter);
                System.out.println("Boss counters for " + counter + " damage!");
            }
        } else {
            boolean success = Math.random() < 0.6;
            if (success) {
                player.weakspotStrike(z);
            } else {
                System.out.println("❌ Missed the weakspot! The zombie lunges!");
            }
        }
    }

    private void gameOverMenu() {
        System.out.println("\n💀 You were killed in wave " + wave + "!");
        System.out.println("\n===== GAME OVER =====");
        System.out.println("You reached Wave " + wave);
        System.out.println("1. Retry");
        System.out.println("2. Quit");
        System.out.print("Choose: ");

        int choice = sc.nextInt();
        sc.nextLine();

        if (choice == 1) {
            System.out.println("Restarting game...");
            start();
        } else {
            System.out.println("Exiting to main menu...");
        }
    }
}
