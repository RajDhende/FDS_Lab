package Assignments.Assignment3;


import java.util.Scanner;

public class TestApplication {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the Array : ");
        int size = sc.nextInt();
        MyLongArray la = new MyLongArray(size);
        Sorting st = new Sorting(size);
        System.out.println("Array of size : " + size + " has been created");
        boolean loop = true;
        while (loop) {
            System.out.println("1)Insert an element.");
            System.out.println("2)Delete an element.");
            System.out.println("3)Find an element.");
            System.out.println("4)Get an element.");
            System.out.println("5)Display the Array");
            System.out.println("6)Delete a duplicate value");
            System.out.println("7)Insert an element at a particular index.");
            System.out.println("8)Delete an element at a particular index.");
            System.out.println("9)Sort the Array using bubble sort.");
            System.out.println("10)Sort the Array using selection sort.");
            System.out.println("11)Sort the Array using insertion sort.");
            System.out.println("12)Exit.");
            int op = sc.nextInt();

            switch (op) {
                case (1): {
                    System.out.print("Enter the element to be inserted : ");
                    long value = sc.nextInt();
                    la.insert(value);
                    break;
                }
                case (2): {
                    System.out.print("Enter the value to be deleted : ");
                    long value = sc.nextInt();
                    la.delete(value);
                    System.out.println("Value successfully deleted");
                    break;
                }
                case (3): {
                    System.out.print("Enter the element to be found : ");
                    long value = sc.nextInt();
                    la.find(value);
                    break;
                }
                case (4): {
                    System.out.print("Enter the index : ");
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
                    System.out.print("Enter the value : ");
                    long value = sc.nextInt();
                    la.dupDelete(value);
                    break;
                }
                case (7): {
                    System.out.print("Enter the index value : ");
                    int index = sc.nextInt();
                    System.out.print("Enter the value to be inserted : ");
                    long value = sc.nextInt();
                    la.insertAt(index, value);
                    break;
                }
                case (8): {
                    System.out.print("Enter the index value : ");
                    int index = sc.nextInt();
                    la.deleteAt(index);
                    break;
                }
                case (9): {
                    st.bubbleSort(la);
                    break;
                }
                case (10): {
                    st.selectionSort(la);
                    break;
                }
                case (11): {
                    st.insertionSort(la);
                    break;
                }
                case (12): {
                    loop = false;
                    break;
                }
                default: {
                    System.out.println("Enter a operation.");
                }
            }
        }
    }

}

