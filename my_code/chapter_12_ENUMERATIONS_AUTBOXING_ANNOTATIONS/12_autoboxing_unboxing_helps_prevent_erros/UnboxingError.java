class UnboxingError {
    public static void main(String args[]) {
        Integer iOb = 1_000;
        int i = iOb.byteValue();
        System.out.println(i);
    }
}
