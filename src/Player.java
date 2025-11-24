// ===== PLAYER =====
public class Player {
    private int health;
    private int healAmount = 15;
    private Weapon weapon;
    private int ammo = 20;
    private boolean dodgeReady = false;

    private Inventory inventory = new Inventory();

    public Player(int health, Weapon startingWeapon) {
        this.health = health;
        this.weapon = startingWeapon;
    }
    // new fields (add near the other fields)
    private boolean stunned = false;
    private int dotDamage = 0;     // damage applied each tick (Damage Over Time)
    private int dotTurns = 0;      // how many ticks remain

    // setter/getter for stunned
    public void setStunned(boolean value) {
        this.stunned = value;
    }
    public boolean isStunned() {
        return this.stunned;
    }

    // apply a damage-over-time effect: dmg per turn for 'turns' turns
    public void applyDamageOverTime(int dmgPerTurn, int turns) {
        // If a stronger DoT is applied, overwrite. You can change logic to stack if wanted.
        this.dotDamage = dmgPerTurn;
        this.dotTurns = turns;
        System.out.println("⚠️ You are afflicted: " + dmgPerTurn + " DOT for " + turns + " turns!");
    }

    // Called each round to process active status effects (DOTs, etc.)
    public void processStatusEffects() {
        // Process DOT
        if (dotTurns > 0) {
            takeDamage(dotDamage);
            dotTurns--;
            System.out.println("🩸 You suffer " + dotDamage + " DOT damage. (" + dotTurns + " turns left)");
        }

        // Stun remains until cleared by game logic or lasts one forced skip.
        // We don't auto-clear stunned here; Game loop will clear after using it to skip one turn.
    }


    public void attack(Zombie z) {
        if (ammo > 0) {
            z.takeDamage(weapon.getDamage());
            ammo--;
            System.out.println("🔫 Fired " + weapon.getName() + "! -" + weapon.getDamage() + " HP | Ammo left: " + ammo);
        } else {
            System.out.println("⚠️ Out of ammo! You punch the zombie for 5 damage!");
            z.takeDamage(5);
        }
    }

    public void weakspotStrike(Zombie z) {
        int dmg = weapon.getDamage() * 2;
        z.takeDamage(dmg);
        System.out.println("💥 Weakspot strike! You deal " + dmg + " damage!");
    }

    public void heal() {
        health += healAmount;
        System.out.println("🩹 Healed +15 HP. Current HP: " + health);
    }

    public void useMedkit() {
        if (inventory.useItem("Medkit")) {
            health += 30;
            System.out.println("💊 Used Medkit! +30 HP. Current HP: " + health);
        } else {
            System.out.println("❌ No Medkits left!");
        }
    }

    public void takeDamage(int dmg) {
        health -= dmg;
    }

    public int getHealth() {
        return health;
    }

    public void setWeapon(Weapon newWeapon) {
        this.weapon = newWeapon;
        System.out.println("🔥 New weapon: " + weapon.getName() + " (Damage: " + weapon.getDamage() + ")");
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
    public boolean isDodgeReady() {
        return dodgeReady;
    }

    public void setDodgeReady(boolean ready) {
        this.dodgeReady = ready;
    }

}

