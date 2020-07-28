import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import java.util.Random;

/*
 * Connets two circles with a line.
 * @author Mr. Young
 */
 public class Exercise14_22 extends Application {
  @Override
  public void start(Stage primaryStage) {
    // Create pane
    Pane pane = new Pane();
    
    // Generate random coordinates for center and fixed radius of each circle
    Random r = new Random();
    double radius = 15.0;
    double c1X = (r.nextDouble() * 400) + radius;
    double c1Y = (r.nextDouble() * 500) + radius;
    double c2X = (r.nextDouble() * 400) + radius;
    double c2Y = (r.nextDouble() * 500) + radius;
    
    // Ensure that the circles will not overlap
    double distance = Math.hypot(c1X - c2X, c1Y - c2Y);
    while (distance <= radius + 5) {
      c1X = (r.nextDouble() * 400) + radius;
      distance = Math.hypot(c1X - c2X, c1Y - c2Y);
    }
    
    // Using centers and radius create the two circle objects
    Circle c1 = new Circle(c1X, c1Y, radius);
    Circle c2 = new Circle(c2X, c2Y, radius);
    c1.setFill(Color.WHITE);
    c1.setStroke(Color.BLACK);
    c2.setFill(Color.WHITE);
    c2.setStroke(Color.BLACK);
    
    // Label each circle
    Text text1 = new Text(c1.getCenterX(), c1.getCenterY(), "1");
    Text text2 = new Text(c2.getCenterX(), c2.getCenterY(), "2");

    // Check positions of circles
    double heightDistance = Math.abs(c1.getCenterY() - c2.getCenterY());
    boolean c1AboveC2 = c1.getCenterY() < c2.getCenterY();
    boolean c1LevelC2 = c1.getCenterY() == c2.getCenterY();
    boolean c1BeforeC2 = c1.getCenterX() < c2.getCenterX();

    // Set line coordinates according to circles' position
    double startX, startY, endX, endY;
    if (c1LevelC2 || (heightDistance <= (radius * 3))) {
      if (c1BeforeC2) {
        startX = c1.getCenterX() + radius;
        startY = c1.getCenterY();
        endX = c2.getCenterX() - radius;
        endY = c2.getCenterY();
      } else {
        startX = c2.getCenterX() + radius;
        startY = c2.getCenterY();
        endX = c1.getCenterX() - radius;
        endY = c1.getCenterY();
      }
    } else if (c1AboveC2) {
      startX = c1.getCenterX();
      startY = c1.getCenterY() + radius;
      endX = c2.getCenterX();
      endY = c2.getCenterY() - radius;
    } else {
      startX = c2.getCenterX();
      startY = c2.getCenterY() + radius;
      endX = c1.getCenterX();
      endY = c1.getCenterY() - radius;
    }
    
    // Create line object
    Line line = new Line(startX, startY, endX, endY);
    // Add all object to the pane
    pane.getChildren().addAll(c1, c2, text1, text2, line);

    // Create scene and add to the stage
    Scene scene = new Scene(pane, 500, 600);
    primaryStage.setTitle("Two Circles");
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  public static void main(String[] args) {
    Application.launch(args);
  }
 }
