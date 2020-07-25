import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.shape.Rectangle;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/** Rotates a rectangle. */
public class Exercise15_02 extends Application {

	private Rotation rect = new Rotation();

	/** Overrides the start method from the Application class. */
	@Override
	public void start(Stage primaryStage) { 
		
		// Create button and add to a StackPane
		StackPane stackpane = new StackPane();
		stackpane.setPadding(new Insets(10, 10, 10, 10));
		stackpane.setAlignment(Pos.CENTER);
		Button btRotate = new Button("Rotate");
		stackpane.getChildren().add(btRotate);
		
		// Create and registor the handler for the button
		btRotate.setOnAction(e -> rect.rotate());

		// Add the rectangle and button to the BorderPane
		BorderPane pane = new BorderPane();
		pane.setCenter(rect);
		pane.setBottom(stackpane);

		// Create a scene and add it to the stage
		Scene scene = new Scene(pane);
		primaryStage.setTitle("Rotate");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	/** The main method. */
	public static void main(String[] args) {
		Application.launch(args);
	}

	/** Class to display and rotate a rectangle. */
	public class Rotation extends StackPane {
		private Rectangle rectangle;
		
		/** Initializes the rectangle and puts it in the StackPane */
		public Rotation() {
			rectangle = new Rectangle(25, 10, 60, 30);
			rectangle.setFill(Color.TRANSPARENT);
			rectangle.setStroke(Color.BLACK);
			setPadding(new Insets(30, 60, 30, 60));
			setAlignment(Pos.CENTER);
			getChildren().add(rectangle);
		}

		/** Rotates the rectangle 15 degrees to the right. */
		public void rotate() {
			rectangle.setRotate(rectangle.getRotate() + 15);
		}
	}
}
