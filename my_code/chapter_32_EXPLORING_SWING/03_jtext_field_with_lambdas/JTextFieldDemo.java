import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


/*
<applet code="JTextFieldDemo" width=300 height=50>
</applet>
*/

public class JTextFieldDemo extends JApplet {
    JTextField textField;

    public void init() {
        try {
            SwingUtilities.invokeAndWait(() -> {
                makeGUI();
            });
        }
        catch (Exception exception) {
            System.out.println("Can't create because of " + exception); 
        }
    }

    private void makeGUI() {
        setLayout(new FlowLayout());
        textField = new JTextField(15);
        add(textField);
        textField.addActionListener((ae) -> {
            showStatus(textField.getText());
        });
    }
}
