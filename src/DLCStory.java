// DLCStory.java
public class DLCStory {

    public static void playMnemosyneIntro() {
        Displays.typewriter("[Intercom crackles]\n\n" +
                "Dr. Havel:\n" +
                "\"What you just defeated was never the source.\"\n\n" +
                "\"Zack D.S Notts... Subject 000\"\n" +
                "\"You were never meant to remember.\"\n\n" +
                "\"Follow the green emergency lights.\"\n" +
                "\"They were installed for you.\"\n\n" +
                "Zack feels his chest tighten.\n" +
                "The lights ahead flicker green...\n"
        );
    }


    public static void playHallwayFightStory() {
        Displays.typewriter("\n⚠️ You step into the hallway, tense and alert."+
       "Water drips from the ceiling, and the lights flicker green across the walls."+
        "A wet, sliding noise echoes closer... you spot the first Failed Scientist, oily and jerky, emerging from the shadows."+
        "All other scientists appear to have been infected. Only Dr. Havel’s voice guides you through the intercom."+
        "You ready your weapon as more Oily Infected crawl out from the darkness."+
        "\n💥 The hallway battle is about to begin!");
    }

    public static void playPostCombatScene() {
        Displays.typewriter("\nThe hallway falls silent. Bodies of the Oily Infected lie scattered."+
        "The green emergency lights flicker weakly."+
        "Dr. Havel's voice echoes: \"Good job, Zack. But the real trial is just ahead...\""+
        "You take a deep breath, reload, and move further into the lab."+
      "\n--- TO BE CONTINUED ---\n");
    }
}
