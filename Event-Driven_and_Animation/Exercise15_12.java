import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.input.MouseButton;
import javafx.stage.Stage;

/** Determines if the mouse pointer is inside the circle. */
public class Exercise15_12 extends Application {
  /** Overrides the start method from the Application class. */
  @Override
  public void start(Stage primaryStage) {
    // Create the circle object
    Circle circle = new Circle(100, 60, 50);
    circle.setStroke(Color.BLACK);
    circle.setFill(Color.TRANSPARENT);

    // Create the text object
    Text text = new Text();
    
    // All objects to the pane
    Pane pane = new Pane();
    pane.getChildren().addAll(circle, text);

    // Display text when mouse enteres the circle
    circle.setOnMouseEntered(e -> {
      text.setText("Mouse point is inside the circle");
      text.setX(e.getX()); 
      text.setY(e.getY());
    });
    
    // Display text when mouse exits the circle
    circle.setOnMouseExited(e -> {
      text.setText("Mouse point is outside the circle"); 
      text.setX(e.getX());
      text.setY(e.getY());
    });

    // Create scene and add to the stage
    Scene scene = new Scene(pane, 400, 120);
    primaryStage.setTitle("Is it in the circle?");
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  /** The main method. */
  public static void main(String[] args) {
    Application.launch(args);
  }
}
