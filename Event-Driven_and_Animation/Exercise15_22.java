import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Line;
import javafx.scene.shape.Ellipse;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/** Draws a cylinder that automatically resizes with the window. */
public class Exercise15_22 extends Application {
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
    arcDashed.setFill(Color.TRANSPARENT);
    arcDashed.getStrokeDashArray().addAll(6.0, 21.0);
    pane.getChildren().add(arcDashed);
    
    // Solid arc for cylinder bottom
    Arc arcSolid = new Arc(300, 400, 100, 50, 0, -180);
    arcSolid.setType(ArcType.OPEN);
    arcSolid.setStroke(Color.BLACK);
    arcSolid.setFill(Color.TRANSPARENT);
    pane.getChildren().add(arcSolid);

    // Create a scene and place it in the stage
    Scene scene = new Scene(pane, 600, 500);
    primaryStage.setTitle("Cylinder");
    primaryStage.setScene(scene);
    primaryStage.show();
    
    // Change the width of the cylinder when the pane width changes
    pane.widthProperty().addListener(ov -> {
      // Update the center of the cylinder
      ellipseTop.setCenterX(pane.getWidth() / 2);
      arcDashed.setCenterX(ellipseTop.getCenterX());
      arcSolid.setCenterX(ellipseTop.getCenterX());
      
      // Update the radius of the cylinder
      ellipseTop.setRadiusX(ellipseTop.getCenterX() * 0.33);
      arcDashed.setRadiusX(ellipseTop.getRadiusX());
      arcSolid.setRadiusX(ellipseTop.getRadiusX());
      
      // Update the left side of the cylinder
      lineLeft.setStartX(ellipseTop.getCenterX() - ellipseTop.getRadiusX());
      lineLeft.setEndX(lineLeft.getStartX());
      
      // Update the right side of the cylinder
      lineRight.setStartX(ellipseTop.getCenterX() + ellipseTop.getRadiusX());
      lineRight.setEndX(lineRight.getStartX());
    });

    // Change the height of the cylinder when the pane height changes
    pane.heightProperty().addListener(ov -> {
      lineLeft.setEndY(pane.getHeight() - 100);
      lineRight.setEndY(pane.getHeight() - 100);
      arcDashed.setCenterY(lineRight.getEndY());
      arcSolid.setCenterY(lineRight.getEndY());
    });
  }

  public static void main(String[] args) {
    Application.launch(args);
  }
}
