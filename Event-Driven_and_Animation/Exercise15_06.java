import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.input.MouseButton;
import javafx.scene.text.Text;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/** Alternates two text messages with the click of the mouse */
public class Exercise15_06 extends Application {
// Data Fields
private int digit;
private Text text;
  
  /** Default Constructor. */
  public Exercise15_06() {
    digit = 0;
    text = new Text("Java is fun");
    text.setFont(new Font(20));
  }

  /** Overrides the start method from the Application class. */
  @Override
  public void start(Stage primaryStage) {
    // Create a StackPane and put the text in it.
    StackPane pane = new StackPane();
    pane.setPadding(new Insets(10, 50, 10, 50));
    pane.getChildren().add(text);
    
    // Assign action to mouse clicks.
    text.setOnMouseClicked(e -> flip());
    
    // Create a scene and add it to the stage.
    Scene scene = new Scene(pane);
    primaryStage.setTitle("Message");
    primaryStage.setScene(scene);
    primaryStage.show();
  }
  
  /** The main method. */
  public static void main(String[] args) {
    Application.launch(args);
  }
  
  /** Switches text between two messages. */
  private void flip() {
    if (digit == 0)
      text.setText("Java is powerful");
    else
      text.setText("Java is fun");

    digit = (digit + 1) % 2;
  }
}
