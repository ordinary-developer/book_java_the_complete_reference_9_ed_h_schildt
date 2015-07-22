enum Apple {
    Jonathan(10), GoldenDel(9), RedDel(12), Winesap(15), Cortland(8);
    private int price;
    Apple(int p) { price = p; System.out.println("Constructor calling"); }
    int getPrice() { return price; }
}

class EnumDemo {
    public static void main(String args[]) {
        Apple ap;

        System.out.println("Winesap costs " +
                Apple.Winesap.getPrice() + " cents.\n");

        System.out.println("All apple prices: ");
        for (Apple a: Apple.values()) {
            System.out.println(a + " costs " + a.getPrice() + " cents.");
        }
    }
}

