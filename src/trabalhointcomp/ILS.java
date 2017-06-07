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
        return geraSolucao(G.vertices[G.maiorGrau(history)]);
    }
    
    private Solucao geraSolucao(Vertice v){
        Solucao s = new Solucao(v,G),aux;
        LinkedList<Solucao> cliques = new LinkedList<>();
        int i = -1,maior = 0;
        Solucao maiorS = s;
        
        while(s.podeMelhorar(history)){
            i++;
            cliques.add(s.melhora(history));
            
        }
        
        for (int j = 0; j < cliques.size(); j++){ 
            aux = cliques.get(j);
            //cliques.get(j).imprime();
            
            if(maior < aux.k){
                maior = aux.k;
                maiorS = aux;
            }
        }
        history.checa(s.gerador);
        return maiorS; 
    }
        
    Solucao LocalSearch(Solucao s){
        System.out.println("Searching locally...");
        int[] vizinhos = N1(s);
        Solucao[] solucoes = new Solucao[vizinhos.length];
        Solucao res = s;
        int maior = s.k;
        
        for (int i = 0; i < vizinhos.length; i++) {
            System.out.println("Generating solutions...");
            solucoes[i] = this.geraSolucao(G.vertices[vizinhos[i]]);
            if(solucoes[i].k > maior){                                          //Usar >= solucoes[i].k para testes
                maior = solucoes[i].k;
                res = solucoes[i];
            }
        }
        
        return res;
    }
    
    private int[] N1(Solucao s){
        LinkedList<Integer> vizinhos = new LinkedList<>();
        Vertice aux;
        
        for (Vertice clique : s.clique) {
            aux = G.vertices[clique.label];
            if((aux.d() > s.k) && !history.foiChecado(aux)){                    //Usar >= s.k para testes
                vizinhos.add(aux.label);
            }
        }
        
        int[] res = new int[vizinhos.size()];
        
        for (int i = 0; i < res.length; i++) {
            res[i] = vizinhos.get(i);
        }
        
        return res;
    }
    
    private Solucao Perturbation(Solucao s1,Historico history){
        return null;
    }
    
    private Solucao AcceptanceCriterion(Solucao s1, Solucao s2, Historico history){
        return null;
    }
}
