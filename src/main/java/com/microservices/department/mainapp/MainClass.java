package com.microservices.department.mainapp;

import com.microservices.department.model.Book;
import com.microservices.department.model.Counter;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MainClass {

    private static List<Book> books = new ArrayList<>();

    public static void main(String[] args){
        //createDB();
try{
    int a =3/0;
}
catch(RuntimeException e){
    throw new RuntimeException("hello");
    //System.out.println("im in catch block");
        }

        System.out.println("line after try catch");

    }

    private static void createDB(){
        Book b1 = new Book("chemistry",20);
        Book b2 = new Book("physics",25);
        Book b3 = new Book("english",30);
        Book b4 = new Book("maths",40);
        Book b5 = new Book("biology",50);

        books.add(b1);
        books.add(b2);
        books.add(b3);
        books.add(b4);
        books.add(b5);
    }

    public static void forEachExample(){
        books.forEach(book->System.out.println(book));
    }

    public static void filterSpecificBook(String bookName){
        Book filterBook = books.stream()
                          .filter(book -> book.getBookName().equalsIgnoreCase(bookName))
                          .findFirst()
                          .orElse(null);
        if(filterBook!=null){
            System.out.println("book found : "+filterBook);
        }
        else{
            System.out.println("book with name : "+bookName +" not found!");
        }
    }

    public static void filterExample(){
       List<Book> filteredBooks = books.stream()
                .filter(book -> book.getPrice()>25)
                .collect(Collectors.toList());
       filteredBooks.forEach(book -> System.out.println(book));
    }

    public static void findFirstExample(){
        Book b = books.stream()
                .filter(book -> book.getPrice()>30)
                .findFirst()
                .orElse(null);
        if(b!=null){
            System.out.println(b);
        }
        else{
            System.out.println("there is no book found with price greater than 30!");
        }
    }

    public static Integer convertMinutesIntoSeconds(Integer minutes){
        return minutes*60;
    }

    public static String[] getMapValues(Map<String,String>map){
        List<String> list = new ArrayList<>();
        map.keySet().stream()
                .forEach(key->list.add(map.get(key)));

        return list.toArray(new String[0]);
    }

    public static void arrayOfMultiple(int input,int len){
        //(7,5) --> [7,14,21,28,35]
        int[] array=new int[5];
        for(int i=0;i<len;i++){
           array[i]=input*(i+1);
        }
        Arrays.stream(array)
                .forEach(j->System.out.println(j));
    }
}
