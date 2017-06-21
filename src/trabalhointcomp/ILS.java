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
public class ILS {
    
    Grafo G;
    Historico history;

    public ILS(Grafo G) {
        this.G = G;
        history = new Historico(G.n);
    }
    
    
    public int IteratedLocalSearch(){
        Solucao s0,s,s1,s2;
        int k = 1;
        
        s0 = GenerateInitialSolution();
        s = LocalSearch(s0);
        
        do{
            
            s1 = Perturbation(s,history);
            s2 = LocalSearch(s1);
            s = AcceptanceCriterion(s,s2,history);
            
        }while(false);//terminal condition met
        
        return s.k;
    }
    
    Solucao GenerateInitialSolution(){
        System.out.println("Generating Initial Solution...");
        return geraSolucao((int)Math.floor(Math.random()*100*G.n)%G.n);
    }
    
    private Solucao geraSolucao(int vertice){
        Solucao s = new Solucao(vertice,G.vizinhos(vertice));
        
        s = s.maximiza(G);
        
        return s; 
    }
        
    Solucao LocalSearch(Solucao s){
        System.out.println("Searching locally...");
        Solucao[] vizinhanca = N1(s);
        Solucao temp;
        Solucao res = s;
        
        for (Solucao vizinhanca1 : vizinhanca) {
            temp = best(vizinhanca1);
            if(temp.k > res.k) res = temp;                                      //Best Improvement
        }
        
        return res;
    }
    
    private Solucao best(Solucao s){
        Solucao res = s.maximiza(s.vizinhos[0], G);
        Solucao temp;
        
        for (int i = 1; i < s.vizinhos.length; i++) {
            temp = s.maximiza(s.vizinhos[i], G);
            if(res.k < temp.k) res = temp;
        }
        return res;
    }
    
    private Solucao[] N1(Solucao s){
        Solucao[] res = new Solucao[s.k];
        
        for (int i = 0; i < s.clique.length; i++) res[i] = s.removeVertice(s.clique[i], G);
        
        return res;
    }
    
    private Solucao Perturbation(Solucao s1,Historico history){
        return null;
    }
    
    private Solucao AcceptanceCriterion(Solucao s1, Solucao s2, Historico history){
        return null;
    }
}
