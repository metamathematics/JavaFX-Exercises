import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import java.util.Random;

public class Exercise14_03 extends Application {
  @Override
  public void start(Stage primaryStage) {
    // create a pane to store the images
    HBox pane = new HBox(15);
    pane.setPadding(new Insets(15,15,15,15));

    // make an array of the card numbers
    int[] cardNumbers = new int[52];
    for (int i = 0; i < 52; i++) {
      cardNumbers[i] = i + 1;
    }

    // randomly select 3 numbers from 0 - array.size
    Random r = new Random();
    int num1 = r.nextInt(52);
    int num2 = r.nextInt(52);
    int num3 = r.nextInt(52);

    // ensure that the numbers are distinct
    while (num1 == num2) {
      num2 = r.nextInt(52);
    }
    while ((num1 == num3) || (num2 == num3)) {
      num3 = r.nextInt(52);
    }

    // make three imageView objects using the 3 random numbers
    ImageView card1 = new ImageView(new Image("card/"+cardNumbers[num1]+".png"));
    ImageView card2 = new ImageView(new Image("card/"+cardNumbers[num2]+".png"));
    ImageView card3 = new ImageView(new Image("card/"+cardNumbers[num3]+".png"));

    // add pictures to the pane
    pane.getChildren().addAll(card1, card2, card3);

    // create a scene and place it in the stage
    Scene scene = new Scene(pane);
    primaryStage.setTitle("Three Cards");
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  public static void main(String[] args) {
    Application.launch(args);
  }
}
