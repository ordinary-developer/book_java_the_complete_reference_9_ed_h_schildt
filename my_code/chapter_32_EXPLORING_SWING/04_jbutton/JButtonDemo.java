import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

/*
<applet code="JButtonDemo" width=250 height=750>
</applet>
*/

public class JButtonDemo extends JApplet implements ActionListener
{
    JLabel label;

    public void init() {
        try {
            SwingUtilities.invokeAndWait(new Runnable() {
                public void run() {
                    makeGUI();
                }
            });
        }
        catch (Exception exception) {
            System.out.println("Can't create because of " + exception);
        }
    }

    private void makeGUI() {
        setLayout(new FlowLayout());
        /*
        ImageIcon icon = new ImageIcon("icon.gif");
        JButton button = new JButton(icon);
        button.setActionCommand("Icon1");
        button.addActionListener(this);
        add(button);

        icon = new ImageIcon("icon.gif");
        button = new JButton(icon);
        button.setActionCommand("Icon2");
        button.addActionListener(this);
        add(button);

        icon = new ImageIcon("icon.gif");
        button = new JButton(icon);
        button.setActionCommand("Icon3");
        button.addActionListener(this);
        add(button);

        icon = new ImageIcon("icon.gif");
        button = new JButton(icon);
        button.setActionCommand("Icon4");
        button.addActionListener(this);
        add(button);
        */
        String[] icons = { "icon.gif", "icon.gif", "icon.gif", "icon.gif" };
        int index = 0;
        for (String iconElement : icons) {
            try (Formatter formatter = new Formatter()) {
                formatter.format("Icon %d", index);

                JButton button = new JButton(new ImageIcon(iconElement));
                button.setActionCommand(formatter.toString());
                button.addActionListener(this);
                add(button);

                index++;
            }
        }

        label = new JLabel("Choose a Timepiece");
        add(label);
    }
    // [ActionListener]
    public void actionPerformed(ActionEvent ae) {
        label.setText("You have pressed " + ae.getActionCommand());
    }
    // end [ActionListener]
}
