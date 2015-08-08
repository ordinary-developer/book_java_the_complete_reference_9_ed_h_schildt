class ConCat {
    public static void main(String args[]) {
        String age = "9";
        String s= "He is " + age + " years old.";
        System.out.println(s);

        String longStr = "This could have been " +
            "a very long line that woule have " +
            "wrapped around. But string concatenation " +
            "prevents this.";

        System.out.println(longStr);
    }
}
