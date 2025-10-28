public class Player {
    private int health;
    private int healAmount = 15;
    private Weapon weapon;

    public Player(int health, Weapon startingWeapon) {
        this.health = health;
        this.weapon = startingWeapon;
    }

    public void attack(Zombie z) {
        z.takeDamage(weapon.getDamage());
        System.out.println("You attacked with your " + weapon.getName() + " for " + weapon.getDamage() + " damage!");
    }

    public void heal() {
        health += healAmount;
        System.out.println("You healed yourself! +15 HP");
    }

    public void takeDamage(int dmg) {
        health -= dmg;
    }

    public int getHealth() {
        return health;
    }

    public void setWeapon(Weapon newWeapon) {
        this.weapon = newWeapon;
        System.out.println("🔥 You found a new weapon: " + weapon.getName() + " (Damage: " + weapon.getDamage() + ")");
    }
}
