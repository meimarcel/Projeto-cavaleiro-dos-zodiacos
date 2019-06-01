///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package main;
//
//import graph.Grafo;
//import graph.Pilha;
//import graph.Vertice;
//import java.awt.Graphics;
//import java.awt.Graphics2D;
//import java.awt.Image;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import javax.swing.ImageIcon;
//import javax.swing.JPanel;
//import javax.swing.Timer;
//import persona.Seiya;
//import search.ASS;
//import java.util.Scanner;
//import javax.swing.JFrame;
//import javax.swing.SwingUtilities;
//
///**
// *
// * @author meimarcel
// */
//public class Labirinto extends JPanel implements ActionListener{
//    private Image plano;
//    private Image rocha;
//    private Image agua;
//    private Image ponto;
//    private Image casa;
//    private Timer timer;
//    private Seiya seiya;
//    private String[] labirinto;
//    private String[] casas;
//    private Vertice[] rota;
//    private int pos = 0;
//    private int hora = 0;
//    private String min;
//    private javax.swing.JLabel jLabel2;
//    private int seq;
//    public TelaLabirinto tela;
//    
//    
//    
//
//    private Music enter;
//    private Music theme;
//    
//    private Scanner input = new Scanner(System.in);
//    private boolean teste;
//    
//    public Labirinto(javax.swing.JLabel jLabel2,Vertice[] rota,Music theme,int seq,TelaLabirinto tela) {
//        System.out.print(this);
//        setFocusable(true);
//        setDoubleBuffered(true);
//        ImageIcon ref1 = new ImageIcon("src//images//Plano.jpg");
//        this.plano = ref1.getImage();
//        ImageIcon ref2 = new ImageIcon("src//images//Rocha.jpg");
//        this.rocha = ref2.getImage();
//        ImageIcon ref3 = new ImageIcon("src//images//Agua.jpg");
//        this.agua = ref3.getImage();
//        ImageIcon ref4 = new ImageIcon("src//images//Ponto.jpg");
//        this.ponto = ref4.getImage();
//        this.seiya = new Seiya(1,37,37);
//        ImageIcon ref5 = new ImageIcon("src//images//Casa.png");
//        this.casa = ref5.getImage();
//        this.jLabel2 = jLabel2;
//        this.rota = rota;
//        this.theme = theme;
//        this.seq = seq;
//        this.tela = tela;
//        enter = new Music("src//sounds//Enter.wav");
//        casas = Arquivo.Read("CASAS.txt");
//        labirinto = Arquivo.Read("LABIRINTO.txt");
//        timer = new Timer(500,this);
//        timer.start();
//        theme.loop();
//    }
//    
//    @Override
//    public void paint(Graphics g) {
//        Graphics2D graficos = (Graphics2D) g;
//       
//        for(int i = 0; i < 42; i++) {
//            String[] aux = labirinto[i].split(",");
//            for(int j = 0;j < 42; j++){
//                if(aux[j].equals("1") || aux[j].equals("-1")) {
//                    graficos.drawImage(plano, (j*20), (i*20), this);
//                }
//                else if(aux[j].equals("5")) {
//                    graficos.drawImage(rocha, (j*20), (i*20), this);
//                }
//                else if(aux[j].equals("200")) {
//                    graficos.drawImage(agua, (j*20), (i*20), this);     
//                }
//                else if(aux[j].equals("0")) {
//                    graficos.drawImage(ponto, (j*20), (i*20), this);
//                }
//            }
//        }
//        
//        for(int i = 0; i < 12; i++) {
//            String[] aux = casas[i].split(",");
//            graficos.drawImage(casa, (Integer.parseInt(aux[1])*20), (Integer.parseInt(aux[0])*20), this);  
//        }
//        graficos.drawImage(seiya.imagem, (seiya.y*20), (seiya.x*20), this);
//        
//        g.dispose();
//        
//    }
//    
//
//    @Override
//    public void actionPerformed(ActionEvent e) {
//        try {
//            if(SwingUtilities.getWindowAncestor(this).isVisible()){
//                System.out.println(rota[pos].peso);
//                System.out.println();
//                min = String.valueOf(rota[pos].peso%60);
//                hora = (int) Math.floor(rota[pos].peso / 60);
//                if(rota[pos].peso < 10){
//                    jLabel2.setText(String.valueOf(hora)+":0"+min);
//                } else {
//                    jLabel2.setText(String.valueOf(hora)+":"+min);
//                }
//                seiya.x = rota[pos].x;
//                seiya.y = rota[pos].y;
//                if(pos < (rota.length - 1)) {
//                        pos++;
//                } 
//
//    //            if (pos == rota.length -1){
//    //                theme.stop();
//    //                enter.start();
//    //                JFrame telaPai = (JFrame) SwingUtilities.getWindowAncestor(this);
//    //                TelaLabirinto old =(TelaLabirinto) this.getRootPane().getParent();
//    //                telaPai.setVisible(false);
//    //                telaPai.dispose();
//    //                TelaBatalha tela = new TelaBatalha();
//    //                tela.setSeq(seq);
//    //                
//    //            }
//                if (pos == rota.length -1){
//                    theme.stop();
//                    enter.start();
//                    JFrame telaPai = (JFrame) SwingUtilities.getWindowAncestor(this);
//                    System.out.print(tela);
//                    telaPai.setVisible(false);
//    //                telaPai.add(new TelaBatalha());
//                    TelaBatalha novo = new TelaBatalha();
//                    novo.tela = this.tela;
//
//                }
//            } else {
//                this.setVisible(false);
//            }
//        }catch (Exception ea) {
//            
//            //System.out.println(ea);
//            //System.out.println(seq);
//        }
//        repaint();
//    }
//     public int getSeq() {
//        return this.seq;
//    }
//     
//}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import graph.Grafo;
import graph.Grupo;
import graph.Pilha;
import graph.Vertice;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;
import persona.Seiya;
import search.ASS;
import javax.swing.SwingUtilities;

/**
 *
 * @author meimarcel
 */
public class Labirinto extends JPanel implements ActionListener{
    private Image plano;
    private Image rocha;
    private Image agua;
    private Image ponto;
    private Image casa;
    private Image c1;
    private Image c2;
    private Image c3;
    private Image c4;
    private Image c5;
    private Image end;
    private Image theEnd;
    private Image vida;
    private Image vida2;
    private Timer timer;
    private Seiya seiya;
    private String[] labirinto;
    private String[] casas;
    private Vertice[] rota;
    private int pos = 0;
    private int hora = 0;
    private double hora2 = 0.0;
    private String min;
    private javax.swing.JLabel jLabel2;
    private int seq = 12;
    private int[][] labirint = new int[42][42];
    private Grafo houses;
    private Grafo grafo;
    public int nivel = 0;
    private Grupo[] rotaCasa;
    private int vol = 0;
    private Music enter;
    private Music theme;
    private boolean fim = false;
    private boolean cond1 = true;
    private boolean cond2 = false;
    private boolean cond3 = true;
    private int p1 = 5;
    private int p2 = 5;
    private int p3 = 5;
    private int p4 = 5;
    private int p5 = 5;
    
    private TelaBatalha tela;
    public Labirinto(javax.swing.JLabel jLabel2, Music theme,Grupo[] rotaCasa) {
        setFocusable(true);
        setDoubleBuffered(true);
        ImageIcon ref1 = new ImageIcon("src//images//Plano.jpg");
        this.plano = ref1.getImage();
        ImageIcon ref2 = new ImageIcon("src//images//Rocha.jpg");
        this.rocha = ref2.getImage();
        ImageIcon ref3 = new ImageIcon("src//images//Agua.jpg");
        this.agua = ref3.getImage();
        ImageIcon ref4 = new ImageIcon("src//images//Ponto.jpg");
        this.ponto = ref4.getImage();
        ImageIcon ref0 = new ImageIcon("src//images//End.gif");
        this.end = ref0.getImage();
        this.seiya = new Seiya(1,37,37);
        ImageIcon ref5 = new ImageIcon("src//images//Casa.png");
        this.casa = ref5.getImage();
        ImageIcon ref6 = new ImageIcon("src//images//TheEnd.png");
        this.theEnd = ref6.getImage();
        ImageIcon ref7 = new ImageIcon("src//images//IconSeiya.png");
        this.c1 = ref7.getImage();
        ImageIcon ref8 = new ImageIcon("src//images//IconShiryu.png");
        this.c2 = ref8.getImage();
        ImageIcon ref9 = new ImageIcon("src//images//IconHyoga.png");
        this.c3 = ref9.getImage();
        ImageIcon ref10 = new ImageIcon("src//images//IconShun.png");
        this.c4 = ref10.getImage();
        ImageIcon ref11 = new ImageIcon("src//images//IconIkki.png");
        this.c5 = ref11.getImage();
        ImageIcon ref12 = new ImageIcon("src//images//Vida.png");
        this.vida = ref12.getImage();
        ImageIcon ref13 = new ImageIcon("src//images//Vida2.png");
        this.vida2 = ref13.getImage();
        this.jLabel2 = jLabel2;
        this.theme = theme;
        this.rotaCasa = rotaCasa;
        houses = new Grafo();
        casas = Arquivo.Read("CASAS.txt");
        labirinto = Arquivo.Read("LABIRINTO.txt");
        buscaLabirinto();
        busca();
        timer = new Timer(500,this);
        timer.start();
        theme.loop();
        
    }
    
    @Override
    public void paint(Graphics g) {
        Graphics2D graficos = (Graphics2D) g;
       
        for(int i = 0; i < 42; i++) {
            String[] aux = labirinto[i].split(",");
            for(int j = 0;j < 42; j++){
                if(aux[j].equals("1") || aux[j].equals("-1")) {
                    graficos.drawImage(plano, (j*20), (i*20), this);
                }
                else if(aux[j].equals("5")) {
                    graficos.drawImage(rocha, (j*20), (i*20), this);
                }
                else if(aux[j].equals("200")) {
                    graficos.drawImage(agua, (j*20), (i*20), this);     
                }
                else if(aux[j].equals("0")) {
                    graficos.drawImage(ponto, (j*20), (i*20), this);
                }
            }
        }
        
        for(int i = 0; i < 12; i++) {
            String[] aux = casas[i].split(",");
            graficos.drawImage(casa, (Integer.parseInt(aux[1])*20), (Integer.parseInt(aux[0])*20), this);  
        }
        graficos.drawImage(seiya.imagem, (seiya.y*20), (seiya.x*20), this);
        
        graficos.drawImage(c1, 845, 130, this);
        if(cond3){
            int x = 900;
            for(int i = 0; i < 5; i++) {
                if(i < p1){
                    graficos.drawImage(vida, x, 150, this);
                } else {
                    graficos.drawImage(vida2, x, 150, this);
                }
                x +=12; 
            }
        }
        graficos.drawImage(c2, 845, 190, this);
        if(cond3){
            int x = 900;
            for(int i = 0; i < 5; i++) {
                if(i < p2) {
                    graficos.drawImage(vida, x, 210, this);
                } else {
                    graficos.drawImage(vida2, x, 210, this);
                }
                x +=12;
            }
        }
        graficos.drawImage(c3, 845, 250, this);
        if(cond3){
            int x = 900;
            for(int i = 0; i < 5; i++) {
                if(i < p3) {
                    graficos.drawImage(vida, x, 270, this);
                } else {
                    graficos.drawImage(vida2, x, 270, this);
                }
                x +=12;
            }
        }
        graficos.drawImage(c4, 845, 310, this);
        if(cond3){
            int x = 900;
            for(int i = 0; i < 5; i++) {
                if(i < p4) {
                    graficos.drawImage(vida, x, 330, this);
                } else {
                    graficos.drawImage(vida2, x, 330, this);
                }
                x +=12;
            }
        }
        graficos.drawImage(c5, 845, 370, this);
        if(cond3){
            int x = 900;
            for(int i = 0; i < 5; i++) {
                if(i < p5) {
                    graficos.drawImage(vida, x, 390, this);
                } else {
                    graficos.drawImage(vida2, x, 390, this);
                }
                x +=12;
            }
            cond3 = false;
        }
        if(fim == true) {
            graficos.drawImage(end, 200, 200, this);
            graficos.drawImage(theEnd, 210, 400, this);
            timer.stop();
        
        }
        
        
        g.dispose();

    }
    

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            if(SwingUtilities.getWindowAncestor(this).isVisible()){
                System.out.println(rota[pos].peso);
                System.out.println();
                min = String.valueOf((rota[pos].peso + (int)Math.ceil(hora2))%60);
                hora = (int) Math.floor((rota[pos].peso + (int)Math.ceil(hora2)) / 60);
                if(rota[pos].peso < 10){
                    jLabel2.setText(String.valueOf(hora)+":0"+min);
                } else {
                    jLabel2.setText(String.valueOf(hora)+":"+min);
                }
                seiya.x = rota[pos].x;
                seiya.y = rota[pos].y;
                if(pos < (rota.length - 1)) {
                        pos++;
                }
                
                if(vol < 6 ) {
                    vol += 2;
                    theme.setVolume(vol);
                    theme.loop();
                }
                if(pos == rota.length - 4){
                    vol = -20;
                }
                if (pos == rota.length -1 && cond1 == true && (rota[rota.length - 2].x != 4 || rota[rota.length - 2].y != 37)){
                        theme.stop();
                        enter = new Music("src//sounds//Enter.wav");
                        enter.setVolume(-5);
                        enter.start();
                        tela = new TelaBatalha();
                        tela.grupo = rotaCasa[nivel];
                        p1 = rotaCasa[nivel].p[0];
                        p2 = rotaCasa[nivel].p[1];
                        p3 = rotaCasa[nivel].p[2];
                        p4 = rotaCasa[nivel].p[3];
                        p5 = rotaCasa[nivel].p[4];
                        hora2 += rotaCasa[nivel].peso;
                        tela.ativar();
                        cond1 = false;
                        cond2 = true;
                        cond3 = true;
                        nivel++;
                }
                
                
                
            } else {
                theme.stop();
                this.setVisible(false);
            }
        }catch (Exception ea) {
            if (rota[rota.length - 2].x == 4 && rota[rota.length - 2].y == 37){
                  theme.stop();
                  theme.setMusic("src//sounds//End.wav");
                  theme.loop();
                  fim = true;
            }
            if(!tela.isVisible() && cond2 == true && (rota[rota.length - 2].x != 4 || rota[rota.length - 2].y != 37)){
                seq--;
                pos = 0;
                busca();
                cond2 = false;
                cond1 = true;
               
            }
            //System.out.println(ea);
            //System.out.println(seq);
        }
        repaint();
    }
    
    public void busca() {
        /*for(int i = 0; i < 42; i++) {
            for(int j = 0;j < 42; j++){
                System.out.print(labirinto[i][j]+" ");
            }
            System.out.println();
        }*/
        int cont = 1;
        grafo = new Grafo();
        Vertice inicio = houses.vertices.get(seq+1);
        Vertice fim = houses.vertices.get(seq);
//        Vertice fim = new Vertice(4,13);
        ASS aStar = new ASS(grafo);
        aStar.buscar(inicio, fim, labirint);
        Pilha pilha = new Pilha();
        Vertice atual = (Vertice) grafo.vertices.get(grafo.vertices.size() - 1);
        while(atual != null) {
            pilha.push(atual);
            //System.out.println("pilha x:"+atual.x);
            //System.out.println("pilha y:"+atual.y);
            //System.out.println();
            cont++;
            atual = atual.pai;
        }
        rota = new Vertice[cont];
        cont = pilha.cont;
        for(int i = 0; i < cont; i++) {
            rota[i] = pilha.pop();
            System.out.println("rota:"+rota[i].x);
            System.out.println("rota:"+rota[i].y);
            System.out.println();
        }
        /*houses.vertices.forEach((v) ->{
            System.out.println(v.x);
            System.out.println(v.y);
            System.out.println("pilha:"+v.name);
            System.out.println();
        });*/
    }
    
    public void buscaLabirinto() {
        for (int i = 0; i < 42; i++){
            String[] aux = labirinto[i].split(",");
            for(int j = 0; j < 42; j++) {
                labirint[i][j] = Integer.parseInt(aux[j]);
            }
        }
        houses.add_vertice(new Vertice(13,4,37));
        for(int i = 0; i < 12; i++) {
            String[] aux = casas[i].split(",");
            Vertice novo = new Vertice((12-i),Integer.parseInt(aux[0]), Integer.parseInt(aux[1]));
            novo.peso = Integer.parseInt(aux[2]);
            houses.add_vertice(novo);
            
        }
        houses.add_vertice(new Vertice(14,37,37));
    }
     
}
