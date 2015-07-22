class IFTest {
    public static void main(String args[]) {
        FixedStack mystack_1 = new FixedStack(5);
        FixedStack mystack_2 = new FixedStack(8);

        for (int i = 0; i < 5; i++) {
            mystack_1.push(i);
        }
        for (int i = 0; i < 8; i++) {
            mystack_2.push(i);
        }

        System.out.println("Stack in mystack_1: ");
        for (int i = 0; i < 5; i++) {
            System.out.println(mystack_1.pop());
        }

        System.out.println("Stack in mystack_2: ");
        for (int i = 0; i < 8; i++) {
            System.out.println(mystack_2.pop());
        }
    }
}
