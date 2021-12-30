package DataStructures.LinkedList;

public class SinglyLinkedListRunner {
    private static SinglyLinkedList<String> stringSinglyLinkedList;

    private static void printSinglyLinkedList() {
        System.out.println(stringSinglyLinkedList);
    }

    public static void main(String[] args) {
        stringSinglyLinkedList = new SinglyLinkedList<>();
        stringSinglyLinkedList.addFirst("the");
        stringSinglyLinkedList.addFirst("the");
        stringSinglyLinkedList.addFirst("blee");
        stringSinglyLinkedList.addFirst("alee");
        stringSinglyLinkedList.addFirst("clee");
        stringSinglyLinkedList.addFirst("elee");
        stringSinglyLinkedList.insertElementAt("replaced", 0);

        System.out.println(stringSinglyLinkedList.getNodeAtIndex(0));

        printSinglyLinkedList();
    }
}
