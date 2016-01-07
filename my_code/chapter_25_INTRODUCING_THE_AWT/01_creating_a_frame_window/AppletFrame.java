import java.awt.*;
import java.awt.event.*;
import java.applet.*;


/*
<applet code="AppletFrame" width=300 height=50>
</applet>
*/


class SampleFrame extends Frame {
    SampleFrame(String title) {
        super(title);

        // MyWindowAdapter adapter = new MyWindowAdapter(this);
        // addWindowListener(adapter);
        addWindowListener(new MyWindowAdapter(this));
    }
}

class MyWindowAdapter extends WindowAdapter {
    SampleFrame sampleFrame;

    public MyWindowAdapter(SampleFrame sampleFrame) {
        this.sampleFrame = sampleFrame;
    }

    public void windowClosing(WindowEvent we) {
        sampleFrame.setVisible(false);
    }
}

public class AppletFrame extends Applet {
    Frame f;
    public void init() {
        f = new SampleFrame("A Frame window");

        f.setSize(250, 250);
        f.setVisible(true);
    }

    public void start() {
        f.setVisible(true);
    }

    public void stop() {
        f.setVisible(false);
    }

    public void paint(Graphics gc) {
        gc.drawString("This is an applet window", 10, 20);
    }

}
