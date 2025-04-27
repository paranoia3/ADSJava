import java.util.Objects;

class MyHashTable<K, V> {

    private static class HashNode<K, V> {
        private K key;
        private V value;
        private HashNode<K, V> next;

        public HashNode(K key, V value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }

        @Override
        public String toString() {
            return "{" + key + "=" + value + "}";
        }
    }

    private HashNode<K, V>[] chainArray;
    private int M = 11;
    private int size;

    public MyHashTable() {
        this.chainArray = (HashNode<K, V>[]) new HashNode[M];
        this.size = 0;
    }

    public MyHashTable(int M) {
        if (M <= 0) {
            throw new IllegalArgumentException("Initial capacity must be positive");
        }
        this.M = M;
        this.chainArray = (HashNode<K, V>[]) new HashNode[this.M];
        this.size = 0;
    }

    private int hash(K key) {
        if (key == null) {
            throw new IllegalArgumentException("Key cannot be null for hashing");
        }
        int hashCode = key.hashCode();
        int index = (hashCode & 0x7fffffff) % M;
        return index;
    }

    public void put(K key, V value) {
        if (key == null) {
            throw new IllegalArgumentException("Key cannot be null");
        }
        int index = hash(key);
        HashNode<K, V> head = chainArray[index];
        HashNode<K, V> currentNode = head;
        while (currentNode != null) {
            if (currentNode.key.equals(key)) {
                currentNode.value = value;
                return;
            }
            currentNode = currentNode.next;
        }

        size++;
        HashNode<K, V> newNode = new HashNode<>(key, value);
        newNode.next = head;
        chainArray[index] = newNode;
    }

    public V get(K key) {
        if (key == null) {
            throw new IllegalArgumentException("Key cannot be null");
        }
        int index = hash(key);
        HashNode<K, V> currentNode = chainArray[index];
        while (currentNode != null) {
            if (currentNode.key.equals(key)) {
                return currentNode.value;
            }
            currentNode = currentNode.next;
        }
        return null;
    }

    public V remove(K key) {
        if (key == null) {
            throw new IllegalArgumentException("Key cannot be null");
        }
        int index = hash(key);
        HashNode<K, V> head = chainArray[index];
        HashNode<K, V> currentNode = head;
        HashNode<K, V> prevNode = null;

        while (currentNode != null) {
            if (currentNode.key.equals(key)) {
                if (prevNode == null) {
                    chainArray[index] = currentNode.next;
                } else {
                    prevNode.next = currentNode.next;
                }
                size--;
                return currentNode.value;
            }
            prevNode = currentNode;
            currentNode = currentNode.next;
        }
        return null;
    }

    public boolean contains(V value) {
        for (int i = 0; i < M; i++) {
            HashNode<K, V> currentNode = chainArray[i];
            while (currentNode != null) {
                if (value == null) {
                    if (currentNode.value == null) {
                        return true;
                    }
                } else if (value.equals(currentNode.value)) {
                    return true;
                }
                currentNode = currentNode.next;
            }
        }
        return false;
    }

    public K getKey(V value) {
        for (int i = 0; i < M; i++) {
            HashNode<K, V> currentNode = chainArray[i];
            while (currentNode != null) {
                if (value == null) {
                    if (currentNode.value == null) {
                        return currentNode.key;
                    }
                } else if (value.equals(currentNode.value)) {
                    return currentNode.key;
                }
                currentNode = currentNode.next;
            }
        }
        return null;
    }

    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return M;
    }

    public HashNode<K, V>[] getChains() {
        return chainArray;
    }
}