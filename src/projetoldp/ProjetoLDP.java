/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetoldp;

import java.io.ObjectOutputStream;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author gaalm
 */
public class ProjetoLDP {
    
    ObjectOutputStream out;
    
    public ProjetoLDP(ObjectOutputStream out) {
        this.out = out;
    }
    
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    }
    
    
    public void displayDados(int d1,int d2,int d3){
        
        
        System.out.println("sdlkfjgnkspdfgnjskdjfgnlskdfnglksdjnfglksdfgnlksdjfg");
        FXMLDocumentController.text1Estatico.setText("" + d1);
        FXMLDocumentController.text2Estatico.setText("" + d2);
        FXMLDocumentController.text3Estatico.setText("" + d3);
    }
}
