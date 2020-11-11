package ua.shkarupeta.training.practice2;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class StackImpl implements Stack {
    private static final int NUM_ZERO = 0;
    private static final int NUM_ONE = 1;
    private static final int NUM_TWO = 2;
    private static final int NUM_THREE = 3;

    private Object[] stack = {};
    private int size = NUM_ZERO;

    @Override
    public void push(Object element) {
        Object[] arr2 = new Object[stack.length + NUM_ONE];
        System.arraycopy(stack, NUM_ZERO, arr2, NUM_ZERO, stack.length);
        arr2[arr2.length - NUM_ONE] = element;
        stack = arr2;

        size++;
    }

    @Override
    public Object pop() {
        if (stack.length > NUM_ZERO) {
            Object tmpValue = stack[size - NUM_ONE];
            System.arraycopy(stack, NUM_ZERO, stack, NUM_ZERO, stack.length - NUM_ONE);
            size--;
            return tmpValue;
        } else {
            return null;
        }
    }

    @Override
    public Object top() {
        if (stack.length > NUM_ZERO) {
            return this.stack[size - NUM_ONE];
        } else {
            return null;
        }
    }

    @Override
    public void clear() {
        this.stack = new Object[]{};
        this.size = NUM_ZERO;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public String toString() {

        StringBuilder result = new StringBuilder();
        result.append("[");
        for (int i = NUM_ZERO; i < size(); i++) {
            result.append((this.stack[i]).toString()).append(", ");
        }
        if (result.length() >= NUM_THREE) {
            result.replace(result.length() - NUM_TWO, result.length(), "]");
        } else {
            result.append("]");
        }
        return result.toString();
    }


    @Override
    public Iterator<Object> iterator() {
        return new IteratorImpl();
    }

    private class IteratorImpl implements Iterator<Object> {
        private boolean nextOrPrevious;
        private int nextIndex;
        private int prevIndex;
        private boolean flag = true;

        public IteratorImpl() {
            this.nextIndex = size - NUM_ONE;
            this.prevIndex = -NUM_ONE;
        }

        public boolean isFlag() {
            return flag;
        }

        public boolean isNextOrPrevious() {
            return nextOrPrevious;
        }


        @Override
        public boolean hasNext() {
            return nextIndex >= NUM_ZERO;

        }

        @Override
        public Object next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            int i = nextIndex;
            if (nextIndex < NUM_ZERO) {
                throw new IllegalStateException("exception");
            } else {
                flag = false;
                nextOrPrevious = false;
                prevIndex = i;
                Object next = stack[i];
                nextIndex--;
                return next;
            }
        }

        @Override
        public void remove() {
            if (isFlag()) {
                throw new IllegalStateException();
            }
            int i;
            if (!isNextOrPrevious()) {
                i = prevIndex;
            } else {
                i = nextIndex;
            }
            Object[] arr2 = new Object[stack.length - NUM_ONE];
            System.arraycopy(stack, NUM_ZERO, arr2, NUM_ZERO, i);
            System.arraycopy(stack, i + NUM_ONE, arr2, i, arr2.length - i);
            stack = arr2;
            flag = true;
            size--;
        }
    }
}
