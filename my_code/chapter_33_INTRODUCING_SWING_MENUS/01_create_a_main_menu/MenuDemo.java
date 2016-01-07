import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


class MenuDemo implements ActionListener {
    JLabel label;

    public MenuDemo() {
        JFrame frame = new JFrame("Menu Demo");
        frame.setLayout(new FlowLayout());
        frame.setSize(220, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        label = new JLabel();

        JMenuBar menuBar = new JMenuBar();

        // file menu
        JMenu fileMenu = new JMenu("FILE");
        JMenuItem openItem = new JMenuItem("Open");
        JMenuItem closeItem = new JMenuItem("Close");
        JMenuItem saveItem = new JMenuItem("Save");
        JMenuItem exitItem = new JMenuItem("Exit");
        fileMenu.add(openItem);
        fileMenu.add(closeItem);
        fileMenu.add(saveItem);
        fileMenu.addSeparator();
        fileMenu.add(exitItem);

        // options menu
        JMenu optionsMenu = new JMenu("OPTIONS");
        // colors submenu
        JMenu colorsMenu = new JMenu("Colors");
        JMenuItem redColorItem = new JMenuItem("Red");
        JMenuItem greenColorItem = new JMenuItem("Green");
        JMenuItem blueColorItem = new JMenuItem("Blue");
        colorsMenu.add(redColorItem);
        colorsMenu.add(greenColorItem);
        colorsMenu.add(blueColorItem);
        optionsMenu.add(colorsMenu);
        // priority submenu
        JMenu priorityMenu = new JMenu("Priority");
        JMenuItem highItem = new JMenuItem("High");
        JMenuItem lowItem = new JMenuItem("Low");
        priorityMenu.add(highItem);
        priorityMenu.add(lowItem);
        optionsMenu.add(priorityMenu);
        // reset menu item
        JMenuItem resetItem = new JMenuItem("Reset");
        optionsMenu.addSeparator();
        optionsMenu.add(resetItem);

        // help menu
        JMenu helpMenu = new JMenu("HELP");
        JMenuItem aboutItem = new JMenuItem("About");
        helpMenu.add(aboutItem);

        menuBar.add(fileMenu);
        menuBar.add(optionsMenu);
        menuBar.add(helpMenu);

        openItem.addActionListener(this);
        closeItem.addActionListener(this);
        saveItem.addActionListener(this);
        exitItem.addActionListener(this);
        redColorItem.addActionListener(this);
        greenColorItem.addActionListener(this);
        blueColorItem.addActionListener(this);
        highItem.addActionListener(this);
        lowItem.addActionListener(this);
        resetItem.addActionListener(this);
        aboutItem.addActionListener(this);

        frame.add(label);
        frame.setJMenuBar(menuBar);
        frame.setVisible(true);

    }

    public void actionPerformed(ActionEvent actionEvent) {
        String commandString = actionEvent.getActionCommand();
        if (commandString.equals("Exit")) {
            System.exit(0);
        }
        label.setText(commandString + " Selected");
    }

    public static void main(String args[]) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new MenuDemo();
            }
        });
    }
}
