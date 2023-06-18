/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetoldp;

import java.util.ArrayList;

/**
 *
 * @author mirra
 */
public class Casa {
    public int id;
    ArrayList<Peca> posicao;
    
    public Casa(int id){
        this.id=id;
        posicao = new ArrayList<>();
    }
}
