/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhointcomp;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author Gaburieru
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Grafo G = null;
        String instance = "keller6";
        int nIter = 15;
        try {
            Scanner leitor = new Scanner(new File("gerador_de_grafos\\" + instance + ".txt"));
            PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("log.txt", true)));
            float counter = 0;
            int aux,maior = 0;
            G = new Grafo(leitor);
            writer.append("========================================================\n");
            
            long start = System.currentTimeMillis();
            for (int i = 0; i < nIter; i++) {
                //G.imprimeVizinhos();
                ILS ILS = new ILS(G);
                /*G.imprime(true);
                System.out.println(ILS.history);*/
                counter += aux = ILS.IteratedLocalSearch(150);
                if(aux > maior) maior = aux;
                System.out.println(aux);
            }
            float end = (float)(System.currentTimeMillis()-start)/1000;
            
            writer.append("Instância: " + instance + ", maior: " + maior + 
                            ", media: " + counter/nIter + ", tempo: " + end + ", tempo(média): " + end/nIter);
            System.out.println("Instância: " + instance + ", maior: " + maior + 
                            ", media: " + counter/nIter + ", tempo: " + end + ", tempo(média): " + end/nIter);
            writer.append("\n========================================================\n");
            
        } catch (FileNotFoundException ex) {
            System.out.println("Arquivo não encontrado!!");
        } catch (IOException ex) {
            System.out.println("Ué :/");
        }
        
    }

    
}
