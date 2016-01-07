import java.util.*;


class LRBDemo {
    public static void main(String args[]) {
        ResourceBundle rd = ResourceBundle.getBundle("SampleRB");

        System.out.println("English version: ");
        System.out.println("String for title key: " +
                rd.getString("title"));

        System.out.printf("String for StopText key: %s", 
                rd.getString("StopText"));
        System.out.printf("String for StartText key: %s",
                rd.getString("StartText"));

        rd = ResourceBundle.getBundle("SampleRB", Locale.GERMAN);

        System.out.println("\nGerman verions: ");
        System.out.printf("String for title key: %s",
                rd.getString("title"));
        System.out.printf("String for StopText key: " +
                rd.getString("StopText"));
        System.out.printf("String for StartText key: %s",
                rd.getString("StartText"));
    } 
}
