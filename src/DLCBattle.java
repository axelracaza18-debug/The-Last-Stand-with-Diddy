import java.util.Scanner;

public class DLCBattle {

    public static boolean startHallwayCombat(Player player) {
        Scanner sc = new Scanner(System.in);

        // Spawn 3 failed scientists
        Zombie[] enemies = {
                new Zombie(80, 15, "Failed Scientist 🧪"),
                new Zombie(90, 18, "Failed Scientist 🧪"),
                new Zombie(85, 16, "Failed Scientist 🧪")
        };

        for (Zombie z : enemies) {
            Displays.typewriter("\n⚠️ An enemy appears: " + z.getType());
            while (z.getHealth() > 0 && player.getHealth() > 0) {
                player.processStatusEffects();
                if (player.getHealth() <= 0) break;

                System.out.println("\nYour HP: " + player.getHealth() + " | Weapon: " + player.getWeaponName());
                System.out.println("Zombie HP: " + z.getHealth());
                System.out.println("Ammo: " + player.getAmmo());
                System.out.println("[A] Attack [W] Weakspot Strike [H] Heal [M] Medkit [R] Reload [I] Inventory [D] Dodge");

                String choice = sc.nextLine().trim().toUpperCase();
                switch (choice) {
                    case "A" -> player.attack(z);
                    case "W" -> player.weakspotStrike(z);
                    case "H" -> player.heal();
                    case "M" -> player.useMedkit();
                    case "R" -> player.reload();
                    case "I" -> { player.getInventory().showInventory(); continue; }
                    case "D" -> { System.out.println("🌀 You prepare to dodge!"); player.setDodgeReady(true); continue; }
                    default -> System.out.println("Invalid action! The enemy takes advantage!");
                }

                if (z.getHealth() > 0) z.attack(player);
            }

            if (player.getHealth() <= 0) {
                Displays.typewriter("\n💀 You were killed by the Oily Infected... DLC FAILED");
                return false;
            } else {
                Displays.typewriter("✅ You defeated " + z.getType() + "!");
            }
        }

        // Mini-boss: Silk Emperor
        Displays.typewriter("\n💀 Something larger moves ahead... It's unstable but dangerous!");
        Zombie miniBoss = new SilkEmperor();

        while (miniBoss.getHealth() > 0 && player.getHealth() > 0) {
            player.processStatusEffects();
            if (player.getHealth() <= 0) break;

            System.out.println("\nYour HP: " + player.getHealth() + " | Weapon: " + player.getWeaponName());
            System.out.println("Boss HP: " + miniBoss.getHealth());
            System.out.println("Ammo: " + player.getAmmo());
            System.out.println("[A] Attack [W] Weakspot Strike [H] Heal [M] Medkit [R] Reload [I] Inventory [D] Dodge");

            String choice = sc.nextLine().trim().toUpperCase();
            switch (choice) {
                case "A" -> player.attack(miniBoss);
                case "W" -> player.weakspotStrike(miniBoss);
                case "H" -> player.heal();
                case "M" -> player.useMedkit();
                case "R" -> player.reload();
                case "I" -> { player.getInventory().showInventory(); continue; }
                case "D" -> { System.out.println("🌀 You prepare to dodge!"); player.setDodgeReady(true); continue; }
                default -> System.out.println("Invalid action! The boss strikes!");
            }

            if (miniBoss.getHealth() > 0) miniBoss.attack(player);
        }

        if (player.getHealth() <= 0) {
            Displays.typewriter("\n💀 The mini-boss overwhelmed you... DLC FAILED");
            return false;
        } else {
            Displays.typewriter("\n🏆 You survived the hallway battle!");
            return true;
        }
    }
}
