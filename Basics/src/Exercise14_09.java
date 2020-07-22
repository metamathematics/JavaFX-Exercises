import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Arc;
import javafx.stage.Stage;


public class Exercise14_09 extends Application {
  @Override
  public void start (Stage primaryStage) {
    GridPane pane = new GridPane();
    pane.setPadding(new Insets(5,5,5,5));

    Circle circle = new Circle(100, 100, 70);
    circle.setFill(Color.BLACK);
    Arc arc = new Arc(112, 200, 45, 70, 20, 35);
    arc.setFill(Color.WHITE);
    arc.setType(ArcType.ROUND);

    pane.add(circle, 0, 0);
    pane.add(arc, 0, 0);

    Scene scene = new Scene(pane, 300, 200);
    primaryStage.setTitle("Fans");
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  public static void main (String[] args) {
    Application.launch(args);
  }
}