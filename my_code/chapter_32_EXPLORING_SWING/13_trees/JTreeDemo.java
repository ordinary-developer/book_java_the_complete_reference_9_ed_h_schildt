import java.awt.*;
import javax.swing.event.*;
import javax.swing.*;
import javax.swing.tree.*;


/*
<applet code="JTreeDemo" width=400 height=200>
</applet>
*/

public class JTreeDemo extends JApplet {
    JTree tree;
    JLabel label;

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
        DefaultMutableTreeNode top = new DefaultMutableTreeNode("Options");

        DefaultMutableTreeNode a = new DefaultMutableTreeNode("A");
        top.add(a);
        DefaultMutableTreeNode a1 = new DefaultMutableTreeNode("A1");
        a.add(a1);
        DefaultMutableTreeNode a2 = new DefaultMutableTreeNode("A2");
        a1.add(a2);

        DefaultMutableTreeNode b = new DefaultMutableTreeNode("B");
        top.add(b);
        DefaultMutableTreeNode b1 = new DefaultMutableTreeNode("B1");
        b.add(b1);
        DefaultMutableTreeNode b2 = new DefaultMutableTreeNode("B2");
        b1.add(b2);
        DefaultMutableTreeNode b3 = new DefaultMutableTreeNode("B3");
        b2.add(b3);

        tree = new JTree(top);
        add(new JScrollPane(tree));

        label = new JLabel();
        add(label, BorderLayout.SOUTH);

        tree.addTreeSelectionListener(new TreeSelectionListener() {
            public void valueChanged(TreeSelectionEvent treeSelectionEvent) {
                label.setText("Selection is " 
                    + treeSelectionEvent.getPath());
            }
        });
    }
}


