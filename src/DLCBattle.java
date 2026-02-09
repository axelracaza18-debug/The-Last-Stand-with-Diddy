import java.util.Scanner;

public class DLCBattle {

    public static boolean startHallwayCombat(Player player) {
        Scanner sc = new Scanner(System.in);

        // ===============================
        // HALLWAY ENEMIES
        // ===============================
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

                System.out.println("\nYour HP: " + player.getHealth());
                System.out.println(z.getType() + " HP: " + z.getHealth());
                System.out.println("Ammo: " + player.getAmmo());
                System.out.println("[A] Attack [W] Weakspot [H] Heal [M] Medkit [R] Reload [I] Inventory [D] Dodge");

                String choice = sc.nextLine().trim().toUpperCase();
                switch (choice) {
                    case "A" -> player.attack(z);
                    case "W" -> player.weakspotStrike(z);
                    case "H" -> player.heal();
                    case "M" -> player.useMedkit();
                    case "R" -> player.reload();
                    case "I" -> player.getInventory().showInventory();
                    case "D" -> player.setDodgeReady(true);
                    default -> System.out.println("Invalid action!");
                }

                if (z.getHealth() > 0) z.attack(player);
            }

            if (player.getHealth() <= 0) {
                Displays.typewriter("\n💀 You were killed in the hallway...");
                return false;
            }

            Displays.typewriter("✅ Enemy defeated.");
        }

        // ===============================
        // MINI-BOSS: SUBJECT 017
        // ===============================
        Displays.typewriter("\n⚠️ CONTAINMENT FAILURE...");
        Displays.typewriter("Subject 017 emerges from the shadows.");

        Zombie subject017 = new Zombie(220, 28, "Subject 017");

        while (subject017.getHealth() > 0 && player.getHealth() > 0) {
            player.processStatusEffects();
            if (player.getHealth() <= 0) break;

            System.out.println("\nYour HP: " + player.getHealth());
            System.out.println("Subject 017 HP: " + subject017.getHealth());
            System.out.println("Ammo: " + player.getAmmo());
            System.out.println("[A] Attack [W] Weakspot [H] Heal [M] Medkit [R] Reload [I] Inventory [D] Dodge");

            String choice = sc.nextLine().trim().toUpperCase();
            switch (choice) {
                case "A" -> player.attack(subject017);
                case "W" -> player.weakspotStrike(subject017);
                case "H" -> player.heal();
                case "M" -> player.useMedkit();
                case "R" -> player.reload();
                case "I" -> player.getInventory().showInventory();
                case "D" -> player.setDodgeReady(true);
                default -> System.out.println("Invalid action!");
            }

            if (subject017.getHealth() > 0) subject017.attack(player);
        }

        if (player.getHealth() <= 0) {
            Displays.typewriter("\n💀 Subject 017 killed you...");
            return false;
        }

        Displays.typewriter("\n🧪 Subject 017 has fallen.");
        Displays.typewriter("The vaccine sample is secured.");

        // ===============================
        // FINAL BOSS: SILK EMPEROR
        // ===============================
        Displays.typewriter("\n💀 THE FLOOR TREMBLES...");
        Displays.typewriter("The Silk Emperor awakens.");

        Zombie silkEmperor = new Zombie(350, 35, "Silk Emperor");

        while (silkEmperor.getHealth() > 0 && player.getHealth() > 0) {
            player.processStatusEffects();
            if (player.getHealth() <= 0) break;

            System.out.println("\nYour HP: " + player.getHealth());
            System.out.println("Silk Emperor HP: " + silkEmperor.getHealth());
            System.out.println("Ammo: " + player.getAmmo());
            System.out.println("[A] Attack [W] Weakspot [H] Heal [M] Medkit [R] Reload [I] Inventory [D] Dodge");

            String choice = sc.nextLine().trim().toUpperCase();
            switch (choice) {
                case "A" -> player.attack(silkEmperor);
                case "W" -> player.weakspotStrike(silkEmperor);
                case "H" -> player.heal();
                case "M" -> player.useMedkit();
                case "R" -> player.reload();
                case "I" -> player.getInventory().showInventory();
                case "D" -> player.setDodgeReady(true);
                default -> System.out.println("Invalid action!");
            }

            if (silkEmperor.getHealth() > 0) silkEmperor.attack(player);
        }

        if (player.getHealth() <= 0) {
            Displays.typewriter("\n💀 The Silk Emperor destroyed you...");
            return false;
        }

        Displays.typewriter("\n🏆 SILK EMPEROR DEFEATED.");
        Displays.typewriter("PROJECT MNEMOSYNE — COMPLETE.");

        return true;
    }
}
