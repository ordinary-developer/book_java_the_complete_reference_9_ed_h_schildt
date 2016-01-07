import java.awt.*;
import java.awt.event.*;


class SampleFrame extends Frame {
    SampleFrame(String title) {
        super(title);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });
    }
}

class FileDialogDemo {
    public static void main(String args[]) {
        Frame f = new SampleFrame("File Dialog Demo");
        f.setVisible(true);
        f.setSize(100, 100);

        FileDialog fd = new FileDialog(f, "File Dialog");
        fd.setVisible(true);
    }
}
