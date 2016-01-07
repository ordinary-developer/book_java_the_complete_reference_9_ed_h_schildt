class NewThread implements Runnable {
    public NewThread() {
        thread = new Thread(this, "demo thread");
        System.out.println("child thread: " + thread);
        thread.start();
    }
    // [Runnable] implementation
    public void run() {
        try {
            for (int i = 5; i > 0; i --) {
                System.out.println("[child thread]: " + i);
                Thread.sleep(500);
            }
        }
        catch (InterruptedException e) {
            System.out.println("the child thread was interrupted.");
        }
        System.out.println("exiting the child thread");
    }
    private Thread thread;
}

class ThreadDemo {
    public static void main(String args[]) {
        new NewThread();

        try {
            for (int i = 5; i > 0; i--) {
                System.out.println("[MAIN THREAD]: " + i);
                Thread.sleep(1000);
            }
        }
        catch (InterruptedException e) {
            System.out.println("the main thread was interrupted.");
        }
        System.out.println("exiting the main thread");
    }
}
