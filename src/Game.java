// ===== GAME LOGIC =====
import java.util.Scanner;

public class Game {
    private Player player;
    private Scanner sc = new Scanner(System.in);
    private int wave = 1;


    private final int maxWaves = 10;
    public void showIntro() {
        String intro1 =
                "In the quiet town of new Jockey.\n" +
                        "The morning news exploded with headlines:\n" +
                        "Rapper 'P. Shiddy' arrested for human trafficking.\n" +
                        "But the strangest part wasn't the crime... it was him.\n\n"+
                        "On the news footage, shiddy twitched, mumbled, stared at the camera\n" +
                        "like something was tearing him apart from the inside\n\n";




        String intro2 =
                "Watching from home, Zack D.S. Notts, a janitor at Greyfall Penitentiary, felt a chill.\n" +
                        "Greyfall wasn't normal prison.. it held the worst monsters New Jockey ever produced\n" +
                        "And tonight, Zack would meet another one\n\n";

        String intro3 =
                "During his night shift, Zack heard a violent banging echoing through the Cell block C.\n" +
                        "He checked the source....\n"+
                        "Cell 13. P. Shiddy\n\n"+
                        "Except..he didn't look human anymore.\n\n"+
                        "Shiddy was convulsing, slamming his head into the bars, growling like an animal\n\n"+
                        "Before zack could react\n"+
                        "Shiddy broke the cell open with inhuman strength\n"+
                        "The alarms blared. Guards rushed in. But it was too late\n\n"+
                        "Shiddy lunged. Biting, tearing, infecting\n"+
                        "The bitten guards staggered.. then turned.\n"+
                        "Their eyes went dead\n"+
                        "Their bodies twitched\n"+
                        "And they attacked everything that moved\n"+
                        "Zack froze\n"+
                        "Then instinct took over\n"+
                        "He ran\n"+
                        "He didn't fight\n"+
                        "He didn't help\n"+
                        "He just ran, through the corridors, out of the gate, all the way home\n"+
                        "He collapsed in bed, panting\n"+
                        "His last thought before he sleep was denial: 'Maybe it was just a nightmare'\n ";


        String intro4 =
                "Morning came. Zack watched the news.\n" +
                        "New Jockey was on fire.\n" +
                        "Cars was flipped\n"+
                       "The infection was spreading all over the news\n"+
                        "The chaos he saw in the prison became a real nightmare to him\n\n"+
                         "Zack realized something that punch him straigh in the gut\n"+
                        "He was the only witness to the start of this outbreak.\n"+
                        "He could have stopped it\n\n"+
                        "But he didn't\n"+
                        "All he did was run\n"+
                        "He stood up from the couch, heart pounding,he clenched his fist\n"+
                        "'I should've stopped him'\n"+
                        "'Now it's on me to finish this\n";



        Displays.typewriter(intro1);
        Displays.typewriter(intro2);
        Displays.typewriter(intro3);
        Displays.typewriter(intro4);

        System.out.println("\n--- GAME STARTS ---\n");
    }
    private void zackDialogueAfterWave(int wave) {
        switch (wave) {
            case 1 -> Displays.typewriter(
                    "Zack wipes blood from his hands.\n" +
                            "\"I never wanted this... but running won't fix anything.\"");
            case 2 -> Displays.typewriter(
                    "\"Damn.. they keep spawning out of nowhere\"\n"+
                         "Zack picks up a torn news print, soiled in oil\n."+
                         "\"...Authorities confirm the first abnormal incident was logged\"\n"+
                        "\" at greyfall penitentiary-three hours before the citywide outbreak\"\n"+
                        "*Zack exhales slowly\n"+
                         "\"Greyfall... of course\n"

                    );

             case 4 -> Displays.typewriter("\"Greyfall.. I know im scared but.. here i come\"\n");

             case 5 -> Displays.typewriter("*Zack suddenly trembled*\n"+
                        "*A sudden weird growl that scared Zack"+
                        "\"what the hell was that?\"\n"+
                         "*Growl*"+
                         "\"that growling... it's not an ordinary infected\"\n"+
                         "\"This might be the end of me\n"
             );


             case 6 -> Displays.typewriter("\"*gasping for air* \n"+
                                         "\"WHAT THE HELL WAS THAT?!"+
                                           "\"AND HOW THE FUCK? DID HE KNOW MY NAME?\n"+
                                          "THIS IS STARTING TO BECOME A NIGHTMARE!..."
                     );

             case 7 -> Displays.typewriter("Zack wipes sweat from his brow\n"+
                                                "\"Whoever that was.. he's playing with me.\"\n"+
                                                "*Takes a deep breathe*\n"+
                                                "\"Fine. I'll play too\n"+
                                                "*Gun clicks*"


                                      );



        }
    }


    public void start() {

        Weapon pistol = new Weapon("Pistol", 15);
        player = new Player(100, pistol);
        player.addAmmo(20);

        System.out.println("💀 Welcome to The Last Stand: Oily Apocalypse 💀");



        while (player.getHealth() > 0 && wave <= maxWaves) {
            Zombie z;
            // === CUTSCENES per wave ===
            if (wave == 1) {
                Displays.typewriter("Zack packed what little he had.\n");
                Displays.typewriter("No plan. No Backup... Just scared");
                Displays.typewriter("Zack steps out into the ruined streets. The smell of smoke hits him first...\n");
                Displays.typewriter("Sirens are wailing\n");
                Displays.typewriter("People are screaming\n");
                Displays.typewriter("He saw the chaos\n");
                Displays.typewriter("This is was his hometown\n");
                Displays.typewriter("Or atleast... it used to be\n\n");
                Displays.typewriter("Something rushed him\n");
                Displays.typewriter("An infected cop - eyes glazed, body leaking oil\n\n");
                Displays.typewriter("Zack was unprepared\n");
                Displays.typewriter("He fought back with panic\n");
                Displays.typewriter("Struggling and struggling..\n");
                Displays.typewriter("Not until he saw a handgun on the oily infected cop\n");
                Displays.typewriter("He grab the handgun and shot the Oily infected cop right through the face\n");
                Displays.typewriter("Zack stared at the corpse.\n");
                Displays.typewriter("He immediately grab a magazine from the corpse shakingly\n");
                Displays.typewriter("He said\n");
                Displays.typewriter("'Time to make things right'\n");
                Displays.typewriter("*handgun clicks*");
            }
            if (wave == 3) {
                Displays.typewriter("Zack wipes blood from his arm. 'I can't stop now... I need to reach Greyfall.'");
            }

            if (wave == 5) {
                Displays.typewriter("A loud explosion shakes the city. Zack sees smoke rising from Greyfall Penitentiary.");
                Displays.typewriter("Zack was trembling with fear... 'hoping this will be all worth it.'");
            }
            if (wave ==6){
                Displays.typewriter("Greyfall Penitentiary looms ahead");
                Displays.typewriter("As Zack walks ahead");
                Displays.typewriter("Floodlights flicker. The gates are half-open");
                Displays.typewriter("Zack tightens his grip");
                Displays.typewriter("\"This is it...\"");
                Displays.typewriter("A slow clap echoes from inside the gates");
                Displays.typewriter("*Footstep*");
                Displays.typewriter("Someone humming in a broken tune");
                Displays.typewriter("\"You should've have stayed home, janitor");

            }

            if (wave == 7) { Displays.typewriter("Zack stepped deeper into Greyfall, passing heavy reinforced doors.\n.'");
                             Displays.typewriter("A rusted sign hung crooked on the wall:\n");
                             Displays.typewriter("He pushed inside.\n");
                             Displays.typewriter("Rows of bolted metal charis faced a small stage.\n");
                             Displays.typewriter("Ceiling fans turned slowly, creaking with each rotation\n\n");
                             Displays.typewriter("Silence\n");
                             Displays.typewriter("Not even the infected the infected wandered here.\n");
                             Displays.typewriter("Zack whispered:\"what was this place...? \"\n\n");
                             Displays.typewriter("Then-\n");
                             Displays.typewriter("A spotlight flickered on, illuminating the stage.\n");
                             Displays.typewriter("Dust drifted through the beam like falling snow.\n\n");
                             Displays.typewriter("A microphone lowered from the ceiling with a metallic screech.\n\n");
                             Displays.typewriter("Someone hummed softly, perfectly on pitch\n");
                             Displays.typewriter("Footsteps echoed behind the stage curtain.\n\n");
                             Displays.typewriter("A voice spoke smoothly:\n");
                             Displays.typewriter("\"I missed the crowd... but you'll do just fine.\"\n\n");
                             Displays.typewriter("*evil laugh echoes*\n\n");
                             Displays.typewriter("\"hehehehehehehe\"\n");
                             Displays.typewriter("Zack grab his gun\n");
                             Displays.typewriter("And aims towards the stage\n");
                             Displays.typewriter("\"Show yourself.\"\n\n");
                             Displays.typewriter("The curtain slid open.\n");
                             Displays.typewriter("Zack flinched and tightened his grip\n\n");
                             Displays.typewriter("A man in a filthy gold suit emerged, bowing with exaggerate grace.\n\n");
                             Displays.typewriter("\"They call me the Golden Crooner,\"he said with a grin.\n");
                             Displays.typewriter("\"And darling... you're front row.\"\n\n");
                             Displays.typewriter("Music cracked through the old speakers.\n");
                             Displays.typewriter("Doors suddenly shut behind Zack.\n\n");
                             Displays.typewriter("Zack's legs are shaking in trembled");
                             Displays.typewriter("Zack muttered:\"Great... another freak with a theme");

            }
            if (wave == 8) {
                Displays.typewriter("The cafeteria doors slam shut behind him. 'What… what is that thing?'");
            }
            if (wave == 9) {
                Displays.typewriter("Zack enters the underground hall. Purple lights flicker. A voice starts singing…");
            }

            if (wave == 10) { Displays.typewriter("Zack reaches Sector X-19. The air turns cold. 'This… this is where it all began.'");
            }


            if (wave == 9) {
                System.out.println("\n🎵 A soft R&B intro begins to play...");
                System.out.println("🎶 \"If I had one wish... we would be best friends...\" 🎶");
                System.out.println("🌈 The lights dim. Purple fog fills the arena.");
                System.out.println("🔥 Wave 9 — Ray J, the R&B Menace, floats down from the sky!");
                System.out.println("💫 His aura grows stronger as the chorus approaches...");
                z = new RayJBoss();

            } else if (wave == 10) {
                System.out.println("\n⚠️ FINAL WAVE! The Diddler emerges from the shadows! ⚠️");
                z = new DiddlerBoss();

            } else if (wave == 8) {
                System.out.println("\n🔥 Wave 8 – EDP Boss appears!");
                System.out.println("\"Did you miss me?\"");
                z = new EDPBoss();

            } else if (wave == 7) {
                System.out.println("\n🎤 Wave 7 – The Golden Crooner sings ominously…");
                z = new GoldenCrooner();

            } else if (wave == 6) {
                System.out.println("\n💿 Wave 6 – Rapper Snake enters!");
                z = new RapperSnake();

            } else if (Math.random() < 0.6) {
                z = new Walker();

            } else {
                z = new Runner();
            }


            System.out.println("\nWave " + wave + " - A " + z.getType() + " appears!");

            // === Combat loop ===
            // === Combat loop ===
            // === Combat loop ===
            while (z.getHealth() > 0 && player.getHealth() > 0) {
                // 1) Apply status effects at the start of the player's turn
                player.processStatusEffects();
                // check death from DOT
                if (player.getHealth() <= 0) break;

                System.out.println("\nYour HP: " + player.getHealth() +
                        " | Weapon: " + player.getWeaponName());
                System.out.println("Zombie HP: " + z.getHealth());
                System.out.println("Ammo: " + player.getAmmo());

                // 2) If stunned, skip player's input/action this turn
                if (player.isStunned()) {
                    System.out.println("🔒 You are stunned and lose your turn!");
                    // clear stun so it only skips one turn (change if you want multi-turn stuns)
                    player.setStunned(false);
                } else {
                    System.out.println("[A] Attack  [W] Weakspot Strike  [H] Heal  [M] Medkit  [R] Reload  [I] Inventory  [D] Dodge");
                    String choice = sc.nextLine().trim();

                    switch (choice.toUpperCase()) {
                        case "A" -> player.attack(z);
                        case "H" -> player.heal();
                        case "M" -> player.useMedkit();
                        case "R" -> player.reload();
                        case "I" -> {
                            player.getInventory().showInventory();
                            continue; // checking inventory consumes the player's action; the enemy will still attack below
                        }
                        case "W" -> handleWeakspot(z);
                        case "D" -> {
                            // Dodge is a simple action you can use to reduce chance of being hit by a telegraphed ultimate.
                            // Implementation of dodge effect for specific boss ultimates is handled in the boss logic.
                            System.out.println("🌀 You prepare to dodge this turn!");
                            // set a temporary "dodge" flag on player by reusing stun/DoT? Better to add a dodge flag if you want persistent behavior.
                            // For now we'll set a short-term flag by a method or field if you want — see optional note below.
                        }
                        default -> System.out.println("Invalid action. The zombie takes advantage!");
                    }
                }

                // 3) Enemy attacks back if still alive
                if (z.getHealth() > 0 && player.getHealth() > 0) {
                    z.attack(player);
                }
            }



            // === After combat ===
            if (player.getHealth() > 0) {
                System.out.println("✅ You survived wave " + wave + "!");
                handleLootDrop();
                zackDialogueAfterWave(wave);
                // Weapon upgrades
                if (wave == 3) player.setWeapon(new Weapon("Shotgun", 25));
                else if (wave == 5) player.setWeapon(new Weapon("Assault Rifle", 35));
                else if (wave == 8) player.setWeapon(new Weapon("Flamethrower", 50));

                wave++;
            } else {
                gameOverMenu();
                return;
            }
        }

        // === Game End ===
        if (player.getHealth() > 0) {
            System.out.println("\n🌕 You survived all 10 waves!");
            System.out.println("The oily apocalypse fades under the moonlight...");
            System.out.println("You are the last survivor. 🏆");
        } else {
            System.out.println("\nYou died... the oily zombies win 💧🧟‍♂️");
        }
    }

    // ===== Loot Drops =====
    private void handleLootDrop() {
        int lootChance = (int) (Math.random() * 100);

        if (lootChance < 40) {
            player.getInventory().addItem("Ammo Pack");
        } else if (lootChance < 70) {
            player.getInventory().addItem("Medkit");
        } else {
            System.out.println("No loot found this time...");
        }
    }

    // ===== Weakspot Mechanic =====
    private void handleWeakspot(Zombie z) {
        if (z instanceof BossZombie || z instanceof RapperSnake) {
            boolean success = Math.random() < 0.5;
            if (success) {
                player.weakspotStrike(z);
            } else {
                System.out.println("⛔ Weakspot failed! The boss counters!");
                int counter = 25 + (int)(Math.random() * 15);
                player.takeDamage(counter);
                System.out.println("Boss counters for " + counter + " damage!");
            }
        } else {
            boolean success = Math.random() < 0.6;
            if (success) {
                player.weakspotStrike(z);
            } else {
                System.out.println("❌ Missed the weakspot! The zombie lunges!");
            }
        }
    }

    // ===== Game Over Menu =====
    private void gameOverMenu() {
        System.out.println("\n💀 You were killed in wave " + wave + "!");
        System.out.println("\n===== GAME OVER =====");
        System.out.println("You reached Wave " + wave);
        System.out.println("1. Retry");
        System.out.println("2. Quit");
        System.out.print("Choose: ");

        int choice = sc.nextInt();
        sc.nextLine();

        if (choice == 1) {
            System.out.println("Restarting game...");
            start();
        } else {
            System.out.println("Exiting to main menu...");
        }
    }


}



