import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyArrayList<T> implements MyList<T>{
    private T[] elements;
    private int size;
    private static final int DEFAULT_CAPACITY = 10;

    public MyArrayList() {
        this.elements = (T[]) new Object[DEFAULT_CAPACITY];
        this.size = 0;
    }

    public MyArrayList(int initialCapacity) {
        this.elements = (T[]) new Object[initialCapacity];
        this.size = 0;
    }
    
    @Override
    public void add(T item) {
        ensureCapacity(size + 1);
        elements[size++] = item;
    }

    private void ensureCapacity(int i) {
        if(size == elements.length){
            elements = Arrays.copyOf(elements, size + DEFAULT_CAPACITY);
        }
    }

    @Override
    public T set(int index, T item) {
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        T oldelement = (T) elements[index];
        elements[index] = item;
        return oldelement;
    }

    @Override
    public void add(int index, T item) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        ensureCapacity(size + 1);
        System.arraycopy(elements, index, elements, index + 1, size - index);
        elements[index] = item;
        size++;
    }

    @Override
    public void addFirst(T item) {
        add(0, item);
    }

    @Override
    public void addLast(T item) {
        add(item);
    }

    @Override
    public T get(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        return (T) elements[index];
    }

    @Override
    public T getFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException("List is empty");
        }
        return elements[0];
    }

    private boolean isEmpty() {
        return size == 0;
    }

    @Override
    public T getLast() {
        if (isEmpty()) {
            throw new NoSuchElementException("List is empty");
        }
        return elements[size - 1];
    }

    @Override
    public T remove(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        T removeElement = (T) elements[index];
        int numMoved = size - index - 1;
        if (numMoved > 0) {
            System.arraycopy(elements, index + 1, elements, index, numMoved);
        }
        elements[--size] = null;
        return removeElement;
    }

    @Override
    public void removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException("List is empty");
        }
        remove(0);
    }

    @Override
    public void removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException("List is empty");
        }
        remove(size - 1);
    }

    @Override
    public void sort() {
        if (size > 0) {
            Arrays.sort(elements, 0, size, null);
        }
    }

    @Override
    public int indexOf(Object object) {
        for(int index = 0; index < size; index++){
            if(object.equals(elements[index])){
                return index;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object object) {
        if (object == null) {
            for (int i = size - 1; i >= 0; i--) {
                if (elements[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = size - 1; i >= 0; i--) {
                if (object.equals(elements[i])) {
                    return i;
                }
            }
        }
        return -1;
    }

    @Override
    public boolean exists(Object object) {
        return indexOf(object) >= 0;
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(elements, size);
    }

    @Override
    public void clear() {
        Arrays.fill(elements, 0, size, null);
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        return new ArrayListIterator();
    }
    private class ArrayListIterator implements Iterator<T> {
        private int currentIndex = 0;

        @Override
        public boolean hasNext() {
            return currentIndex < size;
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return elements[currentIndex++];
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("Remove is not supported");
        }
    }
    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }
}
