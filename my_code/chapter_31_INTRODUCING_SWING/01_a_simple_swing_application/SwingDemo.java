import javax.swing.*;


class SwingDemo {
    SwingDemo() {
        JFrame frame = new JFrame("A Simple Swing Application");
        frame.setSize(275, 100);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel label = new JLabel(" Swing means powerful GUIs");
        frame.add(label);

        frame.setVisible(true);
    }

    public static void main(String args[]) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run(){
                new SwingDemo();
            }
        });
    }
}
