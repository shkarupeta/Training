package ua.shkarupeta.training.practice4;

//import java.io.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Part2 {
    private static final String FILE_NAME = "resources\\practice4\\part2.txt";
    private static final String FILE_NAME_SORTED = "resources\\practice4\\part2_sorted.txt";
    private static Random random = new Random();
    private static final int COUNT_NUMBERS = 10;
    private static final int MAX = 50;

    public static Random getRandom() {
        return random;
    }

    public static String sortNumbers(String str) {
        String[] arr = str.split(" ");
        int[] arr2 = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            arr2[i] = Integer.valueOf(arr[i]);
        }
        Arrays.sort(arr2);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr2.length; i++) {
            sb.append(arr2[arr2.length - 1 - i]).append(" ");
        }
        return sb.toString();
    }

    public static String fileWithRandomNumbers() {
        int count = 0;
        StringBuilder sb = new StringBuilder();
        while (count != COUNT_NUMBERS) {
            sb.append(calculateRandomInt()).append(" ");
            count++;
        }

        return sb.toString().substring(0, sb.length()-1);
    }

    public static int calculateRandomInt() {
        return getRandom().nextInt(MAX);

    }

    public static void writeFirstFile() {
        try {
            PrintWriter pr = new PrintWriter(new File(FILE_NAME));
            pr.write(fileWithRandomNumbers());
            pr.close();
        } catch (FileNotFoundException e) {
            System.out.println(FILE_NAME + " cannot be written");
        }
    }

    public static void writeSecondFile() {
        try {
            Scanner sc = new Scanner(new File(FILE_NAME));
            PrintWriter pr2 = new PrintWriter(new File(FILE_NAME_SORTED));
            while (sc.hasNextLine()) {
                pr2.write(sortNumbers(sc.nextLine()));
            }
            sc.close();
            pr2.close();
        } catch (FileNotFoundException e) {
            System.out.println(FILE_NAME + " or " + FILE_NAME_SORTED + " cannot be written");
        } catch (IllegalArgumentException e) {
            System.out.println("Unsupported encoding");
        }

    }

    public static String output() {
        String str = null;
        try {
            StringBuilder sb = new StringBuilder();
            Scanner sc = new Scanner(new File(FILE_NAME));
            while (sc.hasNextLine()) {
                sb.append("input: ").append(sc.nextLine()).append(System.lineSeparator());
            }
            sc = new Scanner(new File(FILE_NAME_SORTED));
            while (sc.hasNextLine()) {
                sb.append("output: ").append(sc.nextLine());
            }
            sc.close();
            str = sb.toString().substring(0, sb.length() - 1);

        } catch (FileNotFoundException e) {
            System.out.println(FILE_NAME + "  or " + FILE_NAME_SORTED +" not found");
        }
        return str;
    }


    public static void main(String[] args) {
        writeFirstFile();
        writeSecondFile();
        System.out.println(output());
    }
}
