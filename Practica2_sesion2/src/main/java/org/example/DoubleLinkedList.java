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
        } else {
            LinkedNode<T> newLast = new LinkedNode<>(value,last,null);
            last.setNext(newLast);
            last = newLast;
        }
        size++;
    }

    @Override
    public void deleteFirst() {
        if (size == 0) {
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
        if (size == 0) {
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
        if(size == 0) {
            throw new DoubleLinkedQueueException("The Queue is empty");
        }
        return this.first.getItem();
    }

    @Override
    public T last() {
        if(size == 0) {
            throw new DoubleLinkedQueueException("The Queue is empty");
        }
        return this.last.getItem();
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public T get(int index) {
        if (index >= size()) {
            throw new DoubleLinkedQueueException("The element does not exist");
        }
        LinkedNode<T> auxiliarElem = this.first;
        for (int i = 0; i < index; i++) {
            auxiliarElem = auxiliarElem.getNext();
        }
        return auxiliarElem.getItem();
    }

    @Override
    public boolean contains(T value) {
        boolean found = false;
        int i = 0;

        while (i < this.size && !found) {
            if (get(i).equals(value))
                found = true;
            i++;
        }
        return found;
    }

    @Override
    public void remove(T value) {
        boolean finish = false;
        int i = 0;

        if (size() == 0) {
            throw new DoubleLinkedQueueException("Empty queue");
        } else if (first().equals(value)) {
            deleteFirst();
        } else if (last().equals(value)) {
            deleteLast();
        } else if (size() > 2) {
            LinkedNode<T> currentElem = this.first.getNext();
            while (currentElem.getNext() != null && !finish) {
                System.out.println(currentElem.getItem());
                System.out.println(value);
                if (currentElem.getItem().equals(value)) {
                    LinkedNode<T> next = currentElem.getNext();
                    LinkedNode<T> previous = currentElem.getPrevious();
                    next.setPrevious(previous);
                    previous.setNext(next);
                    this.size--;
                    finish = true;
                }
                currentElem = currentElem.getNext();
                i++;
            }
        }
    }

    @Override
    public void sort(Comparator<? super T> comparator) {
        if (this.size <= 0) {
            throw new DoubleLinkedQueueException("Empty queue");
        } else {
            LinkedNode<T> current = this.first;
            LinkedNode<T> next = current.getNext();
            while (current.getNext() != null) {
                while (next != null) {
                    if (comparator.compare(current.getItem(), next.getItem()) > 0) {
                        current.setNext(next.getNext());
                        next.setPrevious(current.getPrevious());
                        current.setPrevious(next);
                        next.setNext(current);
                    }
                    next = next.getNext();
                }
                current = current.getNext();
                next = current.getNext();
            }
        }


        /*
        LinkedNode<T> current = first.getNext();

        while (current != null) {
            T currentItem = current.getItem();
            LinkedNode<T> previous = current.getPrevious();

            while (previous != null && comparator.compare(previous.getItem(), currentItem) > 0) {
                // Déplace les éléments vers la droite jusqu'à ce que la position correcte soit trouvée

                //deplace current vers la gauche jusqu'à la bonne place

                LinkedNode<T> currentNext = current.getNext();
                LinkedNode<T> previousPrev = previous.getPrevious();
                current.setNext(previous);
                current.setPrevious(previousPrev);
                previous.setNext(currentNext);


                LinkedNode<T> next = previous.getNext();
                current.setItem(previous.getItem());
                current = previous;
                previous = next.getPrevious();
            }
            // Insertion de l'élément courant à sa position correcte
            current.setItem(currentItem);
            // Passer à la prochaine node
            current = current.getNext();
        }

         */
    }
}
