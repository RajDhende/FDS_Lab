package Assignments.Assignment2;
import java.util.Scanner;

/**
 * The TestApplication class provides a user interface to interact with the MyLongArray class.
 */
public class TestApplication {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the Array: ");
        int size = sc.nextInt();
        MyLongArray la = new MyLongArray(size);
        System.out.println("Array of size: " + size + " has been created");
        boolean loop = true;

        while (loop) {
            System.out.println("1) Insert an element.");
            System.out.println("2) Delete an element.");
            System.out.println("3) Find an element.");
            System.out.println("4) Get an element.");
            System.out.println("5) Display the Array");
            System.out.println("6) Delete a duplicate value");
            System.out.println("7) Insert an element at a particular index.");
            System.out.println("8) Delete an element at a particular index.");
            System.out.println("9) Exit");
            int op = sc.nextInt();

            switch (op) {
                case (1): {
                    System.out.print("Enter the element to be inserted: ");
                    long value = sc.nextInt();
                    la.insert(value);
                    System.out.println("Value successfully inserted");
                    break;
                }
                case (2): {
                    System.out.print("Enter the value to be deleted: ");
                    long value = sc.nextInt();
                    la.delete(value);
                    System.out.println("Value successfully deleted");
                    break;
                }
                case (3): {
                    System.out.print("Enter the element to be found: ");
                    long value = sc.nextInt();
                    la.find(value);
                    break;
                }
                case (4): {
                    System.out.print("Enter the index: ");
                    int index = sc.nextInt();
                    long result = la.getElement(index);
                    System.out.println(result);
                    break;
                }
                case (5): {
                    la.display();
                    break;
                }
                case (6): {
                    System.out.print("Enter the value: ");
                    long value = sc.nextInt();
                    la.dupDelete(value);
                    break;
                }
                case (7): {
                    System.out.print("Enter the index value: ");
                    int index = sc.nextInt();
                    System.out.print("Enter the value to be inserted: ");
                    long value = sc.nextInt();
                    la.insertAt(index, value);
                    break;
                }
                case (8): {
                    System.out.print("Enter the index value: ");
                    int index = sc.nextInt();
                    la.deleteAt(index);
                    break;
                }
                case (9): {
                    loop = false;
                    break;
                }
                default: {
                    System.out.println("Enter an operation.");
                }
            }
        }
    }
}
