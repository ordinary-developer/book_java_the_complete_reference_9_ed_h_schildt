import java.util.*;


class FormatDemo {
    public static void main(String args[]) {
        Formatter fmt = new Formatter();

        for (double i = 1.23; i < 1.0e+6; i *= 100) {
            fmt.format("%f %e", i, i);
            System.out.println(fmt);
        }
        System.out.println("==================");

        fmt.format("Hex: %x, Octal: %o", 196, 196);
        System.out.println(fmt);
        System.out.println("==================");

        fmt.format("%a", 512.0);
        System.out.println(fmt);

        fmt.close();
    }
}
