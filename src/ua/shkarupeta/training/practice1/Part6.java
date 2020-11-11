package ua.shkarupeta.training.practice1;

public class Part6 {

    public static void main(String[] args) {
        int arrayLenght = Integer.parseInt(args[0]);
        int[] array = new int[arrayLenght];
        int counter = 0;
        int nextNumber = 2;

        boolean isSimple;
        while (counter < arrayLenght) {
            int i = 0;
            isSimple = true;
            while (isSimple && i < counter) {
                if (nextNumber % array[i] == 0) {
                    isSimple = false;
                }
                i++;
            }
            if (isSimple) {
                array[counter] = nextNumber;
                counter++;
                nextNumber++;
            } else {
                nextNumber++;
            }
        }
        for (int value : array) {
            System.out.print(value + " ");
        }
        System.out.println();
    }


}
