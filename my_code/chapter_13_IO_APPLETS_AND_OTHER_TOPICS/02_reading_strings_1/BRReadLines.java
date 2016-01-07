import java.io.*;

class BRReadLines {
    public static void main(String args[]) throws IOException {
        BufferedReader br = 
            new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter lines of text.");
        System.out.println("Enter 'stop' to quit.");

        String str;
        do {
            str = br.readLine();
            System.out.println(str);
        } while (!str.equals("stop"));

    }
}
