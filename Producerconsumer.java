class SharedResource {
    private int x;
    private boolean isProduced;

    public SharedResource() {
        this.x = 0;
        this.isProduced = false;
    }

    public synchronized int consume() {
        while (!isProduced) {
            try {
                wait(); // Consumer waits until Producer produces
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println("Consumed: " + x);
        isProduced = false;
        notify(); // Notify Producer that it can produce now
        return x;
    }

    public synchronized void produce() {
        while (isProduced) {
            try {
                wait(); // Producer waits until Consumer consumes
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        x++;
        System.out.println("Produced: " + x);
        isProduced = true;
        notify(); // Notify Consumer that it can consume now
    }
}

class Producer extends Thread {
    private SharedResource sharedResource;

    public Producer(SharedResource sharedResource) {
        this.sharedResource = sharedResource;
    }

    public void run() {
        while (true) {
            sharedResource.produce();
        }
    }
}

class Consumer extends Thread {
    private SharedResource sharedResource;

    public Consumer(SharedResource sharedResource) {
        this.sharedResource = sharedResource;
    }

    public void run() {
        while (true) {
            sharedResource.consume();
        }
    }
}


 class ProducerConsumer {
    public static void main(String[] args) {
        SharedResource sharedResource = new SharedResource();
        Producer producer = new Producer(sharedResource);
        Consumer consumer = new Consumer(sharedResource);

        producer.start();
        consumer.start();
    }
}
