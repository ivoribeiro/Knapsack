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

        //criar itens
        Item<Ring> item1 = new Item(new Ring("Kowalski", 10, "Platinium"), 70, 5);
        Item<Ring> item2 = new Item(new Ring("Stone Cold", 4, "Gold"), 25, 7);
        Item<Book> item3 = new Item(new Book("The secret", 500, "Meee Lee"), 43, 3);
        Item<Book> item4 = new Item(new Book("Angular4Dummys", 100, "Arnaldo Swag"), 19, 9);
        Item<Book> item5 = new Item(new Ring("Anel de Casamento", 10, "Platinium"), 30, 1);
        Item<Book> item6 = new Item(new Book("Livro Harry Potter", 4, "Gold"), 16, 3);
        Item<Book> item7 = new Item(new Ring("Anel Ruby", 500, "Meee Lee"), 15, 4);
        Item<Book> item8 = new Item(new Ring("Anel de filosofar", 100, "Arnaldo Swag"), 26, 7);
        Item<Book> item9 = new Item(new Book("Livro Kamasutra", 10, "Platinium"), 69, 1);
        Item<Book> item10 = new Item(new Book("Livro 100 reasons why women deserve less", 300, "Gold"), 300, 5);
        Item<Book> item11 = new Item(new Book("Livro 50 ways to suicide", 500, "Meee Lee"), 25, 6);
        Item<Book> item12 = new Item(new Book("Livro Utilidade do XML", 100, "Arnaldo Swag"), 1, 1000);
        Item<Book> item13 = new Item(new Ring("Anel de Ouro", 100, "Arnaldo Swag"), 20, 5);
        Item<Book> item14 = new Item(new Book("Livro cenas fixes", 100, "Arnaldo Swag"), 39, 8);
        Item<Book> item15 = new Item(new Ring("Anel de prata", 100, "Arnaldo Swag"), 17, 3);
        Item<Book> item16 = new Item(new Book("Livro Dilemas", 100, "Arnaldo Swag"), 32, 4);

        List<Item> itensList;
        itensList = new ItensList<>();

        itensList.add(item1);
        itensList.add(item2);
        itensList.add(item3);
        itensList.add(item4);
        //exemplo1
       // KnapsackIt(20,itensList,1); //376794   171
       // KnapsackIt(120,itensList,7); //376794   171
        //exemplo4
        //KnapsackIt(40, itensList,4);//554539 332

        itensList.add(item5);
        itensList.add(item6);
        itensList.add(item7);
        itensList.add(item8);

        //exemplo 2
        // KnapsackIt(20,itensList,2); //531562   341
        //exemplo 5
        // KnapsackIt(40,itensList,5); //1216636 664
        itensList.add(item9);
        itensList.add(item10);
        itensList.add(item11);
        itensList.add(item12);
        itensList.add(item13);
        itensList.add(item14);
        itensList.add(item15);
        itensList.add(item16);

        //exemplo 3
         //KnapsackIt(20,itensList,3); //780057 678
        //exemplo 6
        //KnapsackIt(40,itensList,7); //1935791 1322
        
        
        //7
        generate(120,20);
    }
    
    private static void generate(int itensN, int weightn){
         Item<Ring> item1 = new Item(new Ring("Kowalski", 10, "Platinium"), 70, 5);
         final int MAX_CAPACITY = weightn;
          List<Item> itensList;
        itensList = new ItensList<>();
        for(int i=1;i<=itensN;i++){
            itensList.add(item1);
        }
         KnapsackIt(MAX_CAPACITY,itensList,7);
    }

    private static void KnapsackIt(int maxCapacity, List<Item> itensList, int i) {

        final int MAX_CAPACITY = maxCapacity; //conjunto 1 ,2 ,3
        //final int MAX_CAPACITY = 40; //conjunto 4, 5, 6
        Knapsack knapsack = new Knapsack(MAX_CAPACITY);

        MaxKnapsack maxKnapsack = new MaxKnapsack(knapsack, itensList);
        final long startTime = System.nanoTime();
        int compareCount=maxKnapsack.maximise().accept().compareCount();
        final long endTime = System.nanoTime();

        System.out.println("Total execution time: " + (endTime - startTime));
        
        System.out.println("Comparações\n"+compareCount);

        System.out.println("Caso de estudo " + i + "\n");

        System.out.println("Capacidade da mochila: " + MAX_CAPACITY + "\n");

        System.out.println("Lista de Itens existentes:\n");

        System.out.println(itensList.toString());

        System.out.println("Solução Encontrada: \n");

        System.out.println("Tabela de valores \n");   

        maxKnapsack.printValueTable();

        System.out.println("Itens escolhidos \n");
        System.out.println(knapsack.toString());

    }

}
