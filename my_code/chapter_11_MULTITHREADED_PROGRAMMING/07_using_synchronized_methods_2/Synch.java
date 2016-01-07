class Callme {
    public synchronized void call(String message) {
        System.out.print("[" + message);
        try {
            Thread.sleep(1000);
        }
        catch (InterruptedException e) {
            System.out.println("Interrupted");
        }
        System.out.println("]");
    }
}

class Caller implements Runnable {
    public Caller(Callme target, String message) {
        this.target = target;
        this.message = message;
        thread = new Thread(this);
        thread.start();
    }

    public void run() {
        target.call(message);
    }

    public Thread getThread() {
        return thread;
    }

    public void setThread(Thread thread) {
        this.thread = thread;
    }

    private String message;
    private Callme target;
    private Thread thread;
}

class Synch {
    public static void main(String args[]) {
        Callme target = new Callme();
        Caller ob1 = new Caller(target, "Hello");
        Caller ob2 = new Caller(target, "Synchronized");
        Caller ob3 = new Caller(target, "World");

        try {
            ob1.getThread().join();
            ob2.getThread().join();
            ob3.getThread().join();
        }
        catch (InterruptedException e) {
            System.out.println("Interrupted");
        }
    }
}
