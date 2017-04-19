/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import domain.Domeincontroller;
import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;

/**
 * FXML Controller class
 *
 * @author UGent
 */
public class HangmanPanelController extends GridPane {
    private Domeincontroller domeincontroller;
    
    @FXML
    private FlowPane buttonContainer;

    public HangmanPanelController(Domeincontroller domeincontroller) {
         FXMLLoader loader
                = new FXMLLoader(getClass().getResource("HangmanPanel.fxml"));
        loader.setRoot(this);
        loader.setController(this);
        try
        {
            loader.load();
            this.domeincontroller = domeincontroller;
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private void generateButtons(){
        char[] chars = new char[]{
            'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'
        };
        for(char c : chars){
            Button b = new Button(""+c);
            b.setOnAction((ActionEvent event) -> {
                String eventChar = ((Button)event.getSource()).getText();
                processAction(eventChar);
            });
        }
    }
    
    @FXML
    private void toonOplossing(ActionEvent event) {
    }

    @FXML
    private void gaNaarVolgendWoord(ActionEvent event) {
    }

    private void processAction(String stringchar) {
        boolean isvalid = domeincontroller.checkChar(stringchar);
        if(isvalid){
            //update label
        } else{
            //update image hangman
        }
        Button gekozen = buttonContainer.getChildren()
                .stream()
                .map(m -> (Button) m)
                .filter(b -> b.getText().equals(stringchar))
                .findFirst()
                .get();
        //disable gekozen knop
        gekozen.setDisable(true);
    }
    
    
}