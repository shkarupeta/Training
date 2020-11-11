package ua.shkarupeta.training.practice2;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class QueueImpl implements Queue {

    private static final int NUM_ZERO = 0;
    private static final int NUM_ONE = 1;
    private static final int NUM_TWO = 2;
    private static final int NUM_THREE = 3;

    private Object[] queue = {};
    private int size = NUM_ZERO;

    @Override
    public void enqueue(Object element) {
        Object[] arr2 = new Object[queue.length + NUM_ONE];
        System.arraycopy(queue, NUM_ZERO, arr2, NUM_ZERO, queue.length);
        arr2[arr2.length - NUM_ONE] = element;
        queue = arr2;

        size++;

    }

    @Override
    public Object dequeue() {
        if (queue.length > NUM_ZERO) {
            Object tmpValue = queue[NUM_ZERO];
            System.arraycopy(queue, NUM_ONE, queue, NUM_ZERO, queue.length - NUM_ONE);
            size--;
            return tmpValue;
        } else {
            return null;
        }
    }

    @Override
    public Object top() {
        return this.queue[NUM_ZERO];
    }

    @Override
    public String toString() {

        StringBuilder result = new StringBuilder();
        result.append("[");
        for (int i = NUM_ZERO; i < size(); i++) {
            result.append((this.queue[i]).toString()).append(", ");
        }
        if (result.length() >= NUM_THREE) {
            result.replace(result.length() - NUM_TWO, result.length(), "]");
        } else {
            result.append("]");
        }
        return result.toString();
    }

    @Override
    public void clear() {
        queue = new Object[]{};
        size = NUM_ZERO;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<Object> iterator() {
        return new IteratorImpl();
    }

    private class IteratorImpl implements Iterator<Object> {
        private int pointer = -1;
        private boolean nextOrPrevious;
        private boolean flag = true;

        public boolean isFlag() {
            return flag;
        }


        public boolean isNextOrPrevious() {
            return nextOrPrevious;
        }

        @Override
        public boolean hasNext() {
            return pointer < queue.length - NUM_ONE;

        }
        @Override
        public Object next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            flag = false;
            nextOrPrevious = false;
            return queue[++pointer];
        }
        @Override
        public void remove() {
            if (isFlag()) {
                throw new IllegalStateException();
            }
            int i;
            if (!isNextOrPrevious()) {
                i = pointer--;
            } else {
                i = ++pointer;
            }
            Object[] arr2 = new Object[queue.length - NUM_ONE];
            System.arraycopy(queue, NUM_ZERO, arr2, NUM_ZERO, i);
            System.arraycopy(queue, i + NUM_ONE, arr2, i, arr2.length - i);
            queue = arr2;
            flag = true;
            size--;
            if (isNextOrPrevious()) {
                --pointer;
            }
        }
    }

}
