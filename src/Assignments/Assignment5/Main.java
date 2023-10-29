package Assignments.Assignment5;
import java.util.Scanner;
import java.util.Iterator;

/**
 * A simple interactive program for manipulating a LinkedPositionalList of strings.
 */
public class Main {
    /**
     * Main entry point for the program.
     *
     * @param args The command-line arguments (not used in this program).
     */
    public static void main(String[] args) {
        LinkedPositionalList<String> list = new LinkedPositionalList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Add Element at the Front");
            System.out.println("2. Add Element at the Back");
            System.out.println("3. Add Element Before a Position");
            System.out.println("4. Add Element After a Position");
            System.out.println("5. Replace Element at a Position");
            System.out.println("6. Remove Element at a Position");
            System.out.println("7. Print List");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume the newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter the element to add at the front: ");
                    String element = scanner.nextLine();
                    list.addFirst(element);
                    break;
                case 2:
                    System.out.print("Enter the element to add at the back: ");
                    element = scanner.nextLine();
                    list.addLast(element);
                    break;
                case 3:
                    System.out.print("Enter the element to add: ");
                    element = scanner.nextLine();
                    System.out.print("Enter the position before which to add: ");
                    Position<String> beforePos = list.first();
                    list.addBefore(beforePos, element);
                    break;
                case 4:
                    System.out.print("Enter the element to add: ");
                    element = scanner.nextLine();
                    System.out.print("Enter the position after which to add: ");
                    Position<String> afterPos = list.first();
                    list.addAfter(afterPos, element);
                    break;
                case 5:
                    System.out.print("Enter the new element: ");
                    element = scanner.nextLine();
                    System.out.print("Enter the position to replace: ");
                    Position<String> replacePos = list.first();
                    list.set(replacePos, element);
                    break;
                case 6:
                    System.out.print("Enter the position to remove: ");
                    Position<String> removePos = list.first();
                    list.remove(removePos);
                    break;
                case 7:
                    printList(list);
                    break;
                case 8:
                    System.out.println("Exiting the program.");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    /**
     * Prints the contents of the given LinkedPositionalList.
     *
     * @param list The LinkedPositionalList to print.
     */
    private static void printList(LinkedPositionalList<String> list) {
        Iterator<String> iterator = list.iterator();
        System.out.println("List Contents:");
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
