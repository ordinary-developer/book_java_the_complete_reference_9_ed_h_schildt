import java.util.*;

class MyClass {
    private int val;

    MyClass(int v) { val = v; }

    int getVal() { return val; }
}

class UseMethodRef {
    static int compareMC(MyClass a, MyClass b) {
        return a.getVal() - b.getVal();
    }

    public static void main(String args[]) {
        ArrayList<MyClass> al = new ArrayList<MyClass>();

        for (int i = 0; i < 7; i++) {
            al.add(new MyClass(i));
        }

        MyClass maxValObj = Collections.max(al, UseMethodRef::compareMC);
        System.out.println("Maximuv value is: " + maxValObj.getVal());
    }
}


