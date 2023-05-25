/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetoldp;

import java.io.*;
import java.net.*;
import static javafx.application.Application.launch;

/**
 *
 * @author gaalm
 */
public class GameServer {

    private ServerSocket ss;
    private int numPlayers;
    private ServerSideConnection player1;
    private ServerSideConnection player2;
    private int turnsMade;
    private int maxTurns;
    private int[] values;
    
    public GameServer() {
        System.out.println("-----Game Servers");
        numPlayers = 0;
        turnsMade = 0;
        maxTurns = 4;
        values = new int[4];
        
        for( int i =0; i< values.length; i++){
            
        }
        try {
            ss = new ServerSocket(51734);

        } catch (IOException ex) {
            System.out.println("IOException from GameServer Constructor");
        }

    }

    public void acceptConnections() {
        try {
            System.out.println("Waiting for Connections...");
            while (numPlayers < 2) {
                Socket s = ss.accept();
                numPlayers++;
                System.out.println("Player #" + numPlayers + "conectou-se.");
                ServerSideConnection ssc = new ServerSideConnection(s, numPlayers);
                if(numPlayers == 1){
                    player1= ssc;
                }else{
                    player2 = ssc;
                }
                Thread t = new Thread(ssc);
                t.start();
            }
            System.out.println("Dois players já se conectaram, deixamos de aceitar conecções");
        } catch (IOException ex) {
            System.out.println("IOException from acceptConnection()");
        }
    }

    private class ServerSideConnection implements Runnable {

        private Socket socket;
        private DataInputStream dataIn;
        private DataOutputStream dataOut;
        private int playerID;
        
        public ServerSideConnection(Socket s, int id ){
            socket = s;
            playerID = id;
            try{
                dataIn = new DataInputStream(socket.getInputStream());
                dataOut = new DataOutputStream(socket.getOutputStream());
                
            }catch(IOException ex){
                System.out.println("IOException from Server Side Connection Constructor");
            }
        }
        public void run(){
            try{
                dataOut.writeInt(playerID);
                dataOut.flush();
                while(true){
                    
                }
            }catch(IOException ex){
                System.out.println("IOException from run in Server Side Connection");
            }
        }
    }

    public static void main(String[] args) {
        GameServer gs = new GameServer();
        gs.acceptConnections();
          
    }
}
