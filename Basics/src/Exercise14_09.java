import javafx.scene.layout.Pane;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.paint.Color;

public class Exercise14_09 extends Application {
  @Override
  public void start(Stage primaryStage) {   
    // Create a pane for the fans
    GridPane pane = new GridPane();
    pane.setPadding(new Insets(20, 20, 20, 20));
    pane.setHgap(20);
    pane.setVgap(20);

    // Create the fans
    int cirRadius = 100;
    int eliRadius = cirRadius - 5;
    int center = 100;
    int deg = 30;
    int len = 50;
    Circle[] cir = new Circle[4];
    Arc[][] arc = new Arc[4][4];
    Pane[] fan = new Pane[4];
    // For each circle, make four fan blades
    for(int i = 0; i < 4; i++) {
      cir[i] = new Circle(center, center, cirRadius);
      cir[i].setStroke(Color.BLACK);
      cir[i].setFill(Color.WHITE);
      for(int j = 0; j < 4; j++) {
        arc[i][j] = new Arc(center, center, eliRadius, eliRadius, deg, len);
        arc[i][j].setType(ArcType.ROUND);
        deg += 90;
      }
      // Add the fan to a pane
      fan[i] = new Pane();
      fan[i].getChildren().addAll(cir[i], arc[i][0], arc[i][1], arc[i][2], arc[i][3]);
    }
    
    // Add fans to the GridPane
    pane.add(fan[0], 0, 0);
    pane.add(fan[1], 0, 1);
    pane.add(fan[2], 1, 0);
    pane.add(fan[3], 1, 1);

    // Create a scene and place it in the stage
    Scene scene = new Scene(pane, 450, 450);
    primaryStage.setTitle("Four Fans");
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  public static void main(String[] args) {
    Application.launch(args);
  }
}
