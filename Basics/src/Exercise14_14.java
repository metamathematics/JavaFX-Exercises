import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

/*
 * Displays a rectanguloid. The cube grows and shrinks as the window grows or shrinks.
 * @author Mr. Young
 */
 public class Exercise14_14 extends Application {
	@Override
	public void start(Stage primaryStage) {
	 // Create pane
	 Pane pane = new Pane();

	 // Front Rectangle
	 Rectangle front = new Rectangle();
	 front.setX(5);
	 front.setY(100);
	 front.widthProperty().bind(pane.widthProperty().multiply(0.5));
	 front.heightProperty().bind(pane.heightProperty().multiply(0.5));
	 front.setStroke(Color.BLACK);
	 front.setFill(Color.WHITE);
	 pane.getChildren().add(front);

	 // Top line
	 Line l1 = new Line();
	 l1.setStartX(50);
	 l1.setStartY(45);
	 l1.endXProperty().bind(front.widthProperty().add(l1.getStartX()));
	 l1.setEndY(l1.getStartY());
	 l1.setStroke(Color.BLACK);
	 pane.getChildren().add(l1);

	 // Bottom line
	 Line l2 = new Line();
	 l2.setStartX(l1.getStartX());
	 l2.startYProperty().bind(front.heightProperty().add(l2.getStartX()));
	 l2.endXProperty().bind(front.widthProperty().add(l2.getStartX()));
	 l2.endYProperty().bind(front.heightProperty().add(l2.getStartY()));
	 l2.setStroke(Color.BLACK);
	 pane.getChildren().add(l2);

	 // Left Line
	 Line l3 = new Line();
	 l3.setStartX(l1.getStartX());
	 l3.setStartY(l1.getStartY());
	 l3.setEndX(l3.getStartX());
	 l3.endYProperty().bind(l2.startYProperty());
	 l3.setStroke(Color.BLACK);
	 pane.getChildren().add(l3);

	 // Right Line
	 Line l4 = new Line();
	 l4.startXProperty().bind(l1.endXProperty());
	 l4.setStartY(l1.getEndY());
	 l4.endXProperty().bind(l2.endXProperty());
	 l4.endYProperty().bind(l2.endYProperty());
	 l4.setStroke(Color.BLACK);
	 pane.getChildren().add(l4);

	 // Connecting lines
	 Line topLeft = new Line(front.getX(), front.getY(), l1.getStartX(), l1.getStartY());
	 topLeft.setStroke(Color.BLACK);

	 Line bottomLeft = new Line();
	 bottomLeft.setStartX(topLeft.getStartX());
	 bottomLeft.startYProperty().bind(front.heightProperty().add(front.getY()));
	 bottomLeft.setEndX(l2.getStartX());
	 bottomLeft.endYProperty().bind(l2.startYProperty());
	 bottomLeft.setStroke(Color.BLACK);

	 Line topRight = new Line();
	 topRight.startXProperty().bind(front.widthProperty().add(front.getX()));
	 topRight.setStartY(front.getY());
	 topRight.endXProperty().bind(l1.endXProperty());
	 topRight.setEndY(l1.getEndY());
	 topRight.setStroke(Color.BLACK);

	 Line bottomRight = new Line();
	 bottomRight.startXProperty().bind(front.widthProperty().add(bottomLeft.getStartX()));
	 bottomRight.startYProperty().bind(bottomLeft.startYProperty());
	 bottomRight.endXProperty().bind(l2.endXProperty());
	 bottomRight.endYProperty().bind(l2.endYProperty());
	 bottomRight.setStroke(Color.BLACK);

	 pane.getChildren().addAll(topLeft, bottomLeft, topRight, bottomRight);
	 
	 // Create scene to and put in the stage
	 Scene scene = new Scene(pane, 300, 350);
	 primaryStage.setTitle("Rectanguloid");
	 primaryStage.setScene(scene);
	 primaryStage.show();
	}

	public static void main(String[] args) {
		Application.launch(args);
	}
 }
