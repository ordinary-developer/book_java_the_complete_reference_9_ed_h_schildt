class NewThread implements Runnable {
    public NewThread(String name) {
        this.name = name;
        thread = new Thread(this, this.name);
        System.out.println("New thread: " + thread);
        thread.start();
    }

    // [Runnable] interface implementation
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

    private String name;
    private Thread thread;
}

class MultiThreadDemo {
    public static void main(String args[]) {
        new NewThread("One");
        new NewThread("Two");
        new NewThread("Three");

        try {
            Thread.sleep(10000);
        }
        catch (InterruptedException e) {
            System.out.println("main thread was interrupted.");
        }
        System.out.println("exiting the main thread.");
    }
}
