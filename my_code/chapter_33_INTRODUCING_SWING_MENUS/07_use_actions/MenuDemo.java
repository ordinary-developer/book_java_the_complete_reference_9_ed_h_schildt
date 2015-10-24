import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


class MenuDemo implements ActionListener {
    JLabel label;
    JPopupMenu popupMenu;
    JToolBar toolBar;
    DebugAction setAction;
    DebugAction clearAction;
    DebugAction resumeAction;

    public MenuDemo() {
        JFrame frame = new JFrame("Menu Demo");
        //frame.setLayout(new FlowLayout());
        frame.setSize(220, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        label = new JLabel();

        ImageIcon setIcon = new ImageIcon("setIcon.png");
        ImageIcon clearIcon = new ImageIcon("clearIcon.png");
        ImageIcon resumeIcon = new ImageIcon("resumeIcon.png");

        setAction = 
            new DebugAction("Set Breakpoint",
                            setIcon,
                            KeyEvent.VK_S,
                            KeyEvent.VK_B,
                            "Set a breakpoint.");
        
        clearAction =
            new DebugAction("Clear Breakpoint",
                            clearIcon,
                            KeyEvent.VK_C,
                            KeyEvent.VK_L,
                            "Clear a breakpoint.");

        resumeAction =
            new DebugAction("Resume",
                            resumeIcon,
                            KeyEvent.VK_R,
                            KeyEvent.VK_R,
                            "Resume execution after breakpoint.");

        clearAction.setEnabled(false);

        JMenuBar menuBar = new JMenuBar();

        // file menu
        JMenu fileMenu = new JMenu("FILE");
        fileMenu.setMnemonic(KeyEvent.VK_F);
        JMenuItem openItem = new JMenuItem("Open", KeyEvent.VK_O);
        openItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, 
                                                   InputEvent.CTRL_DOWN_MASK));
        JMenuItem closeItem = new JMenuItem("Close", KeyEvent.VK_C);
        closeItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,
                                                   InputEvent.CTRL_DOWN_MASK));
        JMenuItem saveItem = new JMenuItem("Save", KeyEvent.VK_S);
        saveItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,
                                                   InputEvent.CTRL_DOWN_MASK));
        JMenuItem exitItem = new JMenuItem("Exit", KeyEvent.VK_E);
        exitItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E,
                                                   InputEvent.CTRL_DOWN_MASK));
        fileMenu.add(openItem);
        fileMenu.add(closeItem);
        fileMenu.add(saveItem);
        fileMenu.addSeparator();
        fileMenu.add(exitItem);


        // options menu
        JMenu optionsMenu = new JMenu("OPTIONS");
        // colors submenu
        JMenu colorsMenu = new JMenu("Colors");
        JCheckBoxMenuItem redColorItem = new JCheckBoxMenuItem("Red");
        JCheckBoxMenuItem greenColorItem = new JCheckBoxMenuItem("Green");
        JCheckBoxMenuItem blueColorItem = new JCheckBoxMenuItem("Blue");
        colorsMenu.add(redColorItem);
        colorsMenu.add(greenColorItem);
        colorsMenu.add(blueColorItem);
        optionsMenu.add(colorsMenu);
        // priority submenu
        JMenu priorityMenu = new JMenu("Priority");
        JRadioButtonMenuItem highItem = new JRadioButtonMenuItem("High");
        JRadioButtonMenuItem lowItem = new JRadioButtonMenuItem("Low");
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(highItem);
        buttonGroup.add(lowItem);

        priorityMenu.add(highItem);
        priorityMenu.add(lowItem);
        optionsMenu.add(priorityMenu);
        // debug menu
        JMenu debugMenu = new JMenu("Debug");
        JMenuItem setBreakPointMenuItem = new JMenuItem(setAction);
        JMenuItem clearBreakPointMenuItem = new JMenuItem(clearAction);
        JMenuItem resumeBreakPointMenuItem = new JMenuItem(resumeAction);
        debugMenu.add(setBreakPointMenuItem);
        debugMenu.add(clearBreakPointMenuItem);
        debugMenu.add(resumeBreakPointMenuItem);
        optionsMenu.add(debugMenu);
        // reset menu item
        JMenuItem resetItem = new JMenuItem("Reset");
        optionsMenu.addSeparator();
        optionsMenu.add(resetItem);

        // help menu
        JMenu helpMenu = new JMenu("HELP");
        ImageIcon aboutIcon = new ImageIcon("AboutIcon.gif");
        JMenuItem aboutItem = new JMenuItem("About", aboutIcon);
        aboutItem.setToolTipText("Info about the MenuDemo program.");
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

        popupMenu = new JPopupMenu();
        JMenuItem cutItem = new JMenuItem("Cut");
        JMenuItem copyItem = new JMenuItem("Copy");
        JMenuItem pasteItem = new JMenuItem("Paste");
        popupMenu.add(cutItem);
        popupMenu.add(copyItem);
        popupMenu.add(pasteItem);

        frame.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent mouseEvent) {
                if (mouseEvent.isPopupTrigger()) {
                    popupMenu.show(mouseEvent.getComponent(),
                        mouseEvent.getX(), mouseEvent.getY());
                }
            }
            public void mouseReleased(MouseEvent mouseEvent) {
                if (mouseEvent.isPopupTrigger()) {
                    popupMenu.show(mouseEvent.getComponent(),
                        mouseEvent.getX(), mouseEvent.getY());
                }
            }
        });

        frame.add(label, BorderLayout.CENTER);

        // adding a toolbar            
        toolBar = new JToolBar("Breakpoints");

        JButton setButton = new JButton(setAction);
        JButton clearButton = new JButton(clearAction);
        JButton resumeButton = new JButton(resumeAction);

        setButton.addActionListener(this);
        clearButton.addActionListener(this);
        resumeButton.addActionListener(this);

        toolBar.add(setButton);
        toolBar.add(clearButton);
        toolBar.add(resumeButton);

        frame.add(toolBar, BorderLayout.NORTH);
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

    class DebugAction extends AbstractAction {
        public DebugAction(String name, Icon icon, int mnemonic,
                int accelerator, String toolTip) 
        {
            super(name, icon);
            putValue(ACCELERATOR_KEY,
                    KeyStroke.getKeyStroke(accelerator,
                                            InputEvent.CTRL_DOWN_MASK));
            putValue(MNEMONIC_KEY, new Integer(mnemonic));
            putValue(SHORT_DESCRIPTION, toolTip);
        }

        public void actionPerformed(ActionEvent actionEvent) {
            String commandString = actionEvent.getActionCommand();

            label.setText(commandString + " Selected");

            if (commandString.equals("Set Breakpoint")) {
                clearAction.setEnabled(true);
                setAction.setEnabled(false);
            }
            else if (commandString.equals("Clear Breakpoint")) {
                clearAction.setEnabled(false);
                setAction.setEnabled(true);
            }
        }
    }

    public static void main(String args[]) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new MenuDemo();
            }
        });
    }
}
