/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetoldp;

import javafx.scene.shape.Rectangle;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.text.*;

/**
 *
 
@author gaalm*/
public class FXMLDocumentController implements Initializable {

    @FXML
    private Button lancardados;
    public static Button lancardadosEstatico;
    
    @FXML
    private Button jogada;
    public static Button jogadaEstatico;
    
    @FXML
    private Button jogar;
    public static Button jogarEstatico;

    @FXML
    private Text text1;
    public static Text text1Estatico;

    @FXML
    private Text text2;
    public static Text text2Estatico;

    @FXML
    private Text text3;
    public static Text text3Estatico;
    
    @FXML
    private Text txtDados;
    public static Text txtDadosEstatico;
    
    @FXML
    private Label labelVez;
    public static Label labelVezEstatico;
    
    @FXML
    private TextArea pecaid;
    public static TextArea pecaidEstatico;
    
    @FXML
    private TextArea posicaoid;
    public static TextArea posicaoidEstatico;
    
     @FXML
    private Rectangle pos1;
    public static Rectangle pos1Estatico;
    
     @FXML
    private Rectangle p1;
    public static Rectangle p1Estatico;
    
     @FXML
    private Rectangle p16;
    public static Rectangle p16Estatico;
    

    @FXML
    private void handleButtonAction(ActionEvent event) {
        /*int dado1, dado2, dado3;

        //LANÇA O DADO E OBTÉM UM VALOR ENTRE 1 e 6
        dado1 = (int) (Math.random() * 6 + 1);
        dado2 = (int) (Math.random() * 6 + 1);
        dado3 = (int) (Math.random() * 6 + 1);
        text1.setText("" + dado1);
        text2.setText("" + dado2);
        text3.setText("" + dado3);*/

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        text1Estatico = text1;
        text2Estatico = text2;
        text3Estatico = text3;
        lancardadosEstatico = lancardados;
        txtDadosEstatico = txtDados;
        jogadaEstatico = jogada;
        labelVezEstatico = labelVez;
        pecaidEstatico = pecaid;
        posicaoidEstatico = posicaoid;
        jogarEstatico = jogar;
        pos1Estatico = pos1;
        p1Estatico = p1;
        p16Estatico = p16;

    }

}
