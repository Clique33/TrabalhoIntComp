/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhointcomp;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Gaburieru
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            Scanner leitor = new Scanner(new File("gerador_de_grafos\\grafos.txt"));
            for (int i = 0; i < 2; i++) {
                Grafo G = new Grafo(leitor);
                G.imprime(true);
                ILS ILS = new ILS(G);
                Solucao s = ILS.GenerateInitialSolution();
                s.imprime();
                
            }
            
        } catch (FileNotFoundException ex) {
            System.out.println("Arquivo não encontrado!!");
        }
    }

    
}
