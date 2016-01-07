import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


/*
<applet code="JToggleButtonDemo" width=200 height=80>
</applet>
*/

public class JToggleButtonDemo extends JApplet {
    JLabel label;
    JToggleButton button;

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

        label = new JLabel("Button is off.");

        button = new JToggleButton("On/Off");
        button.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent ie) {
                if (button.isSelected()) {
                    label.setText("Button is on.");
                }
                else {
                    label.setText("Button is off.");
                }
            }
        });

        add(button);
        add(label);
    }
}
