package Algorithms;

import java.util.Arrays;
import java.util.List;

final class SortUtilities {

    /**
     * Helper method for swapping places in array
     *
     * @param array The array which elements we want to swap
     * @param firstIndex index of the first element
     * @param secondIndex index of the second element
     */
    static <T> boolean swap(T[] array, int firstIndex, int secondIndex) {
        T swap = array[firstIndex];
        array[firstIndex] = array[secondIndex];
        array[secondIndex] = swap;
        return true;
    }

    /**
     * This method checks if first element is less than the other element
     *
     * @param firstIndex first element
     * @param secondIndex second element
     * @return true if the first element is less than the second element
     */
    static <T extends Comparable<T>> boolean less(T firstIndex, T secondIndex) {
        return firstIndex.compareTo(secondIndex) < 0;
    }

    /**
     * This method checks if first element is greater than the other element
     *
     * @param firstIndex first element
     * @param secondIndex second element
     * @return true if the first element is greater than the second element
     */
    static <T extends Comparable<T>> boolean greater(T firstIndex, T secondIndex) {
        return firstIndex.compareTo(secondIndex) > 0;
    }

    /**
     * This method checks if first element is greater than or equal the other element
     *
     * @param firstIndex first element
     * @param secondIndex second element
     * @return true if the first element is greater than or equal the second element
     */
    static <T extends Comparable<T>> boolean greaterOrEqual(T firstIndex, T secondIndex) {
        return firstIndex.compareTo(secondIndex) >= 0;
    }

    /**
     * Prints a list
     *
     * @param listToPrint - a list which should be printed
     */
    static void printList(List<?> listToPrint) {
        listToPrint.stream().map(Object::toString).map(str -> str + " ").forEach(System.out::print);
        System.out.println(" Buffer space ");
    }

    /**
     * Prints an array
     *
     * @param arrayToPrint - an array which should be printed
     */
    static void printArray(Object[] arrayToPrint) {
        System.out.println(Arrays.toString(arrayToPrint));
    }

    /**
     * Swaps all position from {@param left} to @{@param right} for {@param array}
     *
     * @param array is an array
     * @param left is a left flip border of the array
     * @param right is a right flip border of the array
     */
    static <T extends Comparable<T>> void flipArray(T[] array, int left, int right) {
        while (left <= right) {
            swap(array, left++, right--);
        }
    }
}