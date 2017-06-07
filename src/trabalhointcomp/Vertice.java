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
    LinkedList<Vertice> vizinhos = new LinkedList<>();
    private int grau;

    private Vertice(int label) {
        this.label = label;
        grau = 0;
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
        grau = vizinhos.size();
    }
    
    public int d(){
        return grau;
    }
    
    public boolean eVizinho(Vertice v){
        return vizinhos.contains(v);
    }
    
    @Override
    public boolean equals(Object v){
        return this.hashCode() == ((Vertice)v).hashCode();
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + this.label;
        return hash;
    }
    
    @Override
    public String toString(){
        String lab = "||" + this.label + "||";
        String res = lab;
        boolean cont = false;
        
        for (int i = 0; i < vizinhos.size(); i++) {
            if(vizinhos.get(i).label > this.label){
                res += " " + vizinhos.get(i).label;
                cont = true;
            }
        }
        
        if(!cont) return lab;
        return res + "||";
    }
}
