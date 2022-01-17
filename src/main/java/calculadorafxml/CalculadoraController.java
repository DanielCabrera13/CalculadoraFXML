package calculadorafxml;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class CalculadoraController implements Initializable {
		
		//MODEL
		Calculadora c = new Calculadora();
		
		//VIEW
	
	  	@FXML
	    private Button Button0;

	    @FXML
	    private Button Button1;

	    @FXML
	    private Button Button2;

	    @FXML
	    private Button Button3;

	    @FXML
	    private Button Button4;

	    @FXML
	    private Button Button5;

	    @FXML
	    private Button Button6;

	    @FXML
	    private Button Button7;

	    @FXML
	    private Button Button8;

	    @FXML
	    private Button Button9;

	    @FXML
	    private Button ButtonC;

	    @FXML
	    private Button ButtonCE;

	    @FXML
	    private Button ButtonDivide;

	    @FXML
	    private Button ButtonDot;

	    @FXML
	    private Button ButtonEqual;

	    @FXML
	    private Button ButtonMinus;

	    @FXML
	    private Button ButtonMulti;

	    @FXML
	    private Button ButtonPlus;

	    @FXML
	    private TextField resultadoText;

	    @FXML
	    private GridPane root;
	    
	    public CalculadoraController() throws IOException {
	    	FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/View.fxml"));
	    	loader.setController(this);
	    	loader.load();
	    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		root.getStylesheets().add("/css/modern.css");
		
		MenuItem clasicoItem = new MenuItem("Clásico");
		clasicoItem.setOnAction(e -> {
			System.out.println("Tema clásico seleccionado");
			root.getStylesheets().setAll("/css/classic.css");
		});
		
		MenuItem modernoItem = new MenuItem("Moderno");
		modernoItem.setOnAction(e -> {
			System.out.println("Tema moderno seleccionado");
			root.getStylesheets().setAll("/css/modern.css");
		});
		
		ContextMenu menu = new ContextMenu(clasicoItem, modernoItem);
		
		root.setOnContextMenuRequested(e -> {
			menu.show(root, e.getScreenX(), e.getScreenY());
		});
		
		
		//BINDINGS
		
		resultadoText.textProperty().bind(c.getResultado());
		
	}
	
	public void onPulsarAction(ActionEvent e) {
		
		String nombreButton = ((Button) e.getSource()).getText();
		switch (nombreButton) {
		case "0": 
			c.insertar('0');
			break;
		case "1": 
			c.insertar('1');
			break;
		case "2": 
			c.insertar('2');
			break;
		case "3": 
			c.insertar('3');
			break;
		case "4": 
			c.insertar('4');
			break;
		case "5": 
			c.insertar('5');
			break;
		case "6": 
			c.insertar('6');
			break;
		case "7": 
			c.insertar('7');
			break;
		case "8": 
			c.insertar('8');
			break;
		case "9": 
			c.insertar('9');
			break;
		case ".": 
			c.insertarComa();
			break;
		case "+": 
			c.operar(Calculadora.SUMAR);
			break;
		case "-": 
			c.operar(Calculadora.RESTAR);
			break;
		case "*": 
			c.operar(Calculadora.MULTIPLICAR);
			break;
		case "/": 
			c.operar(Calculadora.DIVIDIR);
			break;
		case "=": 
			c.operar(Calculadora.IGUAL);
			break;
		case "CE": 
			c.borrar();
			break;
		case "C": 
			c.borrarTodo();
			break;
		default:
			break;
		}
	}
	
	public GridPane getView() {
		return root;
	}
	

}
