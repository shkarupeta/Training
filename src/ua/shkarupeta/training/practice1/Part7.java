package ua.shkarupeta.training.practice1;

import static java.lang.Math.pow;

public class Part7 {
    public static final int NUM26 = 26;
    public static final int NUM64 = 64;

    public static void main(String[] args) {



    	String delimiter = " ==> ";

        System.out.println("A" + delimiter + str2int("A") + delimiter + int2str(str2int("A")));
        System.out.println("B" + delimiter + str2int("B") + delimiter + int2str(str2int("B")));
        System.out.println("Z" + delimiter + str2int("Z") + delimiter + int2str(str2int("Z")));
        System.out.println("AA" + delimiter + str2int("AA") + delimiter + int2str(str2int("AA")));
        System.out.println("AZ" + delimiter + str2int("AZ") + delimiter + int2str(str2int("AZ")));
        System.out.println("BA" + delimiter + str2int("BA") + delimiter + int2str(str2int("BA")));
        System.out.println("ZZ" + delimiter + str2int("ZZ") + delimiter + int2str(str2int("ZZ")));
        System.out.println("AAA" + delimiter + str2int("AAA") + delimiter + int2str(str2int("AAA")));

    }

    public static int str2int(String number) {
        int num = 0;
        for (int i = 1, j = number.length(); j > 0; i++, j--){
            num += (number.charAt(number.length() - i) - NUM64) * pow(NUM26, number.length() - (double) j);
        }
        return num;
    }

    public static StringBuilder int2str(int number) {
        StringBuilder chars = new StringBuilder();
        StringBuilder result = new StringBuilder();
        int modul;
        int div = number;
        while (div != 0) {
            modul = div % NUM26;
            if (modul == 0) {
                chars.append("Z");
                div = (div - 1) / NUM26;
            } else {
                chars.append((char) (modul + NUM64));
                div = (div - modul) / NUM26;
            }
        }
        for (int i = 0; i < chars.length(); i++){
            result.append(chars.charAt(chars.length() - i - 1));
        }
        return result;
    }

    public static StringBuilder rightColumn(String number) {
        StringBuilder chars;
        int num;
        num = str2int(number);
        num++;
        chars = int2str(num);
        return chars;
    }


}
