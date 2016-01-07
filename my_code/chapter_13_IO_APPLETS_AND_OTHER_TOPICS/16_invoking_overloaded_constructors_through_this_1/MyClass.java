class MyClass {
    int a;
    int b;

    MyClass(int i, int j) {
        a = i;
        b = j;
    }

    MyClass(int i) {
        a = i;
        b = i;
    }

    MyClass() { 
        a = 0;
        b = 0;
    }

    public static void main(String args[]) {
        new MyClass(1, 2);
        new MyClass(3);
        new MyClass();
    }
}
