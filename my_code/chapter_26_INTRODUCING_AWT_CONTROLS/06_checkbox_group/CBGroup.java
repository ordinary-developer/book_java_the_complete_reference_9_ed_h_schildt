import java.awt.*;
import java.awt.event.*;
import java.applet.*;

import java.util.Formatter;

/*
<applet code="CBGroup" width=240 height=200>
</applet>
*/


public class CBGroup extends Applet implements ItemListener {
    String msg = "";
    Checkbox windows, android, solaris, mac;
    CheckboxGroup cbg;

    public void init() {
        cbg = new CheckboxGroup();
        windows = new Checkbox("Windows", cbg, true);
        android = new Checkbox("Android", cbg, false);
        solaris = new Checkbox("Solaris", cbg, false);
        mac = new Checkbox("Mac OS", cbg, false);

        add(windows);
        add(android);
        add(solaris);
        add(mac);

        windows.addItemListener(this);
        android.addItemListener(this);
        solaris.addItemListener(this);
        mac.addItemListener(this);
    }

    // [ItemListener] 
    public void itemStateChanged(ItemEvent ie) {
        repaint();
    }
    // end [ItemListener]
    
    public void paint(Graphics g) {
        try (Formatter formatter = new Formatter()) {
            formatter.format("Current selection: %s",
                    cbg.getSelectedCheckbox().getLabel());
            g.drawString(formatter.toString(), 6, 100);
        }
    }
}
