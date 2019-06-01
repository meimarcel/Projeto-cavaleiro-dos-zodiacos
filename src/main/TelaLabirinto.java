package main;


import graph.Grupo;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;



/**
 *
 * @author meimarcel
 */
public class TelaLabirinto extends JFrame {

    /**
     * Creates new form TelaLabirinto
     */
    
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton jButton1;
    public Grupo[] rotaCasa;
    private Music theme;
    
    public TelaLabirinto() {
        setVisible(true);
        setTitle("Labirinto");
        setSize(1000,840);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jButton1 = new javax.swing.JButton();
        getContentPane().add(jButton1);
        jButton1.setBackground(new java.awt.Color(204, 204, 255));
        jButton1.setForeground(new java.awt.Color(255,102,51));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Back.png")));// NOI18N
        jButton1.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/images/BackSelect.png")));
        jButton1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 255), 4));
        jButton1.setPreferredSize(new java.awt.Dimension(111, 77));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jButton1.setBounds(870, 700, 100, 58);
        
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        
        jLabel1.setFont(new java.awt.Font("Gillius ADF", 3, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Custo de Tempo:");
        jLabel1.setOpaque(true);
        jLabel1.setPreferredSize(new java.awt.Dimension(100, 20));
        jLabel1.setBounds(850, 50, 100, 20);
        
        jLabel2.setFont(new java.awt.Font("Gillius ADF", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setOpaque(true);
        jLabel2.setPreferredSize(new java.awt.Dimension(100, 20));
        jLabel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 1));
        jLabel2.setBounds(850, 80, 100, 20);
        add(jLabel1);
        add(jLabel2);
        theme = new Music("src//sounds//Theme2.wav");
        
        
        
    }


    private void jButton1ActionPerformed(ActionEvent evt) {
        this.dispose();
        theme.stop();
        TelaInicial tela = new TelaInicial();
    }
    
    public void ativar() {
        add(new Labirinto(jLabel2,theme,rotaCasa));
    }


//*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package main;
//
//import graph.Grafo;
//import graph.Pilha;
//import graph.Vertice;
//import java.awt.event.ActionEvent;
//import javax.swing.JFrame;
//import javax.swing.SwingUtilities;
//import javax.swing.Timer;
//import search.ASS;
//
//
///**
// *
// * @author meimarcel
// */
//public class TelaLabirinto extends JFrame {
//
//    /**
//     * Creates new form TelaLabirinto
//     */
//    
//    private javax.swing.JLabel jLabel1;
//    private javax.swing.JLabel jLabel2;
//    private javax.swing.JButton jButton1;
//    private Music theme;
//    private String[] labirinto;
//    private String[] casas;
//    private int[][] labirint = new int[42][42];
//    private Vertice[] rota;
//    private static int seq = 12;
//    private Grafo grafo;
//    private Grafo houses;
//    
//
//
//    
//    public TelaLabirinto() {
//        System.out.print(this);
//        setVisible(true);
//        setTitle("Labirinto");
//        setSize(1000,840);
//        setLocationRelativeTo(null);
//        setResizable(false);
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        jButton1 = new javax.swing.JButton();
//        getContentPane().add(jButton1);
//        jButton1.setBackground(new java.awt.Color(204, 204, 255));
//        jButton1.setForeground(new java.awt.Color(255,102,51));
//        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Back.png")));// NOI18N
//        jButton1.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/images/BackSelect.png")));
//        jButton1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 255), 4));
//        jButton1.setPreferredSize(new java.awt.Dimension(111, 77));
//        jButton1.addActionListener(new java.awt.event.ActionListener() {
//            @Override
//            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                jButton1ActionPerformed(evt);
//            }
//        });
//        jButton1.setBounds(870, 700, 100, 58);
//        
//        jLabel1 = new javax.swing.JLabel();
//        jLabel2 = new javax.swing.JLabel();
//        
//        jLabel1.setFont(new java.awt.Font("Gillius ADF", 3, 12)); // NOI18N
//        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
//        jLabel1.setText("Custo de Tempo:");
//        jLabel1.setOpaque(true);
//        jLabel1.setPreferredSize(new java.awt.Dimension(100, 20));
//        jLabel1.setBounds(850, 50, 100, 20);
//        
//        jLabel2.setFont(new java.awt.Font("Gillius ADF", 1, 12)); // NOI18N
//        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
//        jLabel2.setOpaque(true);
//        jLabel2.setPreferredSize(new java.awt.Dimension(100, 20));
//        jLabel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 1));
//        jLabel2.setBounds(850, 80, 100, 20);
//        houses = new Grafo();
//        labirinto = Arquivo.Read("LABIRINTO.txt");
//        casas = Arquivo.Read("CASAS.txt");
//        buscaLabirinto();
//        add(jLabel1);
//        add(jLabel2);
//        theme = new Music("src//sounds//Theme.wav");
//        
//        
//        
//    }
//
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1000, 840));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1000, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 840, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaLabirinto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaLabirinto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaLabirinto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaLabirinto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaLabirinto().setVisible(true);
            }
        });
    }
}
//    public void busca() {
        /*for(int i = 0; i < 42; i++) {
            for(int j = 0;j < 42; j++){
                System.out.print(labirinto[i][j]+" ");
//            }
//            System.out.println();
//        }*/
//
//        int cont = 1;
//        grafo = new Grafo();
//        Vertice inicio = houses.vertices.get(seq+1);
//        Vertice fim = houses.vertices.get(seq);
////        Vertice fim = new Vertice(4,13);
//        ASS aStar = new ASS(grafo);
//        aStar.buscar(inicio, fim, labirint);
//        Pilha pilha = new Pilha();
//        Vertice atual = (Vertice) grafo.vertices.get(grafo.vertices.size() - 1);
//        while(atual != null) {
//            pilha.push(atual);
//            //System.out.println("pilha x:"+atual.x);
//            //System.out.println("pilha y:"+atual.y);
//            //System.out.println();
//            cont++;
//            atual = atual.pai;
//        }
//        rota = new Vertice[cont];
//        cont = pilha.cont;
//        for(int i = 0; i < cont; i++) {
//            rota[i] = pilha.pop();
//            System.out.println("rota:"+rota[i].x);
//            System.out.println("rota:"+rota[i].y);
//            System.out.println();
//        }
//        /*houses.vertices.forEach((v) ->{
////            System.out.println(v.x);
//            System.out.println(v.y);
//            System.out.println("pilha:"+v.name);
////            System.out.println();
////        });*/
//    }
//    
//    public void buscaLabirinto() {
//        for (int i = 0; i < 42; i++){
//            String[] aux = labirinto[i].split(",");
//            for(int j = 0; j < 42; j++) {
//                labirint[i][j] = Integer.parseInt(aux[j]);
//            }
//        }
//        houses.add_vertice(new Vertice(13,4,37));
//        for(int i = 0; i < 12; i++) {
//            String[] aux = casas[i].split(",");
//            Vertice novo = new Vertice((12-i),Integer.parseInt(aux[0]), Integer.parseInt(aux[1]));
//            novo.peso = Integer.parseInt(aux[2]);
//            houses.add_vertice(novo);
//            
//        }
//        houses.add_vertice(new Vertice(14,37,37));
//    }
//    
//    public void setSeq(int s) {
//        this.seq = s;
//        busca();
//        add(new Labirinto(jLabel2,rota,theme,seq,this));
// 
//    }
//    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
//}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
