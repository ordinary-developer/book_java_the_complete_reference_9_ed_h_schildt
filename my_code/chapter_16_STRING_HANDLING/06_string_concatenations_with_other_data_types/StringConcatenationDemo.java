class StringConcatenationDemo {
    public static void main(String args[]) {
        int age = 9;
        String s1 = "He is " + age + " years old.";
        System.out.println(s1);

        String s2 = "four: " + 2 + 2;
        System.out.println(s2);

        String s3 = "four: " + (2 + 2);
        System.out.println(s3);
    }
}
