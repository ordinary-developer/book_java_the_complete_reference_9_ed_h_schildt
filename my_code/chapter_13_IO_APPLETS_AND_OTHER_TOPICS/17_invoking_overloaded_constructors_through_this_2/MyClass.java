class MyClass {
    int a;
    int b;

    MyClass(int i, int j) {
        a = i; 
        b = j;
    }

    MyClass(int i) {
        this(i, i);
    }

    MyClass() {
        this(0);
    }

    public static void main(String args[]) {
        new MyClass(1, 2);
        new MyClass(1);
        new MyClass();
    }
}
