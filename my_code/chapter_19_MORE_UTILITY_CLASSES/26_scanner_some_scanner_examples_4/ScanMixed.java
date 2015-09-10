import java.util.*;
import java.io.*;


class ScanMixed {
    public static void main(String args[])
        throws IOException 
    {
        int i;
        double d;
        boolean b;
        String str;

        FileWriter fout = new FileWriter("test.txt");
        fout.write("Testing Scanner 10 12,2 one true two false");
        fout.close();

        FileReader fin = new FileReader("test.txt");

        Scanner src = new Scanner(fin);

        while (src.hasNext()) {
            if (src.hasNextInt()) {
                i = src.nextInt();
                System.out.printf("int: %d\n", i);
            }
            else if (src.hasNextDouble()) {
                d = src.nextDouble();
                System.out.printf("double: %f\n", d);
            }
            else if (src.hasNextBoolean()) {
                b = src.nextBoolean();
                System.out.println("boolean: %b\n" + b);
            }
            else {
                str = src.next();
                System.out.printf("String: %s\n", str);
            }
        }

        src.close();
    }
}
