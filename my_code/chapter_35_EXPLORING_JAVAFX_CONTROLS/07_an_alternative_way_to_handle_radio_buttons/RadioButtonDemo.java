import javafx.application.*;
import javafx.scene.*;
import javafx.stage.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.event.*;
import javafx.geometry.*;


public class RadioButtonDemo extends Application {
    Label responseLabel;
    ToggleGroup toggleGroup;

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage stage) {
        stage.setTitle("Demonstrate radio buttons.");
        FlowPane rootNode = new FlowPane(10, 10);
        rootNode.setAlignment(Pos.CENTER);
        Scene scene = new Scene(rootNode, 200, 140);
        stage.setScene(scene);

        Label chooseLabel = new Label("   Select a Transport Type   ");
        responseLabel = new Label("No transport confirmed");

        Button confirmButton = new Button("Confirm transport selection");

        RadioButton trainRadioButton = new RadioButton("Train");
        RadioButton carRadioButton = new RadioButton("Car");
        RadioButton planeRadioButton = new RadioButton("Airplane");

        toggleGroup = new ToggleGroup();

        trainRadioButton.setToggleGroup(toggleGroup);
        carRadioButton.setToggleGroup(toggleGroup);
        planeRadioButton.setToggleGroup(toggleGroup);

        trainRadioButton.setSelected(true);

        confirmButton.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent actionEvent) {
                RadioButton radioButton = 
                    (RadioButton)toggleGroup.getSelectedToggle();
                responseLabel.setText(radioButton.getText() + " is confirmed");
            }
        });

        Separator separator = new Separator();
        separator.setPrefWidth(180);

        rootNode.getChildren().addAll(chooseLabel, trainRadioButton,
                                      carRadioButton, planeRadioButton,
                                      separator, confirmButton, responseLabel);

        stage.show();
    }
}

