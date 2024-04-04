package org.example;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );

        DoubleLinkedList<String> doubleLinkedList = new DoubleLinkedList();
        doubleLinkedList.prepend("3");

        System.out.println(doubleLinkedList.get(0));
        doubleLinkedList.deleteLast();
        doubleLinkedList.first();

    }
}
