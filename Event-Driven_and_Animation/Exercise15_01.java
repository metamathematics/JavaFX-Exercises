import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import java.util.Random;
import java.util.ArrayList;

/** Lets the user click the Refresh botton to display four cards. */
public class Exercise15_01 extends Application {
  private Deal hand = new Deal();

  /** Override the start method from the the Application class.  */
  @Override
  public void start(Stage primaryStage) {
    // Place Refresh button into a stackpane
    HBox hbox = new HBox();
    hbox.setPadding(new Insets(5, 10, 10, 10));
    hbox.setAlignment(Pos.CENTER);
    Button btRefresh = new Button("Refresh");
    hbox.getChildren().add(btRefresh);

    // Create and register the handler for the button
    btRefresh.setOnAction(e -> hand.updateCards());

    // Place hbox and stackpane into a borderpane
    BorderPane pane = new BorderPane();
    pane.setCenter(hand);
    pane.setBottom(hbox);
    pane.setAlignment(hbox, Pos.CENTER);

    // Create scene and place into the stage
    Scene scene = new Scene(pane);
    primaryStage.setTitle("Cards");
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  /** Class to display four random cards.  */
  public class Deal extends HBox {
    private ImageView[] cards = new ImageView[4];
    
    /** Default Constructor.  */
    public Deal() {
      setAlignment(Pos.CENTER);
      setSpacing(3);
      setPadding(new Insets(10, 10, 5, 10));
      initializeCards();
    }
    
    /** Creates four ImageView card objects and adds them to the HBox.  */
    private void initializeCards() {
      int[] numbers = randomNumbers();
      for (int i = 0; i < 4; i++) {
        cards[i] = new ImageView("card/" + numbers[i] + ".png");
        getChildren().add(cards[i]);
      }
    }
    
    /** Updates the card images to new random ones.  */
    public void updateCards() {
      int[] numbers = randomNumbers();
      for (int i = 0; i < 4; i++) {
        cards[i].setImage(new Image("card/" + numbers[i] + ".png"));
      }
    }

    /** Creates an int array of four random ints 1-52.
        @return The array
      */
    private int[] randomNumbers() {
      ArrayList<Integer> cardNames = new ArrayList<>(52);
      for (int num = 1; num <= 52; num++) {
        cardNames.add(num);
      }

      Random r = new Random();
      int[] numbers = new int[4];
      for (int i = 0; i < 4; i++) {
        numbers[i] = cardNames.remove(r.nextInt(51 - i));
      }
      return numbers;
    }
  }

  /** The main method.  */
  public static void main(String[] args) {
    Application.launch(args);
  }
}
