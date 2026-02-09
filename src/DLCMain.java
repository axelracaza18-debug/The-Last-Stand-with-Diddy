public class DLCMain {

    private Player player;

    public DLCMain(Player existingPlayer) {
        this.player = existingPlayer;
    }

    public void startDLC() {
        Displays.typewriter("\n=== PROJECT MNEMOSYNE DLC START ===\n");

        DLCStory.playMnemosyneIntro();
        DLCStory.playHallwayFightStory();

        boolean survived = DLCBattle.startHallwayCombat(player);

        if (survived) {
            Displays.typewriter("\n🧪 The cure is complete...");
            Displays.typewriter("Zack saved the city.");
        }
    }
}
