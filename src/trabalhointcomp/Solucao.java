/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhointcomp;

/**
 *
 * @author Gaburieru
 */
public class Solucao {
    int k;
    Vertice[] clique;

    public Solucao(Vertice v) {
        k = 1;
        clique = new Vertice[k];
        clique[0] = v;
    }

    public Solucao(Solucao s,Vertice v) {//Aqui, v já foi confirmado como parte da nova clique
        k = s.k + 1;
        clique = new Vertice[k];
        System.arraycopy(s.clique, 0, clique, 0, clique.length-1);
        clique[s.k] = v;
    }
    
    public boolean viavel(Vertice v){//é viável se v é vizinho de todos na clique
        for (Vertice clique1 : clique) {
            if (!clique1.eVizinho(v)) {
                return false;
            }
        }
        return true;
    }
    
}
