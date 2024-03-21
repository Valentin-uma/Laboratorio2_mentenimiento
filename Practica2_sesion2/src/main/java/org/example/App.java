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
        doubleLinkedList.prepend("2");

        doubleLinkedList.prepend("1");

        System.out.println(doubleLinkedList.get(1));

    }
}
