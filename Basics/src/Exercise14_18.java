import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polyline;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.collections.ObservableList;


/*
 * Plots the square function.
 * @author Mr. Young
 */
 public class Exercise14_18 extends Application {
	@Override
	public void start(Stage primaryStage) {
		// Create pane
		Pane pane = new Pane();

		// x-axis
		Line xAxis = new Line(5, 200, 420, 200);
		xAxis.setStroke(Color.BLACK);
		Line xArrow1 = new Line(410, 190, 420, 200);
		Line xArrow2 = new Line(410, 210, 420, 200);
		Text xLabel = new Text(400, 175, "x");
		xLabel.setFont(Font.font("Times New Roman", 15));
		pane.getChildren().addAll(xAxis, xArrow1, xArrow2, xLabel);

		// y-axis
		Line yAxis = new Line(200, 245, 200, 10);
		yAxis.setStroke(Color.BLACK);
		Line yArrow1 = new Line(190, 20, 200, 10);
		Line yArrow2 = new Line(210, 20, 200, 10);
		Text yLabel = new Text(225, 30, "y");
		yLabel.setFont(Font.font("Times New Roman", 15));
		pane.getChildren().addAll(yAxis, yArrow1, yArrow2, yLabel);

		// Graph the function
		Polyline polyline = new Polyline();
		pane.getChildren().add(polyline);
		polyline.setStroke(Color.BLUE);
		ObservableList<Double> list = polyline.getPoints();
		double scaleFactor = 0.0125;
		for (int x = -100; x <= 100; x++) {
			list.add(x + 200.0);
			list.add(scaleFactor * -Math.pow(x, 2) + 200);
		}

		// Create scene and put in stage
		Scene scene = new Scene(pane, 425, 250);
		primaryStage.setTitle("The Square Function");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		Application.launch(args);
	}
 }
