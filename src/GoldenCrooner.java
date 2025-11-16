public class GoldenCrooner extends Zombie {

    private boolean chargingUltimate = false;

    public GoldenCrooner() {
        super(250, 25, "Golden Crooner 🎤✨");
    }

    @Override
    public void attack(Player p) {
        if (chargingUltimate) {
            System.out.println("💛 LIQUID SYMPHONY UNLEASHED!");
            int dmg = attackPower * 3;
            p.takeDamage(dmg);
            System.out.println("You take " + dmg + " DAMAGE!");
            chargingUltimate = false;
            return;
        }

        double r = Math.random();

        if (r < 0.15) {
            // 👑 Heavy Attack
            int dmg = attackPower * 2;
            System.out.println("👑 Ego Burst! The Crooner smashes you for " + dmg + "!");
            p.takeDamage(dmg);

        } else if (r < 0.30) {
            // 🎵 Deafening Attack
            System.out.println("🎵 High Note Blast! You are DEAFENED and lose a turn!");
            p.takeDamage(attackPower);
            p.setStunned(true);

        } else if (r < 0.50) {
            // 💛 Damage over time
            System.out.println("💛 Golden Splash! You are coated in shimmering liquid...");
            p.takeDamage(attackPower);
            p.applyDamageOverTime(5, 2);

        } else if (r < 0.65) {
            // 🎤 Heal
            System.out.println("🎤 ENCORE! The Crooner heals himself.");
            healSelf(20);

        } else if (r < 0.75) {
            // 🟡 ULTIMATE (Charging)
            System.out.println("⚠️ The Golden Crooner begins charging LIQUID SYMPHONY...");
            chargingUltimate = true;

        } else {
            // Normal Attack
            System.out.println("🎶 The Crooner slaps you with a mic chord!");
            p.takeDamage(attackPower);
        }
    }

    private void healSelf(int amount) {
        this.health += amount;
        System.out.println("He heals " + amount + " HP!");
    }
}
