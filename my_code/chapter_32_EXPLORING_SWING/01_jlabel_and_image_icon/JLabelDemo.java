import java.awt.*;
import javax.swing.*;


/*
<applet code="JLabelDemo" width=250 height=200>
</applet>
*/

public class JLabelDemo extends JApplet {
    public void init() {
        try {
            // new utilities
            SwingUtilities.invokeAndWait(() -> {
                makeGUI();
            });
            // old version
            /*
            SwingUtilities.invokeAndWait(
                new Runnable() {
                    public void run() { 
                        makeGUI();
                    }
                }
            );*/
        }
        catch (Exception exception) {
            System.out.println("Can't create because of " + exception);
        }
    }

    private void makeGUI() {
        ImageIcon imageIcon = new ImageIcon("icon.gif");            
        JLabel label = new JLabel("Icon", imageIcon, JLabel.CENTER);
        add(label);
    }
}
