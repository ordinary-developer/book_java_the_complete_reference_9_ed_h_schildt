import java.applet.*;
import java.awt.*;


/*
<applet code="MultiLine" width=300 height=100>
</applet>
 */


public class MultiLine extends Applet {
    int curX = 0, curY = 0;

    public void init() {
        Font f = new Font("SansSerif", Font.PLAIN, 12);
        setFont(f);
    }

    public void paint(Graphics g) {
        FontMetrics fm = g.getFontMetrics();

        nextLine("This is on line one.", g);
        nextLine("This is on line two.", g);
        sameLine(" This is on same line.", g);
        sameLine(" This, too.", g);
        nextLine("This is on line three.", g);
        curX = curY = 0;
    }

    void nextLine(String s, Graphics g) {
        FontMetrics fm = g.getFontMetrics();

        curY += fm.getHeight();
        curX = 0;
        g.drawString(s, curX, curY);
        curX = fm.stringWidth(s);
    }

    void sameLine(String s, Graphics g) {
        FontMetrics fm = g.getFontMetrics();

        g.drawString(s, curX, curY);
        curX += fm.stringWidth(s);
    }
}

