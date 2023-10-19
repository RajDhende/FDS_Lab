package Assignments.Assignment4;

/**
 * A class that simulates round-robin scheduling of processes.
 *
 * @param <T> The type of elements representing the processes.
 */
class RoundRobinSchedular<T> {
    private Queue<T> queue; // The queue to manage the scheduling of processes
    private int timeQuantum; // The time quantum for each process

    /**
     * Creates a new RoundRobinSchedular instance.
     *
     * @param queueSize     The maximum size of the scheduling queue.
     * @param timeQuantum   The time quantum allocated to each process.
     */
    public RoundRobinSchedular(int queueSize, int timeQuantum) {
        this.queue = new Queue<>(queueSize);
        this.timeQuantum = timeQuantum;
    }

    /**
     * Schedules an array of processes using round-robin scheduling.
     *
     * @param processes An array of processes to be scheduled.
     */
    public void schedule(T[] processes) {
        int[] remainingTime = new int[processes.length];

        // Initialize remainingTime array with the burst times of processes
        for (int i = 0; i < processes.length; i++) {
            remainingTime[i] = timeQuantum;
        }

        int currentTime = 0;

        while (true) {
            boolean allProcessesCompleted = true;

            for (int i = 0; i < processes.length; i++) {
                if (remainingTime[i] > 0) {
                    allProcessesCompleted = false;

                    // Execute the process for the time quantum or the remaining time, whichever is smaller
                    int executionTime = Math.min(remainingTime[i], timeQuantum);
                    remainingTime[i] -= executionTime;

                    // Add the process to the queue
                    queue.enQueue(processes[i]);

                    currentTime += executionTime;

                    // Check if the process has completed its execution
                    if (remainingTime[i] == 0) {
                        System.out.println("Process " + processes[i] + " completed at time " + currentTime);
                    } else {
                        System.out.println("Time " + currentTime + ": Process " + processes[i]);
                    }
                }
            }

            // If all processes have completed, exit the scheduling loop
            if (allProcessesCompleted) {
                break;
            }
        }
    }

    /**
     * The main method that demonstrates the usage of the RoundRobinSchedular class.
     *
     * @param args The command line arguments (not used in this program).
     */
    public static void main(String[] args) {
        // Example usage
        String[] processes = {"P1", "P2", "P3", "P4"};
        int timeQuantum = 4;
        int queueSize = processes.length;

        RoundRobinSchedular<String> scheduler = new RoundRobinSchedular<>(queueSize, timeQuantum);
        scheduler.schedule(processes);
    }
}
