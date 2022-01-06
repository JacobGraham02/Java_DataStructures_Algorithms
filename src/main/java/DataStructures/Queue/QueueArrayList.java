package DataStructures.Queue;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class QueueArrayList<T> implements Iterable<T> {

    private ArrayList<T> queueArrayList;

    private int front;

    private int rear;

    private static final int INITIAL_CAPACITY = 10;

    private final int maxSize;

    private int size;

    public QueueArrayList() {
        this(INITIAL_CAPACITY);
    }

    public QueueArrayList(final int initialSize) {
        queueArrayList = new ArrayList<>(initialSize);
        maxSize = initialSize;
    }

    public boolean enqueue(T element) {
        if(isFull()) {
            return false;
        }
        rear = (rear + 1) % maxSize;
        queueArrayList.add(element);
        size++;
        return true;
    }

    public T dequeue() {
        if (queueArrayList.isEmpty()) {
            return null;
        }
        T frontElement = queueArrayList.get(front);
        front = (front + 1) % maxSize; // Traverse the front position 1 forward to take into account the removed element; wrap around to the other side of
        // arraylist if at the maximum size of arraylist
        queueArrayList.remove(front);
        size--;
        return frontElement;
    }

    public boolean isFull() {
        return queueArrayList.size() == maxSize;
    }

    public T front() {
        return queueArrayList.get(front);
    }

    public T rear() {
        return queueArrayList.get(rear);
    }

    @Override
    public Iterator<T> iterator() {
        return new QueueArrayListIterator();
    }

    private class QueueArrayListIterator implements Iterator<T> {

        private int queueArrayListCursor;

        @Override
        public boolean hasNext() {
            return this.queueArrayListCursor != maxSize;
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            T element = queueArrayList.get(queueArrayListCursor);
            queueArrayListCursor++;
            return element;
        }

        @Override
        public void remove() {
            Iterator.super.remove();
        }
    }
}
