public class Main {

    public static void main(String[] args) {

        MyHashTable<Integer, String> hashTable = new MyHashTable<>(5); // Small capacity for visibility

        hashTable.put(1, "One");
        hashTable.put(6, "Six");
        hashTable.put(3, "Three");
        hashTable.put(11, "Eleven");
        hashTable.put(4, "Four");
        hashTable.put(1, "One v2");

        System.out.println("Hash table after additions:");
        System.out.println("  Size: " + hashTable.getSize());
        System.out.println("  Get key 6: " + hashTable.get(6));
        System.out.println("  Get key 1: " + hashTable.get(1));
        System.out.println("  Get key 99 (non-existent): " + hashTable.get(99));

        String removedValue = hashTable.remove(6);
        System.out.println("\nRemoved key 6 (value: " + removedValue + ")");
        System.out.println("  Size after removal: " + hashTable.getSize());
        System.out.println("  Get key 6 after removal: " + hashTable.get(6));
        System.out.println("  Get key 11 (remains in the same bucket): " + hashTable.get(11));

        BST<Integer, String> bst = new BST<>();

        bst.put(5, "Five");
        bst.put(2, "Two");
        bst.put(8, "Eight");
        bst.put(1, "One");
        bst.put(4, "Four");
        bst.put(7, "Seven");
        bst.put(9, "Nine");
        bst.put(2, "Two v2");

        System.out.println("BST after additions:");
        System.out.println("  Size: " + bst.size());
        System.out.println("  Get key 4: " + bst.get(4));
        System.out.println("  Get key 2: " + bst.get(2));

        System.out.println("\nIn-order traversal:");
        System.out.print("  [ ");
        for (BST.Entry<Integer, String> entry : bst) {
            System.out.print(entry.getKey() + ":" + entry.getValue() + " ");
        }
        System.out.println("]");

        String removedBSTValue = bst.delete(5);
        System.out.println("\nRemoved root (key 5, value: " + removedBSTValue + ")");
        System.out.println("  Size after removal: " + bst.size());

        System.out.println("\nTraversal after removal:");
        System.out.print("  [ ");
        for (BST.Entry<Integer, String> entry : bst) {
            System.out.print(entry.getKey() + ":" + entry.getValue() + " ");
        }
        System.out.println("]");
    }
}