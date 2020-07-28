import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/** A simple calculator. */
public class Exercise15_04 extends Application {
  /** Override the start method from the Application class. */
  @Override
  public void start(Stage primaryStage) {

    // Create the text fields and labels and put them in an HBox
    HBox hBoxTxt = new HBox(5);
    hBoxTxt.setPadding(new Insets(5, 5, 5, 5));
    hBoxTxt.setAlignment(Pos.CENTER);
    TextField num1 = new TextField();
    TextField num2 = new TextField();
    TextField result = new TextField();
    num1.setPrefColumnCount(5);
    num2.setPrefColumnCount(5);
    result.setPrefColumnCount(5);
    hBoxTxt.getChildren().addAll(new Label("Number 1:"), num1,
        new Label("Number 2:"), num2, new Label("Result"), result);

    // Create the buttons and put them in an HBox
    HBox hboxBtn = new HBox(2);
    hboxBtn.setPadding(new Insets(5, 5, 5, 5));
    hboxBtn.setAlignment(Pos.CENTER);
    Button btnAdd = new Button("Add");
    Button btnSub = new Button("Subtract");
    Button btnMult = new Button("Multiply");
    Button btnDiv = new Button("Divide");
    hboxBtn.getChildren().addAll(btnAdd, btnSub,btnMult, btnDiv);

    // Assign actions to the buttons
    btnAdd.setOnAction(e -> add(num1.getText(), num2.getText(), result));
    btnSub.setOnAction(e -> sub(num1.getText(), num2.getText(), result));
    btnMult.setOnAction(e -> mult(num1.getText(), num2.getText(), result));
    btnDiv.setOnAction(e -> div(num1.getText(), num2.getText(), result));

    // Put the two HBoxs in a BorderPane
    BorderPane pane = new BorderPane();
    pane.setCenter(hBoxTxt);
    pane.setBottom(hboxBtn);

    // Create a scene and place in the stage
    Scene scene = new Scene(pane);
    primaryStage.setTitle("Calculator");
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  /** Add two numbers and put the sum in a TextField.
      @param num1 This number gets added to num2
      @param num2 This number gets added to num1
      @param textField The TextField in which to place the sum
    */
  public void add(String num1, String num2, TextField textField) {
    double number1 = Double.parseDouble(num1);
    double number2 = Double.parseDouble(num2);
    double result = number1 + number2;
    textField.setText(String.valueOf(result));
  }

  /** Subtract two numbers and put the difference in a TextField.
      @param num1 The number that is to be subtracted from
      @param num2 The number that is to be subtracted
      @param textField The TextField in which to place the difference
    */
  public void sub(String num1, String num2, TextField textField) {
    double number1 = Double.parseDouble(num1);
    double number2 = Double.parseDouble(num2);
    double result = number1 - number2;
    textField.setText(String.valueOf(result));
  }

  /** Multiply two number and put the product in a TextField.
      @param num1 The multiplicand
      @param num2 The multiplier
      @param textField The TextField in which to place the product
    */
  public void mult(String num1, String num2, TextField textField) {
    double number1 = Double.parseDouble(num1);
    double number2 = Double.parseDouble(num2);
    double result = number1 * number2;
    textField.setText(String.valueOf(result));
  }

  /** Divide two numbers and put the quotient in a TExtField.
      @param num1 The dividend
      @param num2 The divisor
      @param textField The TextField in which to place the quotient
    */
  public void div(String num1, String num2, TextField textField) {
    double number1 = Double.parseDouble(num1);
    double number2 = Double.parseDouble(num2);
    double result = number1 / number2;
    textField.setText(String.valueOf(result));
  }

  /** The main method. */
  public static void main(String[] args) {
    Application.launch(args);
  }
}
