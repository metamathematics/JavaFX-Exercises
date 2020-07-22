import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.text.Text;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/*
 * Displays a pie chart
 * @author Mr. Young
 */
 public class Exercise14_13 extends Application {
	@Override
	public void start(Stage primaryStage) {
		// Create a pane to hold the chart
		Pane pane = new Pane();

		// Left slice of pie
		double centerX = 300;
		double centerY = centerX;
		double radiusX = 200;
		double radiusY = radiusX;
		Arc leftArc = new Arc(centerX, centerY, radiusX, radiusY, 108, 108);
		leftArc.setType(ArcType.ROUND);
		leftArc.setStroke(Color.GREEN);
		leftArc.setFill(Color.GREEN);
		pane.getChildren().add(leftArc);

		// Top slice of pie
		Arc topArc = new Arc(centerX, centerY, radiusX, radiusY, 72, 36);
		topArc.setType(ArcType.ROUND);
		topArc.setStroke(Color.BLUE);
		topArc.setFill(Color.BLUE);
		pane.getChildren().add(topArc);

		// Right slice of pie
		Arc rightArc = new Arc(centerX, centerY, radiusX, radiusY, 0, 72);
		rightArc.setType(ArcType.ROUND);
		rightArc.setStroke(Color.RED);
		rightArc.setFill(Color.RED);
		pane.getChildren().add(rightArc);

		// Bottom slice of pie
		Arc bottomArc = new Arc(centerX, centerY, radiusX, radiusY, 216, 144);
		bottomArc.setType(ArcType.ROUND);
		bottomArc.setStroke(Color.ORANGE);
		bottomArc.setFill(Color.ORANGE);
		pane.getChildren().add(bottomArc);

		// Midterm text
		Text midterm = new Text(125, centerY, "Midterm -- 30%");
		midterm.setFont(Font.font("Times New Roman", 15));
		pane.getChildren().add(midterm);

		// Quiz text
		Text quiz = new Text(centerX - 50, 95, "Quiz -- 10%");
		quiz.setFont(Font.font("Times New Roman", 15));
		pane.getChildren().add(quiz);

		// Project text
		Text project = new Text(centerX + 50, centerY - 50, "Project -- 20%");
		project.setFont(Font.font("Time New Roman", 15));
		pane.getChildren().add(project);

		// Final text
		Text fin = new Text(centerX, centerY + 100, "Final -- 40%");
		fin.setFont(Font.font("Times New Roman", 15));
		pane.getChildren().add(fin);

		// Create a scene and put it in the stage
		Scene scene = new Scene(pane, 600, 600);
		primaryStage.setTitle("Pie Chart");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		Application.launch(args);
	}
 }
