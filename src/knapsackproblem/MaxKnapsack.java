/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package knapsackproblem;

import java.util.Arrays;
import java.util.List;

/**
 * Class with the intention of resolve the problem, it receive a knapsack to put
 * itens on , a list of itens and it will construct a value table with it , to
 * find what is the ideal value to put in the bag. Later we find the itens that
 * match the value
 *
 * @author ivo
 */
public class MaxKnapsack {

    //The knapsack in sudy
    private Knapsack knapsack;
    //the itens to analise 
    private List<Item> itens;
    
    private int compareN;

    //the value table 
    private int valueTable[][];
    //knapsack ideal value
    private int knapsackMaximalValue;
    //the choosed itens 
    private List<Item> choosedItens;

//construct
    public MaxKnapsack(Knapsack knapsack, List<Item> itens) {
        this.knapsack = knapsack;
        this.itens = itens;
        // a value table from 0 to itens number , and 0 to knapsack capacity weight
        this.valueTable = new int[this.itens.size() + 1][this.knapsack.getCapacity() + 1];

    }

    //function to build the value table matrix
    //it returns the final item and weight state
    private int[] buildValueTable() {

        int wt = 0, val = 0;
        int i, w = 1;
        int iw[] = new int[2];
        for (i = 1; i <= this.itens.size(); i++) {
            this.compareN++;
            for (w = 1; w <= this.knapsack.getCapacity(); w++) {
                this.compareN++;
                wt = this.itens.get(i - 1).getWeight();
                val = this.itens.get(i - 1).getValue();

                if (wt > w) {
                    this.compareN++;
                    this.valueTable[i][w] = this.valueTable[i - 1][w];
                } else if (wt <= w) {
                    this.compareN++;
                    this.valueTable[i][w] = Math.max(this.valueTable[i - 1][w], val + this.valueTable[i - 1][w - wt]);
                }
            }
        }
        iw[0] = i;
        iw[1] = w;
        return iw;
    }

    //returns the ideal value of the value table
    private int getMaximalValue() {
        return this.valueTable[this.itens.size()][this.knapsack.getCapacity()];
    }

    //select the itens to the ideal value
    //return the ideal list of itens
    private List<Item> getSelectedItens(int i, int w) {
        i = i - 1;
        w = w - 1;
        List<Item> toReturn = new ItensList<>();
        while (i > 0 && w > 0) {
            this.compareN++;
            if (this.valueTable[i][w] != this.valueTable[i - 1][w]) {
                this.compareN++;
                toReturn.add(this.itens.get(i - 1));
                w = w - this.itens.get(i - 1).getWeight();
                i = i - 1;
            } else {
                i = i - 1;
            }
        }

        return toReturn;
    }

    public MaxKnapsack maximise() {
        int iw[] = new int[2];
        iw = this.buildValueTable();
        this.knapsackMaximalValue = this.getMaximalValue();
        this.choosedItens = this.getSelectedItens(iw[0], iw[1]);
  
        return this;
    }

    public MaxKnapsack accept() {
        for(Item item:this.choosedItens){
               this.knapsack.addItem(item);
        }
        return this;
    }
    
    public int compareCount(){
        return this.compareN;
    }

    public void printValueTable() {
        String weights = "";
        for (int i = 0; i <= this.knapsack.getCapacity(); i++) {
            weights = weights + i + ",";
        }
        System.out.println("V[i,w]|Peso(w)" + "   " + weights);
        for (int i = 0; i <= this.knapsack.getCapacity(); i++) {
        }
        System.out.println("Item(i)");
        for (int i = 0; i <= this.itens.size(); i++) {
            System.out.println(+i + "               " + Arrays.toString(this.valueTable[i]));
        }
    }

}
