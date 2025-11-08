public class BossZombie extends Zombie {
    public BossZombie(int wave) {
        // Boss scales with wave: big HP and attack
        super(300 + (wave * 40), 30 + (wave * 5), "Diddy Boss 🛢️");
    }

    // Boss special behavior: sometimes hits harder
    @Override
    public void attack(Player p) {
        double r = Math.random();
        if (r < 0.25) { // 25% chance heavy slam
            int heavy = attackPower * 2;
            p.takeDamage(heavy);
            System.out.println(type + " uses a HEAVY SLAM for " + heavy + " damage!");
        } else if (r < 0.45) { // 20% chance for quick double jab
            int quick = attackPower + 10;
            p.takeDamage(quick);
            System.out.println(type + " jabs quickly for " + quick + " damage!");
        } else {
            // normal attack
            p.takeDamage(attackPower);
            System.out.println(type + " attacks you for " + attackPower + " damage!");
        }
    }
}
