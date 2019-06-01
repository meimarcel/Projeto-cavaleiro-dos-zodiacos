/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graph;

/**
 *
 * @author meimarcel
 */
public class Pilha2 {
      public Grupo[] rota = new Grupo[1000];
    public int cont = 0;
    
    public void push(Grupo v) {
        rota[cont] = v;
        cont++;
    }
    
    public Grupo pop() {
        if(cont > 0) {
            cont--;
            return rota[cont];
        }
        return null;
    }
    
}
