package control;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import org.apache.commons.lang3.StringUtils;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import model.AlertBox;
import model.Recipe;
import model.RecipeList;

/**
 * Welcome Controller
 * @author Hoa Pham
 *
 */
public class WelcomeController implements Initializable {

	@FXML // fx:id="motherPane"
	BorderPane motherPane = new BorderPane();

	@FXML // fx:id="byName"
	TextField byName = new TextField();

	@FXML // fx:id="byIngredient"
	TextField byIngredient = new TextField();

	@FXML // fx:id="byCategory"
	TextField byCategory = new TextField();

	@FXML // fx:id="startRep"
	Button startRep = new Button();

	@FXML // fx:id="findRep"
	Button findRep = new Button();

	// constant values
	static Constants constants = new Constants();

	// minimum size of the window
	private static final int[] MIN_SIZES = constants.getMinSizes();

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		/**
		 * Start a new recipe
		 */
		startRep.setOnAction( action -> {
			try {
				String fxmlFileDir = "/view/EditInterface.fxml";
				String cssFileDir = "/view/RecipeKeeper.css";
				Parent root = FXMLLoader.load(getClass().getResource(fxmlFileDir));
				Scene editWindow = new Scene(root, MIN_SIZES[0], MIN_SIZES[1]);
				editWindow.getStylesheets().add(getClass().getResource(cssFileDir).toExternalForm());
				Stage originalStage = (Stage) motherPane.getScene().getWindow();
				originalStage.setScene(editWindow);
			} catch (IOException ioe) {

			}
		});

		/**
		 * find a recipe and enter read mode
		 */
		findRep.setOnAction(action -> {
			try {
				if ( (byName.getText().isEmpty() || byName.getText().equals(null) || StringUtils.isBlank(byName.getText()))
						&& (byIngredient.getText().isEmpty() || byIngredient.getText().equals(null) || StringUtils.isBlank(byIngredient.getText())) 
						&& (byCategory.getText().isEmpty() || byCategory.getText().equals(null)) || StringUtils.isBlank(byCategory.getText())) 
					throw new NullPointerException();
				else if ((byName.getText().isEmpty() || byName.getText().equals(null) || StringUtils.isBlank(byName.getText()))
						&& !(byIngredient.getText().isEmpty() || byIngredient.getText().equals(null) || StringUtils.isBlank(byIngredient.getText()))
						&& !(byCategory.getText().isEmpty() || byCategory.getText().equals(null)) || StringUtils.isBlank(byCategory.getText())) {
					String neededIngredient = byIngredient.getText();
					String needCategory = byCategory.getText();
					ArrayList<Recipe> data = ReadData.readRecipes().getRecipeList();
				}
			} 
			catch (NullPointerException e) {
				AlertBox.display("Warning", "");
			}
		});

	}



}
