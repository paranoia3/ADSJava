import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BST<K extends Comparable<K>, V> {
    private Node root;
    private int size = 0;

    private class Node {
        private K key;
        private V val;
        private Node left, right;

        public Node(K key, V val) {
            this.key = key;
            this.val = val;
        }
    }

    public void put(K key, V val) {
        Node newNode = new Node(key, val);
        if (root == null) {
            root = newNode;
            size++;
            return;
        }

        Node current = root;
        while (true) {
            if (key.compareTo(current.key) < 0) {
                if (current.left == null) {
                    current.left = newNode;
                    size++;
                    return;
                }
                current = current.left;
            } else if (key.compareTo(current.key) > 0) {
                if (current.right == null) {
                    current.right = newNode;
                    size++;
                    return;
                }
                current = current.right;
            } else {
                current.val = val;
                return;
            }
        }
    }

    public V get(K key) {
        Node current = root;
        while (current != null) {
            if (key.compareTo(current.key) < 0) {
                current = current.left;
            } else if (key.compareTo(current.key) > 0) {
                current = current.right;
            } else {
                return current.val;
            }
        }
        return null;
    }

    public void delete(K key) {
        root = deleteRec(root, key);
    }

    private Node deleteRec(Node node, K key) {
        if (node == null) return null;

        if (key.compareTo(node.key) < 0) {
            node.left = deleteRec(node.left, key);
        } else if (key.compareTo(node.key) > 0) {
            node.right = deleteRec(node.right, key);
        } else {
            size--;
            if (node.left == null) return node.right;
            if (node.right == null) return node.left;

            Node minNode = getMin(node.right);
            node.key = minNode.key;
            node.val = minNode.val;
            node.right = deleteRec(node.right, minNode.key);
        }
        return node;
    }

    private Node getMin(Node node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    public int size() {
        return size;
    }

    // Class to store both key and value for iteration
    public class Entry {
        private K key;
        private V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
    }

    public Iterable<Entry> iterator() {
        Queue<Entry> queue = new LinkedList<>();
        inOrderTraversal(queue);
        return queue;
    }

    private void inOrderTraversal(Queue<Entry> queue) {
        Stack<Node> stack = new Stack<>();
        Node current = root;

        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            current = stack.pop();
            queue.add(new Entry(current.key, current.val));
            current = current.right;
        }
    }
}