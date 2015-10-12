import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


/*
<applet code="JCheckBoxDemo" width=270 height=50>
</applet>
*/


public class JCheckBoxDemo extends JApplet implements ItemListener
{
    JLabel label;

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

        JCheckBox checkbox = new JCheckBox("C");
        checkbox.addItemListener(this);
        add(checkbox);

        checkbox = new JCheckBox("C++");
        checkbox.addItemListener(this);
        add(checkbox);

        checkbox = new JCheckBox("Java");
        checkbox.addItemListener(this);
        add(checkbox);

        checkbox = new JCheckBox("Perl");
        checkbox.addItemListener(this);
        add(checkbox);

        label = new JLabel("Select languages");
        add(label);
    }
        
    public void itemStateChanged(ItemEvent ie) {
        JCheckBox checkbox = (JCheckBox)ie.getItem();
        if (checkbox.isSelected()) {
            label.setText(checkbox.getText() + " is selected");
        }
        else {
            label.setText(checkbox.getText() + " is cleared");
        }

    }
}
