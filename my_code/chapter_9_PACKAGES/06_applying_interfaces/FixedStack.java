class FixedStack implements IntStack {
    private int stack[];
    private int pos;

    FixedStack(int size) {
        stack = new int[size];
        pos = -1;
    }

    public void push(int item) {
        if ((stack.length - 1) == pos) {
            System.out.println("Stack is full.");
        }
        else {
            stack[++pos] = item;
        }
    }

    public int pop() {
        if (pos < 0) {
            System.out.println("Stack underflow.");
            return 0;
        }
        else {
            return stack[pos--];
        }
    }
}
