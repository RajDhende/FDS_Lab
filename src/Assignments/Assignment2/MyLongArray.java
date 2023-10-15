package Assignments.Assignment2;
/**
 * The MyLongArray class represents an array of long values with various
 * operations like insertion, deletion, searching, and display.
 */
public class MyLongArray {
    private long a[];
    private int currentIndex;

    /**
     * Constructor to create a MyLongArray with a specified size.
     *
     * @param size The size of the array to be created.
     */
    public MyLongArray(int size) {
        this.a = new long[size];
        this.currentIndex = 0;
    }

    /**
     * Searches for a specific value in the array and returns its index.
     *
     * @param searchKey The value to search for.
     * @return The index of the found value, or -1 if not found.
     */
    public int find(long searchKey) {
        for (int i = 0; i < currentIndex; i++) {
            if (a[i] == searchKey) {
                System.out.println("Value found at index : " + i);
                return i;
            }
        }
        System.out.println("Value was not found");
        return -1;
    }

    /**
     * Inserts a value at the next available index in the array.
     *
     * @param value The value to be inserted.
     */
    public void insert(long value) {
        if (currentIndex == a.length) {
            System.out.println("The array is full");
        } else {
            a[currentIndex] = value;
            currentIndex++;
        }
    }

    /**
     * Retrieves the element at a specific index in the array.
     *
     * @param index The index of the element to retrieve.
     * @return The element at the specified index.
     */
    public long getElement(int index) {
        if (index < 0 || index >= currentIndex) {
            System.out.println("Enter valid index value");
        }
        return a[index];
    }

    /**
     * Deletes a specific value from the array.
     *
     * @param value The value to be deleted.
     * @return True if the value was deleted, false if not found.
     */
    public boolean delete(long value) {
        for (int i = 0; i < currentIndex; i++) {
            if (a[i] == value) {
                for (int j = i; j < currentIndex - 1; j++) {
                    a[j] = a[j + 1];
                }
                a[currentIndex - 1] = 0;
                currentIndex--;
                return true;
            }
        }
        return false;
    }

    /**
     * Displays the elements of the array.
     */
    public void display() {
        for (int i = 0; i < currentIndex; i++) {
            if (a[i] == 0) {
                System.out.print(" ");
            } else {
                System.out.print(a[i] + " ");
            }
        }
        System.out.println();
    }

    /**
     * Deletes the element at a specified index.
     *
     * @param index The index of the element to be deleted.
     * @return The deleted element, or -1 if the index is invalid.
     */
    public long deleteAt(int index) {
        if (index >= currentIndex || index < 0) {
            System.out.println("Enter proper index value");
            return -1;
        }
        long temp = a[index];
        while (index < currentIndex - 1) {
            a[index] = a[index + 1];
            index++;
        }
        a[currentIndex - 1] = 0;
        currentIndex--;
        System.out.println("The value has been deleted successfully.");
        return temp;
    }

    /**
     * Deletes all occurrences of a specified value in the array.
     *
     * @param value The value to be deleted.
     * @return The number of occurrences deleted.
     */
    public int dupDelete(long value) {
        for (int i = 0; i < currentIndex; i++) {
            if (a[i] == value) {
                for (int j = i + 1; j < currentIndex; j++) {
                    if (a[j] == value) {
                        deleteAt(j);
                        System.out.println("The duplicate value has been deleted");
                    }
                }
            }
        }
        return 1;
    }

    /**
     * Inserts a value at a specified index in the array.
     *
     * @param index The index at which to insert the value.
     * @param value The value to be inserted.
     */
    public void insertAt(int index, long value) {
        if (index > currentIndex || index < 0) {
            System.out.println("Enter a proper index value");
        } else if (currentIndex == a.length) {
            System.out.println("Array is already full");
        } else {
            for (int i = currentIndex; i > index; i--) {
                a[i] = a[i - 1];
            }
            a[index] = value;
            currentIndex++;
        }
    }
}
