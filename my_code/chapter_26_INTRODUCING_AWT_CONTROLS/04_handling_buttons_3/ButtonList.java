import java.awt.*;
import java.awt.event.*;
import java.applet.*;


/*
<applet code="ButtonList" width=250 height=150>
</applet>
*/


public class ButtonList extends Applet {
    String msg = "";

    public void init() {
        Button yes = new Button("Yes");
        Button no = new Button("No");
        Button maybe = new Button("Undecided");

        yes.addActionListener((ae) -> {
            msg = "You pressed " + ae.getActionCommand();
            repaint();
        });

        no.addActionListener((ae) -> {
            msg = "You pressed " + ae.getActionCommand();
            repaint();
        });

        maybe.addActionListener((ae) -> {
            msg = "You pressed " + ae.getActionCommand();
            repaint();
        });

        add(yes);
        add(no);
        add(maybe);
    }

    public void paint(Graphics g) {
        g.drawString(msg, 6, 100);
    }
}
