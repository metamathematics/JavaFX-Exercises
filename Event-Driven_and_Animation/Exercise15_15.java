import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.paint.Color;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.MouseButton;
import javafx.stage.Stage;
import java.util.ArrayList;

/** Using mouse clicks to add and remove points. */
public class Exercise15_15 extends Application {
  /** Overrides the start method from the Application class. */
  @Override
  public void start(Stage primaryStage) {
    // Create ArrayList of Circle objects and Pane to hold circles
    ArrayList<Circle> points = new ArrayList<>();
    Pane pane = new Pane();
    
    // Assign action to mouse click
    pane.setOnMousePressed(e -> {
      // if right click, display circle
      if (e.isPrimaryButtonDown()) {
        points.add(new Circle(e.getX(), e.getY(), 5));
        Circle c = points.get(points.size() - 1);
        pane.getChildren().add(c);
        c.setStroke(Color.BLACK);
        c.setFill(Color.TRANSPARENT);
      }

      // if left click, erase circle
      if (e.isSecondaryButtonDown()) {
        for (Circle c : points) {
          if (isClose(c, e.getX(), e.getY())) {
            pane.getChildren().remove(c);
            points.remove(c);
            break;
          }
        }
      }
    });
    
    // Create scene and add to the stage
    Scene scene = new Scene(pane, 600, 300);
    primaryStage.setTitle("Point Clicker");
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  
  /** Returns true if the point (x,y) is in the Circle.
      @param c The Circle
      @param x The x coordinate of the point
      @param y The y coordinate of the point
      @return true, if (x,y) is in c; false, if not
    */
  private boolean isClose(Circle c, double x, double y) {
    double distance = Math.hypot((c.getCenterX() - x), (c.getCenterY() - y));
    return distance < c.getRadius();
  }

  /** The main method. */
  public static void main(String[] args) {
    Application.launch(args);
  }
}
