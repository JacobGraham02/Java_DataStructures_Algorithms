package DataStructures.DynamicArray;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class DynamicArray<E> implements Iterable<E> {

    private static final int DEFAULT_CAPACITY = 16;

    private int capacity;
    private int size;
    private Object[] elements;

    /**
     * Constructor for DynamicArray
     * @param capacity the initial number of elements array can hold
     */
    public DynamicArray(final int capacity) {
        this.size = 0;
        this.capacity = capacity;
        this.elements = new Object[this.capacity];
    }

    /**
     * Constructor chaining which calls another constructor to build a new array with a size of {@value DEFAULT_CAPACITY}
     */
    public DynamicArray() {
        this(DEFAULT_CAPACITY);
    }

    /**
     * If at maximum array size when trying to add element, copy the current array elements into a new array of capacity * 2. Extra padding elements are added to
     * the newly added empty spaces.
     * @param element
     */
    public void add(final E element) {
        if (this.size == this.elements.length) {
            this.elements = Arrays.copyOf(this.elements, newCapacity(2 * this.capacity));
        }
        this.elements[this.size] = element; // Insert element at end of array
        size++;
    }

    /**
     *
     * @param index location in array to put Object E
     * @param element of type E
     */
    public void put(final int index, E element) {
        this.elements[index] = element;
    }

    /**
     *
     * @param index location of element to get
     * @return the type E element in array at location index
     */
    public E get(final int index) {
        return getElement(index);
    }

    /**
     *
     * @param index the location in array to remove any element
     * @return the removed element of type E
     */
    public E remove(final int index) {
        final E oldElement = getElement(index);
        removeElementAtIndex(this.elements, index);

        if (this.capacity > DEFAULT_CAPACITY && size * 4 <= this.capacity) {
            // Create a copy of the array with a new length of the original divided by 2
            this.elements = Arrays.copyOf(this.elements, newCapacity(this.capacity / 2));
        }
        return oldElement;
    }


    /**
     *
     * @param elements an array of Objects
     * @param index the index at which to remove an element
     */
    private void removeElementAtIndex(final Object[] elements, final int index) {
        // 1 less than current size to accommodate for element removed
        final int newArraySize = this.size - 1;

        // If the index location is located inside the array (the new array size will always be greater than the index location if valid).
        if (newArraySize > index) {
            // Array to copy from, starting position in source array to copy from, array to copy into, starting position in new array to copy to, total number of
            // copied elements.
            // copies only the portion of the array into the currently existing array which does not contain the deleted index element
            System.arraycopy(elements, index+1,  elements, index, newArraySize - index);
        }

        elements[this.size = newArraySize] = null;
    }

    /**
     *
     * @return size of the array
     */
    public int getSize() {
        return this.size;
    }

    /**
     *
     * @return if the array is empty
     */
    public boolean isEmpty() {
        return this.size==0;
    }

    /**
     *
     * @return a new stream of type E for this array
     */
    public Stream<E> stream() {
       return StreamSupport.stream(spliterator(), false);
    }

    /**
     *
     * @return a specific element of type E
     */
    public E getElement(final int index) {
        return (E) this.elements[index];
    }

    /**
     *
     * @param capacity the amount of elements an array can contain
     * @return the new capacity of the array
     */
    private int newCapacity(int capacity) {
        this.capacity = capacity;
        return this.capacity;
    }

    /**
     * Internally converts the array containing all E to a stream, and filter based on not null values. Then, convert back to an array and convert to a String
     * @return String representation of array
     */
    public String toString() {
        return Arrays.toString(Arrays.stream(this.elements).filter(Objects::nonNull).toArray());
    }

    /**
     *
     * @return a new instance of an array iterator
     */
    @Override
    public Iterator<E> iterator() {
        return new DynamicArrayIterator();
    }

    private class DynamicArrayIterator implements Iterator<E> {

        private int internalCursor;

        @Override
        public boolean hasNext() {
            return this.internalCursor != size;
        }

        @Override
        public E next() {
            // If the iterator current location is greater than the size of array throw an Exception for out of bounds
            if (this.internalCursor > DynamicArray.this.size) {
                throw new NoSuchElementException();
            }

            final E elementTraversedOver = DynamicArray.this.getElement(this.internalCursor);
            // Increment after traversing over an element
            this.internalCursor++;

            return elementTraversedOver;
        }

        @Override
        public void remove() {
            // If the cursor is not pointing at a valid index
            if (this.internalCursor < 0) {
                throw new IllegalArgumentException();
            }
            // Remove an element at specified cursor index, and decrement the cursor location in array because you removed the current element, and go to previous
            DynamicArray.this.remove(this.internalCursor);
            this.internalCursor--;
        }
    }
}
