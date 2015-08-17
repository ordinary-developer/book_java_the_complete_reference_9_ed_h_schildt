class PBDemo {
    public static void main(String args[]) {

        try {
            ProcessBuilder proc = 
                new ProcessBuilder("xterm");
            proc.start();
        }
        catch (Exception e) {
            System.out.println("Error executing xterm");
        }
    }
}
