package Assignments.Assignment5;
import java.util.Iterator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        LinkedPositionalList<String> list = new LinkedPositionalList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("LinkedPositionalList Menu:");
            System.out.println("1. Add element at the front");
            System.out.println("2. Add element at the back");
            System.out.println("3. Add element before a position");
            System.out.println("4. Add element after a position");
            System.out.println("5. Remove element at a position");
            System.out.println("6. Print the list");
            System.out.println("7. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter element to add at the front: ");
                    String element = scanner.next();
                    list.addFirst(element);
                    break;

                case 2:
                    System.out.print("Enter element to add at the back: ");
                    element = scanner.next();
                    list.addLast(element);
                    break;

                case 3:
                    System.out.print("Enter element to add: ");
                    element = scanner.next();
                    System.out.print("Enter the position before which to add: ");
                    int positionBefore = scanner.nextInt();
                    list.addBefore(list.positions().iterator().next(), element);
                    break;

                case 4:
                    System.out.print("Enter element to add: ");
                    element = scanner.next();
                    System.out.print("Enter the position after which to add: ");
                    int positionAfter = scanner.nextInt();
                    list.addAfter(list.positions().iterator().next(), element);
                    break;

                case 5:
                    System.out.print("Enter the position to remove: ");
                    int positionToRemove = scanner.nextInt();
                    list.remove(list.positions().iterator().next());
                    break;

                case 6:
                    System.out.println("LinkedPositionalList:");
                    printList(list);
                    break;

                case 7:
                    System.out.println("Exiting program.");
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public static void printList(LinkedPositionalList<String> list) {
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next());
        }
        System.out.println();
    }

}
