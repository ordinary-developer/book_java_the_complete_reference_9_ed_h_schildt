import javafx.application.*;
import javafx.scene.*;
import javafx.stage.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.event.*;
import javafx.geometry.*;


public class JavaFXEventDemo extends Application {
    Label responseLabel;

    public static void main(String args[]) {
        launch(args);
    }

    public void start(Stage myStage) {
        myStage.setTitle("Demonstrate JavaFX Buttons and Events.");
        FlowPane rootNode = new FlowPane(10, 10);
        rootNode.setAlignment(Pos.CENTER);
        Scene myScene = new Scene(rootNode, 300, 100);
        myStage.setScene(myScene);

        responseLabel = new Label("Push a button");

        Button alphaButton = new Button("Alpha");
        Button betaButton = new Button("Betta");

        /*
        alphaButton.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent ae) {
                responseLabel.setText("Alpha was pressed.");
            }
        });

        betaButton.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent ae) {
                responseLabel.setText("Beta was pressed.");
            }
        });
        */
        alphaButton.setOnAction((ae) -> {
            responseLabel.setText("Alpha was pressed.");
        });

        betaButton.setOnAction((ae) -> {
            responseLabel.setText("Beta was pressed.");
        });

        rootNode.getChildren().addAll(alphaButton, betaButton, responseLabel);
        myStage.show();
    }

}
