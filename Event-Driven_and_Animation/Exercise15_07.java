import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Circle;
import javafx.scene.paint.Color;
import javafx.scene.input.MouseButton;
import javafx.stage.Stage;

/** Changes the fill color of a circle for each mouse click. */
public class Exercise15_07 extends Application {
// CirclePane object
private Circle circle;
  
  /** Default Constructor. */
  public Exercise15_07() {
    circle = new Circle(50);
    circle.setStroke(Color.BLACK);
    circle.setFill(Color.RED);
  }

  /** Overrides the start method from the Application class. */
  @Override
  public void start(Stage primaryStage) {
    // Put CirclePane in a StackPane
    StackPane pane = new StackPane();
    pane.setPadding(new Insets(50, 50, 50, 50));
    pane.getChildren().add(circle);
    
    // Assign actions to the mouse clicks
    pane.setOnMousePressed(e -> fillBlack());
    pane.setOnMouseReleased(e -> fillWhite());
    
    // Create scene and put in the stage
    Scene scene = new Scene(pane);
    primaryStage.setTitle("Circle Color");
    primaryStage.setScene(scene);
    primaryStage.show();
  }
  
  /** Colors this circle black. */
  private void fillBlack() {
    circle.setFill(Color.BLACK);
  }
  
  /** Colors this circle white. */
  private void fillWhite() {
    circle.setFill(Color.WHITE);
  }

  /** The main method. */
  public static void main(String[] args) {
    Application.launch(args);
  }
}
