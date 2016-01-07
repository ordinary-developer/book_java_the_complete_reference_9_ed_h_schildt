import javafx.application.*;
import javafx.scene.*;
import javafx.stage.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.event.*;
import javafx.geometry.*;


public class ScrollPaneDemo extends Application {
    ScrollPane scrollPane;

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage stage) {
        stage.setTitle("Demonstrate a ScrollPane");
        FlowPane rootNode = new FlowPane(10, 10);
        rootNode.setAlignment(Pos.CENTER);
        Scene scene = new Scene(rootNode, 200, 200);
        stage.setScene(scene);

        Label scrollLabel = 
            new Label("A ScrollPane streamlines the process of \n" +
                      "adding scroll bars to a window whose\n" +
                      "contents exceed the window's dimensions.\n" +
                      "It also enables a control to fit a\n" +
                      "smaller space that it otherwise would.\n" +
                      "As such, it often provides a superior\n" +
                      "aprroach over using individual scroll bars.");

        scrollPane = new ScrollPane(scrollLabel);
        scrollPane.setPrefViewportWidth(130);
        scrollPane.setPrefViewportHeight(80);
        scrollPane.setPannable(true);

        Button resetButton = new Button("Reset scroll bar positions");
        resetButton.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent ae) {
                scrollPane.setVvalue(0);
                scrollPane.setHvalue(0);
            }
        });

        rootNode.getChildren().addAll(scrollPane, resetButton);

        stage.show();
    }
}
