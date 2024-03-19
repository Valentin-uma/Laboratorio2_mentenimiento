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
        // TODO
    }

    @Override
    public void append(T value) {
        // TODO
    }

    @Override
    public void deleteFirst() {
        // TODO
    }

    @Override
    public void deleteLast() {
        // TODO
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
