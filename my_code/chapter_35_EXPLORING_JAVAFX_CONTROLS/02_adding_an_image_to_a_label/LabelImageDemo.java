import javafx.application.*;
import javafx.scene.*;
import javafx.stage.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;
import javafx.scene.image.*;


public class LabelImageDemo extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage stage) {
        stage.setTitle("Use an Image in a Label");
        FlowPane rootNode = new FlowPane();
        rootNode.setAlignment(Pos.CENTER);
        Scene scene = new Scene(rootNode, 300, 200);
        stage.setScene(scene);

        ImageView imageView = new ImageView("image.png");
        Label label = new Label("Image", imageView);

        rootNode.getChildren().add(label);

        stage.show();
    }
}
