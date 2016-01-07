import java.awt.*;
import java.awt.event.*;
import java.applet.*;


/*
<applet code="AnonymousInnerClassDemo" width=200 height=100>
</applet>
*/

public class AnonymousInnerClassDemo extends Applet {
    public void init() {
        addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent me) {
                showStatus("Mouse Pressed");
            }
        });
    }
}
