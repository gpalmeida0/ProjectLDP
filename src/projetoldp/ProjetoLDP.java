/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetoldp;

import java.io.ObjectOutputStream;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author gaalm
 */
public class ProjetoLDP {

    private boolean lancouDados = false;
    private boolean podeMover = false;
    private boolean podeRetirar = false;
   

    ObjectOutputStream out;
    private boolean minhavez = true;

    public ProjetoLDP(ObjectOutputStream out) {
        this.out = out;

       

    }

    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));

        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.show();
    }

    public void displayDados(int d1, int d2, int d3) {

        FXMLDocumentController.text1Estatico.setText("" + d1);
        FXMLDocumentController.text2Estatico.setText("" + d2);
        FXMLDocumentController.text3Estatico.setText("" + d3);

    }
    
     public void movePeca(String idpeca, int mover, int id) {

        
      
                    

    }
    
    public void lancouDados(){
        FXMLDocumentController.lancardadosEstatico.setDisable(true);
    }

    public int[] geraDado() {

        int dado1;
        int dado2;
        int dado3;
        
        int[] dados = new int[3];

        if (!lancouDados) {
            dado1 = (int) (Math.random() * 6 + 1);
            dado2 = (int) (Math.random() * 6 + 1);
            dado3 = (int) (Math.random() * 6 + 1);
            dados[0] = dado1;
            dados[1] = dado2;
            dados[2] = dado3;
            lancouDados = true;

            return dados;
        } else {
            return dados;
        }

    }

    public void passouVez() {
        this.mudaVez();
    }

    public void iniciaJogo(boolean vez) {
        this.minhavez = vez;
        
        Platform.runLater(() -> {
            if (!this.minhavez) {
                FXMLDocumentController.jogadaEstatico.setDisable(true);
                FXMLDocumentController.lancardadosEstatico.setDisable(true);
                FXMLDocumentController.jogarEstatico.setDisable(true);
                 FXMLDocumentController.pecaidEstatico.setDisable(true);
                  FXMLDocumentController.posicaoidEstatico.setDisable(true);
            } else {
                FXMLDocumentController.jogadaEstatico.setDisable(false);
                FXMLDocumentController.lancardadosEstatico.setDisable(false);
                  FXMLDocumentController.jogarEstatico.setDisable(false);
                 FXMLDocumentController.pecaidEstatico.setDisable(false);
                  FXMLDocumentController.posicaoidEstatico.setDisable(false);
            }
        });
        Platform.runLater(() -> {
            String labelText = "É a tua vez...";
            if (!this.minhavez) {
                labelText = "É a vez do adversário...";
            }
            FXMLDocumentController.labelVezEstatico.setText(labelText);
        });

    }

    public void mudaVez() {
        this.minhavez = !this.minhavez;
        lancouDados = false;
        
        Platform.runLater(() -> {
            if (!this.minhavez) {
                FXMLDocumentController.jogadaEstatico.setDisable(true);
                FXMLDocumentController.lancardadosEstatico.setDisable(true);
                 FXMLDocumentController.jogarEstatico.setDisable(true);
                 FXMLDocumentController.pecaidEstatico.setDisable(true);
                  FXMLDocumentController.posicaoidEstatico.setDisable(true);
            } else {
                FXMLDocumentController.jogadaEstatico.setDisable(false);
                FXMLDocumentController.lancardadosEstatico.setDisable(false);
                 FXMLDocumentController.jogarEstatico.setDisable(false);
                 FXMLDocumentController.pecaidEstatico.setDisable(false);
                  FXMLDocumentController.posicaoidEstatico.setDisable(false);
            }
        });
        Platform.runLater(() -> {
            String labelText = "É a tua vez...";
            if (!this.minhavez) {
                labelText = "É a vez do adversário...";
            }
            FXMLDocumentController.labelVezEstatico.setText(labelText);

        });
    }

    public boolean getMinhaVez() {
        return this.minhavez;
    }
}
