package calculadorafxml;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {
	
	private CalculadoraController calculadoraController;

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		calculadoraController = new CalculadoraController();
		
		Scene scene = new Scene(calculadoraController.getView());
		scene.getStylesheets().add("/css/modern.css");
		
		primaryStage.setTitle("Calculadora");
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}

	public static void main(String[] args) {
		launch(args);

	}

}
