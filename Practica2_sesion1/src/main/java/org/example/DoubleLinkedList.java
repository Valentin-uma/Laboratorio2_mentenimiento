package org.example;

import java.util.Comparator;
import java.util.Objects;

public class DoubleLinkedList<T> implements DoubleLinkedQueue<T> {

    private LinkedNode<T> first;
    private LinkedNode<T> last;
    private int size;

    public DoubleLinkedList() {
        this.first = null;
        this.last = null;
        this.size = 0;
    }

    @Override
    public void prepend(T value) {
        if (size == 0) {
            LinkedNode<T> temp = new LinkedNode<>(value,null,null);
            first = temp;
            last = temp;
        } else {
            LinkedNode<T> newFirst = new LinkedNode<>(value,null,first);
            first.setPrevious(newFirst);
            first = newFirst;
        }
        size++;
    }

    @Override
    public void append(T value) {

        if (size == 0) {
            LinkedNode<T> temp = new LinkedNode<>(value,null,null);
            first = temp;
            last = temp;
        } else{
            LinkedNode<T> newLast = new LinkedNode<>(value,last,null);
            last.setNext(newLast);
            last = newLast;
        }
        size++;
    }

    @Override
    public void deleteFirst() {
        if (size <= 0) {
            throw new DoubleLinkedQueueException("The Queue is empty");
        } else if (size == 1) {
            this.first = null;
            this.last = null;
        } else {
            this.first = new LinkedNode<>(first.getNext().getItem(),null,first.getNext().getNext());
        }
        size--;
    }

    @Override
    public void deleteLast() {
        if (size <= 0) {
            throw new DoubleLinkedQueueException("The Queue is empty");
        } else if (size == 1) {
            this.first = null;
            this.last = null;
        } else {
            this.last = new LinkedNode<>(last.getPrevious().getItem(),last.getPrevious().getPrevious(),null);
        }
        size--;
    }

    @Override
    public T first() {
        if(size <=0) {
            throw new DoubleLinkedQueueException("The Queue is empty");
        }
        return this.first.getItem();
    }

    @Override
    public T last() {
        if(size <=0) {
            throw new DoubleLinkedQueueException("The Queue is empty");
        }
        return this.last.getItem();
    }

    @Override
    public int size() {
        return this.size;
    }
}
