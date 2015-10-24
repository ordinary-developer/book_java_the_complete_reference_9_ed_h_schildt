import javafx.application.*;
import javafx.scene.*;
import javafx.stage.*;
import javafx.scene.layout.*;
import javafx.geometry.*;
import javafx.scene.image.*;


public class ImageDemo extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage stage) {
        stage.setTitle("Display an Image");
        FlowPane rootNode = new FlowPane();
        rootNode.setAlignment(Pos.CENTER);
        Scene scene = new Scene(rootNode, 300, 200);
        stage.setScene(scene);

        Image image = new Image("image.png");
        ImageView imageView = new ImageView(image);

        rootNode.getChildren().add(imageView);

        stage.show();
    }
}
