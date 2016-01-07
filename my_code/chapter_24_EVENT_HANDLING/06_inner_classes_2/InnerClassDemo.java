import java.awt.*;
import java.awt.event.*;
import java.applet.*;


/*
<applet code="InnerClassDemo" width=200 height=100>
</applet>
*/


public class InnerClassDemo extends Applet {
    public void init() {
        addMouseListener(new MyMouseAdapter());        
    }

    class MyMouseAdapter extends MouseAdapter {
        public void mousePressed(MouseEvent me) {
            showStatus("Mouse Pressed");
        }
    }
}
