import javax.swing.*;

/*
<applet code="JTabbedPaneDemo" width=400 height=100>
</applet>
*/

public class JTabbedPaneDemo extends JApplet {
    public void init() {
        try {
            SwingUtilities.invokeAndWait(
                new Runnable() {
                    public void run() {
                        makeGUI();
                    }
                 }
            );
        }
        catch (Exception exception) {
            System.out.println("Can't create because of " + exception);
        }
    }

    private void makeGUI() {
        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.addTab("Cities", new CitiesPanel());
        tabbedPane.addTab("Colors", new ColorsPanel());
        tabbedPane.addTab("Flavors", new FlavorsPanel());
        add(tabbedPane);
    }
}

class CitiesPanel extends JPanel {
    public CitiesPanel() {
        JButton cityNewYorkButton = new JButton("New York");
        add(cityNewYorkButton);

        JButton cityLondonButton = new JButton("London");
        add(cityLondonButton);

        JButton cityHongKongButton = new JButton("Hong Kong");
        add(cityHongKongButton);

        JButton cityTokyoButton = new JButton("Tokyo");
        add(cityTokyoButton);
    }
}

class ColorsPanel extends JPanel {
    public ColorsPanel() {
        add(new JCheckBox("Red"));
        add(new JCheckBox("Green"));
        add(new JCheckBox("Blue"));
    }
}

class FlavorsPanel extends JPanel {
    public FlavorsPanel() {
        JComboBox<String> flavorsComboBox = new JComboBox<String>();
        flavorsComboBox.addItem("Vanilla");
        flavorsComboBox.addItem("Chocolate");
        flavorsComboBox.addItem("Strawberry");
        add(flavorsComboBox);
    }
}
