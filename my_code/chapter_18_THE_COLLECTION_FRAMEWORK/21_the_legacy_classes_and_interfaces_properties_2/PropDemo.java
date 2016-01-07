import java.util.*;


class PropDemo {
    public static void main(String args[]) {
        Properties defList = new Properties();
        defList.put("Florida", "Tallahassee");
        defList.put("Wisconsin", "Madison");

        Properties capitals = new Properties(defList);

        capitals.put("Illinois", "Springfield");
        capitals.put("Missouri", "Jefferson City");
        capitals.put("Washington", "Olympia");
        capitals.put("California", "Sacramento");
        capitals.put("Indiana", "Indianapolis");

        Set<?> states = capitals.keySet();

        for (Object name : states) {
            System.out.println("The capitals of " +
                    name + " is " +
                    capitals.getProperty((String)name) + ".");
        }
        System.out.println();

        String str = capitals.getProperty("Florida");
        System.out.println("The capital of Florida is " + 
                str + ".");
    }
}
