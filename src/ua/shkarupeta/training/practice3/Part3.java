package ua.shkarupeta.training.practice3;

import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part3 {
    private static final int NUM_ZERO = 0;
    private static final int NUM_ONE = 1;
    private static final int NUM_TWO = 2;

    private static final String FILE_NAME = "resources\\practice3\\part3.txt";

    public static String convert(String input) {

        StringBuilder sb = new StringBuilder();


        Pattern pattern = Pattern.compile("[a-zA-Zа-яёА-ЯЁЇїІіЄєҐґ]+|[\\W]");

        Matcher matcher = pattern.matcher(input);

        while (matcher.find()) {
            int start = matcher.start();
            int end = matcher.end();
            int currentWordLen = input.substring(start, end).length();
            String currentWord = input.substring(start, end);

            if (currentWordLen > NUM_TWO) {

                if (Character.isUpperCase(currentWord.charAt(NUM_ZERO))) {
                    String capitalized = currentWord.substring(NUM_ZERO, NUM_ONE)
                            .toLowerCase(Locale.ENGLISH) + currentWord.substring(NUM_ONE);
                    sb.append(capitalized);
                } else {
                    String capitalized = currentWord.substring(NUM_ZERO, NUM_ONE)
                            .toUpperCase(Locale.ENGLISH) + currentWord.substring(NUM_ONE);
                    sb.append(capitalized);
                }
            } else {
                sb.append(currentWord);
            }

        }
        return sb.toString();

    }

    public static void main(String[] args) {
        System.out.println(Part3.convert(Util.readFile(FILE_NAME)) + System.lineSeparator());
    }

}
