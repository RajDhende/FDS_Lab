package Assignments.Assignment4;

/**
 * A generic stack data structure.
 * @param <T> The type of elements stored in the stack.
 */
public class Stacks<T> implements Stack<T> {
    private T[] a; // Array to store elements
    private int topOfStack; // Index of the top element
    private int size; // Number of elements in the stack

    /**
     * Constructs a new stack with the given size.
     * @param size The maximum number of elements the stack can hold.
     */
    public Stacks(int size) {
        this.a = (T[]) new Object[size];
        this.topOfStack = -1; // Stack is initially empty
        this.size = 0;
    }

    /**
     * Checks if the stack is empty.
     * @return True if the stack is empty, false otherwise.
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Checks if the stack is full.
     * @return True if the stack is full, false otherwise.
     */
    public boolean isFull() {
        return size == a.length;
    }

    /**
     * Pushes a new element onto the stack.
     * @param value The element to be pushed onto the stack.
     */
    public void Push(T value) {
        if (isFull()) {
            System.out.println("The stack is full");
        } else {
            topOfStack++;
            a[topOfStack] = value;
            size++;
        }
    }

    /**
     * Pops and removes the top element from the stack.
     * @return The top element of the stack, or null if the stack is empty.
     */
    public T Pop() {
        if (isEmpty()) {
            System.out.println("The stack is empty");
            return null;
        } else {
            T result = a[topOfStack];
            topOfStack--;
            size--;
            return result;
        }
    }

    /**
     * Peeks at the top element of the stack without removing it.
     * @return The top element of the stack, or null if the stack is empty.
     */
    public T Peek() {
        if (isEmpty()) {
            return null;
        } else {
            return a[topOfStack];
        }
    }
}

/**
 * A generic stack interface.
 * @param <T> The type of elements stored in the stack.
 */
interface Stack<T> {
    /**
     * Checks if the stack is empty.
     * @return True if the stack is empty, false otherwise.
     */
    boolean isEmpty();

    /**
     * Checks if the stack is full.
     * @return True if the stack is full, false otherwise.
     */
    boolean isFull();

    /**
     * Pushes a new element onto the stack.
     * @param value The element to be pushed onto the stack.
     */
    void Push(T value);

    /**
     * Pops and removes the top element from the stack.
     * @return The top element of the stack, or null if the stack is empty.
     */
    T Pop();

    /**
     * Peeks at the top element of the stack without removing it.
     * @return The top element of the stack, or null if the stack is empty.
     */
    T Peek();
}
