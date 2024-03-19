package org.example;

class LinkedNode<T> {

    private T item;
    private LinkedNode<T> previous;
    private LinkedNode<T> next;

    DequeNode(T item, LinkedNode<T> previous, LinkedNode<T> next) {
        this.item = item;
        this.previous = previous;
        this.next = next;
    }

    T getItem() { return item; }
    void setItem(T item) { this.item = item;  }

    LinkedNode<T> getPrevious() { return previous; }
    void setPrevious(DequeNode<T> previous) { this.previous = previous; }

    LinkedNode<T> getNext() { return next; }
    void setNext(DequeNode<T> next) {  this.next = next; }
    boolean isFirstNode() {  return previous == null; }
    boolean isLastNode() {  return next == null; }
    boolean isNotATerminalNode() { return !(isFirstNode() || isLastNode());  }
}