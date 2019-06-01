/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import graph.Cavaleiro;
import graph.Grupo;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

/**
 *
 * @author meimarcel
 */
public class Batalha extends JPanel implements ActionListener{
    
    private Image fundo;
    private Image seiya;
    private Image shiryu;
    private Image hyoga;
    private Image shun;
    private Image ikki;
    private Image cavaleiro;
    private Grupo novo;
    private int cont;
    private Timer timer;
    private Music musica;
    private int vol = -15;
    private Image botao;
    private int cont1 = 0;
    private int cont2 = 0;
    private int cont3 = 0;
    private int cont4 = 0;
    private int cont5 = 0;
    private boolean cond = false;
    
    public Batalha (Grupo grupo) {
        setFocusable(true);
        setDoubleBuffered(true);
        this.novo = grupo;
//        novo.add_Cavaleiro(new Cavaleiro(1,2,2));
//        novo.add_Cavaleiro(new Cavaleiro(2,2,2));
//        novo.add_Cavaleiro(new Cavaleiro(3,2,2));
//        novo.add_Cavaleiro(new Cavaleiro(4,2,2));
//        novo.add_Cavaleiro(new Cavaleiro(5,2,2));
//        novo.nivel = nivel;
        ImageIcon ref1 = new ImageIcon("src//images//BattleBG.png");
        this.fundo = ref1.getImage();
        ImageIcon ref2 = new ImageIcon("src//images//Seiya.png");
        this.seiya = ref2.getImage();
        ImageIcon ref3 = new ImageIcon("src//images//Shiryu.png");
        this.shiryu = ref3.getImage();
        ImageIcon ref4 = new ImageIcon("src//images//Hyoga.png");
        this.hyoga = ref4.getImage();
        ImageIcon ref5 = new ImageIcon("src//images//Shun.png");
        this.shun = ref5.getImage();
        ImageIcon ref6 = new ImageIcon("src//images//Ikki.png");
        this.ikki = ref6.getImage();
        StringBuilder file = new StringBuilder();
        file.append("src//images//");
        file.append(String.valueOf(novo.nivel));
        file.append(".png");
        ImageIcon ref7 = new ImageIcon(file.toString());
        this.cavaleiro = ref7.getImage();
        ImageIcon ref8 = new ImageIcon("src//images//Back.png");
        this.botao = ref8.getImage();
        timer = new Timer(600,this);
        timer.start();
        musica = new Music("src//sounds//BattleMusic.wav");
        musica.setVolume(vol);
        musica.loop();
        
        
    } 
    
    @Override
    public void paint(Graphics g) {
        Graphics2D graficos = (Graphics2D) g;
        graficos.drawImage(fundo, 0, 0, this);
        graficos.drawImage(botao, 870, 700, this);
        
        
        cont = 200;
        novo.grupo.forEach((a) -> {
            switch (a.nome) {
                case 1:
                    graficos.drawImage(seiya, (700 + cont1), (cont), this);
                    break;
                case 2:
                    graficos.drawImage(shiryu, (700 + cont2), (cont), this);
                    break;
                case 3:
                    graficos.drawImage(hyoga, (700 + cont3), (cont), this);
                    break;
                case 4:
                    graficos.drawImage(shun, (700 + cont4), (cont), this);
                    break;
                case 5:
                    graficos.drawImage(ikki, (700 + cont5), (cont), this);
                    break;
                default:
                    break;
            }
           cont += 100;
           cond = false;
        });
         
        graficos.drawImage(cavaleiro, 100, (cont / 2 + 100), this);
        
        g.dispose();

    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            if(SwingUtilities.getWindowAncestor(this).isVisible()){
                if (vol < 6) {
                    vol +=4;
                    musica.setVolume(vol);
                }
                
                if (cont1 == 0 && cond == false) {
                    cont1 = -100;
                    cond = true;
                }
                if (cont1 == -100 && cond == false) {
                    cont1 = 1;
                    cond = true;
                    
                }
                if (cont1 == 1 && cont2 == 0 && cond == false) {
                    cont2 = -100;
                    cond = true;
                }
                if (cont2 == -100 && cond == false) {
                    cont2 = 1;
                    cond = true;
                }
                if (cont2 == 1 && cont3 == 0 && cond == false) {
                    cont3 = -100;
                    cond = true;
                }
                if (cont3 == -100 && cond == false) {
                    cont3 = 1;
                    cond  = true;
                }
                if (cont3 == 1 && cont4 == 0 && cond == false) {
                    cont4 = -100;
                    cond = true;
                }
                if (cont4 == -100 && cond == false) {
                    cont4 = 1;
                    cond = true;
                }
                if (cont4 == 1 && cont5 == 0 && cond == false) {
                    cont5 = -100;
                    cond = true;
                }
                if (cont5 == -100 && cond == false) {
                    cont5 = 1;
                    cond = true;
                }
                if (cont5 == 1 && cond == false) {
                    StringBuilder file = new StringBuilder();
                    file.append("src//images//");
                    file.append(String.valueOf(novo.nivel));
                    file.append("m.png");
                    ImageIcon ref7 = new ImageIcon(file.toString());
                    this.cavaleiro = ref7.getImage();
                    cond = true;
                }
                
            } else {
                musica.stop();
                this.setVisible(false);
                
            }
            repaint();
        } catch (Exception ea) {
            System.out.print(ea);
        }
            
         
    }
    
}
