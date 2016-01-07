import java.awt.*;
import java.awt.event.*;
import java.applet.*;


/*
<applet code="ListDemo" width=300 height=180>
</applet>
*/


public class ListDemo extends Applet implements ActionListener {
    List os, browser;
    String msg = "";

    public void init() {
        os = new List(4, true);
        browser = new List(4, false);

        os.add("Windows");
        os.add("Android");
        os.add("Solaris");
        os.add("Mac OS");

        browser.add("IE");
        browser.add("Firefox");
        browser.add("Chrome");

        browser.select(1);

        add(os);
        add(browser);

        os.addActionListener(this);
        browser.addActionListener(this);
    }

    // [ActionListener]
    public void actionPerformed(ActionEvent ae) {
        repaint();
    }
    // end [ActionListener]

    public void paint(Graphics g) {
        int[] idx;

        msg = "Current OS: ";
        idx = os.getSelectedIndexes();
        for (int i = 0; i < idx.length; i++) {
            msg += os.getItem(idx[i]) + " ";
        }
        g.drawString(msg, 6, 120);
        msg = "Current Browser: ";
        msg += browser.getSelectedItem();
        g.drawString(msg, 6, 140);
    }
}
