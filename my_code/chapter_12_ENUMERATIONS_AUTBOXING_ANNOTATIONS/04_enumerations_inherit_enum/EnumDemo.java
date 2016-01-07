enum Apple {
    Jonathan, GoldenDel, RedDel, Winesap, Cortland
}

class EnumDemo {
    public static void main(String args[]) {
        Apple ap, ap2, ap3;

        System.out.println("Here are all apple constants" + 
                " and their ordinal values: ");
        for (Apple a: Apple.values()) {
            System.out.println(a + " " + a.ordinal());
        }
        System.out.println();

        ap = Apple.RedDel;
        ap2 = Apple.GoldenDel;
        ap3 = Apple.RedDel;

        if (ap.compareTo(ap2) < 0) {
            System.out.println(ap + " comes before " + ap2);
        }
        if (ap.compareTo(ap2) > 0) {
            System.out.println(ap2 + " comes before " + ap);
        }
        if (ap.compareTo(ap3) == 0) {
            System.out.println(ap + " equals " + ap3);
        }
        System.out.println();

        if (ap.equals(ap2)) {
            System.out.println("Error!");
        }
        if (ap.equals(ap3)) {
            System.out.println(ap + " equals " + ap3);
        }
        System.out.println();

        if (ap == ap3) {
            System.out.println(ap + " == " + ap3);
        }
    }
}
