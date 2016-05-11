/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package knapsackproblem;

import java.util.List;

/**
 *
 * @author ivo
 */
public class MaxKnapsack {
    
    private Knapsack knapsack;
    private List<Item> itens;

    public MaxKnapsack(Knapsack knapsack,List<Item> itens) {
        this.knapsack = knapsack;
        this.itens=itens;
    }
    
    public List<Item> maximise(){
        return this.itens;
    }
    
    public Knapsack accept(){
        return null;
    }
    
    
    
}
