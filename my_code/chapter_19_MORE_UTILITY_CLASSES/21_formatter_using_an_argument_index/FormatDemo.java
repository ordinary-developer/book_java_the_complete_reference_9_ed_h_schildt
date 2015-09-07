import java.util.*;


class FormatDemo {
    public static void main(String args[]) {
        Formatter fmt = new Formatter();
        Calendar cal = Calendar.getInstance();

        fmt.format("Today is day %te of %<tB, %<tY", cal);
        System.out.println(fmt);
        fmt.close();

        fmt = new Formatter();
        fmt.format("%3$d %1$d %2$d", 10, 20, 30);
        System.out.println(fmt);
        fmt.close();

        fmt = new Formatter();
        fmt.format("%d in hex is %1$x", 255);
        System.out.println(fmt);
        fmt.close();

        fmt = new Formatter();
        fmt.format("%d in hex is %<x", 255);
        System.out.println(fmt);
        fmt.close();
    }
}
