import java.awt.*;
import java.awt.event.*;
import java.applet.*;


/*
<applet code="XOR" width=400 height=200>
</applet>
*/


public class XOR extends Applet {
    int chsX = 100, chsY = 100;

    public XOR() {
        addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseMoved(MouseEvent me) {
                int x = me.getX();
                int y = me.getY();
                chsX = x - 10;
                chsY = y - 10;
                repaint();
            }
        });
    }

    public void paint(Graphics gc) {
        gc.drawLine(0, 0, 100, 100);
        gc.drawLine(0, 100, 100, 0);
        gc.setColor(Color.blue);
        gc.drawLine(40, 25, 250, 180);
        gc.drawLine(75, 90, 400, 400);
        gc.setColor(Color.green);
        gc.drawRect(10, 10, 60, 50);
        gc.fillRect(100, 10, 60, 50);
        gc.setColor(Color.red);
        gc.drawRoundRect(190, 10, 60, 50, 15, 15);
        gc.fillRoundRect(70, 90, 140, 100, 30, 40);
        gc.setColor(Color.cyan);
        gc.drawLine(20, 150, 400, 40);
        gc.drawLine(5, 290, 80, 19);

        gc.setXORMode(Color.black);
        gc.drawLine(chsX - 10, chsY, chsX + 10, chsY);
        gc.drawLine(chsX, chsY - 10, chsX, chsY + 10);
        gc.setPaintMode();
    }
}
