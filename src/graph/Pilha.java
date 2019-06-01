/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graph;

/**
 *
 * @author marce
 */
public class Pilha {
    public Vertice[] rota = new Vertice[1000];
    public int cont = 0;
    
    public void push(Vertice v) {
        rota[cont] = v;
        cont++;
    }
    
    public Vertice pop() {
        if(cont > 0) {
            cont--;
            return rota[cont];
        }
        return null;
    }
    
}
