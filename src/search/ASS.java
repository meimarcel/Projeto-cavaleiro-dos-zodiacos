/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package search;

import graph.Grafo;
import graph.Vertice;
import java.util.PriorityQueue;

/**
 *
 * @author meimarcel
 */
public class ASS {
    public Grafo grafo;
    public PriorityQueue<Vertice> fronteira;
    public final int[] px = {1,-1,0,0};
    public final int[] py = {0,0,1,-1};
    public boolean[][] enter = new boolean[100][100];
    public Distancia dist; 

    
    public ASS (Grafo grafo) {
        this.grafo = grafo;
        this.fronteira = new PriorityQueue(Vertice.Comparar);
        dist = new Distancia();
    }
    
    public void buscar (Vertice inicio,Vertice fim, int[][] labirinto) {
       inicio.distancia = 0;

       inicio.pai = null;
       grafo.add_vertice(inicio);
       this.fronteira.add(inicio);
       while(!this.fronteira.isEmpty()) {
           Vertice atual = this.fronteira.poll();
           enter[atual.x][atual.y] = true;
           if (atual.x == fim.x && atual.y == fim.y) {
               fim.peso = atual.peso;
               grafo.add_vertice(atual);
               break;
           }
           for(int i = 0; i < 4; i++) {
               int auxX = atual.x + px[i];
               int auxY = atual.y + py[i];
               Vertice novo = new Vertice(auxX,auxY);
               if(auxX >= 0  && auxY >= 0 && auxX < 42 && auxY < 42) {
                   if(enter[auxX][auxY] == false) {
                       if(labirinto[auxX][auxY] == -1){
                           novo.peso = atual.peso + 1;
                       }else{
                           novo.peso = atual.peso + labirinto[auxX][auxY];
                       }
                       novo.distancia = novo.peso + dist.distancia(auxX,auxY,fim.x,fim.y);
                       novo.pai = atual;
                       grafo.add_vertice(atual);
                       fronteira.add(novo);

                   }
               }
           }
       }
    }    
}
