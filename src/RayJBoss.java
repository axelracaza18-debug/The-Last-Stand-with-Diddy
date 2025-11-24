// RayJBoss.java
public class RayJBoss extends Zombie {
    private final int maxHealth;
    private boolean preparingUltimate = false;   // ultimate is charging
    private boolean oilShield = false;           // reduces next incoming damage
    private int freakOffStage = 0;               // used to sequence ultimate hits if desired

    public RayJBoss() {
        super(280, 22, "Ray J 💖");
        this.maxHealth = this.health; // store starting HP so we can check thresholds
    }

    @Override
    public void attack(Player p) {
        // If ultimate was being prepared, resolve it
        if (preparingUltimate) {
            // Announce the chorus moment
            System.out.println("\n🎶 The chorus hits: \"If I had one wish...\" — RAY J enters FREAK OFF MODE!");
            performFreakOff(p);
            preparingUltimate = false;
            return;
        }

        // If Oil Body shield is active, we keep it until next incoming damage (handled in Player.takeDamage or resolved elsewhere)
        // Choose a normal attack
        double r = Math.random();
        if (r < 0.30) {
            bubbleShower(p);                // multi-hit small damage
        } else if (r < 0.55) {
            danceFreakOff(p);               // chance to stun
        } else if (r < 0.80) {
            bubbleGun(p);                   // rapid smaller shots
        } else {
            oilBody();                      // heal + armor effect
        }
    }

    private void bubbleShower(Player p) {
        System.out.println("🫧 Ray J unleashes Bubble Shower — tiny bubbles explode everywhere!");
        int hits = 3;
        int perHit = 6;
        for (int i = 0; i < hits; i++) {
            p.takeDamage(perHit);
        }
        System.out.println("→ Total Bubble Shower damage: " + (hits * perHit));
    }

    private void danceFreakOff(Player p) {
        System.out.println("💃 Ray J does the Dance Freak-Off — the moves mesmerize and may stun you!");
        p.takeDamage(attackPower); // normal damage
        // Try to stun the player (30% chance)
        if (Math.random() < 0.30) {
            System.out.println("✨ You are stunned by the dance!");
            // If Player has setStunned(boolean)
            try {
                p.setStunned(true);
            } catch (Throwable t) {
                // if setStunned() doesn't exist, ignore (no stun)
            }
        }
    }

    private void bubbleGun(Player p) {
        System.out.println("🔫 Ray J fires his Bubble Gun — rapid bubbly shots!");
        int shots = 5;
        int damagePerShot = 4;
        int total = 0;
        for (int i = 0; i < shots; i++) {
            p.takeDamage(damagePerShot);
            total += damagePerShot;
        }
        System.out.println("→ Bubble Gun total damage: " + total);
    }

    private void oilBody() {
        System.out.println("🛢️ Ray J slathers himself in oily glamour — he heals and becomes slippery!");
        int heal = 20;
        this.health += heal;
        // Cap at maxHealth if you want:
        if (this.health > maxHealth) this.health = maxHealth;
        // Oil shield reduces the next incoming damage (handled by boss logic or Player checks)
        oilShield = true;
        System.out.println("→ He heals " + heal + " HP and activates an oil shield (reduces next incoming damage).");
    }

    // The Freak Off: a 4-stage chaotic ultimate, ends with a big final blast the player must dodge.
    private void performFreakOff(Player p) {
        System.out.println("⚠️ THE FREAK OFF BEGINS — a storm of bubbles, dance, and seductive chaos!");

        // Stage 1: Bubble Burst (multi tiny hits)
        System.out.println("→ Burst of bubbles slam you!");
        for (int i = 0; i < 4; i++) p.takeDamage(6);

        // Stage 2: Dance Shockwave (medium single hit + small stun chance)
        System.out.println("→ Dance Shockwave hits!");
        p.takeDamage(18);
        if (Math.random() < 0.25) {
            try { p.setStunned(true); System.out.println("→ You are briefly stunned by the shockwave!"); }
            catch (Throwable ignored) {}
        }

        // Stage 3: Oil Slide (DoT)
        System.out.println("→ Oil Slide coats you — burning slippery damage over time!");
        try {
            p.applyDamageOverTime(6, 3); // 6 damage per turn for 3 turns if method exists
        } catch (Throwable t) {
            // fallback: apply direct burst damage if method missing
            p.takeDamage(6 * 3);
        }

        // Stage 4: Final Freak-Off Blast (dodgeable)
        System.out.println("🎵 CHORUS — Final Freak-Off Blast incoming! You must DODGE (use D) or get slammed!");
        boolean playerDodged = false;

        // Prefer explicit dodge flag if Player implements it
        try {
            if (p.isDodgeReady()) {
                playerDodged = true;
            }
        } catch (Throwable ignored) {}

        // If Player didn't have dodge flag, give a 45% random chance to dodge anyway
        if (!playerDodged && Math.random() < 0.45) playerDodged = true;

        if (playerDodged) {
            System.out.println("🌀 You dodge the Final Blast at the last second! You counter with a swipe!");
            this.takeDamage(30); // counter damage to boss
        } else {
            int finalDmg = 40;
            System.out.println("💥 The Final Freak-Off Blast CRUSHES you for " + finalDmg + " damage!");
            p.takeDamage(finalDmg);
        }

        // After ultimate, Ray J gets slightly enraged (temporary attack boost) — we model by small heal or nothing
        System.out.println("🎭 The Freak Off subsides. Ray J catches his breath and smiles wickedly.");
    }

    // Optionally override takeDamage to respect oilShield: reduce next incoming damage then clear shield.
    @Override
    public void takeDamage(int dmg) {
        if (oilShield && dmg > 0) {
            int reduced = Math.max(1, dmg / 2); // reduce damage by half (min 1)
            super.takeDamage(reduced);
            oilShield = false;
            System.out.println("🛢️ Ray J's oil shield reduced incoming damage from " + dmg + " to " + reduced + "!");
        } else {
            super.takeDamage(dmg);
        }
    }

    // Helper to trigger the ultimate externally if you want (Game can call this to telegraph)
    public void triggerUltimateCharge() {
        preparingUltimate = true;
        System.out.println("⚠️ Ray J is building atmosphere... the chorus might be coming.");
    }

    // optional: getType() inherited from Zombie so no need to reimplement
}
