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
public class Cachorro extends Animal {
    int tamanho;
    String raca;
    String nome;
    
    void latir() {
        System.out.println("Au au");
    }
    
    boolean pegarGraveto(int tamanhoGraveto) {
        cocar();
        
        if (tamanho < 10 && tamanhoGraveto > 10)
            return false;
        if (tamanho >= 10)
            return true;
        
        return true;
    }
    
    public void andar() {
        System.out.println("Cachorro andando");
    }
    
    void cocar() {
        System.out.println("Estou me coçando");
    }
}
