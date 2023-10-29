package Assignments.Assignment4;
import java.util.Scanner;

/**
 * This class represents a process with a name and execution time.
 */
class Process {
    String name;
    int time;
    /**
     * Initializes a new Process with the given name and execution time.
     * @param name The name of the process.
     * @param time The execution time required for the process.
     */
    public Process(String name, int time) {
        this.name = name;
        this.time = time;
    }
}

/**
 * This class represents a Round Robin Scheduler for scheduling processes.
 */
public class RoundRobinScheduler {
    private int timeQuantum;
    private Queue<Process> processQueue;

    /**
     * Initializes a Round Robin Scheduler with the specified queue size and time quantum.
     * @param size The maximum number of processes that can be enqueued.
     * @param timeQuantum The time quantum for each process execution.
     */
    public RoundRobinScheduler(int size, int timeQuantum) {
        this.timeQuantum = timeQuantum;
        this.processQueue = new Queue<>(size);
    }

    /**
     * Schedules and executes processes in a round-robin fashion.
     */
    public void schedule() {
        while (!processQueue.isEmpty()) {
            Process process = processQueue.deQueue();

            if (process.time > timeQuantum) {
                process.time -= timeQuantum;
                System.out.println("Process " + process.name + " executed for " + timeQuantum + " units");
                processQueue.enQueue(process);
            } else {
                System.out.println("Process " + process.name + " executed for " + process.time + " units");
                System.out.println("Process " + process.name + " completed");
            }
        }
    }

    /**
     * The main method to interact with the Round Robin Scheduler and schedule processes.
     * @param args Command-line arguments (not used in this program).
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the maximum number of processes: ");
        int maxProcesses = scanner.nextInt();
        RoundRobinScheduler scheduler = new RoundRobinScheduler(maxProcesses, 0);

        for (int i = 0; i < maxProcesses; i++) {
            System.out.print("Enter the name of the process : ");
            String name = scanner.next();
            System.out.print("Enter the time alloted to the process : ");
            int time = scanner.nextInt();
            scheduler.processQueue.enQueue(new Process(name, time));
        }

        System.out.print("Enter the time quantum: ");
        int timeQuantum = scanner.nextInt();
        scheduler.timeQuantum = timeQuantum;

        scanner.close();

        scheduler.schedule();
    }
}
