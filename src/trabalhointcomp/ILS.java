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
    
    private Solucao LocalSearch(Solucao s){
        return null;
    }
    
    private Solucao GenerateInitialSolution(){/**Futuramente deve ser private*/
        LinkedList<Solucao> cliques = new LinkedList<>();
        Solucao s = new Solucao(G.vertices[G.maiorGrau(history)],G),aux;
        int i = -1,maior = 0;
        Solucao maiorS = s;
        
        while(s.podeMelhorar()){
            i++;
            cliques.add(s.melhora());
            
        }
        
        for (int j = 0; j < cliques.size(); j++)       
{ 
            aux = cliques.get(j);
            cliques.get(j).imprime();
            
            if(maior < aux.k){
                maior = aux.k;
                maiorS = aux;
            }
        }
        
        return maiorS; 
    }
    
    private Solucao Perturbation(Solucao s1,Historico history){
        return null;
    }
    
    private Solucao AcceptanceCriterion(Solucao s1, Solucao s2, Historico history){
        return null;
    }
}
