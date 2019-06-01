///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package search;
//
//import graph.Cavaleiro;
//import graph.GrafoCasa;
//import graph.Grupo;
//import java.math.RoundingMode;
//import java.text.NumberFormat;
//
//import java.util.ArrayList;
//import java.util.Locale;
//import java.util.PriorityQueue;
//import java.util.Stack;
//import main.Arquivo;
//
///**
// *
// * @author meimarcel
// */
//public class UFS {
//    public GrafoCasa grafo;
//    public GrafoCasa melhor;
//    public PriorityQueue<Grupo> fronteira;
//    public Stack<Grupo> pilha;
//    public ArrayList<Grupo> comb;
//    public String[] combinacao = Arquivo.Read("COMBINACOES.txt");
//    public String[] cavaleirosbronze = Arquivo.Read("BRONZE.txt");
//    public String[] cavaleirosouro = Arquivo.Read("CAVALEIROSOURO.txt");
//    public Grupo novo;
//    private boolean cond = true;
//    private Grupo fim;
//    
//    public UFS (GrafoCasa grafo) {
//        Locale.setDefault(Locale.US); // &lt;================================== 
//	NumberFormat format = NumberFormat.getInstance();  
//	format.setMaximumFractionDigits(1);  
//	format.setMinimumFractionDigits(1);  
//	format.setMaximumIntegerDigits(1);  
//	format.setRoundingMode(RoundingMode.HALF_UP);
//        this.melhor = grafo;
//        this.pilha = new Stack<>();
//        this.comb = new ArrayList<>();
//        this.fronteira = new PriorityQueue<>(Grupo.Comparar);
//        for(int i = 0; i < combinacao.length; i++){
//            novo = new Grupo();
//            for(String a : combinacao[i].split(",")){
//                for(String b : cavaleirosbronze){
//                    if(a.equals(b.split(",")[0])) {
//                        novo.add_Cavaleiro(new Cavaleiro(Integer.parseInt(a),Float.parseFloat(b.split(",")[1]),Integer.parseInt(b.split(",")[2])));
//                        novo.poder += Float.parseFloat(b.split(",")[1]);
//                        
//                    }
//                }  
//            }
//            novo.poder= Float.valueOf(format.format(novo.poder));
//            novo.p[0] = 5;
//            novo.p[1] = 5;
//            novo.p[2] = 5;
//            novo.p[3] = 5;
//            novo.p[4] = 5;
//            novo.nivel = 0;
//            this.comb.add(novo);
//        }
//        novo = new Grupo();
//        novo.peso = Float.MAX_VALUE;
//        melhor.add_vertice(novo);
//    }
//
//   public void buscar() {
//        for(Grupo g : comb){
//            System.out.println();
//            System.out.println();
//            System.out.println("#####################################################################################");
//            System.out.println();
//            System.out.println();
//            grafo = new GrafoCasa();
//            g.nivel = 0;
//            g.pai = null;
//            g.h = 0;
//            g.peso = Integer.parseInt(cavaleirosouro[g.nivel].split(",")[1]) / g.poder;
//            this.fronteira.add(g);
//        }
//        while(!fronteira.isEmpty()) {
//            Grupo atual = this.fronteira.poll();
//            if (atual.nivel == 11) {
//                    fim = atual;
//                    grafo.add_vertice(atual);
//                    break;
//            }
//            for (Grupo i : this.comb) {
//                for(Cavaleiro c : i.grupo){
//                    //System.out.println();
//                    //System.out.println("interacao:"+c.nome);
//                    //System.out.println();
//                    if (atual.p[c.nome -1] == 0) {
//                        //System.out.println();
//                        //System.out.println("entrou");
//                        //System.out.println();
//                        cond = false;
//                    }
//                }
//                if (cond = true ) {
//                    int soma = 0;
//                    for(int v = 0; v < 5; v++){
//                        soma += atual.p[v];
//                    }
//                    if(soma < (11 - atual.nivel)) {
//                        cond = false;
//                        System.out.println(cond);
//                    }   
//                }
//                if (cond == true && atual.nivel < 11 && atual.peso <= 360) {
//                    Grupo aux = new Grupo();
//                    aux.p[0] = atual.p[0];
//                    aux.p[1] = atual.p[1];
//                    aux.p[2] = atual.p[2];
//                    aux.p[3] = atual.p[3];
//                    aux.p[4] = atual.p[4];
//                    i.grupo.forEach((a) -> {
//                        aux.add_Cavaleiro(a);
//                        aux.p[a.nome-1]--;
//                    });
//
//                    aux.pai = atual;
//                    aux.nivel = atual.nivel + 1;
//                    int resto = 0;
//                    for(int k = (aux.nivel + 1); k < 12; k++) {
//                        resto += Integer.parseInt(cavaleirosouro[k].split(",")[1]);
//                    }
//                    int resto2 = 0;
//                    for(int k = 0; k < 5; k++) {
//                        resto2 += (aux.p[k] * Float.parseFloat(cavaleirosbronze[k].split(",")[1]));
//                        System.out.println("vida "+k+":"+aux.p[k]);
//                    }
//                    aux.peso = (Integer.parseInt(cavaleirosouro[aux.nivel].split(",")[1]) / i.poder) + atual.peso;
//                    aux.h = resto / resto2;
//                    grafo.add_vertice(aux);
//                    this.fronteira.add(aux);
//                    System.out.println("nivel:"+atual.nivel);
//                    System.out.println("peso h:"+atual.h);
//                    System.out.println("peso aux:"+aux.peso);
//                    System.out.println("poder:"+i.poder);
//                    System.out.println();
//                }
//                    System.out.println();
//                    System.out.println();
//                    System.out.println();
//
//                cond = true;
//            }
//            System.out.println("saiu");
//
//        }
//
//    }
//    
//    /*public void buscar() {
//        for(Grupo g : comb){
//            grafo = new GrafoCasa();
//            g.nivel = 0;
//            g.pai = null;
//            g.peso = Integer.parseInt(cavaleirosouro[g.nivel].split(",")[1]) / g.poder;
//            this.pilha.push(g);
//        }
//        while(!pilha.isEmpty()) {
//            Grupo atual = this.pilha.pop();
//            if (atual.nivel == 11 && atual.peso <= 360) {
//                    fim = atual;
//                    grafo.add_vertice(atual);
//                    break;
//            }
//            for (Grupo i : this.comb) {
//                for(Cavaleiro c : i.grupo){
//                    //System.out.println();
//                    //System.out.println("interacao:"+c.nome);
//                    //System.out.println();
//                    if (atual.p[c.nome -1] == 0) {
//                        System.out.println();
//                        System.out.println("entrou");
//                        System.out.println();
//                        cond = false;
//                    }
//                }
//                if(cond = true) {
//                    int soma = 0;
//                    for(int v = 0; v < 5; v++){
//                        soma += atual.p[v];
//                    }
//                    if(soma < (11 - atual.nivel)) {
//                        cond = false;
//
//                    }
//                }
//                if (cond == true && atual.nivel < 11 && atual.peso < 360) {
//                    Grupo aux = new Grupo();
//                    aux.p[0] = atual.p[0];
//                    aux.p[1] = atual.p[1];
//                    aux.p[2] = atual.p[2];
//                    aux.p[3] = atual.p[3];
//                    aux.p[4] = atual.p[4];
//                    i.grupo.forEach((a) -> {
//                        aux.add_Cavaleiro(a);
//                        aux.p[a.nome-1]--;
//                    });
//
//                    aux.pai = atual;
//                    aux.nivel = atual.nivel + 1;
//                    aux.peso = (Integer.parseInt(cavaleirosouro[aux.nivel].split(",")[1]) / i.poder) + atual.peso;
//
//                    grafo.add_vertice(aux);
//                    this.pilha.push(aux);
//                    System.out.println("nivel:"+atual.nivel);
//                    System.out.println("peso aux:"+aux.peso);
//                    System.out.println("poder:"+i.poder);
//                    System.out.println();
//            }
//
//            cond = true;
//            }
//            System.out.println("saiu");
//
//        }
//    }*/
//    
//    
//}

///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package search;
//
//import graph.Cavaleiro;
//import graph.GrafoCasa;
//import graph.Grupo;
//import java.math.RoundingMode;
//import java.text.NumberFormat;
//
//import java.util.ArrayList;
//import java.util.Locale;
//import java.util.PriorityQueue;
//import java.util.Stack;
//import main.Arquivo;
//
///**
// *
// * @author meimarcel
// */
//public class UFS {
//    public GrafoCasa grafo;
//    public GrafoCasa melhor;
//    public PriorityQueue<Grupo> fronteira;
//    public Stack<Grupo> pilha;
//    public ArrayList<Grupo> comb;
//    public String[] combinacao = Arquivo.Read("COMBINACOES.txt");
//    public String[] cavaleirosbronze = Arquivo.Read("BRONZE.txt");
//    public String[] cavaleirosouro = Arquivo.Read("CAVALEIROSOURO.txt");
//    public Grupo novo;
//    private boolean cond = true;
//    private Grupo fim;
//    
//    public UFS (GrafoCasa grafo) {
//        Locale.setDefault(Locale.US); // &lt;================================== 
//	NumberFormat format = NumberFormat.getInstance();  
//	format.setMaximumFractionDigits(1);  
//	format.setMinimumFractionDigits(1);  
//	format.setMaximumIntegerDigits(1);  
//	format.setRoundingMode(RoundingMode.HALF_UP);
//        this.melhor = grafo;
//        this.pilha = new Stack<>();
//        this.comb = new ArrayList<>();
//        this.fronteira = new PriorityQueue<>(Grupo.Comparar);
//        for(int i = 0; i < combinacao.length; i++){
//            novo = new Grupo();
//            novo.p[0] = 5;
//            novo.p[1] = 5;
//            novo.p[2] = 5;
//            novo.p[3] = 5;
//            novo.p[4] = 5;
//            for(String a : combinacao[i].split(",")){
//                for(String b : cavaleirosbronze){
//                    if(a.equals(b.split(",")[0])) {
//                        novo.grupo[Integer.parseInt(a) - 1] = true;
//                        novo.poder += Float.parseFloat(b.split(",")[1]);
//                        novo.p[Integer.parseInt(a) - 1] -= 1;
//                        System.out.println(novo.grupo[Integer.parseInt(a) - 1]);
//                        
//                    }
//                }  
//            }
//            System.out.println();
//            novo.poder= Float.valueOf(format.format(novo.poder));
//            novo.nivel = 0;
//            this.comb.add(novo);
//        }
//        novo = new Grupo();
//        novo.peso = Float.MAX_VALUE;
//        melhor.add_vertice(novo);
//    }
//
//   public void buscar() {
//        for(Grupo g : comb){
//            System.out.println();
//            System.out.println();
//            System.out.println("#####################################################################################");
//            System.out.println(g.poder);
//            System.out.println();
//            g.nivel = 0;
//            g.pai = null;
//            g.peso = Integer.parseInt(cavaleirosouro[g.nivel].split(",")[1]) / g.poder;
//            int resto2 = 0;
//            for(int k = 0; k < 5; k++) {
//                //resto2 += (aux.p[k] * Float.parseFloat(cavaleirosbronze[k].split(",")[1]));
//                resto2 += g.p[k];
//                System.out.println("vida "+k+":"+g.p[k]);
//            }
//            g.h = g.peso - resto2;
//            this.fronteira.add(g);
//        }
//            grafo = new GrafoCasa();
//        while(!fronteira.isEmpty()) {
//            Grupo atual = this.fronteira.poll();
//            if (atual.nivel == 11) {
//                    fim = atual;
//                    grafo.add_vertice(atual);
//                    break;
//            }
//            for (Grupo i : this.comb) {
//                for(int z = 0; z < 5; z++){
//                    //System.out.println();
//                    //System.out.println("interacao:"+c.nome);
//                    //System.out.println();
//                    if (i.grupo[z] == true) {
//                        if (atual.p[z] == 0) {
//                            //System.out.println();
//                            //System.out.println("entrou");
//                            //System.out.println();
//                            cond = false;
//                            break;
//                        }   
//                    }
//                }
//                if (cond == true ) {
//                    int soma = 0;
//                    for(int v = 0; v < 5; v++){
//                        soma += atual.p[v];
//                    }
//                    if(soma < (11 - atual.nivel)) {
//                        cond = false;
//                        System.out.println(cond);
//                    }   
//                }
//                if (cond == true && atual.nivel < 11 && atual.peso <= 360) {
//                    Grupo aux = new Grupo();
//                    aux.p[0] = atual.p[0];
//                    aux.p[1] = atual.p[1];
//                    aux.p[2] = atual.p[2];
//                    aux.p[3] = atual.p[3];
//                    aux.p[4] = atual.p[4];
//                    for(int z = 0; z < 5; z++) {
//                        if(i.grupo[z] == true) {
//                            aux.grupo[z] = true;
//                            aux.p[z] -= 1;
//                        }
//                    }
//
//                    aux.pai = atual;
//                    aux.nivel = atual.nivel + 1;
//                    /*int resto = 0;
//                    for(int k = (aux.nivel + 1); k < 12; k++) {
//                        resto += Integer.parseInt(cavaleirosouro[k].split(",")[1]);
//                    }*/
//                    int resto2 = 0;
//                    for(int k = 0; k < 5; k++) {
//                        //resto2 += (aux.p[k] * Float.parseFloat(cavaleirosbronze[k].split(",")[1]));
//                        resto2 += aux.p[k];
//                        System.out.println("vida "+k+":"+aux.p[k]);
//                    }
//                    aux.peso = (Integer.parseInt(cavaleirosouro[aux.nivel].split(",")[1]) / i.poder) + atual.peso;
//                    aux.h = aux.peso - resto2;
//                    grafo.add_vertice(aux);
//                    this.fronteira.add(aux);
//                    System.out.println("nivel:"+aux.nivel);
//                    System.out.println("peso h:"+aux.h);
//                    System.out.println("peso aux:"+aux.peso);
//                    System.out.println("poder:"+i.poder);
//                    System.out.println();
//                }
//
//                cond = true;
//            }
//            System.out.println("saiu");
//
//        }
//
//    }
//    
//    /*public void buscar() {
//        for(Grupo g : comb){
//            g.nivel = 0;
//            g.pai = null;
//            g.peso = Integer.parseInt(cavaleirosouro[g.nivel].split(",")[1]) / g.poder;
//            this.pilha.push(g);
//        }
//        grafo = new GrafoCasa();
//        while(!pilha.isEmpty()) {
//            Grupo atual = this.pilha.pop();
//            if (atual.nivel == 11 && atual.peso <= 360) {
//                    fim = atual;
//                    grafo.add_vertice(atual);
//                    break;
//            }
//            for (Grupo i : this.comb) {
//                for(int z = 0; z < 5; z++){
//                    //System.out.println();
//                    //System.out.println("interacao:"+c.nome);
//                    //System.out.println();
//                    if (i.grupo[z] == true) {
//                        if (atual.p[z] == 0) {
//                            //System.out.println();
//                            //System.out.println("entrou");
//                            //System.out.println();
//                            cond = false;
//                            break;
//                        }   
//                    }
//                }
//                if(cond == true) {
//                    int soma = 0;
//                    for(int v = 0; v < 5; v++){
//                        soma += atual.p[v];
//                    }
//                    if(soma < (11 - atual.nivel)) {
//                        cond = false;
//
//                    }
//                }
//                if (cond == true && atual.nivel < 11 && atual.peso < 360) {
//                    Grupo aux = new Grupo();
//                    aux.p[0] = atual.p[0];
//                    aux.p[1] = atual.p[1];
//                    aux.p[2] = atual.p[2];
//                    aux.p[3] = atual.p[3];
//                    aux.p[4] = atual.p[4];
//                    for(int z = 0; z < 5; z++) {
//                        if(i.grupo[z] == true) {
//                            aux.grupo[z] = true;
//                            aux.p[z] -= 1;
//                        }
//                    }
//
//                    aux.pai = atual;
//                    aux.nivel = atual.nivel + 1;
//                    aux.peso = (Integer.parseInt(cavaleirosouro[aux.nivel].split(",")[1]) / i.poder) + atual.peso;
//
//                    grafo.add_vertice(aux);
//                    this.pilha.push(aux);
//                    System.out.println("nivel:"+atual.nivel);
//                    System.out.println("peso aux:"+aux.peso);
//                    System.out.println("poder:"+i.poder);
//                    System.out.println();
//            }
//
//            cond = true;
//            }
//            System.out.println("saiu");
//
//        }
//    }*/
//    
//    
//}


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package search;

import graph.Cavaleiro;
import graph.GrafoCasa;
import graph.Grupo;
import java.math.RoundingMode;
import java.text.NumberFormat;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Locale;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;
import main.Arquivo;

/**
 *
 * @author meimarcel
 */
public class UFS {
    public GrafoCasa grafo;
    public GrafoCasa melhor;
    public Queue<Grupo> fronteira;
    public Stack<Grupo> pilha;
    public ArrayList<Grupo> comb;
    public String[] combinacao = Arquivo.Read("COMBINACOES.txt");
    public String[] cavaleirosbronze = Arquivo.Read("BRONZE.txt");
    public String[] cavaleirosouro = Arquivo.Read("CAVALEIROSOURO.txt");
    public Grupo novo;
    private boolean cond = true;
    private Grupo aux;
    private float maior = 0;
    private boolean cond2 = false;
    
    
    public UFS (GrafoCasa grafo) {
        Locale.setDefault(Locale.US); // &lt;================================== 
	NumberFormat format = NumberFormat.getInstance();  
	format.setMaximumFractionDigits(1);  
	format.setMinimumFractionDigits(1);  
	format.setMaximumIntegerDigits(1);  
	format.setRoundingMode(RoundingMode.HALF_UP);
        this.grafo = grafo;
        this.pilha = new Stack<>();
        this.comb = new ArrayList<>();
        this.fronteira = new LinkedList<>();
        for(int i = 0; i < combinacao.length; i++){
            novo = new Grupo();
            novo.p[0] = 5;
            novo.p[1] = 5;
            novo.p[2] = 5;
            novo.p[3] = 5;
            novo.p[4] = 5;
            novo.nivel = 0;
            for(String a : combinacao[i].split(",")){
                for(String b : cavaleirosbronze){
                    if(a.equals(b.split(",")[0])) {
                        novo.add_Cavaleiro(new Cavaleiro(Integer.parseInt(a),Float.parseFloat(b.split(",")[1]),Integer.parseInt(b.split(",")[2])));
                        novo.poder += Float.parseFloat(b.split(",")[1]);
                        novo.p[Integer.parseInt(a) - 1] -= 1;
                    }
                }  
            }
            novo.poder= Float.valueOf(format.format(novo.poder));
            this.comb.add(novo);
        }
        novo = new Grupo();
       
    }
    public void buscar() {
        for(Grupo g : comb){
            g.nivel = 0;
            g.pai = null;
            g.peso = Integer.parseInt(cavaleirosouro[g.nivel].split(",")[1]) / g.poder;
            float peso = (Integer.parseInt(cavaleirosouro[0].split(",")[1]) / g.poder);
            float  resto = 0;
            for(Cavaleiro a : g.grupo){
                if(g.p[a.nome -1] < 5){
                    resto += (a.cosmo * (5 - g.p[a.nome -1] + 2));
                } else {
                    resto += a.cosmo;
                }
            }
            float haux = peso / resto;
            g.h = haux;
            if(peso < 30){
                //System.out.println(g.h);
                this.fronteira.add(g);
            }
        }
        while(!fronteira.isEmpty()) {
            Grupo atual = this.fronteira.poll();
//            System.out.println();
//            System.out.println(atual.h);
//            for(int k = 0; k < 5; k++) {
//                System.out.println("vida "+k+":"+atual.p[k]);
//            }
//            System.out.println();
            if (atual.nivel == 11) {
                    grafo.add_vertice(atual);
                    break;
            }
            for (Grupo i : this.comb) {
                for(Cavaleiro c : i.grupo){
                    //System.out.println();
                    //System.out.println("interacao:"+c.nome);
                    //System.out.println();
                    if (atual.p[c.nome -1] == 0 ) {
                        //System.out.println();
                        //System.out.println("entrou");
                        //System.out.println();
                        cond = false;
                    }
                }
                if (cond == true ) {
                    int soma = 0;
                    for(int v = 0; v < 5; v++){
                        soma += atual.p[v];
                    }
                    if(soma < (11 - atual.nivel)) {
                        cond = false;
                        System.out.println(cond);
                    }   
                }
                
                if (cond == true && atual.nivel < 11) {
                    //System.out.println("entrou");
                    int[] vida = new int[5];
                    vida[0] = atual.p[0];
                    vida[1] = atual.p[1];
                    vida[2] = atual.p[2];
                    vida[3] = atual.p[3];
                    vida[4] = atual.p[4];
                    i.grupo.forEach((a) -> {
                        vida[a.nome-1]--;
                    });
                    float peso = (Integer.parseInt(cavaleirosouro[atual.nivel + 1].split(",")[1]) / i.poder);
                    float  resto = 0;
                    for(Cavaleiro a : i.grupo){
                        if(vida[a.nome -1] < 5){
                            resto += (a.cosmo * (5 - vida[a.nome -1] + 2));
                        } else {
                            resto += a.cosmo;
                        }
                    }
                    float haux = peso / resto;
                    
                    if(peso > maior && peso < 39) {
                        aux = new Grupo();
                        aux.p[0] = atual.p[0];
                        aux.p[1] = atual.p[1];
                        aux.p[2] = atual.p[2];
                        aux.p[3] = atual.p[3];
                        aux.p[4] = atual.p[4];
                        i.grupo.forEach((a) -> {
                            aux.add_Cavaleiro(a);
                            aux.p[a.nome-1]--;
                        });
                        maior = peso;
                        aux.pai = atual;
                        aux.nivel = atual.nivel + 1;
                        aux.peso = peso;
                        aux.h = haux;
                        aux.poder = i.poder;
                        cond2 = true;
                        /*for(int k = 0; k < 5; k++) {
                            System.out.println("vida "+k+":"+aux.p[k]);
                        }*/
//                        System.out.println("nivel:"+aux.nivel);
//                        System.out.println("peso h:"+aux.h);
//                        System.out.println("peso aux:"+aux.peso);
//                        System.out.println("poder:"+i.poder);
//                        System.out.println();
                    }
                }

                cond = true;
            }
            if(cond2 = true) {
                /*System.out.println("nivel:"+aux.nivel);
                 for(int k = 0; k < 5; k++) {
                    System.out.println("vida "+k+":"+aux.p[k]);
                }
                System.out.println("peso h:"+aux.h);
                System.out.println("peso aux:"+aux.peso);
                System.out.println("poder:"+aux.poder);
                System.out.println();*/
                grafo.add_vertice(aux);
                this.fronteira.add(aux);
                cond2 = false;
            }
            maior = 0;
            //System.out.println("saiu");

        }

    }
    
    /*public void buscar() {
        for(Grupo g : comb){
            grafo = new GrafoCasa();
            g.nivel = 0;
            g.pai = null;
            g.peso = Integer.parseInt(cavaleirosouro[g.nivel].split(",")[1]) / g.poder;
            this.pilha.push(g);
        }
        while(!pilha.isEmpty()) {
            Grupo atual = this.pilha.pop();
            if (atual.nivel == 11 && atual.peso <= 360) {
                    fim = atual;
                    grafo.add_vertice(atual);
                    break;
            }
            for (Grupo i : this.comb) {
                for(Cavaleiro c : i.grupo){
                    //System.out.println();
                    //System.out.println("interacao:"+c.nome);
                    //System.out.println();
                    if (atual.p[c.nome -1] == 0) {
                        System.out.println();
                        System.out.println("entrou");
                        System.out.println();
                        cond = false;
                    }
                }
                if(cond = true) {
                    int soma = 0;
                    for(int v = 0; v < 5; v++){
                        soma += atual.p[v];
                    }
                    if(soma < (11 - atual.nivel)) {
                        cond = false;

                    }
                }
                if (cond == true && atual.nivel < 11 && atual.peso < 360) {
                    Grupo aux = new Grupo();
                    aux.p[0] = atual.p[0];
                    aux.p[1] = atual.p[1];
                    aux.p[2] = atual.p[2];
                    aux.p[3] = atual.p[3];
                    aux.p[4] = atual.p[4];
                    i.grupo.forEach((a) -> {
                        aux.add_Cavaleiro(a);
                        aux.p[a.nome-1]--;
                    });

                    aux.pai = atual;
                    aux.nivel = atual.nivel + 1;
                    aux.peso = (Integer.parseInt(cavaleirosouro[aux.nivel].split(",")[1]) / i.poder) + atual.peso;

                    grafo.add_vertice(aux);
                    this.pilha.push(aux);
                    System.out.println("nivel:"+atual.nivel);
                    System.out.println("peso aux:"+aux.peso);
                    System.out.println("poder:"+i.poder);
                    System.out.println();
            }

            cond = true;
            }
            System.out.println("saiu");

        }
    }*/
    
    
}