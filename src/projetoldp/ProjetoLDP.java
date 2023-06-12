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
    Casa[] casas = new Casa[24];

    Casa casa1 = new Casa(1);
    Casa casa2 = new Casa(2);
    Casa casa3 = new Casa(3);
    Casa casa4 = new Casa(4);
    Casa casa5 = new Casa(5);
    Casa casa6 = new Casa(6);
    Casa casa7 = new Casa(7);
    Casa casa8 = new Casa(8);
    Casa casa9 = new Casa(9);
    Casa casa10 = new Casa(10);
    Casa casa11 = new Casa(11);
    Casa casa12 = new Casa(12);
    Casa casa13 = new Casa(13);
    Casa casa14 = new Casa(14);
    Casa casa15 = new Casa(15);
    Casa casa16 = new Casa(16);
    Casa casa17 = new Casa(17);
    Casa casa18 = new Casa(18);
    Casa casa19 = new Casa(19);
    Casa casa20 = new Casa(20);
    Casa casa21 = new Casa(21);
    Casa casa22 = new Casa(22);
    Casa casa23 = new Casa(23);
    Casa casa24 = new Casa(24);

    ObjectOutputStream out;
    private boolean minhavez = true;

    public ProjetoLDP(ObjectOutputStream out) {
        this.out = out;

        casas[0] = casa1;
        casas[1] = casa2;
        casas[2] = casa3;
        casas[3] = casa4;
        casas[4] = casa5;
        casas[5] = casa6;
        casas[6] = casa7;
        casas[7] = casa8;
        casas[8] = casa9;
        casas[9] = casa10;
        casas[10] = casa11;
        casas[11] = casa12;
        casas[12] = casa13;
        casas[13] = casa14;
        casas[14] = casa15;
        casas[15] = casa16;
        casas[16] = casa17;
        casas[17] = casa18;
        casas[18] = casa19;
        casas[19] = casa20;
        casas[20] = casa21;
        casas[21] = casa22;
        casas[22] = casa23;
        casas[23] = casa24;

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
    
     public void movePeca(String idpeca, int mover) {

         for (GameServer.ClientHandler c : GameServer.listaClientes) {
             if(Integer.parseInt(idpeca) <= 15){
                 if(c.id == 0){
                     
                     casa1.posicao.add(c.pecas.get(0));
                   
                 }
             }
         }
                    

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
        // pinta o mapa de branco, caso seja a segunda vez que esteja a jogar
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
            } else {
                FXMLDocumentController.jogadaEstatico.setDisable(false);
                FXMLDocumentController.lancardadosEstatico.setDisable(false);
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
