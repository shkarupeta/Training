package ua.shkarupeta.training.practice3;

import java.security.SecureRandom;
import java.util.Arrays;

public class Part1 {
    private static final int NUM_ZERO = 0;
    private static final int NUM_ONE = 1;
    private static final int NUM_TWO = 2;
    private static final int MIN = 1000;
    private static final int MAX = 8999;
    private static final String FILE_NAME = "resources\\practice3\\part1.txt";

    public static String convert1(String input) {

        String[] text = input.split(System.lineSeparator());
        StringBuilder sb = new StringBuilder();
        for (int i = NUM_ONE; i < text.length; i++) {
            String[] str = text[i].split(";");
            sb.append(str[NUM_ZERO]);
            sb.append(": ");
            sb.append(str[NUM_TWO]);
            sb.append(System.lineSeparator());
        }
        return sb.toString();
    }

    public static String convert2(String input) {
        String[] text = input.split(System.lineSeparator());
        StringBuilder sb = new StringBuilder();
        for (int i = NUM_ONE; i < text.length; i++) {
            String[] str = text[i].split(";");
            String[] strReverse = str[NUM_ONE].split(" ");
            StringBuilder strNameReverse = new StringBuilder();
            for (int j = strReverse.length - NUM_ONE; j >= NUM_ZERO; j--) {
                strNameReverse.append(strReverse[j]);
                strNameReverse.append(" ");
            }
            sb.append(strNameReverse);
            sb.append("(email: ");
            sb.append(str[NUM_TWO]);
            sb.append(")");
            sb.append(System.lineSeparator());
        }
        return sb.toString();
    }

    public static String convert3(String input) {
        String[] text = input.split(System.lineSeparator());
        StringBuilder sb = new StringBuilder();
        String[] domens = new String[text.length - NUM_ONE];
        String[] domensUnique;
        int count = NUM_ZERO;

        for (int i = NUM_ONE; i < text.length; i++) {
            String[] str = text[i].split(";");
            String[] strDomens = str[NUM_TWO].split("@");
            domens[count++] = strDomens[NUM_ONE];
        }

        domensUnique = Arrays.stream(domens).distinct().toArray(String[]::new);

        for (String domen : domensUnique) {
            sb.append(domen);
            sb.append(" ==> ");
            for (int i = NUM_ONE; i < text.length; i++) {
                String[] str = text[i].split(";");
                if (str[NUM_TWO].contains(domen)) {
                    sb.append(str[NUM_ZERO]);
                    sb.append(", ");
                }
            }
            sb.replace(sb.length() - NUM_TWO, sb.length(), "");
            sb.append(System.lineSeparator());
        }
        return sb.toString();
    }

    public static String convert4(String input) {
        SecureRandom random = new SecureRandom();

        String[] text = input.split(System.lineSeparator());
        StringBuilder sb = new StringBuilder();
        sb.append(text[NUM_ZERO]);
        sb.append(";Password");
        sb.append(System.lineSeparator());
        for (int i = NUM_ONE; i < text.length; i++) {
            int ranNum = MIN + random.nextInt(MAX);

            String str = text[i] + ";" + ranNum;
            sb.append(str);
            sb.append(System.lineSeparator());
        }


        return sb.toString();
    }


    public static void main(String[] args) {
        System.out.println(Part1.convert1(Util.readFile(FILE_NAME)) + System.lineSeparator());
        System.out.println(Part1.convert2(Util.readFile(FILE_NAME)) + System.lineSeparator());
        System.out.println(Part1.convert3(Util.readFile(FILE_NAME)) + System.lineSeparator());
        System.out.println(Part1.convert4(Util.readFile(FILE_NAME)) + System.lineSeparator());
    }

}
