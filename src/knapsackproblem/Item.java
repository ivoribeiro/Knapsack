/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package knapsackproblem;

/**
 *
 * @author gae
 */
public class Item<T> {

    private T content;
    private int value;
    private int weight;

    public Item(T content, int value, int weight) {
        this.content = content;
        this.value = value;
        this.weight = weight;
    }

    public T getcontent() {
        return content;
    }

    public int getValue() {
        return value;
    }

    public int getWeight() {
        return weight;
    }

}
