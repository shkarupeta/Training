
package ua.shkarupeta.training.practice2;


public class StackTests {

    public static void main(String[] args) {
        test2();
    }

    private static void test2() {

        Stack stack = new StackImpl();
        stack.push("A");
        stack.push("B");
        stack.push("C");

        System.out.println(stack);
        System.out.println(stack.size());

        stack.clear();
        System.out.println(stack);
        System.out.println(stack.size());

        stack.push("A");
        stack.push("B");
        stack.push("C");

        System.out.println(stack);
        System.out.println(stack.size());

    }

}
