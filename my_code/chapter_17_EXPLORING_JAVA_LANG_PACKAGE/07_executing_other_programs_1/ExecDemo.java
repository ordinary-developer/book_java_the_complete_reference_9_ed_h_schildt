class ExecDemo {
    public static void main(String args[]) {
        Runtime r = Runtime.getRuntime();
        Process p = null;

        try {
            p = r.exec("xterm");
        }
        catch (Exception e) {
            System.out.println("Error executing an internal notepad.");
        }
    }
}
