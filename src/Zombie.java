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
