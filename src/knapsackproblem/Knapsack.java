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
        this.itens = new ItensList<>();

    }

    public int getCapacity() {
        return capacity;
    }
    

    public List<Item> getItens() {
        return itens;
    }

    private int getKnapsackWeight() {
        int weight = 0;

        for (Item temp : itens) {
            weight = weight + temp.getWeight();
        }
        return weight;
    }

    public Item addItem(Item item) {

        if (this.getKnapsackWeight() + item.getWeight() <= this.capacity) {
            itens.add(item);
            return item;
        } else {
            return null;
        }
    }

    @Override
    public String toString() {
        return "Knapsack:{"
                + "\n \n" + "  capacity:" + capacity +",\n \n"+
                "   ItensList:{\n "+
                this.itens.toString()+"}\n"+
                "\n}";
    }

}
