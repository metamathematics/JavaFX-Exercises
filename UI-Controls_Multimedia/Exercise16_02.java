import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/** Draws the figure indicated by the selction. */
public class Exercise16_02 extends Application {
// Data Fields
private RadioButton rbCircle = new RadioButton("Circle");
private RadioButton rbEllipse = new RadioButton("Ellipse");
private RadioButton rbRectangle = new RadioButton("Rectangle");
private CheckBox chkFill = new CheckBox("Fill");
private Circle circle = new Circle(30);
private Rectangle rectangle = new Rectangle(80, 60);;
private Ellipse ellipse = new Ellipse(40, 30);

  public Exercise16_02() {
    // Set circle colors
    circle.setStroke(Color.GREEN);
    circle.setFill(Color.TRANSPARENT);
    // Set rectangle colors
    rectangle.setStroke(Color.GREEN);
    rectangle.setFill(Color.TRANSPARENT);
    // Set ellipse colors
    ellipse.setStroke(Color.GREEN);
    ellipse.setFill(Color.TRANSPARENT);
    
    // Put radio buttons in a group
    ToggleGroup group = new ToggleGroup();
    rbCircle.setToggleGroup(group);
    rbRectangle.setToggleGroup(group);
    rbEllipse.setToggleGroup(group);
  }
  /** Overrides the start method from the Application class. */
  @Override
  public void start(Stage primaryStage) {
    // Make a pane to display the shape and a pane for the buttons
    StackPane shapePane = getShapePane();
    HBox buttonPane = getButtonPane();

    // Put both panes in a border pane
    BorderPane pane = new BorderPane();
    pane.setPadding(new Insets(5, 5, 5, 5));
    pane.setCenter(shapePane);
    pane.setBottom(buttonPane);
    pane.setAlignment(buttonPane, Pos.CENTER);

    // Assign action to the circle button
    rbCircle.setOnAction(e -> {
      shapePane.getChildren().removeAll(circle, rectangle, ellipse);
      shapePane.getChildren().add(circle);
    });
    
    // Assign action to the rectangle button
    rbRectangle.setOnAction(e -> {
      shapePane.getChildren().removeAll(circle, rectangle, ellipse);
      shapePane.getChildren().add(rectangle);
    });

    // Assign action to the ellipse button
    rbEllipse.setOnAction(e -> { 
      shapePane.getChildren().removeAll(circle, rectangle, ellipse);
      shapePane.getChildren().add(ellipse);
    });

    // Assign action to the fill check box
    chkFill.setOnAction(e -> {
      if (chkFill.isSelected()) {
        circle.setFill(Color.GREEN);
        rectangle.setFill(Color.GREEN);
        ellipse.setFill(Color.GREEN);
      } else {
        circle.setFill(Color.TRANSPARENT);
        rectangle.setFill(Color.TRANSPARENT);
        ellipse.setFill(Color.TRANSPARENT);
      }
    });
    
    // Create a scene and put in the stage
    Scene scene = new Scene(pane, 350, 150);
    primaryStage.setResizable(false);
    primaryStage.setTitle("Shape Maker");
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  /** The main method. */
  public static void main(String[] args) {
    Application.launch(args);
  }

  /** Returns the StackPane for displaying the shapes. */
  private StackPane getShapePane() {
    StackPane pane = new StackPane();
    pane.setStyle("-fx-border-color: green");
    return pane;
  }

  /** Returns an HBox of the buttons. */
  private HBox getButtonPane() {
    HBox box = new HBox(5);
    box.setPadding(new Insets(5, 5, 5, 5));
    box.setAlignment(Pos.CENTER);
    box.getChildren().addAll(rbCircle, rbRectangle, rbEllipse, chkFill);
    return box;
  }
}
