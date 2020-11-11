package ua.shkarupeta.training.practice2;

import java.util.Iterator;
import java.util.NoSuchElementException;


public class ArrayImpl implements Array {

    private static final int NUM_ZERO = 0;
    private static final int NUM_ONE = 1;
    private static final int NUM_TWO = 2;
    private static final int NUM_THREE = 3;


    private Object[] arr = {};
    private int size = NUM_ZERO;

    @Override
    public void add(Object element) {
        Object[] arr2 = new Object[arr.length + NUM_ONE];
        System.arraycopy(arr, NUM_ZERO, arr2, NUM_ZERO, arr.length);
        arr2[arr2.length - NUM_ONE] = element;
        arr = arr2;
        size++;
    }

    @Override
    public String toString() {

        StringBuilder result = new StringBuilder();
        result.append("[");
        for (int i = NUM_ZERO; i < size(); i++) {
            result.append(this.arr[i]).append(", ");
        }
        if (result.length() >= NUM_THREE) {
            result.replace(result.length() - NUM_TWO, result.length(), "]");
        } else {
            result.append("]");
        }
        return result.toString();
    }

    @Override
    public void set(int index, Object element) {
        this.arr[index] = element;
    }

    @Override
    public Object get(int index) {
        return this.arr[index];
    }

    @Override
    public int indexOf(Object element) {
        Object[] es = this.arr;
        int i;
        if (element == null) {
            for (i = NUM_ZERO; i < this.size; ++i) {
                if (es[i] == null) {
                    return i;
                }
            }
        } else {
            for (i = NUM_ZERO; i < this.size; ++i) {
                if (element.equals(es[i])) {
                    return i;
                }
            }
        }
        return -NUM_ONE;

    }

    @Override
    public void remove(int index) {

        if (index < this.arr.length && index >= NUM_ZERO) {
            Object[] es = this.arr;
            es[index] = null;
            this.arr = new Object[this.arr.length - NUM_ONE];
            this.size--;

            int count = NUM_ZERO;
            for (Object item : es) {
                if (item != null) {
                    this.arr[count] = item;
                    count++;
                }
            }
        }

    }

    @Override
    public void clear() {
        this.arr = new Object[]{};
        this.size = NUM_ZERO;
    }


    @Override
    public int size() {
        return this.arr.length;
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
            return pointer < arr.length - NUM_ONE;
        }

        @Override
        public Object next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            flag = false;
            nextOrPrevious = false;
            return arr[++pointer];
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
            Object[] arr2 = new Object[arr.length - NUM_ONE];
            System.arraycopy(arr, NUM_ZERO, arr2, NUM_ZERO, i);
            System.arraycopy(arr, i + NUM_ONE, arr2, i, arr2.length - i);
            arr = arr2;
            size--;
            flag = true;
            if (isNextOrPrevious()) {
                --pointer;
            }
        }
    }


}
