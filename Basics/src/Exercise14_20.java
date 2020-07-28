import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import java.util.Random;

/*
 * Draws an arrow line
 * @author Mr. Young
 */
 public class Exercise14_20 extends Application {
 Pane pane = new Pane();

  @Override
  public void start(Stage primaryStage) {
    // Random generated line
    Random r = new Random();
    double startX = r.nextDouble() * 400;
    double startY = r.nextDouble() * 300;
    double endX = r.nextDouble() * 400;
    double endY = r.nextDouble() * 300;

    double distance = Math.hypot((startX - endX), (startY - endY));
    while (distance < 1.0) {
      endX = r.nextDouble() * 400;
      distance = Math.hypot((startX - endX), (startY - endY));
    }
    
    drawArrowLine(startX, startY, endX, endY, pane);

    // Create scene and put in the stage
    Scene scene = new Scene(pane, 415, 315);
    primaryStage.setTitle("Vector");
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  public static void main(String[] args) {
    Application.launch(args);
  }
  

  public static void drawArrowLine(double startX, double startY, double endX, double endY, Pane pane) {
    Line line = new Line(startX, startY, endX, endY);
    pane.getChildren().add(line);
  }
 }
