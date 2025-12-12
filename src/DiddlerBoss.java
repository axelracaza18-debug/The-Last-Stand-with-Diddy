// DiddlerBoss.java
public class DiddlerBoss extends Zombie {

    private boolean preparingUltimate = false; // charging Grand Freak Off
    private boolean auraActive = false;        // Freak Off Aura active
    private int auraTurns = 0;                 // how long aura lasts (turns)
    private int baseAttack;                    // store base attackPower for buff toggles

    public DiddlerBoss() {
        super(450, 28, "The Diddler — Oily King of Chaos");
        this.baseAttack = this.attackPower;
    }

    @Override
    public void attack(Player p) {

        // 20% chance boss slips and wastes a turn
        if (Math.random() < 0.20) {
            System.out.println("😵 The Diddler slips on oil and WHIFFS completely! You take NO damage.");
            return;
        }

        // If ultimate was charging last turn, resolve it now
        if (preparingUltimate) {
            preparingUltimate = false;
            resolveGrandFreakOff(p);
            return;
        }

        // If aura is active, reduce its remaining turns
        if (auraActive && auraTurns > 0) {
            auraTurns--;
            if (auraTurns == 0) {
                deactivateAura();
            }
        }

        // Choose an action
        double r = Math.random();

        if (r < 0.20) {
            // Aura: signature move
            activateAura(p);

        } else if (r < 0.55) {
            // Freak-Off Slam: heavy hit, chance to stun
            freakOffSlam(p);

        } else if (r < 0.85) {
            // Oily Twirl: multi-hit with DOT chance
            oilyTwirl(p);

        } else {
            // Start charging Ultimate (telegraph)
            System.out.println("\n🎶 The Diddler raises a hand, music swells...");
            System.out.println("🗣️ \"Ain't no party like a Freak Off party!\" — He begins preparing something huge...");
            preparingUltimate = true;
        }
    }

    // ===== MOVES =====

    private void activateAura(Player p) {
        auraActive = true;
        auraTurns = 3; // aura lasts 3 turns
        // buff attack power by +10 while aura active
        this.attackPower = baseAttack + 10;

        // heal a bit when aura starts
        int heal = 25;
        this.health += heal;
        if (this.health > 450) this.health = 450; // cap at max if you want

        System.out.println("\n🕺 THE FREAK OFF AURA ACTIVATES!");
        System.out.println("🗣️ The Diddler shouts: \"Ain't no party like a freak off party!\"");
        System.out.println("🔥 He heals " + heal + " HP and grows stronger (+10 attack) for " + auraTurns + " turns.");
    }

    private void deactivateAura() {
        auraActive = false;
        this.attackPower = baseAttack;
        System.out.println("🕯️ The Freak Off Aura fades. The Diddler calms his dance.");
    }

    private void freakOffSlam(Player p) {
        int min = 15, max = 25;
        int dmg = min + (int)(Math.random() * (max - min + 1));
        System.out.println("💥 Freak-Off Slam! The Diddler slides in and SMASHES you for " + dmg + " damage!");
        p.takeDamage(dmg);

        // 20% chance to stun
        if (Math.random() < 0.20) {
            System.out.println("✨ You are stunned by the brutal slam!");
            try { p.setStunned(true); } catch (Throwable ignored) {}
        }
    }

    private void oilyTwirl(Player p) {
        System.out.println("🌀 Oily Twirl — The Diddler spins and flings burning oil!");
        int hits = 3;
        int perHitMin = 6, perHitMax = 9;
        int total = 0;
        for (int i = 0; i < hits; i++) {
            int hit = perHitMin + (int)(Math.random() * (perHitMax - perHitMin + 1));
            p.takeDamage(hit);
            total += hit;
        }
        System.out.println("→ Oily Twirl hits " + hits + " times for a total of " + total + " damage.");

        // 30% chance to apply Slippery DOT (5 dmg x 2 turns)
        if (Math.random() < 0.30) {
            System.out.println("💧 You are coated in burning oil — DOT applied (5 dmg x 2 turns)!");
            try { p.applyDamageOverTime(5, 2); } catch (Throwable t) { p.takeDamage(5 * 2); }
        }
    }

    // ===== ULTIMATE =====

    private void resolveGrandFreakOff(Player p) {
        System.out.println("\n⚠️ GRAND FREAK OFF — The Diddler unleashes the OIL TSUNAMI!");
        System.out.println("🎵 The arena shakes as loud freak-off music hits. Prepare to DODGE (press D)!");

        // Check for explicit dodge flag first
        boolean playerDodged = false;
        try {
            if (p.isDodgeReady()) {
                playerDodged = true;
                // consume the dodge
                try { p.setDodgeReady(false); } catch (Throwable ignored) {}
            }
        } catch (Throwable ignored) {}

        // fallback random dodge chance (30%) if no flag was set
        if (!playerDodged && Math.random() < 0.30) playerDodged = true;

        if (playerDodged) {
            System.out.println("🌀 You DODGED the Oil Tsunami! The Diddler SLAMS into his own oil and is staggered!");
            int counterDmg = 35;
            this.takeDamage(counterDmg);
            System.out.println("→ The Diddler takes " + counterDmg + " counter damage!");
        } else {
            int finalDmg = 55;
            System.out.println("💥 You are swept by the Oil Tsunami for " + finalDmg + " damage!");
            p.takeDamage(finalDmg);

            // After a successful hit, Diddler grows more chaotic (short buff)
            auraActive = true;
            auraTurns = 2;
            this.attackPower = baseAttack + 12;
            System.out.println("🔥 The Diddler feeds off the chaos and gets a short enraged buff!");
        }
    }

    // ===== override takeDamage to behave normally (but kept if you want custom behavior) =====
    @Override
    public void takeDamage(int dmg) {
        super.takeDamage(dmg);
        // optional: if aura is active, reduce chance aura disappears — we keep behavior simple here
    }
}
