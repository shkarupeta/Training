package ua.shkarupeta.training.practice2;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ListImpl implements List {
    private static final int NUM_ZERO = 0;
    private static final int NUM_ONE = 1;
    private static final int NUM_TWO = 2;
    private static final int NUM_THREE = 3;

    private Object[] list = {};
    private int size = NUM_ZERO;


    @Override
    public void addFirst(Object element) {

        Object[] arr2 = new Object[list.length + NUM_ONE];
        System.arraycopy(list, NUM_ZERO, arr2, NUM_ONE, list.length);
        arr2[NUM_ZERO] = element;
        list = arr2;

        size++;

    }

    @Override
    public void addLast(Object element) {

        Object[] arr2 = new Object[list.length + NUM_ONE];
        System.arraycopy(list, NUM_ZERO, arr2, NUM_ZERO, list.length);
        arr2[arr2.length - NUM_ONE] = element;
        list = arr2;

        size++;
    }

    @Override
    public void removeFirst() {
        System.arraycopy(list, NUM_ONE, list, NUM_ZERO, list.length - NUM_ONE);
        size--;
    }

    @Override
    public void removeLast() {
        System.arraycopy(list, NUM_ZERO, list, NUM_ZERO, list.length - NUM_ONE);
        size--;
    }

    @Override
    public Object getFirst() {
        return this.list[NUM_ZERO];
    }

    @Override
    public Object getLast() {
        return this.list[list.length - NUM_ONE];
    }

    @Override
    public Object search(Object element) {
        for (int i = NUM_ZERO; i < size(); i++) {
            if (!canCompareByNullOrEquality(element, list[i])
                    && element.equals(list[i])) {
                return element;
            }
        }
        return null;
    }

    @Override
    public boolean remove(Object element) {
        for (int i = NUM_ZERO; i < list.length; i++) {
            if (list[i].equals(element)) {
                Object[] arr2 = new Object[list.length - NUM_ONE];
                System.arraycopy(list, NUM_ZERO, arr2, NUM_ZERO, i);
                System.arraycopy(list, i + NUM_ONE, arr2, i, arr2.length - i);
                list = arr2;
                size--;
                return true;
            }
        }
        return false;
    }

    private static boolean canCompareByNullOrEquality(Object a, Object b) {
        return a == null ^ b == null;
    }


    @Override
    public void clear() {

        list = new Object[]{};
        size = NUM_ZERO;
    }

    @Override
    public String toString() {

        StringBuilder result = new StringBuilder();
        result.append("[");
        for (int i = NUM_ZERO; i < size(); i++) {
            result.append((this.list[i]).toString()).append(", ");
        }
        if (result.length() >= NUM_THREE) {
            result.replace(result.length() - NUM_TWO, result.length(), "]");
        } else {
            result.append("]");
        }
        return result.toString();
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
            return pointer < list.length - NUM_ONE;

        }

        @Override
        public Object next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            flag = false;
            nextOrPrevious = false;
            return list[++pointer];
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
            Object[] arr2 = new Object[list.length - NUM_ONE];
            System.arraycopy(list, NUM_ZERO, arr2, NUM_ZERO, i);
            System.arraycopy(list, i + NUM_ONE, arr2, i, arr2.length - i);
            list = arr2;
            flag = true;
            size--;
            if (isNextOrPrevious()) {
                --pointer;
            }
        }
    }

}
