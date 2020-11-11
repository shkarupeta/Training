package ua.shkarupeta.training.practice2;

public interface Queue extends Container {



    void enqueue(Object element);

    Object dequeue();

    Object top();

}
