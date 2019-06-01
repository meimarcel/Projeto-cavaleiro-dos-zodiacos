/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author meimarcel
 */
public class Arquivo {
    public static String[] Read(String Caminho){
        String[] conteudo;
        String aux = "";
        
        try {
            FileReader arq = new FileReader(Caminho);
            BufferedReader lerArq = new BufferedReader(arq);
            String linha="";
            try {
                linha = lerArq.readLine();
                while(linha!=null){
                    aux += linha+":";
                    linha = lerArq.readLine();
                }
                arq.close();
                conteudo = aux.split(":");
                return conteudo;
            } catch (IOException ex) {
                System.out.println("Erro: Não foi possível ler o arquivo!");
                return null;
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Erro: Arquivo não encontrado!");
            return null;
        }
    }
    
}
