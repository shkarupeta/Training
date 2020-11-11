package ua.shkarupeta.training.practice1;

public class Part3 {

    public static void main(String[] args) {

        printArgs(args);
    }

    public static void printArgs(String[] args) {

        for (int i = 0; i < args.length; i++) {
            if (i == args.length - 1) {
                System.out.println(args[i]);
            } else {
                System.out.print(args[i] + " ");
            }

        }

    }
}
