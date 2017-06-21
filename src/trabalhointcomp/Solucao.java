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
public class Solucao {
    int k = 0;
    int[] clique = null;
    int[] vizinhos = null;

    public Solucao() {
    }
    
    public Solucao(int vertice, int[] vizinhos) {
        k =1;
        clique = new int[1];
        clique[0] = vertice;
        this.vizinhos = vizinhos;
    }

    public Solucao(Solucao s,int vertice,int[] vizinhos) {//Aqui, v já foi confirmado como parte da nova clique
        k = s.k + 1;
        clique = new int[s.clique.length+1];
        
        int aux = this.clique.length;
        for (int i = 0; i < s.clique.length; i++) {
            if(s.clique[i] < vertice){
                clique[i] = s.clique[i];
                if(i == s.clique.length-1) clique[i+1] = vertice;
            }
            else{
                clique[i] = vertice;
                aux = i+1;
                break;
            }
        }
        
        for (int i = aux; i < clique.length; i++) {
            clique[i] = s.clique[i-1];
            
        }
        
        this.vizinhos = s.atualizaVizinhos(vizinhos);
    }
    
    public Solucao removeVertice(int vertice,Grafo G){
        Solucao res = new Solucao();
        int[] nova = new int[clique.length-1];
        int cont = 0;
        
        for (int i = 0; i < nova.length; i++) {
            if(clique[cont] != vertice) nova[i] = clique[cont++];
            else{
                i--;
                cont++;
            }
        }
        
        res.k = k -1;
        res.clique = nova;
        res.resetaVizinhos(G);
        
        return res;
    }
    
    private void resetaVizinhos(Grafo G){
        if(k == 0){
            vizinhos = null;
            return;
        } 
        vizinhos = G.vizinhos(clique[0]);
        for (int i = 1; i < clique.length; i++) vizinhos = atualizaVizinhos(G.vizinhos(clique[i]));
    }
    
    private int[] atualizaVizinhos(int[] vizinhos){
        LinkedList<Integer> aux = new LinkedList<>();
        int i = 0,j = 0;
        
        while(true){
            if(i >= this.vizinhos.length || j >= vizinhos.length) break;
            
            if(this.vizinhos[i] == vizinhos[j]){
                aux.add(vizinhos[j++]);
                i++;
            }else if(this.vizinhos[i] > vizinhos[j]) j++;
            else i++;
        }
        
        int[] res = new int[aux.size()];
        for (int l = 0; l < aux.size(); l++) {
            res[l] = aux.get(l);
            
        }
        
        return res;
    }
    
    public Solucao maximiza(Grafo G){
        Solucao res = this;
        while(res.podeMelhorar()) res = res.melhora(G);
        return res;
    }
    
    public Solucao maximiza(int vertice, Grafo G){
        Solucao res = this;
        res = res.melhora(vertice,G);
        res = res.maximiza(G);
        return res;
    }
    
    public boolean podeMelhorar(){
        return vizinhos != null && vizinhos.length != 0;
    }
    
    public boolean podeMelhorar(int vertice){
        if(vizinhos != null && vizinhos.length != 0){
            
        }
        return false;
    }
    
    public Solucao melhora(Grafo G){//Escolhe nó aleatório dos vizinhos e acrescenta ele na clique
        int choice = vizinhos[((int)Math.floor(Math.random()*100*vizinhos.length))%vizinhos.length];
        return new Solucao(this, choice, G.vizinhos(choice));
    }
    
    public Solucao melhora(int vertice, Grafo G){//Escolhe nó aleatório dos vizinhos e acrescenta ele na clique
        int choice = vertice;
        return new Solucao(this, choice, G.vizinhos(choice));
    }
    
    public boolean estaNaClique(int vertice){
        for (int i = 0; i < clique.length; i++) if(clique[i] == vertice) return true;
        return false;
    }
    
    public void imprime(){
        System.out.print("-----------------\n" + k + "\n||");
        
        for (int clique1 : clique) {
            System.out.print(clique1 + ", ");
        }
        System.out.println("||");
        for (int i = 0; i < vizinhos.length; i++) {
            System.out.print(vizinhos[i] + ", ");
            
        }
        System.out.println("");
        System.out.println("-----------------");
        
    }    
}
