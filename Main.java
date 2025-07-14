public class Main {
    public static void main(String[] args) {
        HashTable<String> table = new HashTable<>(4);

        table.add("apple");
        table.add("banana");
        table.add("carrot");
        table.add("chicago");
        table.add("CHICAGO");

        System.out.println(table);
    }
}