import javafx.application.*;
import javafx.scene.*;
import javafx.stage.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.event.*;
import javafx.geometry.*;


public class ToggleButtonDemo extends Application {
    ToggleButton  onOfToggleButton;
    Label responseLabel;

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage stage) {
        stage.setTitle("Demonstrate a Toggle Button");
        FlowPane rootNode = new FlowPane(10, 10);
        rootNode.setAlignment(Pos.CENTER);
        Scene scene = new Scene(rootNode, 220, 120);
        stage.setScene(scene);

        responseLabel = new Label("Push the button");
        onOfToggleButton = new ToggleButton("On/Off");
        onOfToggleButton.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent actionEvent) {
                if (onOfToggleButton.isSelected()) {
                    responseLabel.setText("Button is on.");
                }
                else {
                    responseLabel.setText("Button is off.");
                }
            }
        });

        rootNode.getChildren().addAll(onOfToggleButton, responseLabel);

        stage.show();
    }
}

