package ua.shkarupeta.training.practice1;

public class Part2 {

    public static void main(String[] args) {

        String[] strings = args.clone();

        double[] array = new double[strings.length];
        int i = 0;
        for (String argsForCalc : strings) {

            array[i] = Double.parseDouble(argsForCalc);
            i++;
        }
        calc(array);
    }

    public static void calc(double[] array) {
        double sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }

        double rest = (sum % 1);
        boolean isDouble = rest > 0;

        if (isDouble) {
            System.out.println(sum);
        } else {
            System.out.println((int) sum);
        }


    }
}


