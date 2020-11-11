package ua.shkarupeta.training.practice2;


public class ArrayTests {

    public static void main(String[] args) {
        test2();
    }


    private static void test2() {

        Array array = new ArrayImpl();
        array.add("A");
        array.add("B");
        array.add("C");

        System.out.println(array);
        System.out.println(array.size());

        array.clear();
        System.out.println(array);
        System.out.println(array.size());

        array.add("A");
        array.add("B");
        array.add("C");

        System.out.println(array);
        System.out.println(array.size());

    }


}
