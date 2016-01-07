import javafx.application.*;
import javafx.scene.*;
import javafx.stage.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.event.*;
import javafx.geometry.*;
import javafx.scene.image.*;


public class ButtonImageDemo extends Application {
    Label responseLabel;

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage stage) {
        stage.setTitle("Use images with buttons");
        FlowPane rootNode = new FlowPane(10, 10);
        rootNode.setAlignment(Pos.CENTER);
        Scene scene = new Scene(rootNode, 250, 450);
        stage.setScene(scene);
        
        responseLabel = new Label("Push a button");

        Button hourGlassButton =
            new Button("HourGlass", new ImageView("hourGlassImage.png"));
        Button analogClockButton =
            new Button("AnalogClock", new ImageView("analogClockImage.png"));
        hourGlassButton.setContentDisplay(ContentDisplay.TOP);
        analogClockButton.setContentDisplay(ContentDisplay.TOP);

        hourGlassButton.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent actionEvent) {
                responseLabel.setText("HourGlass is pressed.");
            }
        });

        analogClockButton.setOnAction((actionEvent) -> {
            responseLabel.setText("AnaloClock was pressed.");
        });

        rootNode.getChildren().addAll(
                hourGlassButton, analogClockButton, responseLabel);

        stage.show();
    }
}
