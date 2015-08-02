class MyClass<T, V> {
    T ob1;
    V ob2;

    MyClass(T o1, V o2) {
        ob1 = o1;
        ob2 = o2;
    }

    boolean isSame(MyClass<T, V> o) {
        return (ob1 == o.ob1 && ob2 == o.ob2)
               ? true
               : false;
    }
}

class TypeInferenceDemo {
    public static void main(String args[]) {
        MyClass<Integer, String> mcOb1 =
            new MyClass<Integer, String>(98, "A string");
        MyClass<Integer, String> mcOb2 = new MyClass<>(98, "A string");

        if (mcOb1.isSame(new MyClass<>(98, "A string"))) {
            System.out.println("Same");
        }
    }
}
