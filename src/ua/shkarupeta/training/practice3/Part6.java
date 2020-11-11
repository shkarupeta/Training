package ua.shkarupeta.training.practice3;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part6 {
    private static final int NUM_ZERO = 0;
    private static final int NUM_ONE = 1;

    private static final String FILE_NAME = "resources\\practice3\\part6.txt";


    public static void main(String[] args) {
        System.out.println(convert(Util.readFile(FILE_NAME)));
    }

    public static String convert(String input) {

        StringBuilder sb = new StringBuilder();

        String[] words = Arrays.stream(getListWords(input)).distinct().toArray(String[]::new);
        int[] countWords = countDuplicates(words, getListWords(input));



        Pattern pattern = Pattern.compile("[\\s]|[a-zA-Zа-яёА-ЯЁЇїІіЄєҐґ]*");
        Matcher matcher = pattern.matcher(input);

        while (matcher.find()) {
            int start = matcher.start();
            int end = matcher.end();
            String currentWord = input.substring(start, end);

            try {

                if (countWords[Arrays.asList(words).indexOf(currentWord)] > 1) {
                    sb.append("_");
                }
                sb.append(currentWord);
            } catch (IndexOutOfBoundsException e) {
                sb.append(currentWord);
            }
        }

        return sb.toString();
    }

    private static String[] getListWords(String string) {
        String[] words = new String[NUM_ZERO];

        Pattern pattern = Pattern.compile("[a-zA-Zа-яёА-ЯЁЇїІіЄєҐґ]*");
        Matcher matcher = pattern.matcher(string);
        while (matcher.find()) {
            int start = matcher.start();
            int end = matcher.end();
            int currentWordLen = string.substring(start, end).length();
            String currentWord = string.substring(start, end);
            if (currentWordLen == 0) {
                continue;
            }
            words = addValueToArray(words, currentWord);
        }
        return words;
    }

    private static String[] addValueToArray(String[] array, String value) {
        String[] currentArray = array.clone();
        String[] arrayTmp;
        try {
            arrayTmp = currentArray;
            currentArray = new String[currentArray.length + NUM_ONE];
            System.arraycopy(arrayTmp, NUM_ZERO, currentArray, NUM_ZERO, arrayTmp.length);
            currentArray[currentArray.length - NUM_ONE] = value;

        } catch (IndexOutOfBoundsException e) {
            System.out.println("array in error addValueToArray = " + Arrays.toString(currentArray));
        }

        return currentArray;
    }


    private static int[] countDuplicates(String[] uniqueString, String[] sourceString) {

        int count = NUM_ZERO;
        int[] countWords = new int[uniqueString.length];

        for (String string : uniqueString) {

            int countDupl = NUM_ZERO;
            for (String word : sourceString) {
                if (word.equals(string)) {
                    countDupl++;
                }
            }
            countWords[count] = countDupl;

            count++;
        }


        return countWords;
    }
}
