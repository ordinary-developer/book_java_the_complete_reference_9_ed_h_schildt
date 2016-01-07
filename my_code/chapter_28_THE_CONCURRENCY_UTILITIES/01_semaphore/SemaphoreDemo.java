import java.util.concurrent.*;

class SemaphoreDemo {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(1);

        new IncrementThread(semaphore, "A");
        new DecrementThread(semaphore, "B");
    }   
}

class Shared {
    static int count = 0;
}

class IncrementThread implements Runnable {
    String name;
    Semaphore semaphore;

    IncrementThread(Semaphore semaphore, String name) {
        this.semaphore = semaphore;
        this.name = name;
        new Thread(this).start();
    }

    // [Runnable] interface implementiation
    public void run() {
        System.out.println("Starting " + name);
        try {
            System.out.println(name + " is waiting for a permit");
            semaphore.acquire();
            System.out.println(name + " gets a permit.");

            for (int i = 0; i < 5; i++) {
                Shared.count++;
                System.out.println(name + ": " + Shared.count);
                Thread.sleep(100);
            }
        }
        catch (InterruptedException exception) {
            System.out.println(exception);
        }

        System.out.println(name + " release the permit.");
        semaphore.release();
    }
    // end [Runnable]
}

class DecrementThread implements Runnable {
    String name;
    Semaphore semaphore;

    DecrementThread(Semaphore semaphore, String name) {
        this.semaphore = semaphore;
        this.name = name;
        new Thread(this).start();
    }

    // [Runnable] interface implementiation
    public void run() {
        System.out.println("Starting " + name);
        try {
            System.out.println(name + " is waiting for a permit");
            semaphore.acquire();
            System.out.println(name + " gets a permit.");

            for (int i = 0; i < 5; i++) {
                Shared.count--;
                System.out.println(name + ": " + Shared.count);
                Thread.sleep(100);
            }
        }
        catch (InterruptedException exception) {
            System.out.println(exception);
        }

        System.out.println(name + " release the permit.");
        semaphore.release();
    }
    // end [Runnable]
}
