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
    Grafo G;
    int k;
    Vertice[] clique;
    private Vertice gerador;
    private boolean[] visitados;
    
    public Solucao(Vertice v, Grafo G) {
        k = 1;
        this.G = G;
        clique = new Vertice[k];
        clique[0] = v;
        gerador = v;
        visitados = new boolean[gerador.vizinhos.size()];
    }

    public Solucao(Solucao s,Vertice v) {//Aqui, v já foi confirmado como parte da nova clique
        k = s.k + 1;
        
        G = s.G;
        
        clique = new Vertice[k];
        System.arraycopy(s.clique, 0, clique, 0, s.clique.length);
        clique[s.k] = v;
        
        gerador = s.gerador;
        
        visitados = s.visitados;
        
    }
    
    public boolean eViavel(Vertice v,Solucao s){//é viável se v é vizinho de todos na clique
        for (Vertice clique1 : s.clique) {
            if (!clique1.eVizinho(v)) {
                return false;
            }
        }
        return true;
    }
    
    public boolean podeMelhorar(){
        for (int i = 0; i < visitados.length; i++) {
            if(!visitados[i]) return true;
        }
        return false;
    }
    
    public Solucao melhora(){
        Solucao s = this;
        Vertice v;
        for (int i = 0; i < gerador.vizinhos.size(); i++) {
            if(!visitados[i]){
                v = G.vertices[(gerador.vizinhos.get(i)).label];
                if(this.eViavel(v,s)){
                    s = new Solucao(s,v);
                    visitados[i] = true;
                }
            }
            
        }
        return s;
    }
    
    public void imprime(){
        System.out.println("-----------------\n-->" + k);
        for (Vertice clique1 : clique) {
            System.out.println(clique1);
        }
        for (int i = 0; i < visitados.length; i++) {
            System.out.println(visitados[i]);
            
        }
        System.out.println("-----------------");
        
    }    
}
