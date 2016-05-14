/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package knapsackproblem;

import java.util.List;

class Ring {

    private String name;
    private int quilates;
    private String composition;

    public Ring(String name, int quilates, String composition) {
        this.name = name;
        this.quilates = quilates;
        this.composition = composition;
    }

    @Override
    public String toString() {
        return "Ring{" + "name:" + name + ", quilates:" + quilates + ", composition:" + composition + '}';
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

    @Override
    public String toString() {
        return "Book{" + "name:" + name + ", pages:" + pages + ", author:" + author + '}';
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

        final int MAX_CAPACITY = 90;
        Knapsack knapsack = new Knapsack(MAX_CAPACITY);

        List<Item> itensList;
        itensList = new ItensList<>();

        itensList.add(new Item(new Ring("Kowalski", 10, "Platinium"), 100, 50));
        itensList.add(new Item(new Ring("Stone Cold", 4, "Gold"), 2000, 10));
        itensList.add(new Item(new Book("The secret", 500, "Meee Lee"), 50, 30));
        itensList.add(new Item(new Book("Angular4Dummys", 100, "Arnaldo Swag"), 120, 10));

        MaxKnapsack maxKnapsack = new MaxKnapsack(knapsack, itensList);
        maxKnapsack.maximise().accept();

        System.out.println("Caso de estudo 1\n");
        
        System.out.println("Capacidade da mochila: "+ MAX_CAPACITY+"\n");

        System.out.println("Lista de Itens existentes:\n");

        System.out.println(itensList.toString());
        
        System.out.println("Solução Encontrada: \n");

        System.out.println(knapsack.toString());

    }

}
