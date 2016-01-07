import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/*
<applet code="JTextFieldDemo" width=300 height=500>
</applet>
*/

public class JTextFieldDemo extends JApplet {
    JTextField textField;

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

        textField = new JTextField(15);
        add(textField);
        textField.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                showStatus(textField.getText());
            }
        });
    }
}
