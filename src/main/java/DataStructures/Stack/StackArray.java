package DataStructures.Stack;

public class StackArray<T> {

    private static final int DEFAULT_CAPACITY = 4;
    private T[] stackArray;
    private int topOfStack = -1; // By default, must be just outside of start of the array

    public StackArray(final int size) {
        stackArray = (T[]) new Object[size];
    }
    public StackArray() {
        this(DEFAULT_CAPACITY);
    }

    // Push adds a new element to the end of the stack
    public void push(final T element) {
        if (!isFull()) {
            topOfStack++;
            stackArray[topOfStack] = element;
        } else {
            resizeStack(stackArray.length * 2);
            push(element);
        }
    }
    // Pop removes and returns the element from the top of stack
    public T pop() {
        T removedElement = null;
        if (!isEmpty()) {
            removedElement =  stackArray[topOfStack];
            stackArray[topOfStack] = null;
            topOfStack--;
        } else {
            System.out.println("The stack is empty, and you cannot return any element from it");
        }
        return removedElement;
    }
    // Allows you to access the element at top of stack without removing it
    public T top() {
        T topStackElement = null;
        if (!isEmpty()) {
            topStackElement = stackArray[topOfStack];
        } else {
            System.out.println("The stack is empty so no top element could be accessed");
        }
        return topStackElement;
    }

    private void resizeStack(final int newStackSize) {
        T[] resizedStack = (T[]) new Object[newStackSize];

        for (int i = 0; i < stackArray.length; i++) {
            resizedStack[i] = stackArray[i];
        }
        stackArray = resizedStack;
    }
    public boolean isEmpty() {
        return topOfStack == -1;
    }
    public boolean isFull() {
        System.out.println("Top of stack: " +topOfStack);
        System.out.println("Stack array length: " +stackArray.length);
        return topOfStack+1 == stackArray.length;
    }
    public void emptyStack() {
        stackArray = (T[]) new Object[stackArray.length];
        topOfStack = -1;
    }
    public int size() {
        return stackArray.length;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(stackArray.length);
        stringBuilder.append("[ ");
        for (T element : stackArray) {
            stringBuilder.append(element).append(" ");
        }
        stringBuilder.append(" ]");
        return String.valueOf(stringBuilder);
    }
}
