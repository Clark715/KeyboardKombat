import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

        Warrior userWarrior = new Warrior();
        Warrior cpuWarrior = new Warrior();

        welcomeMessage();
        PlayerWarriorSetup(userWarrior);
        System.out.println("Picking your opponent...");
        cpuWarriorSetup(cpuWarrior);
        System.out.println("FIGHT TO THE DEATH!!!");
        game(userWarrior, cpuWarrior);
        end(userWarrior, cpuWarrior);
    }

    public static void welcomeMessage() {

        Scanner beginInput = new Scanner(System.in);
        System.out.println("Welcome to KeyboardKombat!");
        System.out.println("(The game where you are literally a keyboard warrior.)");
        System.out.println("Press ENTER to begin or type 'h' and press ENTER for help.");
        String userInput = beginInput.nextLine();

        if (userInput.equals(" ")) {
            ;
        }
        else if (userInput.equals("h")) {
            System.out.println("""
                    Welcome to Keyboard Kombat by Colby. In this game you will choose a warrior class
                    and go to battle! The way the game works: After you choose a warrior class, you will be
                    prompted to choose either '1' or '2' to simulate whether or not your warrior connects an
                    attack with their opponent or not. Upon a successful attack the amount of damage you do
                    will vary depending on which class you chose. For example a 'Knight' class may not do as much
                    damage as a mage with powerful magic, but you will be able to sustain more damage due to your
                    totally awesome armor. Some warriors may have more health while others will do more attack
                    damage. The games ends when a warrior's health reaches zero making the remaining
                    warrior our mighty victor! Good luck.""");
        }

    }
    // PLAYER WARRIOR SETUP
    public static void PlayerWarriorSetup(Warrior userWarrior) {


        Random damageOutput = new Random();
        Scanner userInput = new Scanner(System.in);

        System.out.println("What shall we call you..?");
        String userName = userInput.nextLine();
        System.out.println("Choose a warrior class!");
        System.out.println("1. KNIGHT / 2. ARCHER / 3. MAGE");
        String userClass = userInput.nextLine();


        if (userClass.equals("1") || userClass.equalsIgnoreCase("KNIGHT")) {
            userWarrior.warriorClass = "Knight";
            userWarrior.warriorHealth = 125;
            userWarrior.warriorDamage = damageOutput.nextInt(25, 30);
        }
        else if (userClass.equals("2") || userClass.equalsIgnoreCase("ARCHER")) {
            userWarrior.warriorClass = "Archer";
            userWarrior.warriorHealth = 110;
            userWarrior.warriorDamage = damageOutput.nextInt(30, 35);
        }
        else if (userClass.equals("3") || userClass.equalsIgnoreCase("MAGE")) {
            userWarrior.warriorClass = "Mage";
            userWarrior.warriorHealth = 90;
            userWarrior.warriorDamage = damageOutput.nextInt(35, 40);
        } else {
            userWarrior.warriorClass = "Illiterate";
            userWarrior.warriorHealth = 70;
            userWarrior.warriorDamage = damageOutput.nextInt(15, 20);
        }

        userWarrior.warriorName = userName;

        System.out.println("Good, good... You shall be known as " + userWarrior.warriorName + " THE " +
                userWarrior.warriorClass.toUpperCase() + "!!!");
        System.out.println(" ");
    }

    // CPU WARRIOR SETUP
    public static void cpuWarriorSetup(Warrior cpuWarrior) {

        Random cpuWarriorChoice = new Random();
        Random cpuName = new Random();
        Random damageOutput = new Random();

        int cpuChoice = cpuWarriorChoice.nextInt(1, 3);
        String[] cpuNames = {"Jim", "Steve", "Sierra", "Karen"};
        int namesIndex = cpuName.nextInt(cpuNames.length);
        cpuWarrior.warriorName = cpuNames[namesIndex];

        if (cpuChoice == 1) {
            cpuWarrior.warriorClass = "Knight";
            cpuWarrior.warriorHealth = 125;
            cpuWarrior.warriorDamage = damageOutput.nextInt(25, 30);
        }
        else if (cpuChoice == 2) {
            cpuWarrior.warriorClass = "Archer";
            cpuWarrior.warriorHealth = 110;
            cpuWarrior.warriorDamage = damageOutput.nextInt(30, 35);
        }
        else if (cpuChoice == 3) {
            cpuWarrior.warriorClass = "Mage";
            cpuWarrior.warriorHealth = 90;
            cpuWarrior.warriorDamage = damageOutput.nextInt(35, 40);
        }

        System.out.println(" ");
        System.out.println("Your opponent will be... " + cpuWarrior.warriorName + " THE " +
                cpuWarrior.warriorClass.toUpperCase() + "!!!");
        System.out.println(" ");
        System.out.println("You're DOOMED!");
        System.out.println(" ");
    }

    // PLAY GAME UNTIL A WINNER IS DETERMINED
    public static void game(Warrior userWarrior, Warrior cpuWarrior) {

        Scanner playerTurn = new Scanner(System.in);
        Random combat = new Random();
        Random attackChatter = new Random();
        Random defenseChatter = new Random();

        String[] attackChatterArr = {"'AAAAAAAAHHHHHHHHHHHHHH!!!!!!!!!'", "'Take this!!'",
        "'Can we end this already?!'", "'You can't stop me!!'", "'Block this!!'"};
        String[] defenseChatterArr = {"'Ouch...'", "'Tis but a flesh wound!'", "'That hurt!'",
        "'You will pay for that!!'", "'Good thing I brought band-aids..'"};

        int attackChatterIndex = attackChatter.nextInt(attackChatterArr.length);
        int defenseChatterIndex = defenseChatter.nextInt(defenseChatterArr.length);

        int turn = 1;
        int i = 0;

        while (i < turn) {

            // PLAYER'S TURN TO ATTACK
            if (turn == 1) {
                System.out.println(" ");
                System.out.println("It's your turn to attack.");
                System.out.println(" ");
                System.out.println("Enter either '1' or '2' to attempt an attack! ");
                String playerAttack = playerTurn.nextLine();

                int cpuCombatNum = combat.nextInt(1, 2);
                int playerCombatNum = 0;

                if (playerAttack.equals("1") || playerAttack.equals("2")) {
                    playerCombatNum = Integer.parseInt(playerAttack);

                } else {
                    System.out.println("Since you didn't choose '1' or '2'... You trip over your own feet and miss!");
                }

                // CHECK IF PLAYER ATTACK IS SUCCESSFUL
                if (playerCombatNum != cpuCombatNum) {
                    System.out.println(" ");
                    System.out.println(userWarrior.warriorName + ": " + attackChatterArr[attackChatterIndex]);
                    cpuWarrior.warriorHealth = cpuWarrior.warriorHealth - userWarrior.warriorDamage;
                    System.out.println(" ");
                    System.out.println("Attack successful!");
                    System.out.println(" ");
                    System.out.println(cpuWarrior.warriorName + ": " + defenseChatterArr[defenseChatterIndex]);
                    System.out.println(" ");
                    System.out.println(userWarrior.warriorName + " Health: " + userWarrior.warriorHealth + " || " +
                            cpuWarrior.warriorName + " Health: " + cpuWarrior.warriorHealth);
                    turn = 2;
                } else {
                    System.out.println(userWarrior.warriorName + ": " + attackChatterArr[attackChatterIndex]);
                    System.out.println(" ");
                    System.out.println("...");
                    System.out.println(" ");
                    System.out.println("Your opponent blocks your attack!");
                    System.out.println(" ");
                    System.out.println(userWarrior.warriorName + " Health: " + userWarrior.warriorHealth + " || " +
                            cpuWarrior.warriorName + " Health: " + cpuWarrior.warriorHealth);
                    turn = 2;
                }
            }
            // PLAYER'S TURN TO DEFEND
            else if (turn == 2) {
                System.out.println(" ");
                System.out.println("It's your turn to defend.");
                System.out.println(" ");
                System.out.println("Enter either '1' or '2' to attempt a block! ");
                String playerDefense = playerTurn.nextLine();

                int cpuCombatNum = combat.nextInt(1, 2);
                int playerCombatNum = 0;

                if (playerDefense.equals("1") || playerDefense.equals("2")) {
                    playerCombatNum = Integer.parseInt(playerDefense);
                } else {
                    System.out.println("Since you didn't choose '1' or '2'... You left yourself wide open!");
                }

                // CHECK IF PLAYER DEFEND IS SUCCESSFUL
                if (playerCombatNum != cpuCombatNum) {
                    System.out.println(" ");
                    System.out.println(cpuWarrior.warriorName + ": " + attackChatterArr[attackChatterIndex]);
                    userWarrior.warriorHealth = userWarrior.warriorHealth - cpuWarrior.warriorDamage;
                    System.out.println("Block unsuccessful!");
                    System.out.println(userWarrior.warriorName + ": " + defenseChatterArr[defenseChatterIndex]);
                    System.out.println(" ");
                    System.out.println(userWarrior.warriorName + " Health: " + userWarrior.warriorHealth + " || " +
                            cpuWarrior.warriorName + " Health: " + cpuWarrior.warriorHealth);
                    turn = 1;
                } else {
                    System.out.println(" ");
                    System.out.println(cpuWarrior.warriorName + ": " + attackChatterArr[attackChatterIndex]);
                    System.out.println(" ");
                    System.out.println("Block successful!");
                    System.out.println(" ");
                    System.out.println(userWarrior.warriorName + " Health: " + userWarrior.warriorHealth + " || " +
                            cpuWarrior.warriorName + " Health: " + cpuWarrior.warriorHealth);
                    turn = 1;
                }

            }

            if (userWarrior.warriorHealth <= 0 || cpuWarrior.warriorHealth <= 0) {
                i = 3;
            }

        }
    }

    // END GAME
    public static void end(Warrior userWarrior, Warrior cpuWarrior) {

        if (userWarrior.warriorHealth <= 0) {
            System.out.println(" ");
            System.out.println("DEFEAT!!!");
            System.out.println("Your health has reached zero.");
            System.out.println("R.I.P. " + userWarrior.warriorName);
        }
        else if (cpuWarrior.warriorHealth <= 0) {
            System.out.println(" ");
            System.out.println("VICTORY!!!");
            System.out.println("You have proven yourself a true KEYBOARD WARRIOR.");
            System.out.println("R.I.P. " + cpuWarrior.warriorName);
        }
    }
}