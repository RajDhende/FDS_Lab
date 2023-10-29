package Assignments.Assignment5;
import java.util.Scanner;
import java.util.Iterator;

/**
 * This class demonstrates a simple user interface for managing a PositionalList.
 */
public class Main {

    /**
     * Main method to execute the program.
     *
     * @param args The command line arguments (not used in this program).
     */
    public static void main(String[] args) {
        PositionalList<Integer> list = new PositionalLinkedList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Choose an operation:");
            System.out.println("1. Add First");
            System.out.println("2. Add Last");
            System.out.println("3. Add Before");
            System.out.println("4. Add After");
            System.out.println("5. Set Element");
            System.out.println("6. Remove Element");
            System.out.println("7. Print List");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter element to add at the beginning: ");
                    int valueToAddFirst = scanner.nextInt();
                    list.addFirst(valueToAddFirst);
                    break;

                case 2:
                    System.out.print("Enter element to add at the end: ");
                    int valueToAddLast = scanner.nextInt();
                    list.addLast(valueToAddLast);
                    break;

                case 3:
                    System.out.print("Enter element to add: ");
                    int valueToAdd = scanner.nextInt();
                    System.out.print("Enter the element before which to add: ");
                    int elementBefore = scanner.nextInt();
                    Position<Integer> beforePosition = findPosition(list, elementBefore);
                    list.addBefore(beforePosition, valueToAdd);
                    break;

                case 4:
                    System.out.print("Enter element to add: ");
                    int valueToAddAfter = scanner.nextInt();
                    System.out.print("Enter the element after which to add: ");
                    int elementAfter = scanner.nextInt();
                    Position<Integer> afterPosition = findPosition(list, elementAfter);
                    list.addAfter(afterPosition, valueToAddAfter);
                    break;

                case 5:
                    System.out.print("Enter new element value: ");
                    int newValue = scanner.nextInt();
                    System.out.print("Enter the element to update: ");
                    int elementToUpdate = scanner.nextInt();
                    Position<Integer> positionToUpdate = findPosition(list, elementToUpdate);
                    list.set(positionToUpdate, newValue);
                    break;

                case 6:
                    System.out.print("Enter the element to remove: ");
                    int elementToRemove = scanner.nextInt();
                    Position<Integer> positionToRemove = findPosition(list, elementToRemove);
                    list.remove(positionToRemove);
                    break;

                case 7:
                    printList(list);
                    break;

                case 8:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    /**
     * Finds a Position in the PositionalList that corresponds to a given element.
     *
     * @param list    The PositionalList to search within.
     * @param element The element to search for.
     * @return The Position corresponding to the element if found, or null if not found.
     */
    private static Position<Integer> findPosition(PositionalList<Integer> list, int element) {
        for (Position<Integer> position : list.positions()) {
            if (position.getElement() == element) {
                return position;
            }
        }
        return null;
    }

    /**
     * Prints the elements in the PositionalList.
     *
     * @param list The PositionalList to be printed.
     */
    private static void printList(PositionalList<Integer> list) {
        System.out.print("List: ");
        Iterator<Position<Integer>> iterator = list.positions().iterator();
        while (iterator.hasNext()) {
            Position<Integer> position = iterator.next();
            System.out.print(position.getElement() + " ");
        }

        System.out.println();
    }

}
