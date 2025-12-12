public class Zombie {
    protected int health;
    protected int attackPower;
    protected String type;

    public Zombie(int health, int attackPower, String type) {
        this.health = health;
        this.attackPower = attackPower;
        this.type = type;
    }

    public void attack(Player p) {

        // === DODGE SYSTEM ===
        int dodgeChance = 25; // 25% chance to dodge normal zombies
        int roll = new java.util.Random().nextInt(100);

        if (roll < dodgeChance) {
            System.out.println("🌀 You dodged the " + type + "'s attack!");
            return; // skip damage
        }

        // If NOT dodged → apply damage
        p.takeDamage(attackPower);
        System.out.println(type + " attacks you for " + attackPower + " damage!");
    }

    public void takeDamage(int dmg) {
        health -= dmg;
    }

    public int getHealth() {
        return health;
    }

    public String getType() {
        return type;
    }
}
