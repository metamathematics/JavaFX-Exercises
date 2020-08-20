import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/** Uses radio buttons to change the color of text, and buttons to change the text position. */
public class Exercise16_01 extends Application {
// Data Fields
private Button btLeft = new Button("<=");
private Button btRight = new Button("=>");
private RadioButton rbRed = new RadioButton("Red");
private RadioButton rbYellow = new RadioButton("Yellow");
private RadioButton rbBlack = new RadioButton("Black");
private RadioButton rbOrange = new RadioButton("Orange");
private RadioButton rbGreen = new RadioButton("Green");
private Text text = new Text(75, 60, "Eat plenty of fiber");

  public Exercise16_01() {
    // Put the RadioButtons into a group
    ToggleGroup group = new ToggleGroup();
    rbRed.setToggleGroup(group);
    rbYellow.setToggleGroup(group);
    rbBlack.setToggleGroup(group);
    rbOrange.setToggleGroup(group);
    rbGreen.setToggleGroup(group);
    
    // Set the text font
    text.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 20));
    text.setStroke(Color.BLACK);
  }

  /** Overrides the start method from the Application class. */
  @Override
  public void start(Stage primaryStage) {
    // Create the color, text, and button panes
    HBox colorPane = getColorPane();
    Pane textPane = getTextPane();
    HBox buttonPane = getButtonPane();

    // Put the three panes in a BorderPane
    BorderPane pane = new BorderPane();
    pane.setPadding(new Insets(5, 5, 5, 5));
    pane.setTop(colorPane);
    pane.setCenter(textPane);
    pane.setBottom(buttonPane);
    pane.setAlignment(colorPane, Pos.CENTER);
    pane.setAlignment(textPane, Pos.CENTER);
    pane.setAlignment(buttonPane, Pos.CENTER);

    // Assign action to the Buttons
    btLeft.setOnAction(e -> text.setX(text.getX() - 5));
    btRight.setOnAction(e -> text.setX(text.getX() + 5));

    // Assign action to the RadioButtons
    rbRed.setOnAction(e -> text.setFill(Color.RED));
    rbYellow.setOnAction(e -> text.setFill(Color.YELLOW));
    rbBlack.setOnAction(e -> text.setFill(Color.BLACK));
    rbOrange.setOnAction(e -> text.setFill(Color.ORANGE));
    rbGreen.setOnAction(e -> text.setFill(Color.GREEN));

    // Create a scene an put it in the stage
    Scene scene = new Scene(pane, 375, 175);
    primaryStage.setTitle("Eat Fiber!!");
    primaryStage.setScene(scene);
    primaryStage.setResizable(false);
    primaryStage.show();
  }


  /** Sets up an HBox with two Buttons to move text.
      @return The HBox with two Buttons
    */
  private HBox getButtonPane() {
    HBox box = new HBox(5);
    box.setPadding(new Insets(5, 5, 5, 5));
    box.setAlignment(Pos.CENTER);
    box.getChildren().addAll(btLeft, btRight);
    return box;
  }


  /** Sets up a Pane with a line of text in it.
      @return The Pane with the text in it
    */
  private Pane getTextPane() {
    Pane pane = new Pane();
    pane.getChildren().add(text);
    pane.setStyle("-fx-border-color: red");
    return pane;
  }
  

  /** Sets up an HBox with RadioButtons for changing the color.
      @return The HBox of RadioButtons
    */
  private HBox getColorPane() {
    HBox box = new HBox(5);
    box.setPadding(new Insets(5, 5, 5, 5));
    box.setAlignment(Pos.CENTER);
    box.getChildren().addAll(rbRed, rbYellow, rbBlack, rbOrange, rbGreen);
    return box;
  }


  /** The main method. */
  public static void main(String[] args) {
    Application.launch(args);
  }
}
