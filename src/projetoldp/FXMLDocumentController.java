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
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TextArea;
import javafx.scene.layout.StackPane;
import javafx.scene.text.*;

/**
 *
 *
 * @author gaalm
 */
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
    private Rectangle pos2;
    public static Rectangle pos2Estatico;

    @FXML
    private Rectangle pos3;
    public static Rectangle pos3Estatico;

    @FXML
    private Rectangle pos4;
    public static Rectangle pos4Estatico;

    @FXML
    private Rectangle pos5;
    public static Rectangle pos5Estatico;

    @FXML
    private Rectangle pos6;
    public static Rectangle pos6Estatico;

    @FXML
    private Rectangle pos7;
    public static Rectangle pos7Estatico;

    @FXML
    private Rectangle pos8;
    public static Rectangle pos8Estatico;

    @FXML
    private Rectangle pos9;
    public static Rectangle pos9Estatico;

    @FXML
    private Rectangle pos10;
    public static Rectangle pos10Estatico;

    @FXML
    private Rectangle pos11;
    public static Rectangle pos11Estatico;

    @FXML
    private Rectangle pos12;
    public static Rectangle pos12Estatico;

    @FXML
    private Rectangle pos13;
    public static Rectangle pos13Estatico;

    @FXML
    private Rectangle pos14;
    public static Rectangle pos14Estatico;

    @FXML
    private Rectangle pos15;
    public static Rectangle pos15Estatico;

    @FXML
    private Rectangle pos16;
    public static Rectangle pos16Estatico;

    @FXML
    private Rectangle pos17;
    public static Rectangle pos17Estatico;

    @FXML
    private Rectangle pos18;
    public static Rectangle pos18Estatico;

    @FXML
    private Rectangle pos19;
    public static Rectangle pos19Estatico;

    @FXML
    private Rectangle pos20;
    public static Rectangle pos20Estatico;

    @FXML
    private Rectangle pos21;
    public static Rectangle pos21Estatico;

    @FXML
    private Rectangle pos22;
    public static Rectangle pos22Estatico;

    @FXML
    private Rectangle pos23;
    public static Rectangle pos23Estatico;

    @FXML
    private Rectangle pos24;
    public static Rectangle pos24Estatico;
    
    @FXML
    private Label indicativoPecas1;
    public static Label indicativoPecas1Estatico;
    
    @FXML
    private Label indicativoPecas2;
    public static Label indicativoPecas2Estatico;

    @FXML
    private StackPane p1;
    public static StackPane p1Estatico;

    @FXML
    private StackPane p2;
    public static StackPane p2Estatico;
    
    @FXML
    private StackPane p3;
    public static StackPane p3Estatico;
    
    @FXML
    private StackPane p4;
    public static StackPane p4Estatico;
    
    @FXML
    private StackPane p5;
    public static StackPane p5Estatico;
    
    @FXML
    private StackPane p6;
    public static StackPane p6Estatico;
    
    @FXML
    private StackPane p7;
    public static StackPane p7Estatico;
    
    @FXML
    private StackPane p8;
    public static StackPane p8Estatico;
    
    @FXML
    private StackPane p9;
    public static StackPane p9Estatico;
    
    @FXML
    private StackPane p10;
    public static StackPane p10Estatico;
    
    @FXML
    private StackPane p11;
    public static StackPane p11Estatico;
    
    @FXML
    private StackPane p12;
    public static StackPane p12Estatico;
    
    @FXML
    private StackPane p13;
    public static StackPane p13Estatico;
    
    @FXML
    private StackPane p14;
    public static StackPane p14Estatico;
    
    @FXML
    private StackPane p15;
    public static StackPane p15Estatico;
    
    
    @FXML
    private StackPane p16;
    public static StackPane p16Estatico;
    
    @FXML
    private StackPane p17;
    public static StackPane p17Estatico;
    
    @FXML
    private StackPane p18;
    public static StackPane p18Estatico;
    
    @FXML
    private StackPane p19;
    public static StackPane p19Estatico;
    
    @FXML
    private StackPane p20;
    public static StackPane p20Estatico;
    
    @FXML
    private StackPane p21;
    public static StackPane p21Estatico;
    
    @FXML
    private StackPane p22;
    public static StackPane p22Estatico;
    
    @FXML
    private StackPane p23;
    public static StackPane p23Estatico;
    
    @FXML
    private StackPane p24;
    public static StackPane p24Estatico;
    
    @FXML
    private StackPane p25;
    public static StackPane p25Estatico;
    
    @FXML
    private StackPane p26;
    public static StackPane p26Estatico;
    
    @FXML
    private StackPane p27;
    public static StackPane p27Estatico;
    
    @FXML
    private StackPane p28;
    public static StackPane p28Estatico;
    
    @FXML
    private StackPane p29;
    public static StackPane p29Estatico;
    
    @FXML
    private StackPane p30;
    public static StackPane p30Estatico;
    
    
    

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
        pos2Estatico = pos2;
        pos3Estatico = pos3;
        pos4Estatico = pos4;
        pos5Estatico = pos5;
        pos6Estatico = pos6;
        pos7Estatico = pos7;
        pos8Estatico = pos8;
        pos9Estatico = pos9;
        pos10Estatico = pos10;
        pos11Estatico = pos11;
        pos12Estatico = pos12;
        pos13Estatico = pos13;
        pos14Estatico = pos14;
        pos15Estatico = pos15;
        pos16Estatico = pos16;
        pos17Estatico = pos17;
        pos18Estatico = pos18;
        pos19Estatico = pos19;
        pos20Estatico = pos20;
        pos21Estatico = pos21;
        pos22Estatico = pos22;
        pos23Estatico = pos23;
        pos24Estatico = pos24;
        p1Estatico = p1;
        p2Estatico = p2;
        p3Estatico = p3;
        p4Estatico = p4;
        p5Estatico = p5;
        p6Estatico = p6;
        p7Estatico = p7;
        p8Estatico = p8;
        p9Estatico = p9;
        p10Estatico = p10;
        p11Estatico = p11;
        p12Estatico = p12;
        p13Estatico = p13;
        p14Estatico = p14;
        p15Estatico = p15;
        p16Estatico = p16;
        p17Estatico = p17;
        p18Estatico = p18;
        p19Estatico = p19;
        p20Estatico = p20;
        p21Estatico = p21;
        p22Estatico = p22;
        p23Estatico = p23;
        p24Estatico = p24;
        p25Estatico = p25;
        p26Estatico = p26;
        p27Estatico = p27;
        p28Estatico = p28;
        p29Estatico = p29;
        p30Estatico = p24;
        indicativoPecas1Estatico = indicativoPecas1;
        indicativoPecas2Estatico = indicativoPecas2;
       
        
        

    }

}
