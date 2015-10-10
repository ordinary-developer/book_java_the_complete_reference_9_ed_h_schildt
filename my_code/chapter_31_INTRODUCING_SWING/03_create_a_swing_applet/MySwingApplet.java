import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


/*
<applet code="MySwingApplet" width=220 height=90>
</applet>
*/

public class MySwingApplet extends JApplet {
    JButton alphaButton;
    JButton betaButton;
    JLabel label;

    public void init() {
        try {
            SwingUtilities.invokeAndWait(new Runnable() {
                public void run() {
                    makeGUI();
                }
            });
        } 
        catch (Exception exc) {
            System.out.println("Can't create because of " + exc);
        }
    }

    private void makeGUI() {
        setLayout(new FlowLayout());

        alphaButton = new JButton("Alpha");
        betaButton = new JButton("Beta");

        alphaButton.addActionListener((ae) -> {
            label.setText("Alpha was pressed.");
        });
        betaButton.addActionListener((ae) -> {
            label.setText("Beta was pressed.");
        });

        add(alphaButton);
        add(betaButton);

        label = new JLabel("Press a button.");
        add(label);
    }
}
