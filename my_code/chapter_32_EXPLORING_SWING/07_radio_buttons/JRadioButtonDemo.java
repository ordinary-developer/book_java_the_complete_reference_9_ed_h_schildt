import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


/*
<applet code="JRadioButtonDemo" width=300 height=50>
</applet>
*/

public class JRadioButtonDemo extends JApplet implements ActionListener
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

        JRadioButton button1 = new JRadioButton("A");
        button1.addActionListener(this);
        add(button1);

        JRadioButton button2 = new JRadioButton("B");
        button2.addActionListener(this);
        add(button2);

        JRadioButton button3 = new JRadioButton("C");
        button3.addActionListener(this);
        add(button3);

        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(button1);

        label = new JLabel("Select One");
        add(label);
    }


    public void actionPerformed(ActionEvent ae) {
        label.setText("You selected " + ae.getActionCommand());
    }
}
