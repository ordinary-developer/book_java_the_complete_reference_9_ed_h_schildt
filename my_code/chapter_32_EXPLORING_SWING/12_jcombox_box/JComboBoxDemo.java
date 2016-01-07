import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


/*
<applet code="JComboBoxDemo" width=300 height=200>
</applet>
*/

public class JComboBoxDemo extends JApplet {
    JLabel label;
    ImageIcon hourglassIcon, analogIcon, digitalIcon, stopwatchIcon;
    JComboBox<String> comboBox;

    String[] timepieces = { "hourglass", "analog", "digital", "stopwatch" };

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

        comboBox = new JComboBox<String>(timepieces);
        add(comboBox);

        comboBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                String string = (String)comboBox.getSelectedItem();
                label.setIcon(new ImageIcon(string + ".png"));
            }
        });

        label = new JLabel(new ImageIcon("hourglass.png"));        
        add(label);
    }
}
