import javafx.application.*;
import javafx.scene.*;
import javafx.stage.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.event.*;
import javafx.beans.value.*;
import javafx.geometry.*;


public class TreeViewDemo extends Application {
    Label responseLabel;

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage stage) {
        stage.setTitle("Demonstrate a TreeView");
        FlowPane rootNode = new FlowPane(10, 10);
        rootNode.setAlignment(Pos.CENTER);
        Scene scene = new Scene(rootNode, 310, 460);
        stage.setScene(scene);

        responseLabel = new Label("No Selection");

        TreeItem<String> rootTreeItem = new TreeItem<String>("Food");

        TreeItem<String> fruitTreeItem = new TreeItem<String>("Fruit");
        TreeItem<String> applesTreeItem = new TreeItem<String>("Apples");
        applesTreeItem.getChildren().add(new TreeItem<String>("Fuji"));
        applesTreeItem.getChildren().add(new TreeItem<String>("Winesap"));
        applesTreeItem.getChildren().add(new TreeItem<String>("Jonathan"));
        fruitTreeItem.getChildren().add(applesTreeItem);
        fruitTreeItem.getChildren().add(new TreeItem<String>("Pears"));
        fruitTreeItem.getChildren().add(new TreeItem<String>("Oranges"));
        rootTreeItem.getChildren().add(fruitTreeItem);

        TreeItem<String> vegetablesTreeItem = 
            new TreeItem<String>("Vegetables");
        vegetablesTreeItem.getChildren().add(new TreeItem<String>("Corn"));
        vegetablesTreeItem.getChildren().add(new TreeItem<String>("Peas"));
        vegetablesTreeItem.getChildren().add(new TreeItem<String>("Broccoli"));
        vegetablesTreeItem.getChildren().add(new TreeItem<String>("Beans"));
        rootTreeItem.getChildren().add(vegetablesTreeItem);

        TreeItem<String> nutsTreeItem = new TreeItem<String>("Nuts");
        nutsTreeItem.getChildren().add(new TreeItem<String>("Walnuts"));
        nutsTreeItem.getChildren().add(new TreeItem<String>("Peanuts"));
        nutsTreeItem.getChildren().add(new TreeItem<String>("Pecans"));
        rootTreeItem.getChildren().add(nutsTreeItem);

        TreeView<String> foodTreeView = new TreeView<String>(rootTreeItem);
        MultipleSelectionModel<TreeItem<String>> treeViewSelectionModel = 
            foodTreeView.getSelectionModel();
        treeViewSelectionModel.selectedItemProperty().addListener(
                new ChangeListener<TreeItem<String>>() {
                    public void changed(
                        ObservableValue<? extends TreeItem<String>> changed,
                        TreeItem<String> oldValue, TreeItem<String> newValue)
                    {
                        if (newValue != null) {
                            String path = newValue.getValue();
                            TreeItem<String> temp = newValue.getParent();
                            while (temp != null) {
                                path = temp.getValue() + " -> " + path;
                                temp = temp.getParent();
                            }
                            responseLabel.setText("Selection is "  
                                                  + newValue.getValue() 
                                                  + "\nComplete path is " 
                                                  + path);
                        }
                    }
                }
        );

        rootNode.getChildren().addAll(foodTreeView, responseLabel);

        stage.show();
    }
}
