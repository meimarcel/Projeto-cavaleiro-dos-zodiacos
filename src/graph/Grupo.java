/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graph;

import java.util.ArrayList;
import java.util.Comparator;

/**
 *
 * @author meimarcel
 */
public class Grupo {
    public ArrayList<Cavaleiro> grupo;
    //public boolean[] grupo;
    public float poder = 0.0f;
    public float peso;
    public float h;
    public int[] p = new int[5];
    public int nivel;
    public Grupo pai;
    
    
    public Grupo(){
        grupo = new ArrayList<>();
        //grupo = new boolean[5];
    }

    /**
     *
     */
    public static Comparator<Grupo> Comparar = new Comparator<Grupo>() {
        @Override
        public int compare(Grupo o1, Grupo o2) {
            if(o1.h < o2.h) {
                return 1;
            } 
            if(o1.h > o2.h) {
                return -1;
            }
            return 0;
        }
    };
    
       public void add_Cavaleiro(Cavaleiro e) {
           grupo.add(e);
       } 
    
}
