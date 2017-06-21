/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhointcomp;

import java.io.File;
import java.io.FileNotFoundException;
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
        try {
            Scanner leitor = new Scanner(new File("gerador_de_grafos\\grafos.txt"));
            float counter = 0;
            int aux,maior = 0;
            G = new Grafo(leitor);
            
            for (int i = 0; i < 30; i++) {
                //G.imprimeVizinhos();
                ILS ILS = new ILS(G);
                /*G.imprime(true);
                System.out.println(ILS.history);*/
                counter += aux = ILS.IteratedLocalSearch(300);
                if(aux > maior) maior = aux;
                System.out.println(aux);
            }
            System.out.println("maior: " + maior + ", media: " + counter/30);
            
        } catch (FileNotFoundException ex) {
            System.out.println("Arquivo não encontrado!!");
        }
        
    }

    
}
