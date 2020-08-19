import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.stage.Stage;
import javafx.util.Duration;

/** Displays a running fan. */
public class Exercise15_28 extends Application {
  /** Override the start method from the Application class. */
  @Override
  public void start(Stage primaryStage) {   
    // BorderPane to hold the fan and buttons
    BorderPane pane = new BorderPane();
    pane.setPadding(new Insets(10, 10, 5, 10));

    int circleRadius = 100;
    int ellipseRadius = circleRadius - 5;
    int center = 115;
    int deg = 65;
    int len = 50;

    // Outer circle of fan
    Circle circle = new Circle(center, center, circleRadius);
    circle.setStroke(Color.BLACK);
    circle.setFill(Color.WHITE);
    
    // Create the fan blades
    Arc[] arc = new Arc[4];
    for(int i = 0; i < 4; i++) {
      arc[i] = new Arc(center, center, ellipseRadius, ellipseRadius, deg, len);
      arc[i].setType(ArcType.ROUND);
    }
    
    // Create the fan
    Pane fan = new Pane();
    fan.getChildren().addAll(circle, arc[0], arc[1], arc[2], arc[3]);
    
    // The shape of the path for the fan blades
    Circle fanPathShape = new Circle(center, center, circleRadius - 50);
    fanPathShape.setFill(Color.TRANSPARENT);
    fanPathShape.setStroke(Color.BLACK);
    
    // Add fan to the GridPane
    pane.setCenter(fan);
    pane.setAlignment(fan, Pos.CENTER);

    // Create path transition for each fan blade
    PathTransition[] pt = new PathTransition[4];
    int time = 500;
    for (int i = 0; i < 4; i++) {
      pt[i] = new PathTransition();
      pt[i].setDuration(Duration.millis(time));
      pt[i].setPath(fanPathShape);
      pt[i].setNode(arc[i]);
      pt[i].setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
      pt[i].setCycleCount(Timeline.INDEFINITE);
      pt[i].setDelay(Duration.millis((time / 4.0) * i));
      pt[i].play();
    }
    
    // HBox to hold the buttons
    HBox hbox = new HBox(5);
    hbox.setPadding(new Insets(10, 10, 10, 10));
    hbox.setAlignment(Pos.CENTER);
    Button btPause = new Button("Pause");
    Button btResume = new Button("Resume");
    Button btReverse = new Button("Reverse");
    hbox.getChildren().addAll(btPause, btResume, btReverse);
    
    // Add the HBox to the BorderPane
    pane.setBottom(hbox);
    pane.setAlignment(hbox, Pos.CENTER);

    // Assign action to Pause button
    btPause.setOnAction(e -> {
      for (PathTransition p: pt)
        p.pause();
    });

    // Assign action to Resume button
    btResume.setOnAction(e -> {
      for (PathTransition p: pt)
        p.play();
    });

    // Assign action to Reverse button
    btReverse.setOnAction(e -> {
      for (PathTransition p: pt)
        p.setRate(p.getRate() * -1);
    });

    // Create a scene and place it in the stage
    Scene scene = new Scene(pane);
    primaryStage.setResizable(false);
    primaryStage.setTitle("Fans");
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  /** The main method. */
  public static void main(String[] args) {
    Application.launch(args);
  }
}
