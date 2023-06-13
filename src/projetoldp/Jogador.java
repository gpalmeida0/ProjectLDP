package projetoldp;
import java.util.ArrayList;



public class Jogador {
    int id;
    ArrayList<Peca> pecas;
    ArrayList<Peca> pecasAtacadas;

    public Jogador(int id){
        this.id=id;
        pecas = new ArrayList<>();
        pecasAtacadas = new ArrayList<>();

    }
}
