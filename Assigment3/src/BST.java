import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Stack;

class BST<K extends Comparable<K>, V> implements Iterable<BST.Entry<K, V>> {

    private Node root;
    private int size;

    private class Node {
        private K key;
        private V val;
        private Node left, right;

        public Node(K key, V val) {
            this.key = key;
            this.val = val;
        }
        public K getKey() { return key; }
        public V getValue() { return val; }
    }

    public static class Entry<K, V> {
        private K key;
        private V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
        public K getKey() { return key; }
        public V getValue() { return value; }
        @Override
        public String toString() { return "{" + key + "=" + value + "}"; }
    }

    public BST() {
        this.root = null;
        this.size = 0;
    }

    public void put(K key, V val) {
        if (key == null) throw new IllegalArgumentException("Key cannot be null");
        if (root == null) {
            root = new Node(key, val);
            size = 1;
            return;
        }
        Node current = root;
        Node parent = null;
        boolean isLeftChild = false;
        while (current != null) {
            parent = current;
            int cmp = key.compareTo(current.key);
            if (cmp < 0) {
                current = current.left;
                isLeftChild = true;
            } else if (cmp > 0) {
                current = current.right;
                isLeftChild = false;
            } else {
                current.val = val;
                return;
            }
        }
        Node newNode = new Node(key, val);
        size++;
        if (isLeftChild) parent.left = newNode;
        else parent.right = newNode;
    }

    public V get(K key) {
        if (key == null) throw new IllegalArgumentException("Key cannot be null");
        Node current = root;
        while (current != null) {
            int cmp = key.compareTo(current.key);
            if (cmp < 0) current = current.left;
            else if (cmp > 0) current = current.right;
            else return current.val;
        }
        return null;
    }

    public String delete(K key) {
        if (key == null) throw new IllegalArgumentException("Key cannot be null");
        if (root == null) return null;

        Node parent = null;
        Node current = root;
        boolean isLeftChild = false;

        while (current != null) {
            int cmp = key.compareTo(current.key);
            if (cmp == 0) break;
            parent = current;
            if (cmp < 0) { current = current.left; isLeftChild = true; }
            else { current = current.right; isLeftChild = false; }
        }

        if (current == null) return null;

        size--;

        if (current.left == null && current.right == null) {
            if (current == root) root = null;
            else if (isLeftChild) parent.left = null;
            else parent.right = null;
        }
        else if (current.left == null) {
            if (current == root) root = current.right;
            else if (isLeftChild) parent.left = current.right;
            else parent.right = current.right;
        }
        else if (current.right == null) {
            if (current == root) root = current.left;
            else if (isLeftChild) parent.left = current.left;
            else parent.right = current.left;
        }
        else {
            Node successorParent = current;
            Node successor = current.right;
            while (successor.left != null) {
                successorParent = successor;
                successor = successor.left;
            }
            current.key = successor.key;
            current.val = successor.val;
            if (successorParent == current) current.right = successor.right;
            else successorParent.left = successor.right;
        }
        return null;
    }

    public int size() {
        return size;
    }

    @Override
    public Iterator<Entry<K, V>> iterator() {
        return new BSTIterator();
    }

    private class BSTIterator implements Iterator<Entry<K, V>> {
        private Stack<Node> stack;

        public BSTIterator() {
            stack = new Stack<>();
            pushLeftChildren(root);
        }

        private void pushLeftChildren(Node node) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
        }

        @Override
        public boolean hasNext() {
            return !stack.isEmpty();
        }

        @Override
        public Entry<K, V> next() {
            if (!hasNext()) throw new NoSuchElementException();
            Node node = stack.pop();
            Entry<K, V> entry = new Entry<>(node.key, node.val);
            if (node.right != null) {
                pushLeftChildren(node.right);
            }
            return entry;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}