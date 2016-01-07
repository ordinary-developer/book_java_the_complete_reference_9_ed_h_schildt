import java.awt.*;
import java.awt.event.*;
import java.applet.*;


/*
<applet code="CardLayoutDemo.java" width=300 height=100>
</applet>
*/


public class CardLayoutDemo extends Applet 
    implements ActionListener, MouseListener
{
    Checkbox windowsXP, windows7, windows8, android, solaris, mac;
    Panel osCards;
    CardLayout cardLO;
    Button Win, Other;

    public void init() {
        Win = new Button("Windows");
        Other = new Button("Other");
        add(Win);
        add(Other);

        cardLO = new CardLayout();
        osCards = new Panel();
        osCards.setLayout(cardLO);

        windowsXP = new Checkbox("Windows XP", null, true);
        windows7 = new Checkbox("Windows 7", null, false);
        windows8 = new Checkbox("Windows 8", null, false);
        android = new Checkbox("Android");
        solaris = new Checkbox("Solaris");
        mac = new Checkbox("Mac OS");

        Panel winPan = new Panel();
        winPan.add(windowsXP);
        winPan.add(windows7);
        winPan.add(windows8);

        Panel otherPan = new Panel();
        otherPan.add(android);
        otherPan.add(solaris);
        otherPan.add(mac);

        osCards.add(winPan, "Windows");
        osCards.add(otherPan, "Other");

        add(osCards);

        Win.addActionListener(this);
        Other.addActionListener(this);

        addMouseListener(this);
    }

    // [MouseListener]
    public void mousePressed(MouseEvent me) {
        cardLO.next(osCards);
    }

    public void mouseClicked(MouseEvent me) { }
    public void mouseEntered(MouseEvent me) { }
    public void mouseExited(MouseEvent me) { }
    public void mouseReleased(MouseEvent me) { }
    // end [MouseListener]

    // [ActionListener]
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == Win) {
            cardLO.show(osCards, "Windows");
        }
        else {
            cardLO.show(osCards, "Other");
        }
    }
    // end [ActionListener]
}

