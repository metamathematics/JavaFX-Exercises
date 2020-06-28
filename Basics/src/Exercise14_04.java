import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.FontPosture;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import java.util.Random;

public class Exercise14_04 extends Application {
  @Override
  public void start(Stage primaryStage) {
    // Create pane to hold the texts.
    HBox pane = new HBox();
    pane.setPadding(new Insets (40,5,40,5));

    Random r = new Random();

    // First text
    Text text1 = new Text(5, 50, "Pepsi");
    text1.setFont(Font.font("Times Roman", FontWeight.BOLD, FontPosture.ITALIC, 22));
    text1.setFill(new Color(r.nextDouble(), r.nextDouble(), r.nextDouble(), r.nextDouble()));
    text1.setRotate(90);
    pane.getChildren().add(text1);

    Text text2 = new Text(10, 50, "Pepsi");
    text2.setFont(Font.font("Times Roman", FontWeight.BOLD, FontPosture.ITALIC, 22));
    text2.setFill(new Color(r.nextDouble(), r.nextDouble(), r.nextDouble(), r.nextDouble()));
    text2.setRotate(90);
    pane.getChildren().add(text2);

    Text text3 = new Text(15, 50, "Pepsi");
    text3.setFont(Font.font("Times Roman", FontWeight.BOLD, FontPosture.ITALIC, 22));
    text3.setFill(new Color(r.nextDouble(), r.nextDouble(), r.nextDouble(), r.nextDouble()));
    text3.setRotate(90);
    pane.getChildren().add(text3);

    Text text4 = new Text(20, 50, "Pepsi");
    text4.setFont(Font.font("Times Roman", FontWeight.BOLD, FontPosture.ITALIC, 22));
    text4.setFill(new Color(r.nextDouble(), r.nextDouble(), r.nextDouble(), r.nextDouble()));
    text4.setRotate(90);
    pane.getChildren().add(text4);

    Text text5 = new Text(25, 50, "Pepsi");
    text5.setFont(Font.font("Times Roman", FontWeight.BOLD, FontPosture.ITALIC, 22));
    text5.setFill(new Color(r.nextDouble(), r.nextDouble(), r.nextDouble(), r.nextDouble()));
    text5.setRotate(90);
    pane.getChildren().add(text5);

    Scene scene = new Scene(pane);
    primaryStage.setTitle("Pepsi!!");
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  public static void main(String[] args) {
    Application.launch(args);
  }
}
