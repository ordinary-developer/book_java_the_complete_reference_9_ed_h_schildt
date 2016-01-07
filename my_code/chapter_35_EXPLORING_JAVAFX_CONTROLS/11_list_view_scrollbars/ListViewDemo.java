import javafx.application.*;
import javafx.scene.*;
import javafx.stage.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;
import javafx.beans.value.*;
import javafx.collections.*;


public class ListViewDemo extends Application {
    Label responseLabel;
    final ListView<String> transportListView;

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage stage) {
        stage.setTitle("ListView demo");
        FlowPane rootNode = new FlowPane(10, 10);
        rootNode.setAlignment(Pos.CENTER);
        Scene scene = new Scene(rootNode, 200, 120);
        stage.setScene(scene);

        responseLabel = new Label("Select Transport Type");

        ObservableList<String> transportTypes = 
             FXCollections.observableArrayList("Train", "Car", "Airplane",
                                               "Bicycle", "Walking");
        //ListView<String> transportListView = new ListView(transportTypes);
        transportListView = new ListView(transportTypes);
        transportListView.setPrefSize(80, 80);
        transportListView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        MultipleSelectionModel<String> listViewSelectionModel =
            transportListView.getSelectionModel();
        
        listViewSelectionModel.selectedItemProperty().addListener(
            new ChangeListener<String>() {
                public void changed(ObservableValue<? extends String> changed, 
                                    String oldValue, String newValue) 
                {
                    String selectedItems = "";
                    ObservableList<String> selected = 
                        transportListView.getSelectionModel().getSelectedItems();
                    for (int i = 0; i < selected.size(); i++) {
                        selectedItems += "\n " + selected.get(i);
                    }
                    responseLabel.setText("All transport selected: " + selectedItems);
                }
            }
        );

        rootNode.getChildren().addAll(transportListView, responseLabel);
        stage.show();
    }
}

