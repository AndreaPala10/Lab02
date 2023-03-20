package it.polito.tdp.alien;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import it.polito.tdp.alien.model.Dizionario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	
	Dizionario dizionario;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnClear;

    @FXML
    private Button btnTranslate;

    @FXML
    private TextArea txtArea;

    @FXML
    private TextField txtInserisci;

    @FXML
    void doClear(ActionEvent event) {
    	this.txtArea.clear();
    	this.txtInserisci.clear();

    }

    @FXML
    void doTranslate(ActionEvent event) {
    	String tmp=this.txtInserisci.getText();
    	String token[]=tmp.split(" ");
    	
		String parola=token[0].toLowerCase();    	
    	if(parola.matches("^.*[0-9].*$")==true) {
    		txtArea.setText("Formato non valido!");
    		return;
    	}
    	if(token.length==1) {
    		//ritorna il signoficato
    		List<String> ss=dizionario.daiSignificato(parola);
    		this.txtArea.setText("La traduzione di "+parola+" è "+ss);
    		
    	}
    	
		String traduzione=token[1].toLowerCase();
    	if(traduzione.matches("^.*[0-9].*$")==true) {
    		txtArea.setText("Formato non valido!");
    		return;
    	}
    	if(token.length==2) {
    		//aggiungi significato
    		dizionario.aggiungiParole(parola, traduzione);
    		this.txtArea.setText(parola+" aggiunta al dizionario");
    	}


    }

    @FXML
    void initialize() {
        assert btnClear != null : "fx:id=\"btnClear\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnTranslate != null : "fx:id=\"btnTranslate\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtArea != null : "fx:id=\"txtArea\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtInserisci != null : "fx:id=\"txtInserisci\" was not injected: check your FXML file 'Scene.fxml'.";

        dizionario=new Dizionario();
    }

}
