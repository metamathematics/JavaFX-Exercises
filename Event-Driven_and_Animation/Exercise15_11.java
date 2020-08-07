import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.paint.Color;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;

/** Moves a circle using the arrow keys. */
public class Exercise15_11 extends Application {
private Circle circle;
  
  // Initialize the circle
  public Exercise15_11() {
    circle = new Circle(100, 100, 20);
    circle.setStroke(Color.BLACK);
    circle.setFill(Color.TRANSPARENT);
  }

  /** Overrides the start method from the Application class. */
  @Override
  public void start(Stage primaryStage) {
    // Put circle in a pane
    Pane pane = new Pane();
    pane.getChildren().add(circle);
    
    // Assign actions to the arrow keys
    pane.setOnKeyPressed(e -> moveCircle(e.getCode()));
    
    // Create a scene and put it in the stage
    Scene scene = new Scene(pane, 600, 600);
    primaryStage.setTitle("Move the Circle");
    primaryStage.setScene(scene);
    primaryStage.show();
    
    // Focus the pane to recieve Key input
    pane.requestFocus();
  }

  
  /** Moves this Circle 5 pixels in the direction intended by the arrow key.
      @param arrowKey The arrow key
    */
  public void moveCircle(KeyCode arrowKey) {
    switch (arrowKey) {
      case UP: circle.setCenterY(circle.getCenterY() - 5);
               break;
      case DOWN: circle.setCenterY(circle.getCenterY() + 5);
                 break;
      case LEFT: circle.setCenterX(circle.getCenterX() - 5);
                 break;
      case RIGHT: circle.setCenterX(circle.getCenterX() + 5);
    }
  }

  /** The main method. */
  public static void main(String[] args) {
    Application.launch(args);
  }
}
