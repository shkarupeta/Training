package ua.shkarupeta.training.practice2;


public class ListTests {

    public static void main(String[] args) {
        test2();
    }

    private static void test2() {

        List list = new ListImpl();
        list.addLast("A");
        list.addLast("B");
        list.addLast("C");

        System.out.println(list);
        System.out.println(list.size());

        list.clear();
        System.out.println(list);
        System.out.println(list.size());

        list.addLast("A");
        list.addLast("B");
        list.addLast("C");

        System.out.println(list);
        System.out.println(list.size());


    }


}
