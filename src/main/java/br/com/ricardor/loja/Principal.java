/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ricardor.loja;

/**
 *
 * @author ricardorocha
 */
public class Principal {
    
    public static void main(String[] args) {
       Cachorro meuCachorro = new Cachorro();
       meuCachorro.nome = "Thor";
       meuCachorro.raca = "Poodle";
       meuCachorro.tamanho = 2;
       
       trocarNome(meuCachorro);
       System.out.println(meuCachorro.nome);
         
       int i = 1;
       zerar(i);
       
       System.out.println(i);
    }
    
    public static void trocarNome(Cachorro cachorro) {
        cachorro.nome = "Zeus";
    }
    
    public static void zerar(int numero) {
        numero = 0;
        System.out.println("Numero do metodo: " + numero);
    }
   
    public static int somar(int primeiro, int segundo) {
        return primeiro + segundo;
    }
    
    public static double somar(double primeiro, double segundo) {
        return  primeiro + segundo;
    }

    
}
