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
            this.incluiAresta(s-1, leitor.nextInt()-1);
            s = leitor.nextInt();
        }
    }
    
    private void incluiAresta(int v1, int v2){
        //vertices[v1].incluiVizinho(v2);
        //vertices[v2].incluiVizinho(v1);
        matrizAdjacencias[v1][v2] = matrizAdjacencias[v2][v1] = true;
        graus[v1]++;
        graus[v2]++;
    }
    
    public int[] vizinhos(int vertice){
        int[] vizinhos = new int[graus[vertice]];
        int cont = 0;
        
        for (int i = 0; i < matrizAdjacencias.length; i++) {
            if(matrizAdjacencias[vertice][i]) vizinhos[cont++] = i;
        }
        
        return vizinhos;
    }
    
    public void imprimeVizinhos(){
        int[] aux;
        
        for (int i = 0; i < matrizAdjacencias.length; i++) {
            aux = vizinhos(i);
            
            System.out.print(i+": ");
                
            for (int j = 0; j < aux.length; j++) {
                System.out.print(aux[j]+" ");
            }
            
            System.out.println("||"+graus[i]);
        }
        
        System.out.println("======================================");
        
        for (int i = 0; i < vertices.length; i++) {
            System.out.print(i+": ");
            vertices[i].imprimeVizinhos();
            
        }
    }
    
    public int maiorGrau(){
        int maior = 0;
        int indiceMaior = 0;
        
        for (int i = 0; i < graus.length; i++) {
            if(maior < graus[i]){
                maior = graus[i];
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
