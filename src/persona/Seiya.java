/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persona;

import graph.Vertice;
import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author meimarcel
 */
public class Seiya extends Vertice{
    
    public Image imagem;
    public int vida;
    
    public Seiya(int name, int x, int y) {
        super(name, x, y);
        ImageIcon ref = new ImageIcon("src//images//Seiya2.png");
        imagem = ref.getImage();
        vida = 5;
        
    }
    
}
