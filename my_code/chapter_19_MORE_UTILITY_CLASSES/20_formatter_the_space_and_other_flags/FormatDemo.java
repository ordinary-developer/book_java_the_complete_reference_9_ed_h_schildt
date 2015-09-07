import java.util.*;


class FormatDemo {
    public static void main(String args[]) {
        Formatter fmt = new Formatter();

        fmt.format("% d", -100);
        System.out.println(fmt);
        fmt.close();

        fmt = new Formatter();
        fmt.format("% d", 100);
        System.out.println(fmt);
        fmt.close();

        fmt = new Formatter();
        fmt.format("% d", -200);
        System.out.println(fmt);
        fmt.close();

        fmt = new Formatter();
        fmt.format("% d", 200);
        System.out.println(fmt);
        fmt.close();

        fmt = new Formatter();
        fmt.format("%(d", -100);
        System.out.println(fmt);
        fmt.close();

        fmt = new Formatter();
        fmt.format("%,.2f", 43567897.34);
        System.out.println(fmt);
        fmt.close();

        fmt = new Formatter();
        fmt.format("%X", 250);
        System.out.println(fmt);
        fmt.close();

        fmt = new Formatter();
        fmt.format("%E", 123.1234);
        System.out.println(fmt);
        fmt.close();
    }
}
