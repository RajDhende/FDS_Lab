package Assignments.Assignment3;

/**
 * This class extends MyLongArray and provides methods for sorting an array of long values.
 */
public class Sorting extends MyLongArray {

    /**
     * Constructor to create a Sorting object with a given size.
     * @param size The size of the array to be created.
     */
    Sorting(int size) {
        super(size);
    }

    /**
     * Sorts the array using the bubble sort algorithm.
     * @param m The MyLongArray object to be sorted.
     */
    public void bubbleSort(MyLongArray m) {
        long[] b = new long[m.a.length];
        m.getValuesOfa(b);

        for (int i = 0; i < b.length; i++) {
            for (int j = 0; j < b.length - i - 1; j++) {
                if (b[j] > b[j + 1]) {
                    long temp = b[j];
                    b[j] = b[j + 1];
                    b[j + 1] = temp;
                }
            }
        }

        for (int i = 0; i < b.length; i++) {
            System.out.print(b[i] + " ");
        }
        System.out.println();
    }

    /**
     * Sorts the array using the selection sort algorithm.
     * @param m The MyLongArray object to be sorted.
     */
    public void selectionSort(MyLongArray m) {
        long[] b = new long[m.a.length];
        m.getValuesOfa(b);

        for (int i = 0; i < b.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < b.length; j++) {
                if (b[j] < b[minIndex]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                long temp = b[i];
                b[i] = b[minIndex];
                b[minIndex] = temp;
            }
        }

        for (int i = 0; i < b.length; i++) {
            System.out.print(b[i] + " ");
        }
        System.out.println();
    }

    /**
     * Sorts the array using the insertion sort algorithm.
     * @param m The MyLongArray object to be sorted.
     */
    public void insertionSort(MyLongArray m) {
        long[] b = new long[m.a.length];
        m.getValuesOfa(b);

        for (int i = 1; i < b.length; i++) {
            long key = b[i];
            int j = i - 1;

            while (j >= 0 && b[j] > key) {
                b[j + 1] = b[j];
                j--;
            }

            b[j + 1] = key;
        }

        for (int i = 0; i < b.length; i++) {
            System.out.print(b[i] + " ");
        }
        System.out.println();
    }
}
