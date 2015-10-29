import javafx.application.*;
import javafx.scene.*;
import javafx.stage.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.event.*;
import javafx.geometry.*;


public class RadioButtonDemo extends Application {
    Label responseLabel;

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage stage) {
        stage.setTitle("Demonstrate radio buttons");
        FlowPane rootNode = new FlowPane(10, 10);
        rootNode.setAlignment(Pos.CENTER);
        Scene scene = new Scene(rootNode, 220, 120);
        stage.setScene(scene);

        responseLabel = new Label("");

        RadioButton trainRadioButton = new RadioButton("Train");
        RadioButton carRadioButton = new RadioButton("Car");
        RadioButton planeRadioButton = new RadioButton("Airplane");

        ToggleGroup toggleGroup = new ToggleGroup();
        trainRadioButton.setToggleGroup(toggleGroup);
        carRadioButton.setToggleGroup(toggleGroup);
        planeRadioButton.setToggleGroup(toggleGroup);

        trainRadioButton.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent actionEvent) {
                responseLabel.setText("Train");
            }
        });

        carRadioButton.setOnAction((actionEvent) -> {
            responseLabel.setText("Car");
        });

        planeRadioButton.setOnAction((actionEvent) -> {
            responseLabel.setText("Airplane");
        });

        trainRadioButton.fire();
        
        rootNode.getChildren().addAll(trainRadioButton, carRadioButton,
                                      planeRadioButton, responseLabel);

        stage.show();
    }
}
