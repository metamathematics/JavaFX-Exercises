import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.BoarderPane;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import java.util.Random;
import java.util.ArrayList;

/** Lets the user click the Refresh botton to display four cards */
public class Exercise15_01 extends Application {
	@Override
	public void start(Stage primaryStage) {
		// Create four random card image objects
		HBox hbox = new HBox();
		hbox.spacing(5);
		hbox.alignment(Pos.CENTER);

		int[] numbers = randomNumbers();
		Image[] cards = new Image[4];
		for (int i = 0; i < 4; i++) {
			cards[i] = new Image("card/"numbers[i + 1]".png");
			hbox.getChildren().add(new ImageView(cards[i]));
		}

		// Place Refresh button into a stackpane

		// Create and register the handler for the button

		// Place hbox and stackpane into a gridpane

		// Create scene and place into the stage
		Scene scene = new Scene(pane, 400, 300);
		primaryStage.setTitle("Cards");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

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

	public static void main(String[] args) {
		Application.launch(args);
	}
}
