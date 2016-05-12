/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package knapsackproblem;

import java.util.Arrays;
import java.util.List;

/**
 *
 * @author ivo
 */
public class MaxKnapsack {

    private Knapsack knapsack;
    private List<Item> itens;
    private int valueTable[][];

    public MaxKnapsack(Knapsack knapsack, List<Item> itens) {
        this.knapsack = knapsack;
        this.itens = itens;
        this.valueTable = new int[this.itens.size() + 1][this.knapsack.getCapacity() + 1];

    }

    private void buildValueTable() {

        int wt = 0, val = 0;
        for (int i = 1; i <= this.itens.size(); i++) {
            for (int w = 1; w <= this.knapsack.getCapacity(); w++) {
                wt = this.itens.get(i - 1).getWeight();
                val = this.itens.get(i - 1).getValue();

                if (wt > w) {
                    this.valueTable[i][w] = this.valueTable[i - 1][w];
                } else if (wt <= w) {
                    this.valueTable[i][w] = Math.max(this.valueTable[i - 1][w], val + this.valueTable[i - 1][w - wt]);
                }
            }
        }
    }
    private int getMaximalValue(){
        return this.valueTable[this.itens.size()][this.knapsack.getCapacity()];
    }
    
    private int[] getSelectedItens(){
    }

    public List<Item> maximise() {
        this.buildValueTable();
        int maxValue=this.getMaximalValue();
        this.printValueTable();
        return this.itens;
    }

    public Knapsack accept() {
        return null;
    }

    private void printValueTable() {
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
