public class DLCMain {

    private Player player;

    public DLCMain(Player existingPlayer) {
        this.player = existingPlayer; // Keep player's current state from main game
    }

    public void startDLC() {
        Displays.typewriter("\n=== PROJECT MNEMOSYNE DLC START ===\n");

        // Story intro
        DLCStory.playMnemosyneIntro();

        // Hallway story before combat
        DLCStory.playHallwayFightStory();

        // Start combat from separate battle file
        boolean survived = DLCBattle.startHallwayCombat(player);

        // Post-combat scene if survived
        if (survived) {
            DLCStory.playPostCombatScene();
        }
    }
}
