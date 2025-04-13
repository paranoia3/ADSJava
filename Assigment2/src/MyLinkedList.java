import java.util.Iterator;

class Node<T>{
    T data;
    Node<T> next;
    Node<T> prev;
    public Node(T data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}
public class MyLinkedList<T> implements MyList<T> {

    private Node<T> head;
    private Node<T> tail;
    private int size;

    public MyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public void add(T item) {
        Node newNode = new Node(item);
        if (head == null) {
            head = tail = newNode;
        }else{
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    @Override
    public T set(int index, T data) {
        return head.data;
    }

    @Override
    public void add(int index, T data) {
        if(index<0 || index>=size){
            throw new IndexOutOfBoundsException();
        }
        Node<T> newNode = new Node<>(data);

        if(index==0){
            addFirst(data);
        }
        else {
            Node<T> current = head;
            for(int i=0; i<index-1; i++){
                current = current.next;
            }
            newNode.next = current.next;
            newNode.prev = current;
            current.next = newNode;
            if(newNode.next != null){
                newNode.next.prev = newNode;
            }
            size++;
        }
    }

    @Override
    public void addFirst(T data) {
        Node<T> newNode = new Node<>(data);
        if(head == null){
            head = newNode;
            tail = newNode;
        }
        else{
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }

    @Override
    public void addLast(T item) {

    }

    @Override
    public T get(int index) {
        Node<T> current = head;
        for(int i=0; i<index; i++){
            current = current.next;
        }
        return current.data;
    }

    @Override
    public T getFirst() {
        return null;
    }

    @Override
    public T getLast() {
        return null;
    }

    @Override
    public void remove(int index) {
        if(index<0 || index>=size){
            throw new IndexOutOfBoundsException();
        }
        Node<T> current = head;

        if(index==0){
            removeFirst();
        }
        else if(index==size - 1){
            removeLast();
        }
        else{
            for(int i=0; i<index; i++){
                current = current.next;
            }
            Node<T> previous = current.prev;
            Node<T> nextNode = current.next;

            previous.next = nextNode;
            nextNode.prev = previous;

            size--;
        }
    }

    @Override
    public void removeFirst() {

    }

    @Override
    public void removeLast() {
        if(head == tail){
            head = tail = null;
        } else{
            Node<T> current = head;
            while(current.next != tail){
                current = current.next;
            }
            tail = current;
            tail.next = null;
        }
        size--;
    }

    @Override
    public void sort() {

    }

    @Override
    public int indexOf(Object object) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object object) {
        return 0;
    }

    @Override
    public boolean exists(Object object) {
        return false;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public void clear() {

    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }
}
