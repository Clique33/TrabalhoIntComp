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
public class Historico {
    private final int size;
    private boolean vertices[];

    public Historico(int size) {
        this.size = size;
        vertices = new boolean[size];
    }
    
    public boolean checa(Vertice v){
        int i = v.label;
        return vertices[i];
    }
    
    public void checado(Vertice v){
        int i = v.label;
        vertices[i] = true;
    }
}
