class Queue {
    public synchronized int get() {
        while (!valueSet) {
            try {
                wait();
            }
            catch (InterruptedException e) {
                System.out.println("InterruptedException was caught");
            }
        }

        System.out.println("Got: " + n);
        valueSet = false;
        notify();
        return n;
    }

    public synchronized void put(int n) {
        while (valueSet) {
            try {
                wait();
            }
            catch (InterruptedException e) {
                System.out.println("InterruptedException was caught");
            }
        }

        this.n = n;
        valueSet = true;
        System.out.println("Put: " + n);
        notify();
    }
    
    private int n;
    private boolean valueSet = false;
}

class Producer implements Runnable {
    public Producer(Queue queue) {
        this.queue = queue;
        new Thread(this, "Producer").start();
    }

    public void run() {
        int i = 0;
        while (true) {
            queue.put(i++);
        }
    }

    private Queue queue;
}

class Consumer implements Runnable {
    public Consumer(Queue queue) {
        this.queue = queue;
        new Thread(this, "Consumer").start();
    }

    public void run() {
        while (true) {
            queue.get();
        }
    }
    private Queue queue;
}

class PC {
    public static void main(String args[]) {
        Queue queue = new Queue();
        new Producer(queue);
        new Consumer(queue);

        System.out.println("Press Control-C to stop.");
    }
}
