class NewThread implements Runnable {

    public NewThread(String name) {
        this.name = name;
        thread = new Thread(this, this.name);
        System.out.println("New Thread: " + this.name);
        thread.start();
    }

    public void run() {
        try {
            for (int i = 5; i > 0; i--) {
                System.out.println(name + ": " + i);
                Thread.sleep(1000);
            }
        }
        catch (InterruptedException e) {
            System.out.println(name + " was interrupted.");
        }
        System.out.println(name + " exiting.");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Thread getThread() {
        return thread;
    }

    public void setThread(Thread thread) {
        this.thread = thread;
    }

    private String name;
    private Thread thread;
}

class DemoJoin {
    public static void main(String args[]) {
        NewThread ob1 = new NewThread("One");
        NewThread ob2 = new NewThread("Two");
        NewThread ob3 = new NewThread("Three");

        System.out.println("Thread One is alive: " +
                ob1.getThread().isAlive());
        System.out.println("Thread Two is alive: " +
                ob2.getThread().isAlive());
        System.out.println("Thread Three is alive: " +
                ob3.getThread().isAlive());

        try {
            System.out.println("Waiting for threads to finish.");
            ob1.getThread().join();
            ob2.getThread().join();
            ob3.getThread().join();
        }
        catch (InterruptedException e) {
            System.out.println("main thread was interrupted.");
        }

        System.out.println("Thread One is alive: " +
                ob1.getThread().isAlive());
        System.out.println("Thread Two is alive: " +
                ob2.getThread().isAlive());
        System.out.println("Thread Three is alive: " +
                ob3.getThread().isAlive());
    }
}
