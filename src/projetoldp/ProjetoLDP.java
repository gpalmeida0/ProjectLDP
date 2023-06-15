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

    public void movePeca(String peca, int posicao) {

        
        double targetX = 0;
        double targetY = 0;

        switch (posicao) {
            case 1:
                targetX = FXMLDocumentController.pos1Estatico.layoutXProperty().get();
                targetY = FXMLDocumentController.pos1Estatico.layoutYProperty().get();
                System.out.println(targetX);
                System.out.println(targetY);
                break;

            case 2:
                targetX = FXMLDocumentController.pos2Estatico.layoutXProperty().get();
                targetY = FXMLDocumentController.pos2Estatico.layoutYProperty().get();
                System.out.println(targetX);
                System.out.println(targetY);
                break;

            case 3:
                targetX = FXMLDocumentController.pos3Estatico.layoutXProperty().get();
                targetY = FXMLDocumentController.pos3Estatico.layoutYProperty().get();
                System.out.println(targetX);
                System.out.println(targetY);
                break;

            case 4:
                targetX = FXMLDocumentController.pos4Estatico.layoutXProperty().get();
                targetY = FXMLDocumentController.pos4Estatico.layoutYProperty().get();
                System.out.println(targetX);
                System.out.println(targetY);
                break;

            case 5:
                targetX = FXMLDocumentController.pos5Estatico.layoutXProperty().get();
                targetY = FXMLDocumentController.pos5Estatico.layoutYProperty().get();
                System.out.println(targetX);
                System.out.println(targetY);
                break;
            case 6:
                targetX = FXMLDocumentController.pos6Estatico.layoutXProperty().get();
                targetY = FXMLDocumentController.pos6Estatico.layoutYProperty().get();
                System.out.println(targetX);
                System.out.println(targetY);
                break;

            case 7:
                targetX = FXMLDocumentController.pos7Estatico.layoutXProperty().get();
                targetY = FXMLDocumentController.pos7Estatico.layoutYProperty().get();
                System.out.println(targetX);
                System.out.println(targetY);
                break;

            case 8:
                targetX = FXMLDocumentController.pos8Estatico.layoutXProperty().get();
                targetY = FXMLDocumentController.pos8Estatico.layoutYProperty().get();
                System.out.println(targetX);
                System.out.println(targetY);
                break;

            case 9:
                targetX = FXMLDocumentController.pos9Estatico.layoutXProperty().get();
                targetY = FXMLDocumentController.pos9Estatico.layoutYProperty().get();
                System.out.println(targetX);
                System.out.println(targetY);
                break;

            case 10:
                targetX = FXMLDocumentController.pos10Estatico.layoutXProperty().get();
                targetY = FXMLDocumentController.pos10Estatico.layoutYProperty().get();
                System.out.println(targetX);
                System.out.println(targetY);
                break;

            case 11:
                targetX = FXMLDocumentController.pos11Estatico.layoutXProperty().get();
                targetY = FXMLDocumentController.pos11Estatico.layoutYProperty().get();
                System.out.println(targetX);
                System.out.println(targetY);
                break;

            case 12:
                targetX = FXMLDocumentController.pos12Estatico.layoutXProperty().get();
                targetY = FXMLDocumentController.pos12Estatico.layoutYProperty().get();
                System.out.println(targetX);
                System.out.println(targetY);
                break;

            case 13:
                targetX = FXMLDocumentController.pos13Estatico.layoutXProperty().get();
                targetY = FXMLDocumentController.pos13Estatico.layoutYProperty().get();
                System.out.println(targetX);
                System.out.println(targetY);
                break;

            case 14:
                targetX = FXMLDocumentController.pos14Estatico.layoutXProperty().get();
                targetY = FXMLDocumentController.pos14Estatico.layoutYProperty().get();
                System.out.println(targetX);
                System.out.println(targetY);
                break;

            case 15:
                targetX = FXMLDocumentController.pos15Estatico.layoutXProperty().get();
                targetY = FXMLDocumentController.pos15Estatico.layoutYProperty().get();
                System.out.println(targetX);
                System.out.println(targetY);
                break;

            case 16:
                targetX = FXMLDocumentController.pos16Estatico.layoutXProperty().get();
                targetY = FXMLDocumentController.pos16Estatico.layoutYProperty().get();
                System.out.println(targetX);
                System.out.println(targetY);
                break;

            case 17:
                targetX = FXMLDocumentController.pos17Estatico.layoutXProperty().get();
                targetY = FXMLDocumentController.pos17Estatico.layoutYProperty().get();
                System.out.println(targetX);
                System.out.println(targetY);
                break;

            case 18:
                targetX = FXMLDocumentController.pos18Estatico.layoutXProperty().get();
                targetY = FXMLDocumentController.pos18Estatico.layoutYProperty().get();
                System.out.println(targetX);
                System.out.println(targetY);
                break;

            case 19:
                targetX = FXMLDocumentController.pos19Estatico.layoutXProperty().get();
                targetY = FXMLDocumentController.pos19Estatico.layoutYProperty().get();
                System.out.println(targetX);
                System.out.println(targetY);
                break;

            case 20:
                targetX = FXMLDocumentController.pos20Estatico.layoutXProperty().get();
                targetY = FXMLDocumentController.pos20Estatico.layoutYProperty().get();
                System.out.println(targetX);
                System.out.println(targetY);
                break;

            case 21:
                targetX = FXMLDocumentController.pos21Estatico.layoutXProperty().get();
                targetY = FXMLDocumentController.pos21Estatico.layoutYProperty().get();
                System.out.println(targetX);
                System.out.println(targetY);
                break;

            case 22:
                targetX = FXMLDocumentController.pos22Estatico.layoutXProperty().get();
                targetY = FXMLDocumentController.pos22Estatico.layoutYProperty().get();
                System.out.println(targetX);
                System.out.println(targetY);
                break;

            case 23:
                targetX = FXMLDocumentController.pos23Estatico.layoutXProperty().get();
                targetY = FXMLDocumentController.pos23Estatico.layoutYProperty().get();
                System.out.println(targetX);
                System.out.println(targetY);
                break;

            case 24:
                targetX = FXMLDocumentController.pos24Estatico.layoutXProperty().get();
                targetY = FXMLDocumentController.pos24Estatico.layoutYProperty().get();
                System.out.println(targetX);
                System.out.println(targetY);
                break;
                
                
            default:
                // Handle the case when an invalid position is provided
                return;
        }

        switch (peca) {
            case "1":
                FXMLDocumentController.p1Estatico.layoutXProperty().set(targetX);
                FXMLDocumentController.p1Estatico.layoutYProperty().set(targetY);
                targetX = FXMLDocumentController.p1Estatico.layoutXProperty().get();
                targetY = FXMLDocumentController.p1Estatico.layoutYProperty().get();
                System.out.println(targetX);
                System.out.println(targetY);

                break;
                
                case "2":
                FXMLDocumentController.p2Estatico.layoutXProperty().set(targetX);
                FXMLDocumentController.p2Estatico.layoutYProperty().set(targetY);
                targetX = FXMLDocumentController.p2Estatico.layoutXProperty().get();
                targetY = FXMLDocumentController.p2Estatico.layoutYProperty().get();
                System.out.println(targetX);
                System.out.println(targetY);

                break;
                
                case "3":
                FXMLDocumentController.p3Estatico.layoutXProperty().set(targetX);
                FXMLDocumentController.p3Estatico.layoutYProperty().set(targetY);
                targetX = FXMLDocumentController.p3Estatico.layoutXProperty().get();
                targetY = FXMLDocumentController.p3Estatico.layoutYProperty().get();
                System.out.println(targetX);
                System.out.println(targetY);

                break;
                
                case "4":
                FXMLDocumentController.p4Estatico.layoutXProperty().set(targetX);
                FXMLDocumentController.p4Estatico.layoutYProperty().set(targetY);
                targetX = FXMLDocumentController.p4Estatico.layoutXProperty().get();
                targetY = FXMLDocumentController.p4Estatico.layoutYProperty().get();
                System.out.println(targetX);
                System.out.println(targetY);

                break;
                
                case "5":
                FXMLDocumentController.p5Estatico.layoutXProperty().set(targetX);
                FXMLDocumentController.p5Estatico.layoutYProperty().set(targetY);
                targetX = FXMLDocumentController.p5Estatico.layoutXProperty().get();
                targetY = FXMLDocumentController.p5Estatico.layoutYProperty().get();
                System.out.println(targetX);
                System.out.println(targetY);

                break;
                
                case "6":
                FXMLDocumentController.p6Estatico.layoutXProperty().set(targetX);
                FXMLDocumentController.p6Estatico.layoutYProperty().set(targetY);
                targetX = FXMLDocumentController.p7Estatico.layoutXProperty().get();
                targetY = FXMLDocumentController.p7Estatico.layoutYProperty().get();
                System.out.println(targetX);
                System.out.println(targetY);

                break;
                
                case "7":
                FXMLDocumentController.p7Estatico.layoutXProperty().set(targetX);
                FXMLDocumentController.p7Estatico.layoutYProperty().set(targetY);
                targetX = FXMLDocumentController.p7Estatico.layoutXProperty().get();
                targetY = FXMLDocumentController.p7Estatico.layoutYProperty().get();
                System.out.println(targetX);
                System.out.println(targetY);

                break;
                
                case "8":
                FXMLDocumentController.p8Estatico.layoutXProperty().set(targetX);
                FXMLDocumentController.p8Estatico.layoutYProperty().set(targetY);
                targetX = FXMLDocumentController.p8Estatico.layoutXProperty().get();
                targetY = FXMLDocumentController.p8Estatico.layoutYProperty().get();
                System.out.println(targetX);
                System.out.println(targetY);

                break;
                
                case "9":
                FXMLDocumentController.p9Estatico.layoutXProperty().set(targetX);
                FXMLDocumentController.p9Estatico.layoutYProperty().set(targetY);
                targetX = FXMLDocumentController.p9Estatico.layoutXProperty().get();
                targetY = FXMLDocumentController.p9Estatico.layoutYProperty().get();
                System.out.println(targetX);
                System.out.println(targetY);

                break;
                
                case "10":
                FXMLDocumentController.p10Estatico.layoutXProperty().set(targetX);
                FXMLDocumentController.p10Estatico.layoutYProperty().set(targetY);
                targetX = FXMLDocumentController.p10Estatico.layoutXProperty().get();
                targetY = FXMLDocumentController.p10Estatico.layoutYProperty().get();
                System.out.println(targetX);
                System.out.println(targetY);

                break;
                
                case "11":
                FXMLDocumentController.p11Estatico.layoutXProperty().set(targetX);
                FXMLDocumentController.p11Estatico.layoutYProperty().set(targetY);
                targetX = FXMLDocumentController.p11Estatico.layoutXProperty().get();
                targetY = FXMLDocumentController.p11Estatico.layoutYProperty().get();
                System.out.println(targetX);
                System.out.println(targetY);

                break;
                
                case "12":
                FXMLDocumentController.p12Estatico.layoutXProperty().set(targetX);
                FXMLDocumentController.p12Estatico.layoutYProperty().set(targetY);
                targetX = FXMLDocumentController.p12Estatico.layoutXProperty().get();
                targetY = FXMLDocumentController.p12Estatico.layoutYProperty().get();
                System.out.println(targetX);
                System.out.println(targetY);

                break;
                
                case "13":
                FXMLDocumentController.p13Estatico.layoutXProperty().set(targetX);
                FXMLDocumentController.p13Estatico.layoutYProperty().set(targetY);
                targetX = FXMLDocumentController.p13Estatico.layoutXProperty().get();
                targetY = FXMLDocumentController.p13Estatico.layoutYProperty().get();
                System.out.println(targetX);
                System.out.println(targetY);

                break;
                
                case "14":
                FXMLDocumentController.p14Estatico.layoutXProperty().set(targetX);
                FXMLDocumentController.p14Estatico.layoutYProperty().set(targetY);
                targetX = FXMLDocumentController.p14Estatico.layoutXProperty().get();
                targetY = FXMLDocumentController.p14Estatico.layoutYProperty().get();
                System.out.println(targetX);
                System.out.println(targetY);

                break;
                
                case "15":
                FXMLDocumentController.p15Estatico.layoutXProperty().set(targetX);
                FXMLDocumentController.p15Estatico.layoutYProperty().set(targetY);
                targetX = FXMLDocumentController.p15Estatico.layoutXProperty().get();
                targetY = FXMLDocumentController.p15Estatico.layoutYProperty().get();
                System.out.println(targetX);
                System.out.println(targetY);

                break;

            case "16":
                FXMLDocumentController.p16Estatico.layoutXProperty().set(targetX);
                FXMLDocumentController.p16Estatico.layoutYProperty().set(targetY);
                targetX = FXMLDocumentController.p16Estatico.layoutXProperty().get();
                targetY = FXMLDocumentController.p16Estatico.layoutYProperty().get();
                System.out.println(targetX);
                System.out.println(targetY);

                break;
                
                case "17":
                FXMLDocumentController.p17Estatico.layoutXProperty().set(targetX);
                FXMLDocumentController.p17Estatico.layoutYProperty().set(targetY);
                targetX = FXMLDocumentController.p17Estatico.layoutXProperty().get();
                targetY = FXMLDocumentController.p17Estatico.layoutYProperty().get();
                System.out.println(targetX);
                System.out.println(targetY);

                break;
                
                case "18":
                FXMLDocumentController.p18Estatico.layoutXProperty().set(targetX);
                FXMLDocumentController.p18Estatico.layoutYProperty().set(targetY);
                targetX = FXMLDocumentController.p18Estatico.layoutXProperty().get();
                targetY = FXMLDocumentController.p18Estatico.layoutYProperty().get();
                System.out.println(targetX);
                System.out.println(targetY);

                break;
                
                case "19":
                FXMLDocumentController.p19Estatico.layoutXProperty().set(targetX);
                FXMLDocumentController.p19Estatico.layoutYProperty().set(targetY);
                targetX = FXMLDocumentController.p19Estatico.layoutXProperty().get();
                targetY = FXMLDocumentController.p19Estatico.layoutYProperty().get();
                System.out.println(targetX);
                System.out.println(targetY);

                break;
                
                case "20":
                FXMLDocumentController.p20Estatico.layoutXProperty().set(targetX);
                FXMLDocumentController.p20Estatico.layoutYProperty().set(targetY);
                targetX = FXMLDocumentController.p20Estatico.layoutXProperty().get();
                targetY = FXMLDocumentController.p20Estatico.layoutYProperty().get();
                System.out.println(targetX);
                System.out.println(targetY);

                break;
                
                case "21":
                FXMLDocumentController.p21Estatico.layoutXProperty().set(targetX);
                FXMLDocumentController.p21Estatico.layoutYProperty().set(targetY);
                targetX = FXMLDocumentController.p21Estatico.layoutXProperty().get();
                targetY = FXMLDocumentController.p21Estatico.layoutYProperty().get();
                System.out.println(targetX);
                System.out.println(targetY);

                break;
                
                case "22":
                FXMLDocumentController.p22Estatico.layoutXProperty().set(targetX);
                FXMLDocumentController.p22Estatico.layoutYProperty().set(targetY);
                targetX = FXMLDocumentController.p22Estatico.layoutXProperty().get();
                targetY = FXMLDocumentController.p22Estatico.layoutYProperty().get();
                System.out.println(targetX);
                System.out.println(targetY);

                break;
                
                case "23":
                FXMLDocumentController.p23Estatico.layoutXProperty().set(targetX);
                FXMLDocumentController.p23Estatico.layoutYProperty().set(targetY);
                targetX = FXMLDocumentController.p23Estatico.layoutXProperty().get();
                targetY = FXMLDocumentController.p23Estatico.layoutYProperty().get();
                System.out.println(targetX);
                System.out.println(targetY);

                break;
                
                case "24":
                FXMLDocumentController.p24Estatico.layoutXProperty().set(targetX);
                FXMLDocumentController.p24Estatico.layoutYProperty().set(targetY);
                targetX = FXMLDocumentController.p24Estatico.layoutXProperty().get();
                targetY = FXMLDocumentController.p24Estatico.layoutYProperty().get();
                System.out.println(targetX);
                System.out.println(targetY);

                break;
                
                case "25":
                FXMLDocumentController.p25Estatico.layoutXProperty().set(targetX);
                FXMLDocumentController.p25Estatico.layoutYProperty().set(targetY);
                targetX = FXMLDocumentController.p25Estatico.layoutXProperty().get();
                targetY = FXMLDocumentController.p25Estatico.layoutYProperty().get();
                System.out.println(targetX);
                System.out.println(targetY);

                break;
                
                case "26":
                FXMLDocumentController.p26Estatico.layoutXProperty().set(targetX);
                FXMLDocumentController.p26Estatico.layoutYProperty().set(targetY);
                targetX = FXMLDocumentController.p26Estatico.layoutXProperty().get();
                targetY = FXMLDocumentController.p26Estatico.layoutYProperty().get();
                System.out.println(targetX);
                System.out.println(targetY);

                break;
                
                case "27":
                FXMLDocumentController.p27Estatico.layoutXProperty().set(targetX);
                FXMLDocumentController.p27Estatico.layoutYProperty().set(targetY);
                targetX = FXMLDocumentController.p27Estatico.layoutXProperty().get();
                targetY = FXMLDocumentController.p27Estatico.layoutYProperty().get();
                System.out.println(targetX);
                System.out.println(targetY);

                break;
                
                case "28":
                FXMLDocumentController.p28Estatico.layoutXProperty().set(targetX);
                FXMLDocumentController.p28Estatico.layoutYProperty().set(targetY);
                targetX = FXMLDocumentController.p28Estatico.layoutXProperty().get();
                targetY = FXMLDocumentController.p28Estatico.layoutYProperty().get();
                System.out.println(targetX);
                System.out.println(targetY);

                break;
                
                case "29":
                FXMLDocumentController.p29Estatico.layoutXProperty().set(targetX);
                FXMLDocumentController.p29Estatico.layoutYProperty().set(targetY);
                targetX = FXMLDocumentController.p29Estatico.layoutXProperty().get();
                targetY = FXMLDocumentController.p29Estatico.layoutYProperty().get();
                System.out.println(targetX);
                System.out.println(targetY);

                break;
                
                case "30":
                FXMLDocumentController.p30Estatico.layoutXProperty().set(targetX);
                FXMLDocumentController.p30Estatico.layoutYProperty().set(targetY);
                targetX = FXMLDocumentController.p30Estatico.layoutXProperty().get();
                targetY = FXMLDocumentController.p30Estatico.layoutYProperty().get();
                System.out.println(targetX);
                System.out.println(targetY);

                break;

            default:
                // Handle the case when an invalid position is provided
                return;
        }

    }

    public void lancouDados() {
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
                FXMLDocumentController.text1Estatico.setText("0");
                FXMLDocumentController.text2Estatico.setText("0");
                FXMLDocumentController.text3Estatico.setText("0");
                
            } else {
                FXMLDocumentController.jogadaEstatico.setDisable(false);
                FXMLDocumentController.lancardadosEstatico.setDisable(false);
                FXMLDocumentController.jogarEstatico.setDisable(false);
                FXMLDocumentController.pecaidEstatico.setDisable(false);
                FXMLDocumentController.posicaoidEstatico.setDisable(false);
                FXMLDocumentController.text1Estatico.setText("0");
                FXMLDocumentController.text2Estatico.setText("0");
                FXMLDocumentController.text3Estatico.setText("0");
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
