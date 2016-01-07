class CharacterExtractionDemo {
    public static void main(String args[]) {
        String s1 = "string";
        char character1 = s1.charAt(2);
        System.out.println(character1);

        String s2 = "This is a demo of the getChars method.";
        int start = 10;
        int end = 14;
        char buf[] = new char[end - start];
        s2.getChars(start, end, buf, 0);
        System.out.println(buf);

        String s3 = "string";
        byte[] byteArray = s3.getBytes();
        for (byte element : byteArray) {
            System.out.print(element + " ");
        }
        System.out.println();
        
        String s4 = "string";
        char[] charArray = s4.toCharArray();
        for (char element : charArray) {
            System.out.print(element + " ");
        }
        System.out.println();
    }
}
