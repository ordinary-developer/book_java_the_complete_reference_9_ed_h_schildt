import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;


class PaintPanel extends JPanel {
    Insets insets;
    Random random;
    
    PaintPanel() {
        setBorder(BorderFactory.createLineBorder(Color.RED, 5));
        random = new Random();    
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int x, y, x2, y2;

        int height = getHeight();
        int width = getWidth();

        insets = getInsets();

        for (int i = 0; i < 10; i++) {
            x = random.nextInt(width - insets.left);
            y = random.nextInt(height - insets.bottom);
            x2 = random.nextInt(width - insets.left);
            y2 = random.nextInt(height - insets.bottom);

            g.drawLine(x, y, x2, y2);
        }
    }

}

class PaintDemo {
    JLabel label;
    PaintPanel paintPanel;

    PaintDemo() {
        JFrame frame = new JFrame("Paint Demo");
        frame.setSize(200, 150);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        paintPanel = new PaintPanel();

        frame.add(paintPanel);

        frame.setVisible(true);
    }

    public static void main(String args[]) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new PaintDemo();
            }
        });
    }

}
