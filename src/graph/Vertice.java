/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graph;


import java.util.Comparator;

/**
 *
 * @author meimarcel
 */
public class Vertice {
    public int name;
    public double distancia;
    public int peso;
    public Vertice pai;
    public int x;
    public int y;

    public Vertice(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    public Vertice(int name,int x, int y) {
        this.name = name;
        this.x = x;
        this.y = y;
    }

    public static Comparator<Vertice> Comparar = new Comparator<Vertice>() {
        @Override
        public int compare(Vertice o1, Vertice o2) {
            return (int) (o1.distancia - o2.distancia);
        }
    };
    
}
