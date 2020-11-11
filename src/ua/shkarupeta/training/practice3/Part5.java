package ua.shkarupeta.training.practice3;

import java.util.Arrays;
import java.util.Locale;

public class Part5 {
    private static final int NUM_ZERO = 0;
    private static final int NUM_ONE = 1;
    private static final int NUM_TWO = 2;
    private static final int NUM_FOUR = 4;
    private static final String DIVIDER = " --> ";



    private static final String[] romanCharacters = {"M", "CM", "D", "C", "XC", "L", "X", "IX", "V", "I"};
    private static final int[] romanValues = {1000, 900, 500, 100, 90, 50, 10, 9, 5, 1};

    public static void main(String[] args) {

        System.out.println(roman2Decimal("I") + DIVIDER
                + decimal2Roman(roman2Decimal("I")) + DIVIDER
                + roman2Decimal(decimal2Roman(roman2Decimal("I"))));
        System.out.println(roman2Decimal("II") + DIVIDER
                + decimal2Roman(roman2Decimal("II")) + DIVIDER
                + roman2Decimal(decimal2Roman(roman2Decimal("II"))));
        System.out.println(roman2Decimal("IV") + DIVIDER
                + decimal2Roman(roman2Decimal("IV")) + DIVIDER
                + roman2Decimal(decimal2Roman(roman2Decimal("IV"))));
        System.out.println(roman2Decimal("XCIV") + DIVIDER
                + decimal2Roman(roman2Decimal("XCIV")) + DIVIDER
                + roman2Decimal(decimal2Roman(roman2Decimal("XCIV"))));
        System.out.println(roman2Decimal("XCIX") + DIVIDER
                + decimal2Roman(roman2Decimal("XCIX")) + DIVIDER
                + roman2Decimal(decimal2Roman(roman2Decimal("XCIX"))));
    }

    public static String decimal2Roman(int x) {

        StringBuilder result = new StringBuilder();

        for (int i = NUM_ZERO; i < romanValues.length; i++) {
            int numberInPlace = x / romanValues[i];
            if (numberInPlace == NUM_ZERO) {
                continue;
            }
            result.append(numberInPlace == NUM_FOUR && i > NUM_ZERO ?
                    (romanCharacters[i] + romanCharacters[i - NUM_ONE]) :
                    new String(new char[numberInPlace]).replace("\0", romanCharacters[i]));
            x = x % romanValues[i];
        }
        return result.toString();
    }

    public static int roman2Decimal(String s) {
        int result = NUM_ZERO;
        s = s.toUpperCase(Locale.ENGLISH);
        int i = NUM_ZERO;
        while (i < s.length()) {
            int current = romanValues[Arrays.asList(romanCharacters).indexOf(String.valueOf(s.charAt(i)))];
            int next;
            if (i < s.length() - NUM_ONE) {
                next = romanValues[Arrays.asList(romanCharacters).indexOf(String.valueOf(s.charAt(i + NUM_ONE)))];
                if (next > current) {
                    result += next - current;
                    i += NUM_TWO;
                } else {
                    result += current;
                    i++;
                }
            } else {
                result += current;
                i++;
            }

        }
        return result;
    }


}
