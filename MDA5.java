import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MDA5 {
    public static void main(String[] args) {
        String input = "Hello, world!";

        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] digest = md.digest(input.getBytes(StandardCharsets.UTF_8));

            StringBuilder hex = new StringBuilder();
            for (byte b : digest) {
                hex.append(String.format("%02x", b));
            }

            System.out.println("Input: " + input);
            System.out.println("MD5: " + hex);
        } catch (NoSuchAlgorithmException e) {
            System.out.println("MD5 algorithm is not available.");
        }
    }
}