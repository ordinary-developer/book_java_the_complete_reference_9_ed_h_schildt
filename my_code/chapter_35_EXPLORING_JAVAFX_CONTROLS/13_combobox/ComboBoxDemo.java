import javafx.application.*;
import javafx.scene.*;
import javafx.stage.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;
import javafx.collections.*;
import javafx.event.*;


public class ComboBoxDemo extends Application {
    ComboBox<String> transportComboBox;
    Label responseLabel;

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage stage) {
        stage.setTitle("ComboBox Demo");
        FlowPane rootNode = new FlowPane(10, 10);
        rootNode.setAlignment(Pos.CENTER);
        Scene scene = new Scene(rootNode, 280, 120);
        stage.setScene(scene);

        responseLabel = new Label();

        ObservableList<String> transportTypes = 
            FXCollections.observableArrayList("Train", "Car", "Airplane");
        transportComboBox = new ComboBox<String>(transportTypes);
        transportComboBox.setValue("Train");

        responseLabel.setText("Selected transport is " 
                                + transportComboBox.getValue());

        transportComboBox.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent actionEvent) {
                responseLabel.setText("Selected transport is " 
                                        + transportComboBox.getValue());
            }
        });

        rootNode.getChildren().addAll(transportComboBox, responseLabel); 

        stage.show();
    }
}

