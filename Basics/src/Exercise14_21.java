import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.scene.text.Font;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import java.util.Random;

/*
 * Draws two filled circles and displays their distance.
 * @author Mr. Young
 */
 public class Exercise14_21 extends Application {
	@Override
	public void start(Stage primaryStage) {
	// Create Pane
	Pane pane = new Pane();
	
	// Create circles and line connecting them
	Random r = new Random();
	Circle c1 = new Circle((r.nextDouble() * 400) + 15, (r.nextDouble() * 300) + 15, 15);
	Circle c2 = new Circle((r.nextDouble() * 400) + 15, (r.nextDouble() * 300) + 15, 15);
	Line line = new Line(c1.getCenterX(), c1.getCenterY(), c2.getCenterX(), c2.getCenterY());

	// Compute distance and convert to string
	double distance = Math.hypot((c1.getCenterX() - c2.getCenterX()), (c1.getCenterY() - c2.getCenterY()));
	String str = Double.toString(distance);

	// Create text
	Text text = new Text(((line.getStartX() + line.getEndX()) / 2) + 15, ((line.getStartY() + line.getEndY()) / 2) + 15, str);

	// Add all objects to the pane
	pane.getChildren().addAll(c1, c2, line, text);

	// Create scene and put in the stage
	Scene scene = new Scene(pane, 500, 400);
	primaryStage.setTitle("Distance of RandoBalls");
	primaryStage.setScene(scene);
	primaryStage.show();
	}

	public static void main(String[] args) {
		Application.launch(args);
	}
 }
