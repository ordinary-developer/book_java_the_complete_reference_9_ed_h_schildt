import javafx.application.*;
import javafx.scene.*;
import javafx.stage.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.event.*;
import javafx.geometry.*;


public class CheckBoxDemo extends Application {
    CheckBox webCheckBox;
    CheckBox desktopCheckBox;
    CheckBox mobileCheckBox;

    Label responseLabel;
    Label allTargetsLabel;

    String targets = "";

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage stage) {
        stage.setTitle("Demonstrate Checkboxes");
        FlowPane rootNode = new FlowPane(10, 10);
        rootNode.setAlignment(Pos.CENTER);
        Scene scene = new Scene(rootNode, 230, 140);
        stage.setScene(scene);

        Label headingLabel = new Label("Select Deployment Options");
        responseLabel = new Label("No Deployment Selected");
        allTargetsLabel = new Label("Target List: <none>");

        webCheckBox = new CheckBox("Web");
        desktopCheckBox = new CheckBox("Desktop");
        mobileCheckBox = new CheckBox("Mobile");

        webCheckBox.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent actionEvent) {
                if (webCheckBox.isSelected()) {
                    responseLabel.setText("Web deployment selected.");
                }
                else {
                    responseLabel.setText("Web deployment cleared.");
                }

                showAll();
            }
        });

        desktopCheckBox.setOnAction((actionEvent) -> {
            if (desktopCheckBox.isSelected()) {
                responseLabel.setText("Desktop deployment is selected.");
            }
            else {
                responseLabel.setText("Desktop deployment is cleared.");
            }
            showAll();
        });

        mobileCheckBox.setOnAction((actionEvent) -> {
            if (mobileCheckBox.isSelected()) {
                responseLabel.setText("Mobile deployment is selected");
            }
            else {
                responseLabel.setText("Mobile deployment is cleared");
            }
            
            showAll();
        });

        Separator separator = new  Separator();
        separator.setPrefWidth(200);

        rootNode.getChildren().addAll(headingLabel, separator, webCheckBox,
                                      desktopCheckBox, mobileCheckBox,
                                      responseLabel, allTargetsLabel);

        stage.show();
    }

    void showAll() {
        targets = "";
        if (webCheckBox.isSelected()) {
            targets = "Web ";
        }
        if (desktopCheckBox.isSelected()) {
            targets += "Desktop ";
        }
        if (mobileCheckBox.isSelected()) {
            targets += "Mobile";
        }
        if (targets.equals("")) {
            targets = "<none>";
        }
        allTargetsLabel.setText("Target list: " + targets);
    }
}
