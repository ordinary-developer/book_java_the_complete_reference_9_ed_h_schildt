import javafx.application.*;
import javafx.scene.*;
import javafx.stage.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.event.*;
import javafx.geometry.*;
import javafx.beans.value.*;


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

        toggleGroup.selectedToggleProperty().addListener(
            new ChangeListener<Toggle>() {
                public void changed(ObservableValue<? extends Toggle> changed,
                                    Toggle oldValue, Toggle newValue)
                {
                    RadioButton radioButton = (RadioButton)newValue;
                    responseLabel.setText("selection: " + radioButton.getText());
                }
            }
        );

        // lambda way
        /*
        toggleGroup.selectedToggleProperty().addListener(
            (changed, oldValue, newValue) -> {
                RadioButton radioButton = (RadioButton)newValue;
                responseLabel.setText("selection: " + radioButton.getText());
            }
        );
        */

        trainRadioButton.setSelected(true);
        
        rootNode.getChildren().addAll(trainRadioButton, carRadioButton,
                                      planeRadioButton, responseLabel);

        stage.show();
    }
}
