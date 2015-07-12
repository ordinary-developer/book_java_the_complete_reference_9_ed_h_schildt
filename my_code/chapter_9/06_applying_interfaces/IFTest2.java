class IFTest2 {
    public static void main(String args[]) {
        DynStack mystack_1 = new DynStack(5);
        IntStack mystack_2 = new DynStack(8);

        for (int i = 0; i < 12; i++) {
            mystack_1.push(i);
        }
        for (int i = 0; i < 20; i++) {
            mystack_2.push(i);
        }

        System.out.println("Stack in mystack_1: ");
        for (int i = 0; i < 12; i++) {
            System.out.println(mystack_1.pop());
        }

        System.out.println("Stack in mystack_2: ");
        for (int i = 0; i < 20; i++) {
            System.out.println(mystack_2.pop());
        }
    }
}
