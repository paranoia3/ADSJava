public class MainBST {
    public static void main(String[] args) {
        BST<Integer, String> tree = new BST<>();

        tree.put(5, "five");
        tree.put(3, "three");
        tree.put(7, "seven");

        for (var elem : tree.iterator()) {
            System.out.println("key is " + elem.getKey() + " and value is " + elem.getValue());
        }
    }
}