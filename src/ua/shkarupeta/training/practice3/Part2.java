package ua.shkarupeta.training.practice3;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part2 {
    private static final int NUM_ZERO = 0;
    private static final int NUM_ONE = 1;


    private static final String FILE_NAME = "resources\\practice3\\part2.txt";

    public static String convert(String input) {

        StringBuilder sb = new StringBuilder();
        String result;

        String[] minWords = new String[]{};
        String[] maxWords = new String[]{};

        Pattern pattern = Pattern.compile("[a-zA-Zа-яёА-ЯЁЇїІіЄєҐґ]*");
        Matcher matcher = pattern.matcher(input);
        int lengthMin = input.length();
        int lengthMax = NUM_ZERO;

        while (matcher.find()) {
            int start = matcher.start();
            int end = matcher.end();

            int currentWordLen = input.substring(start, end).length();
            String currentWord = input.substring(start, end);

            if (currentWordLen < lengthMin && currentWordLen > NUM_ZERO) {
                lengthMin = currentWordLen;
                minWords = new String[NUM_ONE];
                minWords[NUM_ZERO] = currentWord;

            } else {
                if (currentWordLen == lengthMin) {
                    minWords = addValueToArray(minWords, currentWord);

                }
            }

            if (currentWordLen > lengthMax) {
                lengthMax = currentWordLen;
                maxWords = new String[NUM_ONE];
                maxWords[NUM_ZERO] = currentWord;

            } else {
                if (currentWordLen == lengthMax) {
                    maxWords = addValueToArray(maxWords, currentWord);

                }
            }
        }


        sb.append("Min: " + Arrays.toString(getUniqueArray(minWords)) + System.lineSeparator());
        sb.append("Max: " + Arrays.toString(getUniqueArray(maxWords)) + System.lineSeparator());

        result = sb.toString();
        result = result.replaceAll("\\[", "");
        result = result.replaceAll("\\]", "");

        return result;
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

    private static String[] getUniqueArray(String[] array) {
        array = Arrays.stream(array).distinct().toArray(String[]::new);
        return array;
    }


    public static void main(String[] args) {
        System.out.println(Part2.convert((Util.readFile(FILE_NAME))) + System.lineSeparator());
    }


}
