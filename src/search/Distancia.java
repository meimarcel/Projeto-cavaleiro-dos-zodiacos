/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package search;

/**
 *
 * @author meimarcel
 */
public class Distancia {
    public double distancia (int x1, int y1, int x2, int y2) {
        int distancia = (int) (Math.pow((x2 - x1),2) + Math.pow((y2 - y1), 2));
        return Math.sqrt(distancia);
    }
}
