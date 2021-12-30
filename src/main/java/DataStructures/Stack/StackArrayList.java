package DataStructures.Stack;

import java.util.ArrayList;
import java.util.EmptyStackException;

public class StackArrayList<T> {

    private ArrayList<T> stack;
    private final static int DEFAULT_CAPACITY = 0;

    public StackArrayList(final int sizeOfStack) {
        stack = new ArrayList<>(sizeOfStack);
    }

    public StackArrayList() {
        this(DEFAULT_CAPACITY);
    }

    public void push(T element) {
        stack.add(element);
    }

    public int size() {
        return stack.size();
    }

    public T pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        T removedElement = stack.remove(0);
        return removedElement;
    }

    public boolean isEmpty() {
        return stack.size() == 0;
    }

    public T peek() {
        T elementAtStackTop = stack.get(0);
        return elementAtStackTop;
    }

    public String toString() {
        return String.valueOf(stack);
    }
}
