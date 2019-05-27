package school.cesar.Controller;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;

public class SelectFileController implements Initializable {
	
	private static String path;
	
	public static String getPath() {
		return path;
	}
	
	private void setPath(String path) {
		this.path = path;
	}

	@FXML
    private JFXTextField pathFile;

    @FXML
    private JFXButton btnSelectFile;
    
    @FXML
	private JFXComboBox<String> comboBox;

    @FXML
    public void showPath(ActionEvent event) {
    	
    	FileChooser fc = new FileChooser();
    	fc.getExtensionFilters().addAll(
    			new ExtensionFilter("CSV Files", "*.csv"));
    	File selectedFile = fc.showOpenDialog(null);
    	if (selectedFile != null) {
    		pathFile.setText(selectedFile.getAbsolutePath());
    		String path = selectedFile.getAbsolutePath();
    		setPath(path);
//    		System.out.println(path);
    	}

    }
    
	public void initialize(URL url, ResourceBundle rb) {
		
		comboBox.getItems().add("Transporte");
		comboBox.getItems().add("Satisfação");
		comboBox.getItems().add("Consumo");
		comboBox.getItems().add("Estadia");
		comboBox.getItems().add("Segurança");
		
	}
		
	
}
