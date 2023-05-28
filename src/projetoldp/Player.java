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
        minhavez = in.readUTF();
        System.out.println("" + minhavez);

        // Thread que serve para o cliente envia mensagens para o servidor
        Thread enviarMensagem;
        enviarMensagem = new Thread(() -> {
            
           
                  
                FXMLDocumentController.lancardadosEstatico.setOnMousePressed(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {

                        try {

                            int dado1, dado2, dado3;
                            System.out.println(nomeJogadorserver);
                            //LANÇA O DADO E OBTÉM UM VALOR ENTRE 1 e 6
                            dado1 = (int) (Math.random() * 6 + 1);
                            dado2 = (int) (Math.random() * 6 + 1);
                            dado3 = (int) (Math.random() * 6 + 1);

                            out.writeUTF("#dados" + "-" + dado1 + "-" + dado2 + "-" + dado3);
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
                        } catch (IOException ex) {
                            Logger.getLogger(Player.class.getName()).log(Level.SEVERE, null, ex);
                        }
                     
                    }
                 
                });
                
                
                
                
           

            //coisas de logout...
            /*FXMLDocumentController.logoutButtonEstatico.setOnMousePressed(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    try {
                        Stage stage = (Stage) FXMLDocumentController.logoutButtonEstatico.getScene().getWindow();
                        out.writeUTF("#logout");
                        stage.close();
                        System.exit(0);
                    } catch (IOException ex) {
                        Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

            });*/
            //Serve para clicar em objetos e fazer coisas......... 
            /*FXMLDocumentController.mapaAdversarioEstatico.setOnMouseClicked(event -> {
                javafx.scene.shape.Rectangle rect = (javafx.scene.shape.Rectangle)event.getTarget();
                try{
                    byte x = FXMLDocumentController.mapaAdversarioEstatico.getColumnIndex(rect).byteValue(),
                         y = FXMLDocumentController.mapaAdversarioEstatico.getRowIndex(rect).byteValue();
                    // verifica que se ainda nao disparou na posicao
                    if(!jogoInstancia.jaDisparou(x, y)){
                        boolean acertou = jogoInstancia.meuDisparo(x, y);
                        
                        // #disparo-x-y-acertou
                        String msg = "#disparo-" + x + "-" + y + "-" + acertou;
                        if(this.jogoInstancia.isJogoTerminado()){
                            // apenas para construir a mensagem e avisar o adversario que perdeu
                            msg += "-terminado";
                        }
                        out.writeUTF(msg);
                        if(this.jogoInstancia.isJogoTerminado()){
                            // jogo terminado, notificar o cliente que ganhou o jogo e perguntar se deseja jogar mais                                                                                  
                            jogoTerminado("Parabéns, ganhou o jogo!\nDeseja jogar mais?");
                        }
                    }
                } catch (IOException ex) {
                    Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
                }
            });*/
         
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
                    }
                    
                    if (msg.startsWith("#vez")) {
                        

                        jogoInstancia.mudaVez();
                    }
                   

                    /*if(msg.startsWith("#disparo")){
                        // #disparo-x-y-acertou ou #disparo-x-y-acertou-terminado
                        String[] msgSplit = msg.split("-");
                        int x = Integer.parseInt(msgSplit[1]);
                        int y = Integer.parseInt(msgSplit[2]);
                        boolean acertou = Boolean.parseBoolean(msgSplit[3]);
                        jogoInstancia.disparoAdversario(x, y, acertou);
                        // significa que o jogo terminou
                        if(msgSplit.length == 5){
                            jogoTerminado("O seu adversário ganhou...");
                        }
                    }
                    else if (msg.startsWith("#chat")) {
                        // #chat-id-nome-conteudo
                        String[] msgSplit = msg.split("-");
                        String time = getMyTime();
                        String parseMessage = "[" + time + "] " + msgSplit[2] + " : " + msgSplit[3];
                        Platform.runLater(() -> {
                            FXMLDocumentController.outputChatTextEstatico.appendText(parseMessage + "\n");
                            //FXMLDocumentController.textNomeJogador2Estatico.setText(obj1.nomePlayer);
                        });

                    } 
                    else if(msg.startsWith("#salacheia")){
                        System.out.println("Não pode jogar.. Aguarde que um dos dois jogadores acabem de jogar ou saiam do jogo..");   
                        Platform.runLater(() -> {
                            Stage stage = (Stage) FXMLDocumentController.boxNomeEstatico.getScene().getWindow();
                            stage.close();
                            System.exit(0);
                        });
                        
                    }
                    else if(msg.startsWith("#nome")){
                        // #nome-nomeJogador ou #nome-nomeJogador-pronto-vez
                        String[] msgSplit = msg.split("-");
                        String jogador = nomeAdversario = msgSplit[1];
                        Boolean pronto = false;
                        // verifica se o jogo se encontra pronto para começar
                        if(msgSplit.length == 4 && msgSplit[2].equals("pronto")) pronto = true; 
                        String time = getMyTime();
                        String newMsg = "[" + time + "] Jogador " + jogador + " entrou...";
                        MapaInfo mapaAdversario = (MapaInfo) inObj.readObject();
                        jogoInstancia.setNaviosAdversario(mapaAdversario.mapaNavios);
                        jogoInstancia.setPosicoesNaviosAdversario(mapaAdversario.posicoesNavios);
                        System.out.println(newMsg);
                        Platform.runLater(() -> {
                            FXMLDocumentController.outputChatTextEstatico.appendText(newMsg + "\n");
                            FXMLDocumentController.labelBatalhaEstatico.setText("Batalha: " + textNomeEstatico.getText() + " vs " + jogador);
                        });
                        if(pronto){
                            boolean vez = Boolean.parseBoolean(msgSplit[3]);
                            jogoInstancia.iniciaJogo(vez);
                            Platform.runLater(() -> {
                                
                                FXMLDocumentController.labelDesistenciaEstatico.setVisible(false);
                                FXMLDocumentController.labelEsperaEstatico.setVisible(false);
                                FXMLDocumentController.escondeAnchorEstatico.setVisible(true);
                            });
                           
                        }
                    }
                    else if(msg.startsWith("#pronto")){
                        // #pronto-nomeJogador-vez
                        String[] msgSplit = msg.split("-");
                        nomeAdversario = msgSplit[1];
                        MapaInfo mapaAdversario = (MapaInfo) inObj.readObject();
                        boolean vez = Boolean.parseBoolean(msgSplit[2]);
                        jogoInstancia.setNaviosAdversario(mapaAdversario.mapaNavios);
                        jogoInstancia.setPosicoesNaviosAdversario(mapaAdversario.posicoesNavios);
                        jogoInstancia.iniciaJogo(vez);
                        Platform.runLater(() -> {
                            FXMLDocumentController.labelBatalhaEstatico.setText("Batalha: " + textNomeEstatico.getText() + " vs " + nomeAdversario);
                            FXMLDocumentController.labelEsperaEstatico.setVisible(false);
                            FXMLDocumentController.labelDesistenciaEstatico.setVisible(false);
                            //FXMLDocumentController.labelEsperaEstatico.setText(msg);
                            FXMLDocumentController.escondeAnchorEstatico.setVisible(true);
                        });
                    }
                    else if(msg.startsWith("#espera")){
                        // #espera-nada ou #espera-desistencia
                        String[] msgSplit = msg.split("-");
                        Platform.runLater(() -> {
                            FXMLDocumentController.escondeAnchorEstatico.setVisible(false);
                            FXMLDocumentController.anchorVencedorEstatico.setVisible(false);
                            FXMLDocumentController.labelEsperaEstatico.setVisible(true);
                            if(msgSplit[1].equals("nada")) FXMLDocumentController.labelDesistenciaEstatico.setVisible(false);
                            else FXMLDocumentController.labelDesistenciaEstatico.setVisible(true);
                        });
                    }
                    else if (msg.contains("logout")) {
                        // #logout-nomeAdversario
                        String[] msgSplit = msg.split("-");
                        String time = getMyTime();
                        String mensagem = "[" + time + "] Jogador " + msgSplit[1] + " abandonou a sala de jogo...\n";
                        MapaInfo mapa = null; 
                        while(mapa == null){
                            jogoInstancia = new Jogo(objOut);
                            mapa = jogoInstancia.geraMeusNavios();   
                        }
                        out.writeUTF("#novoMapa");
                        jogoInstancia.mandaMapa(mapa);
                        FXMLDocumentController.outputChatTextEstatico.appendText(mensagem);
                    }*/
                } catch (IOException e) {

                }
            }
        });
        lerMensagem.start();
        enviarMensagem.start();

    }
}
