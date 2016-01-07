import java.awt.*;
import java.awt.event.*;
import java.applet.*;


/*
<applet code="TextFieldDemo" width=380 height=150>
</applet>
*/


public class TextFieldDemo extends Applet 
    implements ActionListener 
{
    TextField name, pass;

    public void init() {
        Label namep = new Label("Name: ", Label.RIGHT);
        Label passp = new Label("Password: ", Label.RIGHT);
        name = new TextField(12);
        pass = new TextField(8);
        pass.setEchoChar('?');

        add(namep);
        add(name);
        add(passp);
        add(pass);

        name.addActionListener(this);
        pass.addActionListener(this);
    }

    // [ActionListener]
    public void actionPerformed(ActionEvent e) {
        repaint();
    }
    // end [ActionListener]

    public void paint(Graphics g) {
        g.drawString("Name: " + name.getText(), 6, 60);
        g.drawString("Selected text in name: "
                + name.getSelectedText(), 6, 80);
        g.drawString("password: " + pass.getText(), 6, 100);
    }
}
