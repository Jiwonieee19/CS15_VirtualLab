package Exercise2;

import java.util.Scanner;
import java.util.Random;

public class Present {
    // 1V1 MINI TURN BASED CARD GAMES NALANG HEEHE
    // FRIEREN NLNG

    static Scanner ryy = new Scanner(System.in);
    static int round = 1;
    static int hpPlayer = 100;
    static int hpBot = 100;
    static int poisonPlayer = 0, poisonBot = 0;
    static int playerDoubleEffect = 0, botDoubleEffect = 0;

    static Random picker = new Random();

    static Card c1 = new Card("Damage", "Burst", 31);
    static Card c2 = new Card("DeBuff", "Poison", 5);
    static Card c3 = new Card("Defense", "Heal", 23);
    static Card c4 = new Card("Buff", "Double Effect Next Card", 0);
    static Card c5 = new Card("Purify", "Remove DeBuffs", 0);

    static Card[] cards = { c1, c2, c3, c4, c5 };

    public static void main(String[] args) {

        System.out.println(
                "THIS IS A 1V1 GAME WITH RANDOM CARDS EVERY TURN\nNOTE THAT YOU CAN DRAW DUPLICATES SO THE GAME WILL BE CHALLENGING WITH LUCK");

        do {
            Card a = cards[picker.nextInt(5)];
            Card b = cards[picker.nextInt(5)];
            Card c = cards[picker.nextInt(5)];

            System.out.println("----------------------------------------------\nROUND " + round);
            System.out.println("YOUR CURRENT HP: " + hpPlayer + "        BOT CURRENT HP: " + hpBot
                    + "\n----------------------------------------------\n");

            System.out.println(
                    "\nPlayer Poison Damage: " + poisonPlayer + "        Bot Poison Damage: " + poisonBot + "\n");

            if (poisonPlayer > 0) {
                hpPlayer -= poisonPlayer;
                System.out.println("You took " + poisonPlayer + " poison damage! Your Current HP: " + hpPlayer + "\n");
            }
            if (poisonBot > 0) {
                hpBot -= poisonBot;
                System.out.println("Bot took " + poisonBot + " poison damage! Bot Current HP: " + hpBot + "\n");
            }

            System.out.println("YOUR TURN\nCHOOSE A CARD!!");
            System.out.printf("%-25s %s %25s\n", "A", "B", "C");
            // System.out.printf("%s %s %s", a.getDetailsR1(), b.getDetailsR2(),
            // c.getDetailsR3() + "\n");
            System.out.printf("%-25s %-25s %-25s\n", a.getName(), b.getName(), c.getName());
            System.out.printf("%-25s %-25s %-25s\n", a.getAttributes(), b.getAttributes(), c.getAttributes());
            System.out.printf("%-25s %-25s %-25s\n", "Amount: " + a.getAmount(), "Amount: " + b.getAmount(),
                    "Amount: " + c.getAmount());

            String choice = ryy.nextLine().toUpperCase();
            switch (choice) {
                case "A":
                    a.executeCard(a, true);
                    break;
                case "B":
                    b.executeCard(b, true);
                    break;
                case "C":
                    c.executeCard(c, true);
                    break;
                default:
                    System.out.println("INVALID INPUT, SKIPPING TURN");
                    break;
            }

            System.out.println("\nBOT'S TURN\nCHOOSING A CARD!!");

            Card botCard = cards[picker.nextInt(5)];
            botCard.executeCard(botCard, false);

            round++;
            System.out.println("\nEND OF ROUND " + round + "\n\n");

        } while (hpPlayer > 0 && hpBot > 0);

        if (hpPlayer <= 0 && hpBot > 0) {
            System.out.println("YOUR HP: " + hpPlayer + "        BOT HP: " + hpBot);
            System.out.println("BOT WINS!!");
        } else if (hpBot <= 0 && hpPlayer > 0) {
            System.out.println("YOUR HP: " + hpPlayer + "        BOT HP: " + hpBot);
            System.out.println("YOU WINS!!");
        } else {
            if (hpPlayer > hpBot) {
                System.out.println("YOUR HP: " + hpPlayer + "        BOT HP: " + hpBot);
                System.out.println("YOU WINS!!\n");
            } else if (hpBot > hpPlayer) {
                System.out.println("YOUR HP: " + hpPlayer + "        BOT HP: " + hpBot);
                System.out.println("BOT WINS!!\n");
            } else {
                System.out.println("IT'S A TIE!!\n");
            }
            System.out.println(
                    "SINCE 1ST TURN IS ALWAYS THE PLAYER, \nWE LET BOTH PLAY UNTIL THE END OF THE \nROUND TO DECIDE WHO WILL WIN FAIRLY\n\n");
        }
    }
}
