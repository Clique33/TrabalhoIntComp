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
public class ILS {
    
    Grafo G;
    Historico history = new Historico(G.n);

    public ILS(Grafo G) {
        this.G = G;
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
            
        }while(false);//terminatal condition met
        
        return s.k;
    }
    
    private static Solucao LocalSearch(Solucao s){
        return null;
    }
    
    private static Solucao GenerateInitialSolution(){
        return null; 
    }
    
    private static Solucao Perturbation(Solucao s1,Historico history){
        return null;
    }
    
    private static Solucao AcceptanceCriterion(Solucao s1, Solucao s2, Historico history){
        return null;
    }
}
