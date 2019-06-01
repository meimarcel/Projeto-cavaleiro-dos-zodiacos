/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graph;

import java.util.ArrayList;

/**
 *
 * @author meimarcel
 */
public class GrafoCasa {
    public ArrayList<Grupo> vertices = new ArrayList<>();

    public GrafoCasa() {
    }

    public void add_vertice(Grupo e) {
        this.vertices.add(e);

    }
}
