public class Main {
    public static void main(String[] args) {
        MyHashMap hashMap = new MyHashMap();

        // Put key-value pairs in the HashMap
        hashMap.put(1, 100);
        hashMap.put(2, 200);
        hashMap.put(1001, 300); // This will go in the same bucket as key 1
        hashMap.put(2002, 400); // This will go in the same bucket as key 2

        // Print the contents of the HashMap
        hashMap.printHashMap();

        // Get values for keys
        System.out.println("Get key 1: " + hashMap.get(1)); // Output: 100
        System.out.println("Get key 3: " + hashMap.get(3)); // Output: null (not present)

        // Update a value
        hashMap.put(1, 500);
        System.out.println("Updated key 1: " + hashMap.get(1)); // Output: 500

        // Remove a key
        hashMap.remove(1);
        System.out.println("Get key 1 after removal: " + hashMap.get(1)); // Output: null

        // Print the contents again after removal
        hashMap.printHashMap();
    }
}