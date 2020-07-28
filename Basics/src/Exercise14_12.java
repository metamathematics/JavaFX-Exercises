import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.FontPosture;
import javafx.stage.Stage;

/*
 * Displays a bar chart.
 * @author Mr. Young
 */
 public class Exercise14_12 extends Application {
  @Override
  public void start(Stage primaryStage) {
    // Create an pane to store the graph
    Pane pane = new Pane();

    // Create Rectangles
    double width = 100;
    double height = 200;

    Rectangle project = new Rectangle(10, 0.8 * height, width, 0.2 * height);
    project.setStroke(Color.BLACK);
    project.setFill(Color.RED);
    pane.getChildren().add(project);

    Rectangle quiz = new Rectangle(20 + width, 0.9 * height, width, 0.1 * height);
    quiz.setStroke(Color.BLACK);
    quiz.setFill(Color.BLUE);
    pane.getChildren().add(quiz);

    Rectangle midterm = new Rectangle(30 + (2 * width), 0.7 * height, width, 0.3 * height);
    quiz.setStroke(Color.BLACK);
    quiz.setFill(Color.GREEN);
    pane.getChildren().add(midterm);

    Rectangle fin = new Rectangle(40 +(3 * width), 0.6 * height, width, 0.4 * height);
    fin.setStroke(Color.BLACK);
    fin.setFill(Color.ORANGE);
    pane.getChildren().add(fin);

    // Create texts
    Text projectText = new Text(project.getX(), project.getY() - 5, "Project -- 20%");
    projectText.setFont(Font.font("Times New Roman", 12));
    pane.getChildren().add(projectText);

    Text quizText = new Text(quiz.getX(), quiz.getY() - 5, "Quiz -- 10%");
    quizText.setFont(Font.font("Times New Roman", 12));
    pane.getChildren().add(quizText);

    Text midtermText = new Text(midterm.getX(), midterm.getY() - 5, "Midterm -- 30%");
    midtermText.setFont(Font.font("Times New Roman", 12));
    pane.getChildren().add(midtermText);

    Text finText = new Text(fin.getX(), fin.getY() - 5, "Final -- 40%");
    finText.setFont(Font.font("Times New Roman", 12));
    pane.getChildren().add(finText);

    // Create a scene and place it in the stage
    Scene scene = new Scene(pane, 50 + (4 * width), height + 5);
    primaryStage.setTitle("Bar Graph");
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  public static void main(String[] args) {
    Application.launch(args);
  }
 }
