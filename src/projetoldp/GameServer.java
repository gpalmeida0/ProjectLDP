/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetoldp;

import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javafx.application.Application.launch;

/**
 *
 * @author gaalm
 */
public class GameServer {

    private ServerSocket ss;
    private int numPlayers;
    private int turnsMade;
    private int maxTurns;
    private int[] values;

    private static int port = 6666, nClientes = 1;
    // lista de jogadores disponíveis
    private static List<ClientHandler> listaClientes = new ArrayList<>();
    // número de jogadores a jogar
    static int njogadores = 0;
    // id atribuido a um novo cliente
    static int id = 0;
    private static Socket s;
    static boolean minhavez = true;

    public static void main(String[] args) throws IOException {
        System.out.println("Servidor aceita conexões (à escuta na porta " + port + ") .");
        ServerSocket ss = new ServerSocket(port);

        Thread servidor = new Thread(() -> {

            while (true) {
                try {
                    s = ss.accept();

                    DataInputStream dis = new DataInputStream(s.getInputStream());
                    DataOutputStream dos = new DataOutputStream(s.getOutputStream());
                    ObjectInputStream in = new ObjectInputStream(s.getInputStream());
                    ObjectOutputStream objOut = new ObjectOutputStream(s.getOutputStream());

                    System.out.println("Novo client recebido : " + s);
                    ClientHandler mtch = new ClientHandler(s, "client " + id, dis, dos, id, in, objOut, minhavez);

                    Thread t = new Thread(mtch);

                    listaClientes.add(mtch);
                    dos.writeUTF("nomeJogador" + mtch.code);
                    dos.writeUTF(Boolean.toString(minhavez));
                    String idNome = Integer.toString(id);
                    t.setName(idNome);

                    t.start();

                    njogadores++;
                    id++;
                    minhavez = false;
                    System.out.println("Adiciona cliente " + id + " à lista ativa." + s.getInetAddress());

                } catch (IOException ex) {
                    Logger.getLogger(GameServer.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        servidor.start();
    }

    private static class ClientHandler implements Runnable {

        private String code;
        private String nome;
        final DataInputStream dis;
        final DataOutputStream dos;
        Socket s;
        boolean isloggedin;
        final int id;
        ObjectInputStream in;
        ObjectOutputStream objOut;
        private boolean prontoJogar;
        private boolean[][] mapaNavios;
        private List<String[]> posicoesNavios;
        private boolean jogoTerminado;
        boolean minhavez;

        private ClientHandler(Socket s, String string,
                DataInputStream dis, DataOutputStream dos, int id, ObjectInputStream in, ObjectOutputStream objOut, boolean minhavez) {
            this.s = s;
            this.dis = dis;
            this.dos = dos;
            this.code = string;
            this.id = id;
            this.isloggedin = true;
            this.in = in;
            this.objOut = objOut;
            this.nome = null;
            this.prontoJogar = false;
            this.jogoTerminado = false;
            this.minhavez = minhavez;
        }
        static String recebido;

        // verifica se os jogadores estão prontos para jogar
        private boolean verificaJogadoresProntos() {
            boolean result = true;
            if (GameServer.njogadores < 2) {
                result = false;
            } else {
                for (ClientHandler c : GameServer.listaClientes) {
                    if (!c.prontoJogar) {
                        result = false;
                    }
                }
            }
            return result;
        }

        // devolve o nome do outro jogador
        private String getNomeOutroJogador(String codeJogador) {
            String result = "";
            for (ClientHandler c : GameServer.listaClientes) {
                if (!c.code.equals(codeJogador)) {
                    result = c.nome;
                }
            }
            return result;
        }

        public boolean geraVez() {
            boolean result = false;
            Random r = new Random();
            int random = r.nextInt();
            if (random % 2 == 0) {
                result = true;
            }
            return result;
        }

        @Override
        public void run() {

            if (GameServer.njogadores > 2) {
                try {
                    System.out.println("Avisar que sala está cheia e remover jogador..");
                    dos.writeUTF("#salacheia");
                    this.isloggedin = false;
                    GameServer.listaClientes.remove(this);
                    GameServer.njogadores--;
                    this.s.close();
                    return;
                } catch (Exception e) {
                };
            }
            Thread cliente = new Thread(() -> {
                while (true) {

                    try {
                        recebido = dis.readUTF();

                        if (recebido.startsWith("#dados")) {
                            // #nome-nomeJogador

                            String[] msgSplit = recebido.split("-");

                            for (ClientHandler client : GameServer.listaClientes) {

                                System.out.println("Mensagem a ser enviada: " + recebido);
                                client.dos.writeUTF(recebido);
                            }
                        }
                        
                        if (recebido.startsWith("#vez")) {
                            // #nome-nomeJogador

                            

                            for (ClientHandler client : GameServer.listaClientes) {
                               
                               
                                System.out.println("Mensagem a ser enviada: " + recebido);
                                client.dos.writeUTF(recebido);
                            }
                        }

                        if (recebido.endsWith("#logout")) {
                            for (ClientHandler client : GameServer.listaClientes) {
                                if (!client.code.equals(code) && client.isloggedin) {
                                    client.dos.writeUTF("#logout-" + nome);
                                }
                            }
                            this.isloggedin = false;
                            GameServer.listaClientes.remove(this);
                            GameServer.njogadores--;
                            System.out.println("Jogador " + this.nome + " saiu do jogo...");
                            this.s.close();

                            for (ClientHandler c : GameServer.listaClientes) {
                                // avisar o cliente que terá que esperar agora
                                if (GameServer.njogadores < 2 && c.prontoJogar) {
                                    if (this.jogoTerminado) {
                                        c.dos.writeUTF("#espera-nada");
                                    } else {
                                        c.dos.writeUTF("#espera-desistencia");
                                    }
                                }
                            }
                            break; // while
                        }

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
            cliente.start();

        }
    }

}
