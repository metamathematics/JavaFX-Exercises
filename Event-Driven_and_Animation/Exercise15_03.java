import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.shape.Circle;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/** Moves a ball left, right , up, and down. */
public class Exercise15_03 extends Application {
//public Ball ball = new Ball();

	@Override
	public void start(Stage primaryStage) {
		int screenWidth = 300;
		int screenHeight = 200;
		Ball ball = new Ball(screenWidth, screenHeight, 20);

		HBox box = new HBox(2);
		box.setPadding(new Insets(5, 5, 5, 5));
		box.setAlignment(Pos.CENTER);
		Button btLeft = new Button("Left");
		Button btRight = new Button("Right");
		Button btUp = new Button("Up");
		Button btDown = new Button("Down");
		box.getChildren().addAll(btLeft, btRight, btUp, btDown);

		btLeft.setOnAction(e -> ball.moveLeft());
		btRight.setOnAction(e -> ball.moveRight(screenWidth));
		btUp.setOnAction(e -> ball.moveUp());
		btDown.setOnAction(e -> ball.moveDown(screenHeight));

		BorderPane pane = new BorderPane();
		pane.setCenter(ball);
		pane.setBottom(box);
		pane.setAlignment(box, Pos.CENTER);

		Scene scene = new Scene(pane, screenWidth, screenHeight);
		primaryStage.setTitle("Move Ball");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		Application.launch(args);
	}


	public class Ball extends Pane {
		private Circle circle;

		public Ball(int width, int height, double radius) {
			circle = new Circle(width / 2.0, height / 2.0, radius, Color.TRANSPARENT);
			circle.setStroke(Color.BLACK);
			getChildren().add(circle);
		}

		public void moveLeft() {
			circle.setCenterX(circle.getCenterX() - 5);
			if (circle.getCenterX() <= circle.getRadius()) {
				circle.setCenterX(circle.getRadius() + 5);
			}
		}

		public void moveRight(int width) {
			circle.setCenterX(circle.getCenterX() + 5);
			if (circle.getCenterX() >= (width - circle.getRadius())) {
				circle.setCenterX(width - (circle.getRadius() + 5));
			}
		}

		public void moveUp() {
			circle.setCenterY(circle.getCenterY() - 5);
			if (circle.getCenterY() <= circle.getRadius()) {
				circle.setCenterY(circle.getRadius() + 5);
			}
		}

		public void moveDown(int height) {
			circle.setCenterY(circle.getCenterY() + 5);
			if (circle.getCenterY() >= (height - (circle.getRadius()))) {
				circle.setCenterY(height - (circle.getRadius() + 5));
			}
		}
	}
}
