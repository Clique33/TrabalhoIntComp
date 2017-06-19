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
    boolean[][] matrizAdjacencias;
    int[] graus;

    public Grafo(Scanner leitor){//Recebe um Scanner do arquivo contendo o Grafo
        n = leitor.nextInt();
        vertices = Vertice.vetorVertice(n);
        matrizAdjacencias = new boolean[n][n];
        graus = new int[n];
        
        int s = leitor.nextInt();
        
        while(s != -1){
            this.incluiAresta(s, leitor.nextInt());
            s = leitor.nextInt();
        }
    }
    
    private void incluiAresta(int v1, int v2){
        vertices[v1].incluiVizinho(v2);
        vertices[v2].incluiVizinho(v1);
        matrizAdjacencias[v1][v2] = matrizAdjacencias[v2][v1] = true;
        graus[v1]++;
        graus[v2]++;
    }
    
    public int maiorGrau(Historico history){
        int maior = 0;
        int indiceMaior = 0;
        
        for (int i = 0; i < vertices.length; i++) {
            if(maior < vertices[i].d() && !history.foiChecado(vertices[i])){
                maior = vertices[i].d();
                indiceMaior = i;
            }
            
        }
        
        
        
        return indiceMaior;
    }
    
    public void imprime(boolean comGrau){
        System.out.println("=============================\n" + n);
        for (Vertice vertice : vertices) {
            if(comGrau) System.out.println(vertice + "--> d(" + vertice.d() + ")");
            else System.out.println(vertice);
        }
        
        System.out.println("=============================");
    }
}
