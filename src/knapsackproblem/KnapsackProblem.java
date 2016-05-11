/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package knapsackproblem;

class Ring {

    private String name;
    private int quilates;
    private String composition;

    public Ring(String name, int quilates, String composition) {
        this.name = name;
        this.quilates = quilates;
        this.composition = composition;
    }

}

class Book {

    private String name;
    private int pages;
    private String author;

    public Book(String name, int pages, String author) {
        this.name = name;
        this.pages = pages;
        this.author = author;
    }

}

/**
 *
 * @author gae
 */
public class KnapsackProblem {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Knapsack knapsack = new Knapsack(100);

        knapsack.addItem(new Item(new Ring("Kowalski", 10, "Platinium"), 100, 50));
        knapsack.addItem(new Item(new Ring("Stone Cold", 4, "Gold"), 2000, 10));
        knapsack.addItem(new Item(new Book("The secret", 500, "Meee Lee"), 50, 30));
        knapsack.addItem(new Item(new Book("Angular4Dummys", 100, "Arnaldo Swag"), 120, 10));

        knapsack.toString();
    }

}
