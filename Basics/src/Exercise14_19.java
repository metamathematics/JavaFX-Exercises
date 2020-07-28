import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polyline;
import javafx.scene.text.Text;
import javafx.scene.text.Font;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


/*
 * Plots the sine and cosine functions
 * @author Mr. Young
 */
 public class Exercise14_19 extends Application {
  @Override
  public void start(Stage primaryStage) {
    // Create Pane
    Pane pane = new Pane();

    // x-axis
    Line xAxis = new Line(10, 100, 390, 100);
    Text xLabel = new Text(380, 90, "x");
    xLabel.setFont(Font.font("Times New Roman", 15));
    pane.getChildren().addAll(xAxis, xLabel);

    // label x-axis
    Text zero = new Text(202, 112, "0");
    zero.setFont(Font.font("Times New Roman", 12));

    Text pi = new Text(250, 112, "\u03c0");
    pi.setFont(Font.font("New Time Roman", 12));

    Text negPi = new Text(145, 112, "-\u03c0");
    negPi.setFont(Font.font("Times New Roman", 12));
    
    Text twoPi = new Text(300, 112, "2\u03c0");
    twoPi.setFont(Font.font("Time New Roman", 12));

    Text negTwoPi = new Text(95, 112, "-2\u03c0");
    negTwoPi.setFont(Font.font("Times New Roman", 12));

    pane.getChildren().addAll(zero, pi, negPi, twoPi, negTwoPi);

    // y-axis
    Line yAxis = new Line(200, 190, 200, 10);
    Text yLabel = new Text(210, 20, "y");
    yLabel.setFont(Font.font("Times New Roman", 15));
    pane.getChildren().addAll(yAxis, yLabel);

    // plot sine
    Polyline sine = new Polyline();
    sine.setStroke(Color.RED);
    ObservableList<Double> sinList = sine.getPoints();
    double scaleFactor = 50;
    for (int x = -170; x <= 170; x++) {
      sinList.add(x + 200.0);
      sinList.add(100 - 50 * Math.sin((x / 100.0) * 2 * Math.PI));
    }
    pane.getChildren().add(sine);

    // plot cosine
    Polyline cosine = new Polyline();
    cosine.setStroke(Color.BLUE);
    ObservableList<Double> cosList = cosine.getPoints();
    for (int x = -170; x <= 170; x++) {
      cosList.add(x + 200.0);
      cosList.add(100 - 50 * Math.cos((x / 100.0) * 2 * Math.PI));
    }
    pane.getChildren().add(cosine);

    // create scene and place in the stage
    Scene scene = new Scene(pane, 400, 200);
    primaryStage.setTitle("Sine and Cosine");
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  public static void main(String[] args) {
    Application.launch(args);
  }
 }
