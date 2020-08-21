import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/** Simulates a traffic light. */
public class Exercise16_03 extends Application {
  // Data Fields
  private RadioButton rbRed = new RadioButton("Red");
  private RadioButton rbYellow = new RadioButton("Yellow");
  private RadioButton rbGreen = new RadioButton("Green");
  private Circle[] circles = new Circle[3];
  private Rectangle rectangle = new Rectangle(27, 80);

  public Exercise16_03() {
    // Set up Circle objects
    addCircles();
    // Set up rectangle
    rectangle.setStroke(Color.BLACK);
    rectangle.setFill(Color.TRANSPARENT);

    // Add RadioButtons to a group
    ToggleGroup group = new ToggleGroup();
    rbRed.setToggleGroup(group);
    rbYellow.setToggleGroup(group);
    rbGreen.setToggleGroup(group);
  }

  /** Overrides the start method from the Application class. */
  @Override
  public void start(Stage primaryStage) {
    // Get the traffic light and pane with buttons
    Pane light = makeLight();
    HBox buttonPane = getButtonPane();

    // Put both panes in a BorderPane
    BorderPane pane = new BorderPane();
    pane.setPadding(new Insets(5, 5, 5, 5));
    pane.setCenter(light);
    pane.setBottom(buttonPane);

    // Assign action to red button
    rbRed.setOnAction(e -> {
      circles[0].setFill(Color.RED); 
      circles[1].setFill(Color.TRANSPARENT); 
      circles[2].setFill(Color.TRANSPARENT); 
    });

    // Assign action to yellow buttton
    rbYellow.setOnAction(e -> {
      circles[0].setFill(Color.TRANSPARENT); 
      circles[1].setFill(Color.YELLOW); 
      circles[2].setFill(Color.TRANSPARENT); 
    });

    // Assign action to green button
    rbGreen.setOnAction(e -> {
      circles[0].setFill(Color.TRANSPARENT); 
      circles[1].setFill(Color.TRANSPARENT); 
      circles[2].setFill(Color.GREEN); 
    });
    
    // Create a scene and put in the stage
    Scene scene = new Scene(pane);
    primaryStage.setResizable(false);
    primaryStage.setTitle("Traffic Light");
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  /** The main method. */
  public static void main(String[] args) {
    Application.launch(args);
  }

  /** Adds circles to the Circle array. */
  private void addCircles() {
    for (int i = 0; i < 3; i++) {
      circles[i] = new Circle(10);
      circles[i].setStroke(Color.BLACK);
      circles[i].setFill(Color.TRANSPARENT);
    }
  }
  
  /** Creates a traffic light. 
      @return A Pane containing the traffic light
    */
  private Pane makeLight() {
    Pane pane = new Pane();
    pane.setPadding(new Insets(0, 0, 3, 3));
    pane.getChildren().addAll(rectangle, circles[0], circles[1], circles[2]);

    rectangle.setX(85);
    rectangle.setY(5);

    circles[0].setCenterY(rectangle.getY() + 15);
    circles[1].setCenterY(circles[0].getCenterY() + (2 * circles[0].getRadius()) + 5);
    circles[2].setCenterY(circles[1].getCenterY() + (2 * circles[1].getRadius()) + 5);
    for (Circle c: circles) {
      c.setCenterX(rectangle.getX() + 13.5);
    }

    return pane;
  }

  /** Puts all RadioButtons in an HBox.
      @return An HBox of RadioButtons
    */
  private HBox getButtonPane() {
    HBox box = new HBox(5);
    box.setPadding(new Insets(5, 5, 5, 5));
    box.setAlignment(Pos.CENTER);
    box.getChildren().addAll(rbRed, rbYellow, rbGreen);
    return box;
  }
}
