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

            if (wave == maxWaves) {
                z = new BossZombie(wave);
                System.out.println("\n⚠️ FINAL WAVE! A DIDDY BOSS APPROACHES! ⚠️");

            } else if (wave == 8) {
                System.out.println("\n🔥 Wave 8 – EDP Boss appears!");
                System.out.println("\"Did you miss me?\"");
                z = new EDPBoss();

            } else if (wave == 7) {
                System.out.println("\n🎤 Wave 7 – The Golden Crooner sings ominously…");
                z = new GoldenCrooner();

            } else if (wave == 6) {
                System.out.println("\n💿 Wave 6 – Rapper Snake enters!");
                z = new RapperSnake();

            } else if (Math.random() < 0.6) {
                z = new Walker();

            } else {
                z = new Runner();
            }


            System.out.println("\nWave " + wave + " - A " + z.getType() + " appears!");

            // === Combat loop ===
            // === Combat loop ===
            // === Combat loop ===
            while (z.getHealth() > 0 && player.getHealth() > 0) {
                // 1) Apply status effects at the start of the player's turn
                player.processStatusEffects();
                // check death from DOT
                if (player.getHealth() <= 0) break;

                System.out.println("\nYour HP: " + player.getHealth() +
                        " | Weapon: " + player.getWeaponName());
                System.out.println("Zombie HP: " + z.getHealth());
                System.out.println("Ammo: " + player.getAmmo());

                // 2) If stunned, skip player's input/action this turn
                if (player.isStunned()) {
                    System.out.println("🔒 You are stunned and lose your turn!");
                    // clear stun so it only skips one turn (change if you want multi-turn stuns)
                    player.setStunned(false);
                } else {
                    System.out.println("[A] Attack  [W] Weakspot Strike  [H] Heal  [M] Medkit  [R] Reload  [I] Inventory  [D] Dodge");
                    String choice = sc.nextLine().trim();

                    switch (choice.toUpperCase()) {
                        case "A" -> player.attack(z);
                        case "H" -> player.heal();
                        case "M" -> player.useMedkit();
                        case "R" -> player.reload();
                        case "I" -> {
                            player.getInventory().showInventory();
                            continue; // checking inventory consumes the player's action; the enemy will still attack below
                        }
                        case "W" -> handleWeakspot(z);
                        case "D" -> {
                            // Dodge is a simple action you can use to reduce chance of being hit by a telegraphed ultimate.
                            // Implementation of dodge effect for specific boss ultimates is handled in the boss logic.
                            System.out.println("🌀 You prepare to dodge this turn!");
                            // set a temporary "dodge" flag on player by reusing stun/DoT? Better to add a dodge flag if you want persistent behavior.
                            // For now we'll set a short-term flag by a method or field if you want — see optional note below.
                        }
                        default -> System.out.println("Invalid action. The zombie takes advantage!");
                    }
                }

                // 3) Enemy attacks back if still alive
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

    // ===== Loot Drops =====
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

    // ===== Weakspot Mechanic =====
    private void handleWeakspot(Zombie z) {
        if (z instanceof BossZombie || z instanceof RapperSnake) {
            boolean success = Math.random() < 0.5;
            if (success) {
                player.weakspotStrike(z);
            } else {
                System.out.println("⛔ Weakspot failed! The boss counters!");
                int counter = 25 + (int)(Math.random() * 15);
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

    // ===== Game Over Menu =====
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
