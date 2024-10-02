public class Main {
    public static void main(String[] args) {
        // Using MyHashSet with Integers
        MyHashSet intHashSet = new MyHashSet();
        intHashSet.add(1);
        intHashSet.add(2);
        intHashSet.add(1001); // This will go in the same bucket as 1 due to mod 1000
        intHashSet.add(1003);
        intHashSet.printHashSet();

        System.out.println("Contains 1: " + intHashSet.contains(1)); // true
        System.out.println("Contains 3: " + intHashSet.contains(3)); // false

        intHashSet.remove(1);
        intHashSet.printHashSet();
        System.out.println("Contains 1 after removal: " + intHashSet.contains(1)); // false
    }}