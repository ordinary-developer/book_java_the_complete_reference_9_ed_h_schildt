import java.util.*;


class ArrayDequeDemo {
    public static void main(String args[]) {
        ArrayDeque<String> adq = new ArrayDeque<String>();

        adq.push("A");
        adq.push("B");
        adq.push("D");
        adq.push("E");
        adq.push("F");

        System.out.print("Popping the statck: ");

        while (adq.peek() != null) {
            System.out.print(adq.pop() + " ");
        }
        System.out.println();
    }
}
