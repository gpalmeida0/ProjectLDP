/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetoldp;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.net.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author gaalm
 */
public class Player extends Application {

    private int width;
    private int height;
    private Container contentPane;
    private JTextArea message;
    private JButton b1;
    private JButton b2;
    private JButton b3;
    private JButton b4;
    private ClientSideConnection csc;
    private int playerID;
    private int otherPlayer;
    
 @Override
    public void start(Stage primaryStage) throws Exception {
         Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
    Scene scene = new Scene(root);
    primaryStage.setScene(scene);
    primaryStage.show();
    }
    public Player(int w, int h) {
       
        //contentPane = this.getContentPane();
      

    }

    public Player() {
        // Empty constructor
    }

    public void setUpGUI() {
//        this.setSize(width, height);
//        this.setTitle("Player # "+playerID +" Tábula");
//        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        contentPane.setLayout(new GridLayout(1, 5));
        contentPane.add(message);
        message.setText("Creating a Tábula Game");
        message.setWrapStyleWord(true);
        message.setLineWrap(true);
        message.setEditable(false);
        contentPane.add(b1);
        contentPane.add(b2);
        contentPane.add(b3);
        contentPane.add(b4);

        if (playerID == 1) {
            message.setText("You are player number 1. You go first");
            otherPlayer = 2;
        } else {
            message.setText("You are player number 2. Wait for your turn");
            otherPlayer = 1;
        }
//        this.setVisible(true);

    }

    public void connectToServer() {
        csc = new ClientSideConnection();
    }

 

    //Client Connection Inner Class
    private class ClientSideConnection {

        private Socket socket;
        private DataInputStream dataIn;
        private DataOutputStream dataOut;

        public ClientSideConnection() {
            System.out.println("---Client---");
            try {
                socket = new Socket("localhost", 51734);
                dataIn = new DataInputStream(socket.getInputStream());
                dataOut = new DataOutputStream(socket.getOutputStream());
                playerID = dataIn.readInt();
                System.out.println("Connected to Server as Player #" + playerID + ".");

            } catch (IOException ex) {
                System.out.println("IOException from Client Side Connection Constructor");
            }
        }

    }
    
public void jogo(){
    if(playerID==1){
        
    }
}
    public static void main(String[] args) {
        Player p = new Player(500, 100);
        p.connectToServer();
        Application.launch(args);
        p.jogo();
///
    }
    
      
}
