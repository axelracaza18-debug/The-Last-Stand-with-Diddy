public class RapperSnake extends Zombie {
    public RapperSnake() {
        super(250, 25, "Rapper Snake 💿");
    }

    @Override
    public void attack(Player p) {
        double r = Math.random();
        if (r < 0.25) {
            System.out.println("🎤 Rapper Snake uses Bass Drop! It shakes your soul!");
            p.takeDamage(attackPower + 10);
        } else if (r < 0.5) {
            System.out.println("⚡ Rapper Snake uses Auto-Tune Shock! You’re momentarily stunned!");
            p.takeDamage(attackPower + 5);
        } else if (r < 0.75) {
            System.out.println("🎶 Rapper Snake whips his mic like a weapon!");
            p.takeDamage(attackPower + 8);
        } else {
            System.out.println("🔥 Rapper Snake dances freakishly! The rhythm hurts your brain!");
            p.takeDamage(attackPower + 12);
        }
    }
}
