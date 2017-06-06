/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhointcomp;

import java.util.Scanner;

/**
 *
 * @author Gaburieru
 */
public class Grafo {
    int n;
    int m;
    Vertice[] vertices;

    public Grafo(Scanner leitor){//Recebe um Scanner do arquivo contendo o Grafo
        n = leitor.nextInt();
        vertices = Vertice.vetorVertice(n);
        
        int s = leitor.nextInt();
        
        while(s != -1){
            this.incluiAresta(s, leitor.nextInt());
            s = leitor.nextInt();
        }
    }
    
    private void incluiAresta(int v1, int v2){
        vertices[v1].incluiVizinho(v2);
        vertices[v2].incluiVizinho(v1);
    }
}
