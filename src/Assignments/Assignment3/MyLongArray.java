package Assignments.Assignment3;

public class MyLongArray {
    public long a[];
    private int currentIndex;

    MyLongArray(int size) {
        this.a = new long[size];
        this.currentIndex = 0;
    }


    public void getValuesOfa(long[] b) {
        System.arraycopy(a, 0, b, 0, a.length);
    }

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

    public void insert(long value) {
        if (currentIndex == a.length) {
            System.out.println("The array is full");
        } else {
            a[currentIndex] = value;
            currentIndex++;
            System.out.println("Value successfully inserted");
        }
    }

    public long getElement(int index) {
        if (index < 0 || index > currentIndex) {
            System.out.println("Enter valid index value");
        }
        return a[index];
    }

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

    public long deleteAt(int index) {
        if (index > currentIndex || index < 0) {
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
        System.out.println("The value has be deleted successfully.");
        return temp;

    }

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
