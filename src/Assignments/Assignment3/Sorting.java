package Assignments.Assignment3;

public class Sorting extends MyLongArray {

    Sorting(int size) {
        super(size);
    }

    long[] b = new long[a.length];

    public void bubbleSort(MyLongArray m) {

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

    public void selectionSort(MyLongArray m) {

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

    public void insertionSort(MyLongArray m) {

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