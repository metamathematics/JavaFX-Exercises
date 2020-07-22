import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Line;
import javafx.scene.shape.Ellipse;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/*
 * A program that draws a cylinder.
 * @author Mr. Young
 */
public class Exercise14_10 extends Application {
	@Override
	public void start(Stage primaryStage) {
		// Create a pane for the drawing
		Pane pane = new Pane();

		// Cylinder top
		Ellipse ellipseTop = new Ellipse(300, 100, 100, 50);
		ellipseTop.setStroke(Color.BLACK);
		ellipseTop.setFill(Color.WHITE);
		pane.getChildren().add(ellipseTop);

		// Cylinder left
		Line lineLeft = new Line(200, 100, 200, 400);
		lineLeft.setStroke(Color.BLACK);
		pane.getChildren().add(lineLeft);
		
		// Cylinder right
		Line lineRight = new Line(400, 100, 400, 400);
		lineRight.setStroke(Color.BLACK);
		pane.getChildren().add(lineRight);

		// Dashed arc for Cylinder bottom
		Arc arcDashed = new Arc(300, 400, 100, 50, 0, 180);
		arcDashed.setType(ArcType.OPEN);
		arcDashed.setStroke(Color.BLACK);
		arcDashed.setFill(Color.WHITE);
		arcDashed.getStrokeDashArray().addAll(6.0, 21.0);
		pane.getChildren().add(arcDashed);
		
		// Solid arc for cylinder bottom
		Arc arcSolid = new Arc(300, 400, 100, 50, 0, -180);
		arcSolid.setType(ArcType.OPEN);
		arcSolid.setStroke(Color.BLACK);
		arcSolid.setFill(Color.WHITE);
		pane.getChildren().add(arcSolid);

		// Create a scene and place it in the stage
		Scene scene = new Scene(pane, 600, 500);
		primaryStage.setTitle("Cylinder");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		Application.launch(args);
	}
}
