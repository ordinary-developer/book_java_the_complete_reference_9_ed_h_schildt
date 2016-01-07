import java.awt.*;
import java.awt.event.*;
import java.applet.*;

/*
<applet code="ChoiceDemo.java" width=300 height=180>
</applet>
 */


public class ChoiceDemo extends Applet implements ItemListener {
    Choice os, browser;
    String msg = "";

    public void init() {
        os = new Choice();
        browser = new Choice();

        os.add("Windows");
        os.add("Android");
        os.add("Solaris");
        os.add("Mac OS");

        browser.add("Internet Explorer");
        browser.add("Firefox");
        browser.add("Chrome");

        add(os);
        add(browser);

        os.addItemListener(this);
        browser.addItemListener(this);
    }

    // [ActionListener]
    public void itemStateChanged(ItemEvent ie) {
        repaint();
    }
    // end [ActionListener]

    public void paint(Graphics g) {
        msg = "Current OS: ";
        msg += os.getSelectedItem();
        g.drawString(msg, 6, 120);
        msg = "Current Browser: ";
        msg += browser.getSelectedItem();
        g.drawString(msg, 6, 140);
    }
}
