import java.util.Scanner;

public class Game {
    private Player player;
    private Scanner sc = new Scanner(System.in);

    public void start() {
        Weapon pistol = new Weapon("Pistol", 15);
        player = new Player(100, pistol);

        System.out.println("💀 Welcome to The Last Stand: Oily Apocalypse 💀");
        int wave = 1;

        while (player.getHealth() > 0) {
            Zombie z = new Zombie(50 + (wave * 10), 10 + (wave * 2));
            System.out.println("\nWave " + wave + " - A slippery zombie appears!");

            while (z.getHealth() > 0 && player.getHealth() > 0) {
                System.out.println("[A]ttack or [H]eal?");
                String choice = sc.nextLine();

                if (choice.equalsIgnoreCase("A")) {
                    player.attack(z);
                } else if (choice.equalsIgnoreCase("H")) {
                    player.heal();
                }

                if (z.getHealth() > 0) {
                    z.attack(player);
                    System.out.println("Zombie attacks! Your HP: " + player.getHealth());
                }
            }

            if (player.getHealth() > 0) {
                System.out.println("You survived wave " + wave + "! 💪");
                wave++;

                // Weapon upgrades by level
                if (wave == 3) player.setWeapon(new Weapon("Shotgun", 25));
                else if (wave == 5) player.setWeapon(new Weapon("Assault Rifle", 35));
                else if (wave == 8) player.setWeapon(new Weapon("Flamethrower", 50));
            }
        }

        System.out.println("You died... the oily zombies win 💧🧟‍♂️");
    }
}
