import java.awt.*;
import java.applet.*;


/*
<applet code="ColorDemo" width=300 height=200>
</applet>
*/

public class ColorDemo extends Applet {
    public void paint(Graphics gc) {
        Color c1 = new Color(255, 100, 100);
        Color c2 = new Color(100, 255, 100);
        Color c3 = new Color(100, 100, 255);

        gc.setColor(c1);
        gc.drawLine(0, 0, 100, 100);
        gc.drawLine(0, 100, 100, 0);

        gc.setColor(c2);
        gc.drawLine(40, 25, 250, 180);
        gc.drawLine(75, 90, 400, 400);

        gc.setColor(c3);
        gc.drawLine(20, 150, 400, 40);
        gc.drawLine(5, 290, 80, 19);

        gc.setColor(Color.red);
        gc.drawOval(10, 10, 50, 50);
        gc.fillOval(70, 90, 140, 100);

        gc.setColor(Color.blue);
        gc.drawOval(190, 10, 90, 30);
        gc.drawRect(10, 10, 60, 50);

        gc.setColor(Color.cyan);
        gc.drawOval(100, 10, 60, 50);
        gc.drawRoundRect(190, 10, 60, 50, 15, 15);
    }
}
