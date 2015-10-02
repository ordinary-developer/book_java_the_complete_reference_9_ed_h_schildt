import java.awt.*;
import java.awt.event.*;
import java.applet.*;


/*
<applet code="FlowLayoutDemo.java" width=240 height=200>
</applet>
*/


public class FlowLayoutDemo extends Applet 
    implements ItemListener 
{
    String msg = "";
    Checkbox windows, android, solaris, mac;

    public void init() {
        setLayout(new FlowLayout(FlowLayout.LEFT));

        windows = new Checkbox("Windows", null, true);
        android = new Checkbox("Android");
        solaris = new Checkbox("Solaris");
        mac = new Checkbox("Mac OS");

        add(windows);
        add(android);
        add(solaris);
        add(mac);

        windows.addItemListener(this);
        android.addItemListener(this);
        solaris.addItemListener(this);
        mac.addItemListener(this);
    }

    public void itemStateChanged(ItemEvent ie) {
        repaint();
    }

    public void paint(Graphics g) {
        msg = "Current state: ";
        g.drawString(msg, 6, 80);

        msg = " Windows: " + windows.getState();
        g.drawString(msg, 6, 100);

        msg = " Android: " + android.getState();
        g.drawString(msg, 6, 120);

        msg = " Solaris: " + solaris.getState();
        g.drawString(msg, 6, 140);
        
        msg = " Mac: " + mac.getState();
        g.drawString(msg, 6, 160);
    }
}
