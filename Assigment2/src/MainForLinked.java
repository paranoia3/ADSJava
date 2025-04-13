public class MainForLinked {
    public static void main(String[] args) {
        MyLinkedList<String> list = new MyLinkedList<>();
        list.add("Apple");
        list.add("Banana");
        list.add("Cherry");

        System.out.println("Size: " + list.size());
        System.out.println("Get element at index 1: " + list.get(1));
        System.out.println("List: " + list);

        list.add(1, "Orange");
        System.out.println("List after insertion: " + list);

        list.remove(2);
        System.out.println("List after removal: " + list);

        for (String item : list) {
            System.out.println(item);
        }
    }
}