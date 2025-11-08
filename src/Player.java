public class Player {
    private int health;
    private int healAmount = 15;
    private Weapon weapon;
    private int ammo = 20; // starting ammo
    private Inventory inventory = new Inventory();

    public Player(int health, Weapon startingWeapon) {
        this.health = health;
        this.weapon = startingWeapon;
    }

    public void attack(Zombie z) {
        if (ammo > 0) {
            z.takeDamage(weapon.getDamage());
            ammo--;
            System.out.println("Fired " + weapon.getName() + "! Damage: " + weapon.getDamage() +
                    " | Ammo left: " + ammo);
        } else {
            System.out.println("⚠️ No ammo! You punch the zombie for 5 damage!");
            z.takeDamage(5);
        }
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
    public void useMedkit() {
        if (inventory.useItem("Medkit")) {
            health += 30;
            System.out.println("🩹 Used Medkit! +30 HP");
            System.out.println("Current HP: " + health);
        } else {
            System.out.println("❌ No Medkits left!");
        }
    }

    public void setWeapon(Weapon newWeapon) {
        this.weapon = newWeapon;
        System.out.println("🔥 You found a new weapon: " + weapon.getName() + " (Damage: " + weapon.getDamage() + ")");
    }

    public String getWeaponName() {
        return weapon.getName();
    }

    public void addAmmo(int amount) {
        ammo += amount;
        System.out.println("💥 Ammo increased! +" + amount + " bullets");
    }

    public int getAmmo() {
        return ammo;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void reload() {
        if (inventory.useItem("Ammo Pack")) {
            ammo += 30;
            System.out.println("🔁 Reloaded! +30 ammo. Current ammo: " + ammo);
        } else {
            System.out.println("❌ No ammo packs left!");
        }
    }

}

