package ua.shkarupeta.training.practice2;


public class QueueTests extends QueueImpl {

    public static void main(String[] args) {
        test2();

    }

    public static void test2() {

        Queue queue = new QueueImpl();
        queue.enqueue("A");
        queue.enqueue("B");
        queue.enqueue("C");

        System.out.println(queue);
        System.out.println(queue.size());

        queue.clear();
        System.out.println(queue);
        System.out.println(queue.size());

        queue.enqueue("A");
        queue.enqueue("B");
        queue.enqueue("C");

        System.out.println(queue);
        System.out.println(queue.size());

    }

}