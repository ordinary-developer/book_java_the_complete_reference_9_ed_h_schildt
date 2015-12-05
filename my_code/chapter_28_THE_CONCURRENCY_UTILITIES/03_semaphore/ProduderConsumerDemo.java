import java.util.concurrent.Semaphore;

class ProducerConsumerDemo {
    public static void main(String[] args) {
        Queue queue = new Queue();
        new Consumer(queue);
        new Producer(queue);

    }
}

class Queue {
    int number;

    static Semaphore consumerSemaphore = new Semaphore(0);
    static Semaphore producerSemaphore = new Semaphore(1);

    void get() {
        try {
            consumerSemaphore.acquire();
        }
        catch (InterruptedException exception) {
            System.out.println("InterruptedException caught");
        }
        System.out.println("Got: " + number);
        producerSemaphore.release();
    }

    void put(int number) {
        try {
            producerSemaphore.acquire();
            this.number = number;
        }
        catch (InterruptedException exception) {
            System.out.println("InterruptedException caught");
        }

        System.out.println("Put: " + number);
        consumerSemaphore.release();
    }
}

class Consumer implements Runnable {
    Queue queue;

    public Consumer(Queue queue) {
        this.queue = queue;
        new Thread(this, "Consumer").start();
    }

    // [Runnable] implementation
    public void run() {
        for (int i = 0; i < 20; i++) {
            queue.put(i);
        }
    }
}

class Producer implements Runnable {
    Queue queue;

    public Producer(Queue queue) {
        this.queue = queue;
        new Thread(this, "Producer").start();
    }

    // [Runnable] implementation
    public void run() {
        for (int i = 0; i < 20; i++) {
            queue.get();
        }
    }

}
