import java.awt.*;
import java.awt.event.*;
import java.applet.*;


/*
<applet code="MouseEvents" width=300 height=100>
</applet>
*/

public class MouseEvents extends Applet 
    implements MouseListener, MouseMotionListener
{
    String msg = "";
    int mouseX = 0, mouseY = 0;

    public void init() {
        addMouseListener(this);
        addMouseMotionListener(this);
    }
    // [MouseListener] iterface implementation
    // MouseListener's method implementation
    public void mouseClicked(MouseEvent me) {
        mouseX = 0;
        mouseY = 10;
        msg = "Mouse clicked";
        repaint();
    }
    // MouseListener's method implementation
    public void mouseEntered(MouseEvent me) {
        mouseX = 0;
        mouseY = 10;
        msg = "Mouse entered.";
        repaint();
    }
        
    // MouseListener's method implementation
    public void mouseExited(MouseEvent me) {
        mouseX = 0;
        mouseY = 10;
        msg = "Mouse exited.";
        repaint();
    }

    // MouseListener's method implementation
    public void mousePressed(MouseEvent me) {
        mouseX = me.getX();
        mouseY = me.getY();
        msg = "Down";
        repaint();
    }
    // MouseListener's method implementation
    public void mouseReleased(MouseEvent me) {
        mouseX = me.getX();
        mouseY = me.getY();
        msg = "Up";
        repaint();
    }
    // end [MouseListener] region
    

    // [MouseMotionListener] interface region
    public void mouseMoved(MouseEvent me) {
        showStatus("Moving mouse at " + me.getX() + ", " + me.getY());            
    }

    public void mouseDragged(MouseEvent me) {
        mouseX = me.getX();
        mouseY = me.getY();
        msg = "*";
        showStatus("Dragging mouse at " + mouseX + ", " + mouseY);
        repaint();
    }
    // end [MouseMotionListener] region
    
    public void paint(Graphics g) {
        g.drawString(msg, mouseX, mouseY);
    }
}
