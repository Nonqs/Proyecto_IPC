/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.aplicacion.register;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.shape.Rectangle;

import javafx.scene.layout.StackPane;
/**
 * FXML Controller class
 *
 * @author payap
 */
public class RegistroController implements Initializable {


    @FXML
    private StackPane StackPane_Registro;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Rectangle clip = new Rectangle();

    clip.setArcWidth(30);
    clip.setArcHeight(30);

    StackPane_Registro.setClip(clip);

    // importante: ajustar tamaño dinámico
    StackPane_Registro.layoutBoundsProperty().addListener((obs, oldVal, newVal) -> {
        clip.setWidth(newVal.getWidth());
        clip.setHeight(newVal.getHeight());
    });
    }
}