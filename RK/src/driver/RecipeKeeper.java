package driver;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;

/**
 * Driver class of Recipe Keeper
 * @author Hoa Pham
 *
 */
public class RecipeKeeper extends Application {
	
	
	
	@Override
	public void start(Stage primaryStage) {
		try {
			final int[] MIN_SIZES = { 529,737 };
			String fileDirectory = "/view/ReadInterface.fxml";
			String cssDirectory = "/view/RecipeKeeper.css";
			Parent root = FXMLLoader.load(getClass().getResource(fileDirectory));
			Scene scene = new Scene(root, MIN_SIZES[0], MIN_SIZES[1]);
			scene.getStylesheets().add(getClass().getResource(cssDirectory).toExternalForm());
			primaryStage.setTitle("Interface Demo");
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
