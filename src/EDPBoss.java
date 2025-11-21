public class EDPBoss extends Zombie {
    private boolean preparingUltimate = false;

    public EDPBoss() {
        super(320, 30, "EDP Boss 🔥");
    }

    @Override
    public void attack(Player p) {

        // Resolve ultimate if preparing
        if (preparingUltimate) {
            preparingUltimate = false;

            System.out.println("⚠️ EDP charges with his Predator Lunge!");

            // Later you will add dodge mechanic
            boolean dodged = false;

            if (dodged) {
                System.out.println("🌀 You dodge the Predator Lunge!");
                this.takeDamage(40);
            } else {
                int dmg = 55;
                System.out.println("💥 Predator Lunge hits for " + dmg + " damage!");
                p.takeDamage(dmg);
            }

            return;
        }

        double r = Math.random();
        if (r < 0.33) {
            System.out.println("💬 EDP says: \"Did you miss me?\" then swings HARD.");
            int dmg = attackPower + 12;
            p.takeDamage(dmg);
        }

        else if (r < 0.66) {
            System.out.println("🍰 EDP throws burning cupcakes at you!");
            for (int i = 0; i < 3; i++) p.takeDamage(8);
        }

        else {
            System.out.println("❗ EDP prepares his ultimate — Predator Lunge!");
            preparingUltimate = true;
        }
    }
}
