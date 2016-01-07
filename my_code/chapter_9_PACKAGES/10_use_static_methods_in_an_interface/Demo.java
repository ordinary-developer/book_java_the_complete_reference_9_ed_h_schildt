interface MyIF {
    public int getNUmber();

    public default String getString() {
        return "Default String";
    }

    public static int getDefaultNumber() {
        return 0;
    }
}

class Demo {
    public static void main(String args[]) {
        int defNumb = MyIF.getDefaultNumber();
    }
}
