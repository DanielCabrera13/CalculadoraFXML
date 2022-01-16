package calculadorafxml;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class App extends Application {
	
	private CalculadoraController calculadoraController;
	private static Scene scene;

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		calculadoraController = new CalculadoraController();
		
		
		scene = new Scene(calculadoraController.getView());
		
		primaryStage.setTitle("Calculadora");
		primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("../calculator-32x32.png")));
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}

	public static void main(String[] args) {
		launch(args);

	}
	
	public static Scene getScene() {
		return scene;
	}

}
