import java.util.*;


class LinkedHashSetDemo {
    public static void main(String args[]) {
        HashSet<String> hs = new LinkedHashSet<String>();

        hs.add("Beta");
        hs.add("Alpha");
        hs.add("Eta");
        hs.add("Gamma");
        hs.add("Epsilon");
        hs.add("Omega");

        System.out.println(hs);
    }
}
