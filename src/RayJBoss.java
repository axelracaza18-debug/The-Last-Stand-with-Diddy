public class RayJBoss extends Zombie {

    private boolean chargingUltimate = false;   // preparing One Wish attack
    private int slowTurns = 0;                  // applies slow debuff to player

    public RayJBoss() {
        super(340, 32, "Ray J — The R&B Menace 🎤");
    }

    @Override
    public void attack(Player p) {

        // ================================
        // If he was preparing ultimate last turn
        // ================================
        if (chargingUltimate) {
            chargingUltimate = false;

            System.out.println("\n🎵 *Silk Daddy hits the ONE WISH CHORUS!!* 🎵");
            System.out.println("🌈 \"If I had one wishhhh...\" echoes through the arena...");
            System.out.println("💥 Silk Daddy unleashes: THE FREAK OFF!");

            boolean dodged = false; // You will add dodge later

            if (dodged) {
                System.out.println("🌀 You SLIDE under the Freak Off! Ray J stumbles!");
                this.takeDamage(45);
            } else {
                int dmg = 60;
                System.out.println("🔥 The Freak Off SMACKS YOU for " + dmg + " damage!");
                p.takeDamage(dmg);

                // Applies a slow effect
                slowTurns = 2;
                System.out.println("💫 You're overwhelmed by R&B energy... Movement slowed! (2 turns)");
            }
            return;
        }

        // ================================
        // Normal attack pattern
        // ================================
        double r = Math.random();

        if (r < 0.30) {
            // Smooth slap
            int dmg = attackPower + 10;
            System.out.println("🎶 Silk Daddy glides forward with a silky smooth SLAP! -" + dmg);
            p.takeDamage(dmg);
        }

        else if (r < 0.60) {
            // R&B echo attack
            System.out.println("🔊 Silk Daddy overlays his vocals — R&B Echo Attack!");
            int hits = 3;
            for (int i = 0; i < hits; i++) {
                p.takeDamage(8);
            }
            System.out.println("🎤 Echo hits you 3 times for 8 damage each!");
        }

        else if (r < 0.80) {
            // Emotional Damage debuff
            System.out.println("💔 Silk Daddy hits you with EMOTIONAL DAMAGE lyrics.");
            int dot = 6;
            int turns = 3;
            p.applyDamageOverTime(dot, turns);
        }

        else {
            // Starts ultimate
            System.out.println("\n🎵 A soft R&B intro fills the arena...");
            System.out.println("🌈 Silk Daddy begins singing: \"If I had one wish...\"");
            System.out.println("⚠️ He is preparing his ULTIMATE — The Freak Off!");
            chargingUltimate = true;
        }
    }
}
