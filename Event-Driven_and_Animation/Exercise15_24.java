import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

/** Animates a palindrome swing (I've never heard of a palindrome swing). */
public class Exercise15_24 extends Application {
  /** Overrides the start method from the Application class. */
  @Override
  public void start(Stage primaryStage) {
    // Create a pane
    Pane pane = new Pane();
    
    // Create an Arc object
    Arc arc = new Arc(150, 150, 60, 10, 0, -180);
    arc.setType(ArcType.OPEN);
    arc.setFill(Color.TRANSPARENT);
    arc.setStroke(Color.BLACK);
    
    // Create a circle object
    Circle circle = new Circle(10, Color.RED);
    
    // Put the arc and circle in the pane
    pane.getChildren().addAll(arc, circle);

    // Create a path transition
    PathTransition path = new PathTransition();
    path.setDuration(Duration.millis(2000));
    path.setPath(arc);
    path.setNode(circle);
    path.setCycleCount(Timeline.INDEFINITE);
    path.setAutoReverse(true);
    path.play();
    
    // Assign actions to pushing and releasing the mouse button
    pane.setOnMousePressed(e -> path.pause());
    pane.setOnMouseReleased(e -> path.play());
    
    // Create a scene and put in the stage
    Scene scene = new Scene(pane, 300, 200);
    primaryStage.setTitle("Ball Swing");
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  /** The main method. */
  public static void main(String[] args) {
    Application.launch(args);
  }
}
