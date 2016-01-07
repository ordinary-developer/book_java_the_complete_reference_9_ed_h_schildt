import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;


/*
<applet code="JListDemo" width=200 height=120>
</applet>
*/

public class JListDemo extends JApplet {
    JList<String> list;
    JLabel label;
    JScrollPane scrollPane;

    String[] cities = { "New York", "Chicago", "Houston",
                        "Denver", "Los Angeles", "Seattle",
                        "London", "Paris", "New Delhi",
                        "Hong Kong", "Tokyo", "Sydney" };

    public void init() {
        try {
            SwingUtilities.invokeAndWait(
                new Runnable() {
                    public void run() {
                        makeGUI();
                    }
                }
            );
        }
        catch (Exception exception) {
            System.out.println("Can't create because of " + exception);
        }
    }

    private void makeGUI() {
        setLayout(new FlowLayout());

        list = new JList<String>(cities);
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        scrollPane = new JScrollPane(list);
        scrollPane.setPreferredSize(new Dimension(120, 90));

        label = new JLabel("Choose a city");

        list.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent listSelectionEvent) {
                int index = list.getSelectedIndex();
                if (index != -1) {
                    label.setText("Current selection: " + cities[index]);
                }
                else {
                    label.setText("Choose a City");
                }
            }
        });

        add(scrollPane);
        add(label);
    }
}

