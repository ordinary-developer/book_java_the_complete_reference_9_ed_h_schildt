import java.awt.*;
import javax.swing.*;

/*
<applet code="JScrollPaneDemo" width=300 height=250>
</applet>
*/

public class JScrollPaneDemo extends JApplet {
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
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(20, 20));
        int buttonNumber = 0;

        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++) {
                panel.add(new JButton("Button " + buttonNumber));
                ++buttonNumber;
            }
        }

        JScrollPane scrollPane = new JScrollPane(panel);
        add(scrollPane, BorderLayout.CENTER);
    }
}
