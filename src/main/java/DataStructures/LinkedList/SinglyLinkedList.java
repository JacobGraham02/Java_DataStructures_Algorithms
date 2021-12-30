package DataStructures.LinkedList;

import java.lang.reflect.Array;
import java.util.Arrays;

public class SinglyLinkedList<E> {

    /**
     *
     * @param <E> the data type of the data to be inserted into the Node
     */
    private static class Node<E> {
        private final E element;
        private Node<E> next;
        private final int indexNumber = 0;

        public Node(E newElement, Node<E> nextReference) {
            element = newElement;
            next = nextReference;
        }
        // The methods below all interact with either the data or reference for a given Node. Therefore, the methods are defined strictly for the Node.
        public E getElement() { return element;}
        public Node<E> getNext() { return next; }
        public void setNext(Node<E> n) { next = n;}
    }

    private Node<E> head = null;
    private Node<E> tail = null;
    private int size = 0;


    public SinglyLinkedList() {

    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    /**
     *
     * @return first element in arraylist of type E
     */
    public E first() {
        if (isEmpty()) {
            return null;
        }
        return head.getElement();
    }

    /**
     *
     * @return last element in arraylist of type E
     */
    public E last() {
        if (isEmpty()) {
            return null;
        }
        return tail.getElement();
    }

    /**
     * Constructs a new head Node from the function 'e' parameter value.
     * @param e an element of type E which is used to construct a new head Node for linked list.
     */
    public void addFirst(E e) {
        head = new Node<>(e, head);
        if (size == 0) {
            tail = head;
        }
        size++;
    }

    public void insertElementAt(E element, final int index) {
        if (!(isEmpty() || (index < 0 || index > this.size()))) {
            if (index == 0) {
                addFirst(element);
            }
            if (index == this.size - 1) {
                addLast(element);
            }
            Node newNode = new Node(element, null);
            Node currentHead = head;

            for (int i = 0; i < index - 1; i++) {
                currentHead = currentHead.getNext();
            }
            newNode.next = currentHead.next;
            currentHead.next = newNode;
            size++;
        }

    }

    public Node getNodeAtIndex(final int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("Index must be greater than 0 and be a less than " + size);
        }
        Node currentHead = head;

        for (int i = 0; i < index; ++i) {
            currentHead = currentHead.getNext();
        }
        return currentHead;

    }

//    public E getElementFromList(E elementToSearchFor) {
//        Node currentHead = head;
//        E elementToGet = null;
//
//        if (isEmpty()) {
//            throw new IndexOutOfBoundsException("You cannot get an element from linked list if the list is empty");
//        }
//        while (currentHead != null) {
//            if (currentHead.element == elementToSearchFor) {
//                elementToGet = (E) currentHead.getElement();
//            }
//            currentHead = currentHead.next;
//        }
//        return elementToGet;
//    }

    public E[] getAllElementsFromList() {
        if (isEmpty()) {
            return null;
        }
        Node currentHead = head;
        E[] listOfReturnedElements = (E[]) new Object[this.size];

        for (int i = 0; i < this.size(); i++) {
            listOfReturnedElements[i] = (E) currentHead.getElement();
            currentHead = currentHead.next;
        }
        return listOfReturnedElements;
    }

    public void addLast(E e) {
        Node<E> newNode = new Node<>(e, null);
        if (isEmpty()) {
            head = newNode;
        }
        else {
            tail.setNext(newNode);
        }
        tail = newNode;
        size++;
    }
    public E removeFirst() {
        if (isEmpty()) {
            return null;
        }
        E removedFirstElement = head.getElement();
        head = head.getNext();
        size--;

        if (size == 0) {
            tail = null;
        }
        return removedFirstElement;
    }

    public String toString() {
        return Arrays.toString(getAllElementsFromList());
    }
}
