package Algorithms;


import static Algorithms.SortUtilities.greater;
import static Algorithms.SortUtilities.swap;

class BubbleSort implements ISortAlgorithm {

    /**
     * Implements generic bubble sort algorithm.
     *
     * @param array the array to be sorted.
     * @param <T>   the type of elements in the array.
     * @return the sorted array.
     */
    @Override
    public <T extends Comparable<T>> T[] sort(T[] array) {
        // Start the 1st element at the 2nd element in the unsorted array, and traverse until end of the array
        for (int i = 1, size = array.length; i < size; ++i) {

            boolean swapped = false;

            /* Have the 2nd element start at the 1st element (adjacent to the 2nd element) in the unsorted array, and after each array index traversed,
            * decrease the number of indexes traversing by the value of i. Traverse through entire array after each iteration of the i loop.
            */
            for (int j = 0; j < size - i; ++j) {
                // If the number at index j is greater than the one at j+1 (index i) swap them.
                if (greater(array[j], array[j + 1])) {
                    swap(array, j, j + 1);
                    swapped = true;
                }
            }
            // If they fail to swap, break out of the current for loop.
            if (!swapped) {
                break;
            }
        }
        return array;
    }
}
