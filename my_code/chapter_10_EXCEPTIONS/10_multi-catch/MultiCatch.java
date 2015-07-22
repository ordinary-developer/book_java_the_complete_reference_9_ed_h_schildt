import java.util.Random;


class MultiCatch {
    public static void main(String args[]) {
        Random numberGenerator = new Random();
        int a = 10, b = 0;
        int values[] = { 1, 2, 3 };
        try {
            if (numberGenerator.nextDouble() > 0.5) {
                int result = a / b;
            }
            else {
                values[10] = 19;
            }
        }
        catch (ArithmeticException | ArrayIndexOutOfBoundsException e) {
            System.out.println("Exception caught: " + e);
        }
        System.out.println("After multi-catch.");
    }
}
