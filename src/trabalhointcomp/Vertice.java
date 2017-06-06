/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhointcomp;

import java.util.LinkedList;

/**
 *
 * @author Gaburieru
 */
public class Vertice {
    int label;
    LinkedList<Vertice> vizinhos;

    private Vertice(int label) {
        this.label = label;
    }
    
    public static Vertice[] vetorVertice(int n){
        Vertice[] res = new Vertice[n];
        
        for (int i = 0; i < res.length; i++) {
            res[i] = new Vertice(i);
        }
        return res;
    }
    
    public void incluiVizinho(int v){
        vizinhos.add(new Vertice(v));
    }
}
