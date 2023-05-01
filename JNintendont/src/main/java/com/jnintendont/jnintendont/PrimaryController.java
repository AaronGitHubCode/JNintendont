/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.jnintendont.jnintendont;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

/**
 * FXML Controller class
 *
 * @author aaron
 */
import java.io.File;
import java.util.regex.Pattern;
import javafx.event.ActionEvent;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextArea;
public class PrimaryController implements Initializable {
    private Logs logs = new Logs();
    
    @FXML
    private TextField directorio;
    @FXML
    private TextArea consola;
    @FXML
    private ProgressBar porcentaje;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void enterPresionado(KeyEvent event) {
        if(event.getCode().equals(KeyCode.ENTER)) {
            consola.setText("");
            File verDirectorio = new File(directorio.getText());

            if(verDirectorio.isDirectory()) {
                int contador = 0;
                for(String s : verDirectorio.list()) {
                    if(s.split(Pattern.quote("."))[s.split(Pattern.quote(".")).length  - 1].equalsIgnoreCase("iso")) {
                        contador++;
                        consola.setText(consola.getText() + "\n" + s + ": " + (((long) new File(verDirectorio + "/" + s).length()) / 1024) / 1024 + "MiB");
                    }
                }
                consola.setText(consola.getText() + "\nTotal de archivos: " + contador);
            }else {
                consola.setText("\nEl directorio " + directorio.getText().split(Pattern.quote("/"))[directorio.getText().split(Pattern.quote("/")).length - 1] + " no existe");
            }
        }
    } 

    @FXML
    private void realizarAccion(ActionEvent event) {
        consola.setText("");
        File verDirectorio = new File(directorio.getText());
    
        if(verDirectorio.isDirectory()) {
            int contador = 0;
            for(String s : verDirectorio.list()) {
                if(s.split(Pattern.quote("."))[s.split(Pattern.quote(".")).length  - 1].equalsIgnoreCase("iso")) {
                    contador++;
                    consola.setText(consola.getText() + "\n" + s + ": " + (((long) new File(verDirectorio + "/" + s).length()) / 1024) / 1024 + "MiB");
                }
            }
            consola.setText(consola.getText() + "\nTotal de archivos: " + contador);
        }else {
            consola.setText("\nEl directorio " + directorio.getText().split(Pattern.quote("/"))[directorio.getText().split(Pattern.quote("/")).length - 1] + " no existe");
        }
    }

    @FXML
    private void conversion(ActionEvent event) {
        File verDirectorio = new File(directorio.getText());
        
        if(verDirectorio.isDirectory()) {
            
        }else {
            consola.setText("\nEl directorio " + directorio.getText().split(Pattern.quote("/"))[directorio.getText().split(Pattern.quote("/")).length - 1] + " no existe");
        }
    }
}
