import javafx.application.*;
import javafx.scene.*;
import javafx.stage.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.event.*;
import javafx.geometry.*;


public class TextFieldDemo extends Application {
    TextField textField;
    Label responseLabel;

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage stage) {
        stage.setTitle("Demonstrate a TextField");
        FlowPane rootNode = new FlowPane(10, 10);
        rootNode.setAlignment(Pos.CENTER);
        Scene scene = new Scene(rootNode, 230, 140);
        stage.setScene(scene);

        responseLabel = new Label();
        
        Button getTextButton = new Button("Get Search String");

        textField = new TextField();
        textField.setPromptText("Enter a search String");
        textField.setPrefColumnCount(15);
        textField.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent actionEvent) {
                responseLabel.setText("Search String: " + textField.getText());
            }
        });

        getTextButton.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent actionEvent) {
                responseLabel.setText("Search String: " + textField.getText());
            }
        });

        Separator separator = new Separator();
        separator.setPrefWidth(180);

        rootNode.getChildren().addAll(textField, getTextButton, separator, 
                                      responseLabel);

        stage.show();
    }
}
