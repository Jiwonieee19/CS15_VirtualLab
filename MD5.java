import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Scanner;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class MDA5 {
    private static final String ALGORITHM = "AES/CBC/PKCS5Padding";
    private static final String SECRET_KEY = "1234567890123456";
    private static final String INIT_VECTOR = "abcdefghijklmnop";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String tryAgain;

        do {
            try {
                System.out.println("Choose operation:");
                System.out.println("1. Encrypt");
                System.out.println("2. Decrypt");
                System.out.print("Enter choice (1 or 2): ");

                String choice = scanner.nextLine().trim();

                if ("1".equals(choice)) {
                    System.out.print("Enter plaintext: ");
                    String plaintext = scanner.nextLine();
                    String ciphertext = encrypt(plaintext);
                    System.out.println("Ciphertext: " + ciphertext);
                } else if ("2".equals(choice)) {
                    System.out.print("Enter ciphertext: ");
                    String ciphertext = scanner.nextLine();
                    String plaintext = decrypt(ciphertext);
                    System.out.println("Plaintext: " + plaintext);
                } else {
                    System.out.println("Invalid choice. Please choose 1 or 2.");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }

            System.out.print("Do you want to try again? (Y/N): ");
            tryAgain = scanner.nextLine().trim();
            System.out.println();
        } while ("Y".equalsIgnoreCase(tryAgain));

        try {
            scanner.close();
        } catch (Exception e) {
            System.out.println("Error closing scanner: " + e.getMessage());
        }
    }

    private static String encrypt(String plaintext) throws Exception {
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        SecretKeySpec keySpec = new SecretKeySpec(SECRET_KEY.getBytes(StandardCharsets.UTF_8), "AES");
        IvParameterSpec ivSpec = new IvParameterSpec(INIT_VECTOR.getBytes(StandardCharsets.UTF_8));

        cipher.init(Cipher.ENCRYPT_MODE, keySpec, ivSpec);
        byte[] encrypted = cipher.doFinal(plaintext.getBytes(StandardCharsets.UTF_8));
        return Base64.getEncoder().encodeToString(encrypted);
    }

    private static String decrypt(String ciphertext) throws Exception {
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        SecretKeySpec keySpec = new SecretKeySpec(SECRET_KEY.getBytes(StandardCharsets.UTF_8), "AES");
        IvParameterSpec ivSpec = new IvParameterSpec(INIT_VECTOR.getBytes(StandardCharsets.UTF_8));

        cipher.init(Cipher.DECRYPT_MODE, keySpec, ivSpec);
        byte[] decoded = Base64.getDecoder().decode(ciphertext);
        byte[] decrypted = cipher.doFinal(decoded);
        return new String(decrypted, StandardCharsets.UTF_8);
    }
}