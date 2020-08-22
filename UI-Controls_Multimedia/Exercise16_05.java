import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import java.util.regex.Pattern;

/** Converts between decimal, binary, and hexadecimal. */
public class Exercise16_05 extends Application {
  
  /** Overrides the start method from the Application class. */
  @Override
  public void start(Stage primaryStage) {
    // Make GridPane to hold the converter
    GridPane pane = new GridPane();
    pane.setPadding(new Insets(5, 10, 5, 10));
    pane.setHgap(5);
    pane.setVgap(5);

    // Add Labels to the pane
    pane.add(new Label("Decimal"), 0, 0);
    pane.add(new Label("Hex"), 0, 1);
    pane.add(new Label("Binary"), 0, 2);

    // Add TextFields to the pane
    TextField tfDec = new TextField();
    tfDec.setAlignment(Pos.CENTER_RIGHT);
    TextField tfHex = new TextField();
    tfHex.setAlignment(Pos.CENTER_RIGHT);
    TextField tfBin = new TextField();
    tfBin.setAlignment(Pos.CENTER_RIGHT);
    pane.add(tfDec, 1, 0);
    pane.add(tfHex, 1, 1);
    pane.add(tfBin, 1, 2);

    // Assign action to Deciaml TextField
    tfDec.setOnKeyPressed(e -> {
      if (e.getCode() == KeyCode.ENTER) {
        try {
          tfBin.setText(decimalToBinary(tfDec.getText()));
          tfHex.setText(decimalToHexadecimal(tfDec.getText()));
        } catch (IllegalArgumentException ex) {
          primaryStage.close();
          System.out.println(ex + " is not a positive integer");
        }
      }
    });

    // Assign action to Binary TextField
    tfBin.setOnKeyPressed(e -> {
      if (e.getCode() == KeyCode.ENTER) {
        try {
          tfDec.setText(binaryToDecimal(tfBin.getText()));
          tfHex.setText(decimalToHexadecimal(tfDec.getText()));
        } catch (IllegalArgumentException ex) {
          primaryStage.close();
          System.out.println(ex + " is not a binary number");
        }
      }
    });

    // Assign action to Hexadecimal TextField
    tfHex.setOnKeyPressed(e -> {
      if (e.getCode() == KeyCode.ENTER) {
        try {
          tfDec.setText(hexadecimalToDecimal(tfHex.getText()));
          tfBin.setText(decimalToBinary(tfDec.getText()));
        } catch (IllegalArgumentException ex) {
          primaryStage.close();
          System.out.println(ex + " is not a hexadecimal number");
        }
      }
    });

    // Create a scene an place in the stage
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


  /** Converts a positive integer string to a binary number string.
      @param decimal The integer to be converted to binary
      @return The binary representation of decimal
      @throws IllegalArgumentException if decimal is not a positive integer
    */
  private String decimalToBinary(String decimal) throws IllegalArgumentException {
    // if input is an empty string, return empty string 
    if (decimal.equals(""))
      return "";

    // If input is not a positive int, throw exception
    if (!isPositiveInt(decimal)) {
      throw new IllegalArgumentException(decimal);
    }
    
    // Convert input string to int
    int dec = Integer.parseInt(decimal);

    // Convert to binary string and return result
    return Integer.toBinaryString(dec);  
  }


  /** Converts a positive integer string to a hexadecimal string.
      @param decimal The integer to be converted to hexadecimal
      @return The hexadecimal representation of decimal
      @throws IllegalArgumentException if decimal is not a positive integer
    */
  private String decimalToHexadecimal(String decimal) throws IllegalArgumentException {
    // if input is an empty string, return empty string 
    if (decimal.equals(""))
      return "";

    // If input is not a positive int, throw exception
    if (!isPositiveInt(decimal)) {
      throw new IllegalArgumentException(decimal);
    }

    // Convert input string to int
    int dec = Integer.parseInt(decimal);

    // Convert to hexadecimal string and return result
    return Integer.toHexString(dec).toUpperCase();
  }


  /** Converts a binary string to a decimal string.
      @param binary The binary string to be converted to a decimal
      @return The decimal representation of binary
      @throws IllegalArgumentException if binary is not a binary number
    */
  private String binaryToDecimal(String binary) throws IllegalArgumentException {
    // if input is an empty string, return empty string 
    if (binary.equals("")) {
      return "";
    }

    // If input is not binary, throw exception
    if (!isBinary(binary)) {
      throw new IllegalArgumentException(binary);
    }

    // Convert binary to decimal
    int dec = 0;
    for (int i = 0; i < binary.length(); i++) {
      int bit = Character.getNumericValue(binary.charAt(i));
      dec = dec + (bit * pow(2, binary.length() - (i + 1)));
    }
    // Convert decimal to string and return result
    return Integer.toString(dec);
  }


  /** Converts a hexadecimal string to a decimal string.
      @param hexadecimal The hexadecimal string to be converted to a decimal
      @return The deicmal representation of hexadecimal
      @throws IllegalArgumentException if hexadecimal is not a hexadecimal number
    */
  private String hexadecimalToDecimal(String hexadecimal) throws IllegalArgumentException {
    // if input is an empty string, return empty string 
    if (hexadecimal.equals("")) {
      return "";
    }
    
    // Make input upper case
    hexadecimal = hexadecimal.toUpperCase();

    // If input is not a hexadecimal, throw exception
    if (!isHexadecimal(hexadecimal)) {
      throw new IllegalArgumentException(hexadecimal);
    }

    // Convert hexadecimal to decimal
    int dec = 0;
    for (int i = 0; i < hexadecimal.length(); i++) {
      char hexChar = hexadecimal.charAt(i);
      boolean isLetter = Pattern.matches("[A-F]", Character.toString(hexChar));
      int letterToDec = 0;
      if (isLetter) {
        letterToDec = charHexToDec(hexChar);
      } else {
        letterToDec = Character.getNumericValue(hexChar);
      }
      dec = dec + (letterToDec * pow(16, hexadecimal.length() - (i + 1)));
    }

    // Convert decimal to string and return result
    return Integer.toString(dec);
  }


  /** Computes an exponential expression.
      @param base The base of the expression
      @param exp The exponent of the expression
      @return the result of base^exp
    */
  private int pow(int base, int exp) {
    if (exp == 0)
      return 1;

    return base * pow(base, exp - 1);
  }


  /** Converts a hexadecimal letter character to a decimal.
      @param hexLetter A hexadecimal letter A-F
      @return The decimal representation of hexLetter
    */
  private int charHexToDec(char hexLetter) {
    switch (hexLetter) {
      case 'A': return 10;
      case 'B': return 11;
      case 'C': return 12;
      case 'D': return 13;
      case 'E': return 14;
      case 'F': return 15;
      default: return -1;
    }
  }


  /** Determines if the string input is a positive integer.
      @param integer The string input
      @return true if integer is an integer; else false
    */
  private boolean isPositiveInt(String integer) {
    return Pattern.matches("[0-9]*", integer);
  }

  
  /** Determines if the string input is a binary number.
      @param binary The string input
      @return true if binary is a binary number; else false
    */
  private boolean isBinary(String binary) {
    return Pattern.matches("[01]*", binary);
  }

  
  /** Determines if the string input is a hexadecimal number.
      @param hex The string input
      @return true if hex is a hexadecimal; else false
    */
  private boolean isHexadecimal(String hex) {
    return Pattern.matches("[0-9A-F]*", hex);
  }
}
