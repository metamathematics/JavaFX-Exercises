import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.input.MouseButton;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/** Display mouse position when mouse button is pressed,
      text disappears when mouse button is released.
  */
public class Exercise15_08B extends Application {
  /** Overrides the start method from the Application class. */
  @Override
  public void start(Stage primaryStage) {
    // Create pane to hold the text.
    Pane pane = new Pane();
    Text text = new Text();
    pane.getChildren().add(text);
    
    // Assign action to mouse pressed.
    pane.setOnMousePressed(e -> {
      text.setText(String.format("(%.1f, %.1f)", e.getX(), e.getY()));
      text.setX(e.getX());
      text.setY(e.getY());
    });
    
    // Assign action to mouse release.
    pane.setOnMouseReleased(e -> text.setText(""));
    
    // Create scene and put in the stage.
    Scene scene = new Scene(pane, 600, 600);
    primaryStage.setTitle("Mouse Position");
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  /** The main method. */
  public static void main(String[] args) {
    Application.launch(args);
  }
}
