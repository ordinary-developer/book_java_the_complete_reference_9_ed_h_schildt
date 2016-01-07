class indexDemo {
    public static void main(String args[]) {
        String s = "Now is the time for all good men " +
                   "to come to the aid of their country.";
        System.out.println(s);
        System.out.println("indexOf(t) = " +
                s.indexOf('t'));
        System.out.println("lastIndexOf(t) = " +
                s.lastIndexOf('t'));
        System.out.println("indexOf(the) = " +
                s.indexOf("the"));
        System.out.println("lastIndexOf(the) = " +
                s.lastIndexOf("the"));
        System.out.println("indexOf(t, 10) = " +
                s.indexOf('t', 10));
        System.out.println("lastIndexOf(t, 60) = " +
                s.lastIndexOf('t', 60));
        System.out.println("lastIndexOf(t, 11) = " +
                s.lastIndexOf('t', 11));

        System.out.println("indexOf(the, 10) = " +
                s.indexOf("the", 10));
        System.out.println("lastIndexOf(the, 60) = " +
                s.lastIndexOf("the", 60));

        System.out.println("indexOf(the, 44) = " +
                s.indexOf("the", 44));
        System.out.println("lastIndexOf(the, 55) = " +
                s.lastIndexOf("the", 55));
    }
}
