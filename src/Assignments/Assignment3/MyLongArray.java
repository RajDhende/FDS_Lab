package Assignments.Assignment3;
import java.util.Random;
/**
 * This class represents a custom array of long values and provides various methods for manipulation.
 */
public class MyLongArray {
    public long a[];
    public int currentIndex;

    /**
     * Fills the array 'a' with random long values.
     */
    public void fillWithRandomValues() {
        Random random = new Random();
        for (int i = 0; i < a.length; i++) {
            a[i] = random.nextLong(100);
        }
        currentIndex = a.length;
    }

    /**
     * Constructor to create a MyLongArray with a given size.
     * @param size The size of the array to be created.
     */
    MyLongArray(int size) {
        this.a = new long[size];
        this.currentIndex = 0;
    }



    /**
     * Copies the values of the array 'a' into another array 'b'.
     * @param b The array where the values of 'a' will be copied.
     */
    public void getValuesOfa(long[] b) {
        System.arraycopy(a, 0, b, 0, a.length);
    }

    /**
     * Searches for a given value in the array.
     * @param searchKey The value to search for.
     * @return The index of the value if found, or -1 if not found.
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
     * Inserts a value into the array.
     * @param value The value to be inserted.
     */
    public void insert(long value) {
        if (currentIndex == a.length) {
            System.out.println("The array is full");
        } else {
            a[currentIndex] = value;
            currentIndex++;
            System.out.println("Value successfully inserted");
        }
    }

    /**
     * Retrieves the element at a specified index.
     * @param index The index of the element to retrieve.
     * @return The element at the specified index.
     */
    public long getElement(int index) {
        if (index < 0 || index > currentIndex) {
            System.out.println("Enter a valid index value");
        }
        return a[index];
    }

    /**
     * Deletes a specified value from the array.
     * @param value The value to be deleted.
     * @return True if the value was found and deleted, false otherwise.
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
     * Displays the elements in the array.
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
     * @param index The index of the element to delete.
     * @return The deleted value, or -1 if the index is invalid.
     */
    public long deleteAt(int index) {
        if (index > currentIndex || index < 0) {
            System.out.println("Enter a proper index value");
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
     * Deletes duplicate values from the array.
     * @param value The value to search for and delete duplicates.
     * @return Always returns 1 (as per original code, but not necessarily meaningful).
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
     * @param index The index where the value will be inserted.
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
