import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.scene.input.MouseButton;
import javafx.stage.Stage;

/** Displays mouse position when mouse button is clicked. */
public class Exercise15_08A extends Application {
  /** Overrides the start method from the Application class. */
  @Override
  public void start(Stage primaryStage) {
    // Create pane to hold the text.
    Pane pane = new Pane();
    Text text = new Text();
    pane.getChildren().add(text);
    
    // Assign action to mouse click.
    pane.setOnMouseClicked(e -> {
      text.setText(String.format("(%.1f, %.1f)", e.getX(), e.getY())); 
      text.setX(e.getX());
      text.setY(e.getY());
    });
    
    // Create scene and put in the stage.
    Scene scene = new Scene(pane, 600, 400);
    primaryStage.setTitle("Mouse Position");
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  /** The main method. */
  public static void main(String[] args) {
    Application.launch(args);
  }
}
