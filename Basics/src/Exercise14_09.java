import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import java.util.Random;
import java.util.ArrayList;

public class Exercise14_09 extends Application {
  @Override
  public void start(Stage primaryStage) {
    // Create pane to hold images
    GridPane pane = new GridPane();
    pane.setPadding(new Insets(5, 5, 5, 5));

    // Array of card image names
    ArrayList<Integer> cardNames = new ArrayList<>(54);
    for (int i = 1; i <= 54; i++) {
      cardNames.add(i);
    }

    Random r = new Random();

    // Array of ImageView objects
    ArrayList<ImageView> cards = new ArrayList<>(54);
    for (int i = 0; i < 54; i++) {
      int arrayIndex = r.nextInt(cardNames.size());
      int name = cardNames.remove(arrayIndex);
      cards.add(new ImageView(new Image("card/" + name + ".png")));
    }

    // Add images to pane
    pane.setHgap(5);
    pane.setVgap(5);
    int index = 0;
    for (int i = 0; i < 9; i++) {
      for (int j = 0; j < 6; j++) {
        pane.add(cards.get(index++), i, j);
      }
    }

    // Create scene and add to stage
    Scene scene = new Scene(pane);
    primaryStage.setTitle("Shuffled Cards");
    primaryStage.setScene(scene);
    primaryStage.show();

  }

  public static void main(String[] args) {
    Application.launch(args);
  }
}
