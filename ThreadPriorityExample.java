class CounterThread extends Thread {
     static int counter = 0;

    public CounterThread(String name, int priority) {
        super(name);
        setPriority(priority);
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            counter++;
            System.out.println(getName() + ": Counter value = " + counter);
            try {
                // Sleep to simulate some work being done
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class ThreadPriorityExample {
    public static void main(String[] args) {
        // Create three threads with different priorities
        CounterThread highPriorityThread = new CounterThread("HighPriorityThread", Thread.MAX_PRIORITY);
        CounterThread normalPriorityThread = new CounterThread("NormalPriorityThread", Thread.NORM_PRIORITY);
        CounterThread lowPriorityThread = new CounterThread("LowPriorityThread", Thread.MIN_PRIORITY);

        // Start the threads
        highPriorityThread.start();
        normalPriorityThread.start();
        lowPriorityThread.start();

        try {
            // Wait for all threads to finish
            highPriorityThread.join();
            normalPriorityThread.join();
            lowPriorityThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Main thread finishes last
        System.out.println("Main thread finished. Counter value = " + CounterThread.counter);
    }
}
