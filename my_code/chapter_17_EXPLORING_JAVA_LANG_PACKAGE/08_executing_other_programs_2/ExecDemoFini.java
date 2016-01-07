class ExecDemoFini {
    public static void main(String args[]) {
        Runtime r = Runtime.getRuntime();
        Process p = null;

        try {
            p = r.exec("xterm");
            p.waitFor();
        }
        catch (Exception e) {
            System.out.println("Error executing xterm");
        }
        System.out.println("Xterm returned " + p.exitValue());
    }
}
