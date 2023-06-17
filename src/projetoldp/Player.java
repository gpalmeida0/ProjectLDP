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
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import static projetoldp.FXMLDocumentController.lancardadosEstatico;

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

    private static String serverIP = "127.0.0.1";
    private static final int serverPort = 6666;
    static DataInputStream in;
    static DataOutputStream out;
    static ObjectOutputStream objOut;
    static ObjectInputStream inObj;
    static String minhavez;
    private ProjetoLDP jogoInstancia;
    static boolean comecar;

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
        connectClient();
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

//        this.setVisible(true);
    }

    public void connectToServer() {
        csc = new ClientSideConnection();
        System.out.println("cabelo");
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

    public static void main(String[] args) {
        try {
            launch(args);
            System.out.println("Adeus..");
            out.writeUTF("#logout");
            System.exit(0);
        } catch (IOException ex) {
        }
    }

    //metodo para quando acabar o jogo
    private void jogoTerminado(String text) throws IOException {
        Platform.runLater(() -> {
            //FXMLDocumentController.escondeAnchorEstatico.setVisible(false);
            //FXMLDocumentController.labelVencedorEstatico.setText(text);
            //FXMLDocumentController.anchorVencedorEstatico.setVisible(true);
        });
    }

    private void connectClient() throws IOException {

        Socket socket = new Socket(serverIP, serverPort);

        in = new DataInputStream(socket.getInputStream());
        out = new DataOutputStream(socket.getOutputStream());

        objOut = new ObjectOutputStream(socket.getOutputStream());

        inObj = new ObjectInputStream(socket.getInputStream());
        jogoInstancia = new ProjetoLDP(objOut);

        String nomeJogadorserver = in.readUTF();
        System.out.println(nomeJogadorserver);
        String[] parts = nomeJogadorserver.split("\\s+");
        String numberString = parts[1];

// Convert the number string to an int
        int id = Integer.parseInt(numberString);
        System.out.println(id);

        jogoInstancia.pecasIndicativo(id);
// Print the number
        System.out.println("Number: " + id);
        comecar = true;
        // Thread que serve para o cliente envia mensagens para o servidor
        Thread enviarMensagem;
        enviarMensagem = new Thread(() -> {
            if (comecar) {
                try {
                    out.writeUTF("#nome");
                    comecar = false;
                } catch (IOException ex) {
                    Logger.getLogger(Player.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            FXMLDocumentController.lancardadosEstatico.setOnMousePressed(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {

                    try {
                        int[] dados = new int[3];

                        dados = jogoInstancia.geraDado();
                        jogoInstancia.lancouDados();
                        System.out.println(nomeJogadorserver);
                        out.writeUTF("#dados" + "-" + dados[0] + "-" + dados[1] + "-" + dados[2]);

                    } catch (IOException ex) {
                        System.out.println("IOException from click button");
                    }

                    //FXMLDocumentController.txtDadosEstatico.setText("Nabo");
                }
            });

            FXMLDocumentController.jogadaEstatico.setOnMousePressed(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {

                    try {

                        out.writeUTF("#vez"); //FXMLDocumentController.txtDadosEstatico.setText("Nabo");
                        System.out.println("qwedfrtyukil");
                    } catch (IOException ex) {
                        Logger.getLogger(Player.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }

            });

            FXMLDocumentController.jogarEstatico.setOnMousePressed(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {

                    try {
                        String peca = FXMLDocumentController.pecaidEstatico.getText();
                        String moverr = FXMLDocumentController.posicaoidEstatico.getText();
                        int mover = Integer.parseInt(moverr);
                        if (mover <= 12) {
                            //verificar se pode mover a casa
                            if (mover == Integer.parseInt(FXMLDocumentController.text1Estatico.getText())) {
                                out.writeUTF("#jogada" + "-" + peca + "-" + mover + "-" + id); //FXMLDocumentController.txtDadosEstatico.setText("Nabo");
                            } else if (mover == Integer.parseInt(FXMLDocumentController.text2Estatico.getText())) {
                                out.writeUTF("#jogada" + "-" + peca + "-" + mover + "-" + id); //FXMLDocumentController.txtDadosEstatico.setText("Nabo");
                            } else if (mover == Integer.parseInt(FXMLDocumentController.text3Estatico.getText())) {
                                out.writeUTF("#jogada" + "-" + peca + "-" + mover + "-" + id); //FXMLDocumentController.txtDadosEstatico.setText("Nabo");
                            } else if (mover == (Integer.parseInt(FXMLDocumentController.text1Estatico.getText()) + Integer.parseInt(FXMLDocumentController.text2Estatico.getText()))) {
                                out.writeUTF("#jogada" + "-" + peca + "-" + mover + "-" + id); //FXMLDocumentController.txtDadosEstatico.setText("Nabo");
                            } else if (mover == (Integer.parseInt(FXMLDocumentController.text1Estatico.getText()) + Integer.parseInt(FXMLDocumentController.text3Estatico.getText()))) {
                                out.writeUTF("#jogada" + "-" + peca + "-" + mover + "-" + id); //FXMLDocumentController.txtDadosEstatico.setText("Nabo");
                            } else if (mover == (Integer.parseInt(FXMLDocumentController.text2Estatico.getText()) + Integer.parseInt(FXMLDocumentController.text3Estatico.getText()))) {
                                out.writeUTF("#jogada" + "-" + peca + "-" + mover + "-" + id); //FXMLDocumentController.txtDadosEstatico.setText("Nabo");
                            } else if (mover == (Integer.parseInt(FXMLDocumentController.text1Estatico.getText()) + Integer.parseInt(FXMLDocumentController.text2Estatico.getText()) + Integer.parseInt(FXMLDocumentController.text3Estatico.getText()))) {
                                out.writeUTF("#jogada" + "-" + peca + "-" + mover + "-" + id); //FXMLDocumentController.txtDadosEstatico.setText("Nabo");
                            }

                        }

                    } catch (IOException ex) {
                        Logger.getLogger(Player.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }

            });

        });

        Thread lerMensagem;
        lerMensagem = new Thread(() -> {
            while (true) {

                //
                try {

                    //usar este sistema para comunicar com o jogo
                    String msg = in.readUTF();
                    System.out.println(msg);

                    if (msg.startsWith("#dados")) {
                        String[] msgSplit = msg.split("-");
                        int dado1 = Integer.parseInt(msgSplit[1]);
                        int dado2 = Integer.parseInt(msgSplit[2]);
                        int dado3 = Integer.parseInt(msgSplit[3]);

                        jogoInstancia.displayDados(dado1, dado2, dado3);
                    } else if (msg.startsWith("#vez")) {

                        jogoInstancia.mudaVez();

                    } else if (msg.startsWith("#nome")) {

                        String[] msgSplit = msg.split("-");
                        boolean vez = Boolean.parseBoolean(msgSplit[1]);
                        jogoInstancia.iniciaJogo(vez);
                        System.out.println("fsadfsdf: " + msg);

                    } else if (msg.startsWith("#jogada")) {
                        String[] msgSplit = msg.split("-");
                        String peca = msgSplit[1];
                        int mover = Integer.parseInt(msgSplit[2]);
                        int posicao = Integer.parseInt(msgSplit[3]);
                        int atacada = Integer.parseInt(msgSplit[4]);
                        boolean podeMover2Etapa = Boolean.parseBoolean(msgSplit[5]);
                        
                        if (posicao <= 12) {
                            
                            if (mover <= 12) {

                                //verificar se pode mover a casa
                                if (mover == Integer.parseInt(FXMLDocumentController.text1Estatico.getText())) {
                                    FXMLDocumentController.text1Estatico.setText("0");
                                    jogoInstancia.movePeca(peca, posicao, atacada);

                                } else if (mover == Integer.parseInt(FXMLDocumentController.text2Estatico.getText())) {
                                    FXMLDocumentController.text2Estatico.setText("0");
                                    jogoInstancia.movePeca(peca, posicao, atacada);
                                } else if (mover == Integer.parseInt(FXMLDocumentController.text3Estatico.getText())) {
                                    FXMLDocumentController.text3Estatico.setText("0");
                                    jogoInstancia.movePeca(peca, posicao, atacada);
                                } else if (mover == (Integer.parseInt(FXMLDocumentController.text1Estatico.getText()) + Integer.parseInt(FXMLDocumentController.text2Estatico.getText()))) {
                                    FXMLDocumentController.text1Estatico.setText("0");
                                    FXMLDocumentController.text2Estatico.setText("0");
                                    jogoInstancia.movePeca(peca, posicao, atacada);
                                } else if (mover == (Integer.parseInt(FXMLDocumentController.text1Estatico.getText()) + Integer.parseInt(FXMLDocumentController.text3Estatico.getText()))) {
                                    FXMLDocumentController.text1Estatico.setText("0");
                                    FXMLDocumentController.text3Estatico.setText("0");
                                    jogoInstancia.movePeca(peca, posicao, atacada);
                                } else if (mover == (Integer.parseInt(FXMLDocumentController.text2Estatico.getText()) + Integer.parseInt(FXMLDocumentController.text3Estatico.getText()))) {
                                    FXMLDocumentController.text2Estatico.setText("0");
                                    FXMLDocumentController.text3Estatico.setText("0");
                                    jogoInstancia.movePeca(peca, posicao, atacada);
                                } else if (mover == (Integer.parseInt(FXMLDocumentController.text1Estatico.getText()) + Integer.parseInt(FXMLDocumentController.text2Estatico.getText()) + Integer.parseInt(FXMLDocumentController.text3Estatico.getText()))) {
                                    FXMLDocumentController.text1Estatico.setText("0");
                                    FXMLDocumentController.text2Estatico.setText("0");
                                    FXMLDocumentController.text3Estatico.setText("0");
                                    jogoInstancia.movePeca(peca, posicao, atacada);
                                }

                            }
                        }else{
                            if(podeMover2Etapa){
                            //verificar se pode mover a casa
                                if (mover == Integer.parseInt(FXMLDocumentController.text1Estatico.getText())) {
                                    FXMLDocumentController.text1Estatico.setText("0");
                                    jogoInstancia.movePeca(peca, posicao, atacada);

                                } else if (mover == Integer.parseInt(FXMLDocumentController.text2Estatico.getText())) {
                                    FXMLDocumentController.text2Estatico.setText("0");
                                    jogoInstancia.movePeca(peca, posicao, atacada);
                                } else if (mover == Integer.parseInt(FXMLDocumentController.text3Estatico.getText())) {
                                    FXMLDocumentController.text3Estatico.setText("0");
                                    jogoInstancia.movePeca(peca, posicao, atacada);
                                } else if (mover == (Integer.parseInt(FXMLDocumentController.text1Estatico.getText()) + Integer.parseInt(FXMLDocumentController.text2Estatico.getText()))) {
                                    FXMLDocumentController.text1Estatico.setText("0");
                                    FXMLDocumentController.text2Estatico.setText("0");
                                    jogoInstancia.movePeca(peca, posicao, atacada);
                                } else if (mover == (Integer.parseInt(FXMLDocumentController.text1Estatico.getText()) + Integer.parseInt(FXMLDocumentController.text3Estatico.getText()))) {
                                    FXMLDocumentController.text1Estatico.setText("0");
                                    FXMLDocumentController.text3Estatico.setText("0");
                                    jogoInstancia.movePeca(peca, posicao, atacada);
                                } else if (mover == (Integer.parseInt(FXMLDocumentController.text2Estatico.getText()) + Integer.parseInt(FXMLDocumentController.text3Estatico.getText()))) {
                                    FXMLDocumentController.text2Estatico.setText("0");
                                    FXMLDocumentController.text3Estatico.setText("0");
                                    jogoInstancia.movePeca(peca, posicao, atacada);
                                } else if (mover == (Integer.parseInt(FXMLDocumentController.text1Estatico.getText()) + Integer.parseInt(FXMLDocumentController.text2Estatico.getText()) + Integer.parseInt(FXMLDocumentController.text3Estatico.getText()))) {
                                    FXMLDocumentController.text1Estatico.setText("0");
                                    FXMLDocumentController.text2Estatico.setText("0");
                                    FXMLDocumentController.text3Estatico.setText("0");
                                    jogoInstancia.movePeca(peca, posicao, atacada);
                                }
                        }
                        }
                    }else if (msg.startsWith("#retirarpeca")) {
                        String[] msgSplit = msg.split("-");
                        String peca = msgSplit[1];
                        jogoInstancia.retiraPeca(peca);
                    }

                } catch (IOException e) {

                }
            }
        });
        lerMensagem.start();
        enviarMensagem.start();

    }
}
