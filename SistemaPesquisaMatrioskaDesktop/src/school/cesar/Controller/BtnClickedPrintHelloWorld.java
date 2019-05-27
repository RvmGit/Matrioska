package school.cesar.Controller;

import java.io.File;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;

public class BtnClickedPrintHelloWorld {
	
	private static String path;
	
	public static String getPath() {
		return path;
	}
	
	private void setPath(String path) {
		this.path = path;
	}

    @FXML
    private JFXButton btnPrint;

    @FXML
    private JFXTextField helloFxOutput;

    @FXML
    public void printHelloFx(ActionEvent event) {
    	
//    	helloFxOutput.setText("Hello FX ;)");
    	
    	FileChooser fc = new FileChooser();
    	fc.getExtensionFilters().addAll(
    			new ExtensionFilter("CSV Files", "*.csv"));
    	File selectedFile = fc.showOpenDialog(null);
    	if (selectedFile != null) {
			helloFxOutput.setText(selectedFile.getAbsolutePath());
			String path = selectedFile.getAbsolutePath();
			setPath(path);
			System.out.println(path);
		}
    	
    }

}