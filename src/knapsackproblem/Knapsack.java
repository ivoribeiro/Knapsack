/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package knapsackproblem;

import java.util.List;

/**
 *
 * @author gae
 */
public class Knapsack {

    private int capacity;

    private List<Item> itens;

    public Knapsack(int capacity) {
        this.capacity = capacity;
    }
    
    public List<Item> getItens() {
        return itens;
    }

    private int getKnapsackValue() {
        int value = 0;

        for (Item temp : itens) {
            value = value + temp.getValue();
        }
        return value;
    }

    public Item addItem(Item item) {

        if (this.getKnapsackValue() + item.getValue() <= this.capacity) {
            itens.add(item);
            return item;
        }
        else return null;
    }

    @Override
    public String toString() {
        return "Knapsack{"
                + "/n" + "capacity=" + capacity + '}';
    }
    
    

}
