import java.awt.*;
import java.awt.event.*;
import java.applet.*;


/*
<applet code="ResizeMe" width=200 height=200>
</applet>
*/


public class ResizeMe extends Applet {
    final int inc = 25;
    int max = 500;
    int min = 200;
    Dimension d; 

    public ResizeMe() {
        addMouseListener(new MouseAdapter() {
            public void mouseReleased(MouseEvent me) {
                int w = (d.width + inc) > max ? min : (d.width + inc);
                int h = (d.height + inc) > max ? min : (d.height + inc);
                setSize(new Dimension(w, h));
            }
        });
    }

    public void paint(Graphics gc) {
        d = getSize();

        gc.drawLine(0, 0, d.width - 1, d.height - 1);
        gc.drawLine(0, d.height - 1, d.width - 1, 0);
        gc.drawRect(0, 0, d.width - 1, d.height - 1);
    }
}
