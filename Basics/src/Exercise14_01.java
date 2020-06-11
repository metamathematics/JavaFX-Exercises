import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.geometry.Insets;


public class Exercise14_01 extends Application {
    @Override
    public void start(Stage primaryStage) {
        // Create a grid pane to hold the images
        GridPane pane = new GridPane();
        pane.setPadding(new Insets(5, 5, 5, 5));
        ImageView usa = new ImageView(new Image("us.jpg"));
        ImageView china = new ImageView(new Image("china.jpg"));
        ImageView uk = new ImageView(new Image("uk.jpg"));
        ImageView canada = new ImageView(new Image("ca.gif"));

        pane.setHgap(5);
        pane.setVgap(5);
        pane.add(usa, 0, 0);
        pane.add(china, 1, 0);
        pane.add(uk, 0, 1);
        pane.add(canada, 1, 1);

        Scene scene = new Scene(pane);
        primaryStage.setTitle("Flags");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
