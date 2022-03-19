package fr.istic.vv;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;

class BinaryHeap<T> {

    private Comparator<T> comparator;
    private List<T> elements;
    private int heapSize;

    public BinaryHeap(Comparator<T> comparator) {
        this.comparator = comparator;
        this.heapSize = 0;
        this.elements = new ArrayList<>();
    }

    public T pop() {
        if(heapSize == 0) throw new NoSuchElementException("Heap is empty");
        return null;
    }

    public T peek() { return null; }

    public void push(T element) {
        elements.add(element);
        percUp(++heapSize);
    }

    public void percUp(int size) {
        while(size / 2 > 0) {
            int comp = comparator.compare(elements.get(size), elements.get(size / 2));
            if(comp < 0) {
                T tmp = elements.get(size / 2);
                elements.set(size / 2, elements.get(size));
                elements.set(size, tmp);
            }
        }
    }

    public int count() { return heapSize; }

}