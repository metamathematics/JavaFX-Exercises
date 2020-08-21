import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/** Converts between decimal, binary, and hexadecimal. */
public class Exercise16_05 extends Application {

  
  /** Overrides the start method from the Application class. */
  @Override
  public void start(Stage primaryStage) {
   GridPane pane = new GridPane();
   pane.setPadding(new Insets(5, 10, 5, 10));
   pane.setHgap(5);
   pane.setVgap(5);
   pane.add(new Label("Decimal"), 0, 0);
   pane.add(new Label("Hex"), 0, 1);
   pane.add(new Label("Binary"), 0, 2);

   TextField tfDec = new TextField();
   tfDec.setAlignment(Pos.CENTER_RIGHT);
   TextField tfHex = new TextField();
   tfHex.setAlignment(Pos.CENTER_RIGHT);
   TextField tfBin = new TextField();
   tfBin.setAlignment(Pos.CENTER_RIGHT);
   pane.add(tfDec, 1, 0);
   pane.add(tfHex, 1, 1);
   pane.add(tfBin, 1, 2);

   tfDec.setOnKeyPressed(e -> {
    if (e.getCode() == KeyCode.ENTER) {
      tfBin.setText(decimalToBinary(tfDec.getText()));
      tfHex.setText(decimalToHexadecimal(tfDec.getText()));
    }
   });

   tfBin.setOnKeyPressed(e -> {
    if (e.getCode() == KeyCode.ENTER) {
      tfDec.setText(binaryToDecimal(tfBin.getText()));
      tfHex.setText(decimalToHexadecimal(tfDec.getText()));
    }
   });

   Scene scene = new Scene(pane);
   primaryStage.setResizable(false);
   primaryStage.setTitle("Decimal 2 Hex 2 Binary");
   primaryStage.setScene(scene);
   primaryStage.show();
  }

  /** The main method. */
  public static void main(String[] args) {
    Application.launch(args);
  }

  private String decimalToBinary(String decimal) {
    if (decimal.equals(""))
      return "";

    int dec = Integer.parseInt(decimal);

    if (dec < 0)
      return "";

    return Integer.toBinaryString(dec);  
  }

  private String decimalToHexadecimal(String decimal) {
    if (decimal.equals(""))
      return "";

    int dec = Integer.parseInt(decimal);

    if (dec < 0)
      return "";

    return Integer.toHexString(dec).toUpperCase();
  }

  private String binaryToDecimal(String binary) {
    int bin = 0;
    for (int i = 0; i < binary.length(); i++) {
      int bit = Character.getNumericValue(binary.charAt(i));
      bin = bin + (bit * pow(2, binary.length() - (i + 1)));
    }
    return Integer.toString(bin);
  }

  private String hexadecimalToDecimal(String hexadecimal) {
    return null;
  }

  private int pow(int base, int exp) {
    if (exp == 0)
      return 1;

    return base * pow(base, exp - 1);
  }
}
