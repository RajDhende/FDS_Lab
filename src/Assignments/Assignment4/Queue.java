package Assignments.Assignment4;

/**
 * A generic circular queue implementation.
 *
 * @param <T> The type of elements stored in the queue.
 */
public class Queue<T> {
    private T[] a;       // Array to store the queue elements
    private int front;   // Index of the front element
    private int rear;    // Index of the rear element
    private int size;    // Current size of the queue

    /**
     * Constructs a new queue with the given size.
     *
     * @param size The maximum number of elements the queue can hold.
     */
    public Queue(int size) {
        this.a = (T[]) new Object[size];
        this.front = -1;
        this.rear = -1;
        this.size = 0;
    }

    /**
     * Checks if the queue is empty.
     *
     * @return True if the queue is empty, false otherwise.
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Checks if the queue is full.
     *
     * @return True if the queue is full, false otherwise.
     */
    public boolean isFull() {
        return size == a.length;
    }

    /**
     * Gets the current size of the queue.
     *
     * @return The number of elements in the queue.
     */
    public int size() {
        return size;
    }

    /**
     * Adds an element to the rear of the queue.
     *
     * @param value The element to be added to the queue.
     */
    public void enQueue(T value) {
        if (isFull()) {
            System.out.println("The queue is full");
        } else if (isEmpty()) {
            front = rear = 0;
            a[rear] = value;
            size++;
        } else {
            rear = (rear + 1) % a.length;
            a[rear] = value;
            size++;
        }
    }

    /**
     * Removes and returns the element from the front of the queue.
     *
     * @return The element removed from the queue, or null if the queue is empty.
     */
    public T deQueue() {
        if (isEmpty()) {
            System.out.println("The queue is empty");
            return null;
        } else {
            T result = a[front];
            a[front] = null;
            front = (front + 1) % a.length;
            size--;
            if (size == 0) {
                front = rear = -1;
            }
            return result;
        }
    }

    /**
     * Retrieves the element at the front of the queue without removing it.
     *
     * @return The element at the front of the queue, or null if the queue is empty.
     */
    public T peek() {
        if (isEmpty()) {
            System.out.println("The queue is empty");
            return null;
        } else {
            return a[front];
        }
    }
}
