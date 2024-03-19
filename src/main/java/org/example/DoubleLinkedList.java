package org.example;

public class DoubleLinkedList<T> implements DoubleLinkedQueue<T> {

    private LinkedNode<T> first;
    private LinkedNode<T> last;
    private int size;

    public DoubleLinkedList() {

        this.first = new LinkedNode<>(null, null, last);
        this.last = new LinkedNode<>(null, first, null);
        this.size = 0;
    }

    @Override
    public void prepend(T value) {
        LinkedNode<T> newFirst = new LinkedNode(value,null,first);
        first.setPrevious(newFirst);
        first = newFirst;
    }

    @Override
    public void append(T value) {
        LinkedNode<T> newLast = new LinkedNode(value,last,null);
        last.setNext(newLast);
        last = newLast;
    }

    @Override
    public void deleteFirst() {
        if(size <=0){
            throw new DoubleLinkedQueueException("The Queue is empty");
        }
        LinkedNode<T> newFirst = new LinkedNode(first.getNext().getItem(),null,first.getNext().getNext());
        first = newFirst;


    }

    @Override
    public void deleteLast() {
        if(size <=0){
            throw new DoubleLinkedQueueException("The Queue is empty");
        }
        LinkedNode<T> newLast = new LinkedNode(last.getPrevious().getItem(),last.getPrevious().getPrevious(),null);
        first = newLast;

    }

    @Override
    public T first() {
        return this.first.getItem();
    }

    @Override
    public T last() {
        return this.last.getItem();

    }

    @Override
    public int size() {
        return this.size;
    }
}
