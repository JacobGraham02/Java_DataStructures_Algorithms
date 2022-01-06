package DataStructures.Queue;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class QueueArray<T> implements Iterable<T> {
    private static final int DEFAULT_CAPACITY = 10;

    private int maxSize;

    private int frontReference;

    private int rearReference;

    private int numberOfItems;

    private T[] queueArray;

    public QueueArray() {
        this(DEFAULT_CAPACITY);
    }
    public QueueArray(final int initialCapacity) {
        maxSize = initialCapacity;
        queueArray = (T[]) new Object[initialCapacity];
        frontReference = 0;
        rearReference = -1;
        numberOfItems = 0;
    }

    /**
     * Inserts an element at the rear of the queue
     * @param element generic type T to give the queue the ability to store any object type
     * @return true if an element was inserted into Queue, false otherwise.
     */
    public boolean enqueue(T element) {
        if (isFull()) {
            return false;
        }
        rearReference = (rearReference + 1) % maxSize; // Modulus is commonly used to wrap around from the end to start of an array. In this case,
        // if the rear of the queue is at the end of the array, wrap the rear back to the front of the array.
        queueArray[rearReference] = element;
        numberOfItems++;
        return true;
    }

    /**
     * Removes and returns an element from the front of the queue (first element).
     * @return the removed generic type T element
     */
    public T dequeue() {
        if (isEmpty()) {
            return null;
        }
        T removedElement = queueArray[frontReference];
        frontReference = (frontReference + 1) % maxSize;
        numberOfItems--;
        return removedElement;
    }

    public T front() {
        return queueArray[frontReference];
    }

    public T rear() {
        return queueArray[rearReference];
    }

    public boolean isEmpty() {
        return numberOfItems == 0;
    }

    public boolean isFull() {
        return numberOfItems == maxSize;
    }

    public int getSize() {
        return numberOfItems;
    }

    @Override
    public Iterator<T> iterator() {
        return new QueueArrayIterator();
    }

    private class QueueArrayIterator implements Iterator<T> {

        private int iteratorCursor;

        @Override
        public boolean hasNext() {
            return this.iteratorCursor != maxSize;
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            T nextElementInQueue = queueArray[iteratorCursor];
            this.iteratorCursor++;
            return nextElementInQueue;
        }
    }
}
