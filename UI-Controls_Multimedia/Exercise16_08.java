import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/** Enables the user to specify the location of 2 circles, 
      then determines if the circles intersect. 
  */
public class Exercise16_08 extends Application {
// Data Fields
private ParameterBox pBox1 = new ParameterBox();
private ParameterBox pBox2 = new ParameterBox();
private Circle circle1;
private Circle circle2;
private Text question = new Text("Two circles intersect?");
private Text answer = new Text("No");
private Button btn;

  /** Overrides the start method from the Application class. */
  @Override
  public void start(Stage primaryStage) {
    // Get the displaypane, parameterpane, and buttonpane
    Pane display = getDisplayPane();
    HBox parameters = getParameterHBox();
    StackPane button = getButtonPane();

    // Add all panes to a vbox
    VBox pane = new VBox(5);
    pane.setPadding(new Insets(30, 5, 5, 5));
    pane.getChildren().addAll(display, parameters, button);
    
    // Put the ititial parameters for the circles in the text fields
    getInitialParameters();

    // Assign action to the redraw button
    btn.setOnAction(e -> {
      updateParameters();
      updateAnswer();
    });

    // Create a scene and add it to the stage
    Scene scene = new Scene(pane);
    primaryStage.setResizable(false);
    primaryStage.setTitle("Circle Game");
    primaryStage.setScene(scene);
    primaryStage.show();
  }


  /** The main method. */
  public static void main(String[] args) {
    Application.launch(args);
  }


  /** Updates the answer text to 'Yes' or 'No' if the circles intersect or not. */
  private void updateAnswer() {
    // Get the distance of the two radii
    double distance = Math.hypot((circle1.getCenterX() - circle2.getCenterX()), 
                                 (circle1.getCenterY() - circle2.getCenterY()));

    // if distance is less than the sum of the radii, answer = yes; else answer = no
    if (distance < (circle1.getRadius() + circle2.getRadius())) {
      answer.setText("Yes");
    } else {
      answer.setText("No");
    }
  }


  /** Puts the initial parameters of the circles in the text fields. */
  private void getInitialParameters() {
    // Parameters for circle1
    pBox1.setTfCenterX(Double.toString(circle1.getCenterX()));
    pBox1.setTfCenterY(Double.toString(circle1.getCenterY()));
    pBox1.setTfRadius(Double.toString(circle1.getRadius()));

    // Parameters for circle2
    pBox2.setTfCenterX(Double.toString(circle2.getCenterX()));
    pBox2.setTfCenterY(Double.toString(circle2.getCenterY()));
    pBox2.setTfRadius(Double.toString(circle2.getRadius()));
  }


  /** Changes the parameters for each circle to what is displayed in the textfields. */
  private void updateParameters() {
    // Parameters for circle1
    circle1.setCenterX(Double.parseDouble(pBox1.getTfCenterX()));
    circle1.setCenterY(Double.parseDouble(pBox1.getTfCenterY()));
    circle1.setRadius(Double.parseDouble(pBox1.getTfRadius()));

    // Parameters for circle2
    circle2.setCenterX(Double.parseDouble(pBox2.getTfCenterX()));
    circle2.setCenterY(Double.parseDouble(pBox2.getTfCenterY()));
    circle2.setRadius(Double.parseDouble(pBox2.getTfRadius()));
  }


  /** Creates a Pane with 2 circles and text.
      @return The Pane 
    */
  private Pane getDisplayPane() {
    // circle1
    circle1 = new Circle(60, 65, 30);
    circle1.setStroke(Color.RED);
    circle1.setFill(Color.TRANSPARENT);
    
    // circle2
    circle2 = new Circle(210, 65, 50);
    circle2.setStroke(Color.BLUE);
    circle2.setFill(Color.TRANSPARENT);

    // Text for the question
    question.setX(55);
    question.setY(-12);

    // Text for the answer
    answer.setX(200);
    answer.setY(-12);

    // Add all nodes to the Pane
    Pane pane = new Pane();
    pane.getChildren().addAll(circle1, circle2, question, answer);
    
    // Return the Pane
    return pane;
  }


  /** Creates a StackPane with a Button.
      @return The StackPane
    */
  private StackPane getButtonPane() {
    // Create the Button
    btn = new Button("Redraw Circles");

    // Put the Button in a StackPane
    StackPane pane = new StackPane();
    pane.setPadding(new Insets(5, 5, 5, 5));
    pane.getChildren().add(btn);

    // Return the StackPane
    return pane;
  }


  /** Creates an HBox with 2 BorderPanes.
      @return The HBox
    */
  private HBox getParameterHBox() {
    // BorderPane1
    BorderPane box1 = getParameterBox(1, pBox1);
    box1.setStyle("-fx-border-color: red");

    // BorderPane2
    BorderPane box2 = getParameterBox(2, pBox2);
    box2.setStyle("-fx-border-color: blue");
    
    // Put the panes in an HBox
    HBox box = new HBox(5);
    box.getChildren().addAll(box1, box2);
    
    // Return the HBox
    return box;
  }


  /** Creates a BorderPane with a ParameterBox object and text.
      @param circleNum Used to label the circle in the text
      @param pb The ParameterBox object
      @return The BorderPane
    */
  private BorderPane getParameterBox(int circleNum, ParameterBox pb) {
    // The text
    Text text = new Text("Enter circle " + circleNum + " info:");

    // Put the text and ParameterBox in a BorderPane
    BorderPane pane = new BorderPane();
    pane.setTop(text);
    pane.setCenter(pb);
    pane.setPadding(new Insets(5, 5, 5, 5));
    
    // Return the Borderpane
    return pane;
  }


  /** Represents a user interface to enter parameters for the Circle objects. */
  private class ParameterBox extends GridPane {
    // Data Fields
    private Label lCenterX = new Label("Center X:");
    private Label lCenterY = new Label("Center Y:");
    private Label lRadius = new Label("Radius:");
    private TextField tfCenterX = new TextField();
    private TextField tfCenterY = new TextField();
    private TextField tfRadius = new TextField();

    /** Constructor */
    private ParameterBox() {
      // Set H and V gaps
      setHgap(5);
      setVgap(5);

      // Add Labels
      add(lCenterX, 0, 0);
      add(lCenterY, 0, 1);
      add(lRadius, 0, 2);
      
      // Set column width for TextFields
      tfCenterX.setPrefColumnCount(3);
      tfCenterY.setPrefColumnCount(3);
      tfRadius.setPrefColumnCount(3);

      // Set alignment for TextFields
      tfCenterX.setAlignment(Pos.CENTER_RIGHT);
      tfCenterY.setAlignment(Pos.CENTER_RIGHT);
      tfRadius.setAlignment(Pos.CENTER_RIGHT);

      // Add TextFields
      add(tfCenterX, 1, 0);
      add(tfCenterY, 1, 1);
      add(tfRadius, 1, 2);
    }


    /** Adds text to the CenterX TextField.
        @param text The text to add
      */
    private void setTfCenterX(String text) {
      tfCenterX.setText(text);
    }


    /** Adds text to the CenterY TextField.
        @param text The text to add
      */
    private void setTfCenterY(String text) {
      tfCenterY.setText(text);
    }

    
    /** Adds text to the Radius TextField.
        @param text The text to add
      */
    private void setTfRadius(String text) {
      tfRadius.setText(text);
    }


    /** Reads text from the CenterX TextField.
        @return The text
      */
    private String getTfCenterX() {
      return tfCenterX.getText();
    }


    /** Reads text from the CenterY TextField.
        @return The text
      */
    private String getTfCenterY() {
      return tfCenterY.getText();
    }


    /** Reads text from the Radius TextField.
        @return The text
      */
    private String getTfRadius() {
      return tfRadius.getText();
    }
  }
}
