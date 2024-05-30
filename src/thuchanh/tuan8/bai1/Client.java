package thuchanh.tuan8.bai1;

public class Client {
    public static void main(String[] args) {

        // Output:
        // [orange, grape, banana, apple]
        // Size: 4
        // Keys: [orange, grape, banana, apple]
        // Min key: apple
        // Max key: orange
        // Floor of banana: apple
        // Ceiling of orange: null
        // Rank of apple: 0
        // Select key at index 2: grape
        // Size between apple and grape: 3
        // Keys between apple and grape: [grape, banana, apple]
        // -----------------------------------
        // Size: 4
        // apple
        // banana
        // grape
        // orange
        // Is banana in linkedListSymbolTable? true
        // Get value of orange: 3
        OrderedArraySymbolTable<String, Integer> arrSymbolTable = new OrderedArraySymbolTable<>();

        arrSymbolTable.put("apple", 1);
        arrSymbolTable.put("banana", 2);
        arrSymbolTable.put("orange", 3);
        arrSymbolTable.put("grape", 4);
        System.out.println(arrSymbolTable.keys());

        System.out.println("Size: " + arrSymbolTable.size());
        System.out.println("Keys: " + arrSymbolTable.keys());
        System.out.println("Min key: " + arrSymbolTable.min());
        System.out.println("Max key: " + arrSymbolTable.max());
        System.out.println("Floor of banana: " + arrSymbolTable.floor("banana"));
        System.out.println("Ceiling of orange: " + arrSymbolTable.ceiling("orange"));
        System.out.println("Rank of apple: " + arrSymbolTable.rank("apple"));
        System.out.println("Select key at index 2: " + arrSymbolTable.select(2));
        // System.out.println("Delete min key: " + arrSymbolTable.deleteMin());
        // System.out.println("Delete max key: " + arrSymbolTable.deleteMax());
        System.out.println("Size between apple and grape: " +
                arrSymbolTable.size("apple", "grape"));
        System.out.println("Keys between apple and grape: " +
                arrSymbolTable.keys("apple", "grape"));

        System.out.println("-----------------------------------");

        LinkedListSymbolTable<String, Integer> linkedListSymbolTable = new LinkedListSymbolTable<>();

        linkedListSymbolTable.put("apple", 1);
        linkedListSymbolTable.put("banana", 2);
        linkedListSymbolTable.put("orange", 3);
        linkedListSymbolTable.put("grape", 4);

        System.out.println("Size: " + linkedListSymbolTable.size());
        Iterable<String> keys = linkedListSymbolTable.keys();
        for (String key : keys) {
            System.out.println(key);
        }
        System.out.println("Is banana in linkedListSymbolTable? " +
                linkedListSymbolTable.contains("banana"));
        System.out.println("Get value of orange: " +
                linkedListSymbolTable.get("orange"));
    }
}