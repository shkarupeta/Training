package ua.shkarupeta.training.practice3;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Locale;

public class Part4 {


    public static String hash(String input, String algorithm) throws NoSuchAlgorithmException {
        StringBuilder sb = new StringBuilder();

        MessageDigest digest = MessageDigest.getInstance(algorithm);
        digest.update(input.getBytes());
        byte[] hash = digest.digest();


        for (byte b : hash) {
            String s = Integer.toHexString(0xff & b);
            s = (s.length() == 1) ? ("0" + s) : s;
            sb.append(s);


        }
        return sb.toString().toUpperCase(Locale.ENGLISH);
    }


    public static void main(String[] args) throws NoSuchAlgorithmException {
        System.out.println(hash("pssword", "SHA-256"));
        System.out.println(hash("passwort", "SHA-256"));
    }
}
