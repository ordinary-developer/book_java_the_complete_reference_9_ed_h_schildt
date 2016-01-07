interface MyIF {
    int getNumber();

    default String getString() {
        return "Default String";
    }
}

class MyIFImp implements MyIF {
    public int getNumber() {
        return 100_0;
    }
}

class MyIFImp2 implements MyIF {
    public int getNumber() {
        return 100;
    }

    public String getString() {
        return "This is a different string.";
    }
}

class DefaultMethodDemo {
    public static void main(String args[]) {
        MyIFImp obj = new MyIFImp();
        System.out.println(obj.getNumber());
        System.out.println(obj.getString());

        MyIFImp2 obj2 = new MyIFImp2();
        System.out.println(obj2.getNumber());
        System.out.println(obj2.getString());
    }
}
