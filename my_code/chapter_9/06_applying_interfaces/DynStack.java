class DynStack implements IntStack {
    private int stack[];
    private int pos;

    DynStack(int size) {
        stack = new int[size];
        pos = -1;
    }

    public void push(int item) {
        if ((stack.length - 1) == pos) {
            int temp[] = new int[stack.length * 2];
            for (int i = 0; i < stack.length; i++) {
                temp[i] = stack[i];
            }
            stack = temp;
            stack[++pos] = item;
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
