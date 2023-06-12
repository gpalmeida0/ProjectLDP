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
    public static List<ClientHandler> listaClientes = new ArrayList<>();
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

    public static class ClientHandler implements Runnable {

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

        public  ArrayList<Peca> pecas = new ArrayList<Peca>(15);
        public ArrayList<Peca> pecasAtacadas = new ArrayList<Peca>(15);

        
     

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

            geraPecas(id);
        }
        static String recebido;

        private void geraPecas(int playerID) {
            if (playerID == 0) {
                Peca peca1;
        Peca peca2;
        Peca peca3;
        Peca peca4;
        Peca peca5;
        Peca peca6;
        Peca peca7;
        Peca peca8;
        Peca peca9;
        Peca peca10;
        Peca peca11;
        Peca peca12;
        Peca peca13;
        Peca peca14;
        Peca peca15;
                peca1 = new Peca(1);
                peca2 = new Peca(2);
                peca3 = new Peca(3);
                peca4 = new Peca(4);
                peca5 = new Peca(5);
                peca6 = new Peca(6);
                peca7 = new Peca(7);
                peca8 = new Peca(8);
                peca9 = new Peca(9);
                peca10 = new Peca(10);
                peca11 = new Peca(11);
                peca12 = new Peca(12);
                peca13 = new Peca(13);
                peca14 = new Peca(14);
                peca15 = new Peca(15);

                pecas.add(peca1);
                pecas.add(peca2);
                pecas.add(peca3);
                pecas.add(peca4);
                pecas.add(peca5);
                pecas.add(peca6);
                pecas.add(peca7);
                pecas.add(peca8);
                pecas.add(peca9);
                pecas.add(peca10);
                pecas.add(peca11);
                pecas.add(peca12);
                pecas.add(peca13);
                pecas.add(peca14);
                pecas.add(peca15);
                System.out.println("PECAS criadas player 1: " + pecas.get(0).id);

            } else if (playerID == 1) {
                   Peca peca16;
        Peca peca17;
        Peca peca18;
        Peca peca19;
        Peca peca20;
        Peca peca21;
        Peca peca22;
        Peca peca23;
        Peca peca24;
        Peca peca25;
        Peca peca26;
        Peca peca27;
        Peca peca28;
        Peca peca29;
        Peca peca30;
                peca16 = new Peca(16);
                peca17 = new Peca(17);
                peca18 = new Peca(18);
                peca19 = new Peca(19);
                peca20 = new Peca(20);
                peca21 = new Peca(21);
                peca22 = new Peca(22);
                peca23 = new Peca(23);
                peca24 = new Peca(24);
                peca25 = new Peca(25);
                peca26 = new Peca(26);
                peca27 = new Peca(27);
                peca28 = new Peca(28);
                peca29 = new Peca(29);
                peca30 = new Peca(30);

                pecas.add(peca16);
                pecas.add(peca17);
                pecas.add(peca18);
                pecas.add(peca19);
                pecas.add(peca20);
                pecas.add(peca21);
                pecas.add(peca22);
                pecas.add(peca23);
                pecas.add(peca24);
                pecas.add(peca25);
                pecas.add(peca26);
                pecas.add(peca27);
                pecas.add(peca28);
                pecas.add(peca29);
                pecas.add(peca30);
                System.out.println("PECAS criadas player 2: " + pecas.get(0));
            }
        }

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
                        } else if (recebido.startsWith("#nome")) {
                            // #nome-nomeJogador

                            boolean vez = this.geraVez();
                            for (ClientHandler client : GameServer.listaClientes) {
                                if (!client.code.equals(code) && client.isloggedin) {
                                    String message = "#nome-" + !vez;
                                    System.out.println("Mensagem a ser enviada: " + message);
                                    client.dos.writeUTF(message);
                                } else {
                                    String message = "#nome-" + vez;
                                    System.out.println("Mensagem a ser enviada: " + message);
                                    client.dos.writeUTF(message);
                                }
                            }
                        } else if (recebido.startsWith("#vez")) {
                            for (ClientHandler client : GameServer.listaClientes) {
                                client.dos.writeUTF(recebido);
                            }
                        }else if (recebido.startsWith("#jogada")) {
                            for (ClientHandler client : GameServer.listaClientes) {
                                client.dos.writeUTF(recebido);
                                
                                System.out.println(client.id+"---"+client.pecas.get(0).id);
                                
                            }
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
