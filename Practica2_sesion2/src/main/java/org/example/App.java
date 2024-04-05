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

        DoubleLinkedList<LinkedNode> doubleLinkedList = new DoubleLinkedList();

        LinkedNode<String> anotherNode1 = new LinkedNode<>("elem1", null, null);
        LinkedNode<String> anotherNode2 = new LinkedNode<>("elem2", null, null);
        LinkedNode<String> anotherNode3 = new LinkedNode<>("elem3", null, null);
        LinkedNode<String> anotherNode4 = new LinkedNode<>("elem4", null, null);
        doubleLinkedList.prepend(anotherNode1);
        doubleLinkedList.prepend(anotherNode2);
        doubleLinkedList.prepend(anotherNode3);
        doubleLinkedList.prepend(anotherNode4);

        System.out.println(doubleLinkedList.size());
        doubleLinkedList.remove(anotherNode2);
        int newSize = doubleLinkedList.size();

        System.out.println(newSize);

        System.out.println(doubleLinkedList.get(0));
        doubleLinkedList.first();

    }
}
