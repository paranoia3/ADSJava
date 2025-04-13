public class MainForArray {
    public static void main(String[] args) {
        MyArrayList<String> list = new MyArrayList<>();
        list.add("Apple");
        list.add("Banana");
        list.add("Cherry");

        System.out.println("List: " + list);

        list.add(1, "Orange");
        System.out.println("List after insertion: " + list);
    }
}