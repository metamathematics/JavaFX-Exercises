import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.scene.paint.Color;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;

/** Draws lines using the arrow keys. */
public class Exercise15_09 extends Application {
// Data Fields
/** The Pane. */
private Pane pane;
/** The pane width. */
private int width;
/** The pane height */
private int height;
/** The length of each line segment. */
private int length;
/** The number of Line objects created. */
private int numberOfLines;
/** The last Line object created. */
private Line oldLine;
 
  /** Initializes the data fields. */
  public Exercise15_09() {
    pane = new Pane();
    width = 600;
    height = 400;
    length = 10;
    numberOfLines = 0;
  }

  /** Overrides the start method from the Application class. */
  @Override
  public void start(Stage primaryStage) {
    // Assign actions to the arrow keys
    pane.setOnKeyPressed(e -> {
      if (numberOfLines == 0) {
        drawFirstLine(e.getCode());
      } else {
        drawNextLine(e.getCode());
      }
    });
    // Create a scene and put in the stage
    Scene scene = new Scene(pane, width, height);
    primaryStage.setTitle("Line Sketcher");
    primaryStage.setScene(scene);
    primaryStage.show();
    // Focuse the pane to receive key input
    pane.requestFocus();
  }
  

  /** Draws a line with starting point in the middle of the pane and 
        ending point in the direction of the KeyCode:
        DOWN, south; UP, north; RIGHT, east; LEFT, west.
      @param arrowKey The KeyCode
    */
  public void drawFirstLine(KeyCode arrowKey) {
    // Create a line object with start point in the middle of the pane
    Line firstLine = new Line();
    firstLine.setStartX(width / 2.0);
    firstLine.setStartY(height / 2.0);
    // Set the end point in the direction of the arrow key pressed
    setLineEndPoint(firstLine, arrowKey);
    // Add the line to the pane
    pane.getChildren().add(firstLine);
    // Update numberOfLines and oldLine
    numberOfLines++;
    oldLine = firstLine;
   }

  
  /** Draws a line with starting point in the middle of the pane and 
        ending point in the direction of the KeyCode:
        DOWN, south; UP, north; RIGHT, east; LEFT, west.
      @param arrowKey The KeyCode
    */
   public void drawNextLine(KeyCode arrowKey) {
     // Create a line oject with start point set to the end point of oldLine
     Line nextLine = new Line();
     nextLine.setStartX(oldLine.getEndX());
     nextLine.setStartY(oldLine.getEndY());
     // Set the end point in the direction of the arrow key pressed
     setLineEndPoint(nextLine, arrowKey);
     // Add the line to the pane
     pane.getChildren().add(nextLine);
     // Update numberOfLines and oldLine
     numberOfLines++;
     oldLine = nextLine;
   }
   

   /** Sets the end point of a line in the direction of the KeyCode:
        DOWN, south; UP, north; RIGHT, east; LEFT, west.
       @param line The line
       @param arrowKey The KeyCode
     */
   private void setLineEndPoint(Line line, KeyCode keyCode) {
    switch (keyCode) {
      case DOWN: line.setEndX(line.getStartX());
                 line.setEndY(line.getStartY() + length);
                 break;

      case UP: line.setEndX(line.getStartX());
               line.setEndY(line.getStartY() - length);
               break;

      case LEFT: line.setEndX(line.getStartX() - length);
                 line.setEndY(line.getStartY());
                 break;

      case RIGHT: line.setEndX(line.getStartX() + length);
                  line.setEndY(line.getStartY());
                  break;
    }
   }

  /** The main method. */
  public static void main(String[] args) {
    Application.launch(args);
  }
}
