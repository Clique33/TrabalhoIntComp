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
    Historico history;

    public ILS(Grafo G) {
        this.G = G;
        history = new Historico(G.n);
    }
    
    
    public int IteratedLocalSearch(int iter){
        Solucao s0,s,s1,s2;
        int k = -1;
        
        s0 = GenerateInitialSolution();
        s = LocalSearch(s0);
        
        do{
            
            s1 = Perturbation(s);
            s2 = LocalSearch(s1);
            s = AcceptanceCriterion(s,s2);
            k++;    
            if(k%10 == 0) System.out.print(k + " ");
        }while(k < iter);//terminal condition met
        
        return s.k;
    }
    
    Solucao GenerateInitialSolution(){
        //System.out.println("Generating Initial Solution...");
        return geraSolucao((int)Math.floor(Math.random()*100*G.n)%G.n);
        //return geraSolucao(G.maiorGrau());
    }
    
    private Solucao geraSolucao(int vertice){
        Solucao s = new Solucao(vertice,G.vizinhos(vertice));
        
        s = s.maximiza(G);
        /*
        s
        while(Nc diff vazio) 
            adiciona vertice aleatório de Nc a s
        */
        
        return s; 
    }
        
    private Solucao geraSolucao(Solucao solucao){
        Solucao s = solucao;
        
        s = s.maximiza(G);
        
        return s; 
    }
    
    Solucao LocalSearch(Solucao s){
        //System.out.println("Searching locally...");
        Solucao[] vizinhanca = N1(s);
        Solucao temp;
        Solucao res = s;
        
        for (Solucao vizinhanca1 : vizinhanca) {
            temp = vizinhanca1.maximiza(G);
            if(temp.k > res.k) res = temp;                                      //Best Improvement
        }
        
        if(res == s){
            
            vizinhanca = N2(s);
            
            for (int i = 0; i < vizinhanca.length; i++) {
                temp = vizinhanca[i].maximiza(G);
                if(temp.k > res.k) res = temp;    
                
            }
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
        
        for (int i = 0; i < s.clique.length; i++) res[i] = s.removeVerticeTABU(s.clique[i], G);
        
        return res;
    }
    
    private Solucao[] N2Total(Solucao s){
        Solucao[] res = new Solucao[(s.k*s.k - s.k)/2];
        int idx = 0;
        
        for (int i = 0; i < s.clique.length; i++){
            for (int j = i+1; j < s.clique.length; j++) {
                res[idx]  = s.removeVerticeTABU(s.clique[i], G);
                res[idx]  = res[idx].removeVerticeTABU(s.clique[j], G);
                idx++;
            }
        }
        
        return res;
    }
    
    private Solucao[] N2(Solucao s){
        Solucao[] res = new Solucao[s.k];
        int j,k;
        
        for (int i = 0; i < s.clique.length; i++){
                j = (int)Math.floor(Math.random()*100*(s.k-1))%(s.k-1);
                k = 1 + j + (int)Math.floor(Math.random()*100*(s.k-j-1))%(s.k-j-1);
                res[i]  = s.removeVerticeTABU(s.clique[j], G);
                res[i]  = res[i].removeVerticeTABU(s.clique[k], G);
        }
        
        return res;
    }
    
    Solucao Perturbation(Solucao s1){
        //System.out.println("Perturbing...");
        Solucao res = s1;
        
        int perturbacao = 2 + (int)Math.floor((Math.random()*100*s1.k))%(s1.k-1);
        
        if(perturbacao == s1.k){
            //System.out.println("RANDOM START!!");
            res = geraSolucao((int)Math.floor((Math.random()*100*G.n))%G.n);
        }else{
            //System.out.println("perturbacao: " + perturbacao);

            for (int i = 0; i < perturbacao; i++) {
                res = res.removeVertice(G);
            }
        }
        res = res.maximiza(G);
        return res;
    }
    
    private Solucao AcceptanceCriterion(Solucao s1, Solucao s2){
        if(s1.k > s2.k) return s1;
        return s2;
    }
}
