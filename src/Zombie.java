public class Zombie {
    private int health;
    private int attackPower;

    public Zombie(int health, int attackPower) {
        this.health = health;
        this.attackPower = attackPower;
    }

    public void attack(Player p) {
        p.takeDamage(attackPower);
    }

    public void takeDamage(int dmg) {
        health -= dmg;
    }

    public int getHealth() {
        return health;
    }
}
