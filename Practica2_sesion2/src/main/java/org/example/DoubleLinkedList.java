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
        if(size==0){
            LinkedNode<T> temp = new LinkedNode<>(value,null,null);
            first = temp;
            last = temp;

        }
        else {
            LinkedNode<T> newFirst = new LinkedNode<>(value,null,first);
            first.setPrevious(newFirst);
            first = newFirst;
        }

        size++;
    }

    @Override
    public void append(T value) {

        if(size==0){
            LinkedNode<T> temp = new LinkedNode<>(value,null,null);
            first = temp;
            last = temp;

        }
        else{
            LinkedNode<T> newLast = new LinkedNode<>(value,last,null);
            last.setNext(newLast);
            last = newLast;
        }
        size++;
    }

    @Override
    public void deleteFirst() {
        if(size <=0)
            throw new DoubleLinkedQueueException("The Queue is empty");
        this.first = new LinkedNode<>(first.getNext().getItem(),null,first.getNext().getNext());
        size--;
    }

    @Override
    public void deleteLast() {
        if(size <=0)
            throw new DoubleLinkedQueueException("The Queue is empty");
        this.last = new LinkedNode<>(last.getPrevious().getItem(),last.getPrevious().getPrevious(),null);
        size--;
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

    @Override
    public T get(int index) {
        if(index >= size()){
            throw new DoubleLinkedQueueException("The element does not exist");

        }
        LinkedNode<T> elementActu = this.first;
        for (int i=0;i<index;i++){
            elementActu = elementActu.getNext();
        }
        return elementActu.getItem();
    }

    @Override
    public boolean contains(T value) {
        LinkedNode<T> aux = this.first;
        boolean found = false;
        int i = 0;

        while (i <= this.size && !found) {
            if (Objects.equals(aux.getItem(), value))
                found = true;
            aux = aux.getNext();
            i++;
        }
        return found;
    }

    @Override
    public void remove(T value) {

        boolean finish = false;
        LinkedNode<T> elementActu = this.first;
        while (!finish && (elementActu != null)){

            if(elementActu.getItem() == value){
                //delete + stop loop

                if(elementActu.isFirstNode()){
                    LinkedNode<T> next = elementActu.getNext();
                    next.setPrevious(null);
                    this.first = next;
                }
                else if (elementActu.isLastNode()) {

                    LinkedNode<T> previous = elementActu.getPrevious();
                    previous.setNext(null);
                    this.last = previous;

                }
                else{
                    LinkedNode<T> next = elementActu.getNext();
                    LinkedNode<T> previous = elementActu.getPrevious();
                    next.setPrevious(previous);
                    previous.setNext(next);

                }

                this.size = this.size -1;
                finish = true;
            }

            elementActu = elementActu.getNext();

        }

    }

    //NOT FINISH
    @Override
    public void sort(Comparator<? super T> comparator) {
        if (size <= 1) {
            return;
        }

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
    }
}
