import javafx.application.Application;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
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
Fan fan = new Fan(50);

  /** Override the start method from the Application class. */
  @Override
  public void start(Stage primaryStage) {   
    // BorderPane to hold the fan and buttons
    BorderPane pane = new BorderPane();
    pane.setPadding(new Insets(10, 10, 5, 10));
    
    // Add fan to the GridPane
    pane.setCenter(fan);
    pane.setAlignment(fan, Pos.CENTER);

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
      fan.pause();
    });

    // Assign action to Resume button
    btResume.setOnAction(e -> {
      fan.play();
    });

    // Assign action to Reverse button
    btReverse.setOnAction(e -> {
      fan.moveFan(1);
    });

    // Create a scene and place it in the stage
    Scene scene = new Scene(pane);
    primaryStage.setResizable(false);
    primaryStage.setTitle("Fan");
    primaryStage.setScene(scene);
    primaryStage.show();
  }
  
  /** The main method. */
  public static void main(String[] args) {
    Application.launch(args);
  }

  /** Represents a fan. */
  private class Fan extends Pane {
    private int circleRadius = 100;
    private int ellipseRadius = circleRadius - 5;
    private int center = 115;
    private int deg = 65;
    private int len = 50;
    private int time;
    private int fanBit = 0;
    private Timeline animation;
    private Circle circle;
    private Arc[] arc;

    /** Creates a fan with a specified time to complete one cycle.
        @param time Time in milliseconds to complete one cycle.
      */
    private Fan(int time) {
      this.time = time;
      setUpCircle();
      createFanBlades();
      getChildren().addAll(circle, arc[0], arc[1], arc[2], arc[3]);
    
      animation = new Timeline(new KeyFrame(Duration.millis(time), e -> moveFan(0)));
      animation.setCycleCount(Timeline.INDEFINITE);
      animation.play();
    }

    /** Plays the animation. */
    private void play() {
      animation.play();
    }

    /** Pauses the animation. */
    private void pause() {
      animation.pause();
    }

    /** Sets up the fan's circle shape. */
    private void setUpCircle() {
      circle = new Circle(center, center, circleRadius);
      circle.setStroke(Color.BLACK);
      circle.setFill(Color.TRANSPARENT);
    }

    /** Creates each fan blade. */
    private void createFanBlades() {
      arc = new Arc[4];
      for(int i = 0; i < 4; i++) {
        arc[i] = new Arc(center, center, ellipseRadius, ellipseRadius, deg, len);
        arc[i].setType(ArcType.ROUND);
        deg += 90;
      }
    }
  
    /** Spins the fan blades clockwise or counterclockwise.
        @param bit If 1, the direction is reversed; if 0, the direction remains the same
      */
    private void moveFan(int bit) {
      fanBit = (fanBit + bit) % 2;
      switch (fanBit) {
        case 0: moveCounterClockwise();
                break;
        case 1: moveClockwise();
      }
    }

    /** Spins the fan blades clockwise. */
    private void moveClockwise() {
      for (Arc a: arc)
        a.setStartAngle((a.getStartAngle() + 10) % 360);
    }
    
    /** Spins the fan blades counter clockwise. */
    private void moveCounterClockwise() {
      for (Arc a: arc)
        a.setStartAngle((a.getStartAngle() - 10) % 360);
    }
  }
}
