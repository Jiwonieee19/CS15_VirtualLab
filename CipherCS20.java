import java.util.Scanner;

// import java.util.Random;

public class CipherCS20 {

    static Scanner ryy = new Scanner(System.in);
    static int choice;
    static String plaintext;
    static int shiftKeyChoice;
    static char[] dissect;

    public static void main(String[] args) {

        System.out.println("CHOOSE: \nENCRYPTION [1]\nDECRYPTION [2]");
        choice = ryy.nextInt();
        ryy.nextLine();

        switch (choice) {
            case 1:
                Encryption();
                break;
            case 2:
                Decryption();
                break;
            default:
                System.out.println("WRONG CHOICE, DO IT AGAIN");
        }

    }

    public static String accessAlphabets(String text, int shiftKeyChoice) {

        // dissect = new char[plaintext.length()];
        String converted = "";
        String alphabet = "abcdefghijklmnopqrstuvwxyz";

        restart: for (int i = 0; i < text.length(); i++) {
            for (int j = 0; j < alphabet.length(); j++) {
                if (text.charAt(i) == alphabet.charAt(j)) {
                    try {
                        // dissect[i] = alphabet.charAt(j+shiftKeyChoice);
                        converted = converted + alphabet.charAt(j + shiftKeyChoice);
                    } catch (StringIndexOutOfBoundsException e) {
                        // if wxyz, i mean if malapas sa array ang key, ibalik sa abc
                        int newIndex = j + shiftKeyChoice - 26;
                        converted = converted + alphabet.charAt(newIndex);
                    }
                    continue restart;
                    // SALO ANG NON-ALPHABETS AND ALL NA E REMAIN
                } else if (j == (alphabet.length() - 1) && text.charAt(i) != alphabet.charAt(j)) {
                    // dissect[i] = text.charAt(i);
                    converted = converted + text.charAt(i);
                }

            }

        }
        // String converted = new String(dissect);
        // String converted = "";
        // for (int i = 0; i < dissect.length; i++) {
        // converted = converted + dissect[i];
        // }
        return converted;

    }

    public static void Encryption() {

        System.out.print("INPUT PLAINTEXT: ");
        plaintext = ryy.nextLine();
        System.out.print("SHIFT KEY: ");
        shiftKeyChoice = ryy.nextInt();
        ryy.nextLine();

        // dissect = new char[plaintext.length()];
        // for (int i = 0; i < plaintext.length(); i++) {
        // dissect[i] = plaintext.charAt(i);
        // }
        // System.out.println(dissect[plaintext.length() - 1]);

        System.out.println("ENCRYPTED TEXT: " + accessAlphabets(plaintext, shiftKeyChoice));
    }

    public static void Decryption() {

        System.out.print("INPUT ENCRYPTED TEXT: ");
        plaintext = ryy.nextLine();
        System.out.print("SHIFT KEY: ");
        shiftKeyChoice = ryy.nextInt();
        // IF POSITIVE, THEN PAG DECRYPT PA NEGATIVE, IF NEGATIVE, PA DECRYPT POSITIVE
        shiftKeyChoice *= -1;
        ryy.nextLine();

        System.out.println("PLAIN/DECRYPTED TEXT: " + accessAlphabets(plaintext, shiftKeyChoice));
    }

}