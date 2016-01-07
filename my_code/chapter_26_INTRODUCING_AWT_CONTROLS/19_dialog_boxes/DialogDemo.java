import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import java.util.*;


/*
<applet code="DialogDemo" width=250 height=250>
</applet>
*/

class SampleDialog extends Dialog implements ActionListener
{
    SampleDialog(Frame parent, String title) {
        super(parent, title, false);
        setLayout(new FlowLayout());
        setSize(300, 200);

        add(new Label("Press this button:"));
        Button b;
        add(b = new Button("Cancel"));
        b.addActionListener(this);
    }

    // [ActionListener]
    public void actionPerformed(ActionEvent ae) {
        dispose();
    }
    // end [ActionListener]
    
    public void paint(Graphics g) {
        g.drawString("This is in the dialog box", 10, 70);
    }
}

class MenuFrame extends Frame {
    String msg = "";
    CheckboxMenuItem debug, test;

    MenuFrame(String title) {
        super(title);

        MenuBar mbar = new MenuBar();
        setMenuBar(mbar);

        Menu file = new Menu("File");
        MenuItem item1, item2, item3, item4, item5;
        file.add(item1 = new MenuItem("New..."));
        file.add(item2 = new MenuItem("Open..."));
        file.add(item3 = new MenuItem("Close"));
        file.add(item4 = new MenuItem("-"));
        file.add(item5 = new MenuItem("Quit..."));
        mbar.add(file);

        Menu edit = new Menu("Edit");
        MenuItem item6, item7, item8, item9;
        edit.add(item6 = new MenuItem("Cut"));
        edit.add(item7 = new MenuItem("Copy"));
        edit.add(item8 = new MenuItem("Paste"));
        edit.add(item9 = new MenuItem("-"));

        Menu sub = new Menu("Special");
        MenuItem item10, item11, item12;
        sub.add(item10 = new MenuItem("First"));
        sub.add(item11 = new MenuItem("Second"));
        sub.add(item12 = new MenuItem("Third"));
        edit.add(sub);

        debug = new CheckboxMenuItem("Debug");
        edit.add(debug);
        test = new CheckboxMenuItem("Testing");
        edit.add(test);

        mbar.add(edit);

        MyMenuHandler handler = new MyMenuHandler(this);

        item1.addActionListener(handler);
        item2.addActionListener(handler);
        item3.addActionListener(handler);
        item4.addActionListener(handler);
        item5.addActionListener(handler);
        item6.addActionListener(handler);
        item7.addActionListener(handler);
        item8.addActionListener(handler);
        item9.addActionListener(handler);
        item10.addActionListener(handler);
        item11.addActionListener(handler);
        item12.addActionListener(handler);
        debug.addItemListener(handler);
        test.addItemListener(handler);

        MyWindowAdapter adapter = new MyWindowAdapter(this);
        addWindowListener(adapter);
    }

    public void paint(Graphics g) {
        g.drawString(msg, 10, 200);

        if (debug.getState()) {
            g.drawString("Debug is on.", 10, 220);
        }
        else {
            g.drawString("Debug is off.", 10, 220);
        }

        if (test.getState()) {
            g.drawString("Testing is on.", 10, 240);
        }
        else {
            g.drawString("Testing is off.", 10, 240);
        }
    }
}

class MyWindowAdapter extends WindowAdapter {
    MenuFrame menuFrame;

    public MyWindowAdapter(MenuFrame menuFrame) {
        this.menuFrame = menuFrame;
    }

    public void windowClosing(WindowEvent we) {
        menuFrame.setVisible(false);
    }
}

class MyMenuHandler implements ActionListener, ItemListener {
    MenuFrame menuFrame;

    public MyMenuHandler(MenuFrame menuFrame) {
        this.menuFrame = menuFrame;
    }

    // [ActionListener]
    public void actionPerformed(ActionEvent ae) {
        String msg = "You selected ";
        String arg = ae.getActionCommand();

        String[] commandArray = {
            "New...", "Open...", "Close", "Quit...", "Edit", "Cut",
            "Copy", "Paste", "First", "Second", "Third", "Debug", "Testing" };
        for (String element : commandArray) {
            if (arg.equals(element)) {
                msg += element;
            }
        }

        if (arg.equals("New...")) {
            SampleDialog dialog = new
                SampleDialog(menuFrame, "New Dialog Box");
            dialog.setVisible(true);
        }

        menuFrame.msg = msg;
        menuFrame.repaint();
    }
    // end [ActionListener]
    
    // [ItemListener]
    public void itemStateChanged(ItemEvent ie) {
        menuFrame.repaint();
    }
    // end [ItemListener]
}

public class DialogDemo extends Applet {
    Frame f;

    public void init() {
        f = new MenuFrame("Menu Demo");

        int width = Integer.parseInt(getParameter("width"));
        int height = Integer.parseInt(getParameter("height"));
        
        setSize(new Dimension(width, height));

        f.setSize(width, height);
        f.setVisible(true);
    }

    public void start() {
        f.setVisible(true);
    }

    public void stop() {
        f.setVisible(false);
    }
}

