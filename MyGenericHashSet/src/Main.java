public class Main {
    public static void main(String[] args) {
        // Using MyHashSet with Integers
        MyHashSet<Integer> intHashSet = new MyHashSet<>();
        intHashSet.add(1);
        intHashSet.add(2);
        intHashSet.add(1001); // This will go in the same bucket as 1 due to mod 1000
        intHashSet.add(2002); // This will go in the same bucket as 2 due to mod 1000
        intHashSet.printHashSet();

        System.out.println("Contains 1: " + intHashSet.contains(1)); // true
        System.out.println("Contains 3: " + intHashSet.contains(3)); // false

        intHashSet.remove(1);
        System.out.println("Contains 1 after removal: " + intHashSet.contains(1)); // false

        // Using MyHashSet with Strings
        MyHashSet<String> stringHashSet = new MyHashSet<>();
        stringHashSet.add("apple");
        stringHashSet.add("banana");
        stringHashSet.add("cherry");
        stringHashSet.printHashSet();

        System.out.println("Contains 'apple': " + stringHashSet.contains("apple")); // true
        System.out.println("Contains 'grape': " + stringHashSet.contains("grape")); // false

        stringHashSet.remove("banana");
        System.out.println("Contains 'banana' after removal: " + stringHashSet.contains("banana")); // false
    }
}