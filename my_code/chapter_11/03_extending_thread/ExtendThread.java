class NewThread extends Thread {
    public NewThread() {
        super("demo thread");
        System.out.println("child thread: " + this);
        start();
    }

    public void run() {
        try {
            for (int i = 5; i > 0; i--) {
                System.out.println("[child thread]: " + i);
                Thread.sleep(500);
            }
        }
        catch (InterruptedException e) {
            System.out.println("the child thread was interrupted.");
        }
        System.out.println("exiting the child thread.");
    }
}


class ExtendThread { 
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
        System.out.println("exiting the main thread.");
    }
}
