import java.util.concurrent.*;

class SemDemo {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(1);

        new BaseThread(semaphore, "A", new IncrementOperation());
        new BaseThread(semaphore, "B", new DecrementOperation());
    }
}


class Shared {
    static int count = 0;
}

interface Strategy {
    void performOperation() throws InterruptedException;
}

class IncrementOperation implements Strategy {
    // [Strategy] implementation
    public void performOperation() throws InterruptedException {
        for (int i = 0; i < 5; i++) {
            Shared.count++;
            System.out.println(": " + Shared.count);
            Thread.sleep(10);
        }
    }
}

class DecrementOperation implements Strategy {
    // [Strategy] implementation
    public void performOperation() throws InterruptedException {
        for (int i = 5; i > 0; i--) {
            Shared.count--;
            System.out.println(": " + Shared.count);
            Thread.sleep(10);
        }
    }
}

class BaseThread implements Runnable {
    Semaphore semaphore;
    String name;
    Strategy strategy;

    BaseThread(Semaphore semaphore, String name, Strategy strategy) {
        this.semaphore = semaphore;
        this.name = name;
        this.strategy = strategy;
        new Thread(this).start();
    }

    // [Runnable] implementation
    public void run() {
        System.out.println("Starting " + name);

        try {
            System.out.println(name + " is waiting for a permit");
            semaphore.acquire();
            System.out.println(name + " gets a permit.");

            strategy.performOperation();

        }
        catch (InterruptedException exception) {
            System.out.println(exception);
        }

        System.out.println(name + " releases the permit.");
        semaphore.release();
    }
}
