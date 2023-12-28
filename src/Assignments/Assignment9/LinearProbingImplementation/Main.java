package Assignments.Assignment9.LinearProbingImplementation;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * A class providing a simple interface to interact with the LinearProbingHashMap.
 */
public class Main {
    /**
     * The main method to interact with the LinearProbingHashMap.
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Enter the initial capacity of the HashMap:");
            int capacity = scanner.nextInt();
            LinearProbingHashMap<Integer, String> hashMap = new LinearProbingHashMap<>(capacity);

            while (true) {
                System.out.println("\n1. Put Key-Value Pair");
                System.out.println("2. Get Value by Key");
                System.out.println("3. Remove Key-Value Pair");
                System.out.println("4. Print All Entries");
                System.out.println("5. Exit");
                System.out.println("Enter your choice:");
                int choice = scanner.nextInt();

                int h, k;
                String v;
                switch (choice) {
                    case 1:
                        try {
                            System.out.println("Enter the key and value to put:");
                            k = scanner.nextInt();
                            v = scanner.next();
                            h = hashMap.hashValue(k);
                            hashMap.bucketPut(h, k, v);
                        }catch(Exception e){
                            System.out.println("Error Occured");
                            scanner.nextLine();
                        }
                        break;
                    case 2:
                        System.out.println("Enter the key to get the value:");
                        k = scanner.nextInt();
                        h = hashMap.hashValue(k);
                        System.out.println("The value is: " + hashMap.bucketGet(h, k));
                        break;
                    case 3:
                        System.out.println("Enter the key to remove the key-value pair:");
                        k = scanner.nextInt();
                        h = hashMap.hashValue(k);
                        System.out.println("The removed value is: " + hashMap.bucketRemove(h, k));
                        break;
                    case 4:
                        System.out.println("The entries in the HashMap are:");
                        for (LinearProbingHashMap.Entry entry : hashMap.entrySet()) {
                            System.out.println("Key: " + entry.key + ", Value: " + entry.value);
                        }
                        break;
                    case 5:
                        System.out.println("Exiting...");
                        scanner.close();
                        System.exit(0);
                    default:
                        System.out.println("Invalid choice. Please enter a number between 1 and 5.");
                }
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a valid integer.");
        } finally {
            scanner.close();
        }
    }
}
