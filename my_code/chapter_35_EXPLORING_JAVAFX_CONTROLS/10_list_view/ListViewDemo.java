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
             FXCollections.observableArrayList("Train", "Car", "Airplane");
        ListView<String> transportListView = new ListView(transportTypes);
        transportListView.setPrefSize(80, 80);
        MultipleSelectionModel<String> listViewSelectionModel =
            transportListView.getSelectionModel();
        
        listViewSelectionModel.selectedItemProperty().addListener(
            new ChangeListener<String>() {
                public void changed(ObservableValue<? extends String> changed, 
                                    String oldValue, String newValue) 
                {
                    responseLabel.setText("Transport selected is " + newValue);
                }
            }
        );

        rootNode.getChildren().addAll(transportListView, responseLabel);
        stage.show();
    }
}

