import java.awt.*;
import java.awt.event.*;
import java.applet.*;


/*
<applet code="SimpleKey" width=300 height=100>
</applet>
*/


public class SimpleKey extends Applet implements KeyListener {
    String msg="";
    int X = 10, Y = 20;

    public void init() {
        addKeyListener(this);
    }


    // [KeyListener] interface implementation
    public void keyPressed(KeyEvent ke) {
        showStatus("Key Down");

        int key = ke.getKeyCode();
        switch (key) {
            case KeyEvent.VK_F1:
                msg += "<F1>";
                break;
            case KeyEvent.VK_F2:
                msg += "<F2>";
                break;
            case KeyEvent.VK_F3:
                msg += "<F3>";
                break;
            case KeyEvent.VK_PAGE_DOWN:
                msg += "<PgDn>";
                break;
            case KeyEvent.VK_PAGE_UP:
                msg += "<PgUp>";
                break;
            case KeyEvent.VK_LEFT:
                msg += "<Left Arrow>";
                break;
            case KeyEvent.VK_RIGHT:
                msg += "<Right Arrow>";
                break;
        }
        repaint();
    }

    public void keyReleased(KeyEvent ke) {
        showStatus("Key up");
    }

    public void keyTyped(KeyEvent ke) {
        msg += ke.getKeyChar();
        repaint();
    }
    // end [KeyListener] region
    
    
    public void paint(Graphics gc) {
        gc.drawString(msg, X, Y);
    }
}
