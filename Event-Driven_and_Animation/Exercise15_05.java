import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/** An investment calculator. */
public class Exercise15_05 extends Application {
  private TextField tfInvestAmt = new TextField();
  private TextField tfYears = new TextField();
  private TextField tfInterest = new TextField();
  private TextField tfValue = new TextField();
  private Button bt = new Button("Calculate");
  
  /** Override the start method from the Application class. */
  @Override
  public void start(Stage primaryStage) {
   // Put Labels, textFields, and the Button in a GridPane
   GridPane pane = new GridPane();
   pane.setPadding(new Insets(8, 8, 8, 8));
   pane.setHgap(5);
   pane.setVgap(5);
   pane.add(new Label("Investment Amount:"), 0, 0);
   pane.add(tfInvestAmt, 1, 0);
   pane.add(new Label("Number of Years:"), 0, 1);
   pane.add(tfYears, 1, 1);
   pane.add(new Label("Annual Interest Rate:"), 0, 2);
   pane.add(tfInterest, 1, 2);
   pane.add(new Label("Future value:"), 0, 3);
   pane.add(tfValue, 1, 3);
   pane.add(bt, 1, 4);

   // Set properties for UI
   tfInvestAmt.setAlignment(Pos.BOTTOM_RIGHT);
   tfYears.setAlignment(Pos.BOTTOM_RIGHT);
   tfInterest.setAlignment(Pos.BOTTOM_RIGHT);
   tfValue.setAlignment(Pos.BOTTOM_RIGHT);
   tfValue.setEditable(false);
   pane.setHalignment(bt, HPos.RIGHT);

   // Assign action to the button
   bt.setOnAction(e -> calculateValue());

   // Create a scene and place it in the stage
   Scene scene = new Scene(pane);
   primaryStage.setTitle("Investment Calculator");
   primaryStage.setScene(scene);
   primaryStage.show();
  }

  /** Calculates the future value. */
  private void calculateValue() {
    double investment = Double.parseDouble(tfInvestAmt.getText());
    int years = Integer.parseInt(tfYears.getText());
    double interest = Double.parseDouble(tfInterest.getText()) / 1200;
    double value = investment * Math.pow((1 + interest), years * 12);

    tfValue.setText(String.format("$%.2f", value));
  }

  /** The main method. */
  public static void main(String[] args) {
    Application.launch(args);
  }
}
