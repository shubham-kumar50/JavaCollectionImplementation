import java.util.ArrayList;
import java.util.LinkedList;

class MyHashMap {

    // Helper class to store key-value pairs (entries) in the LinkedList
    class Entry {
        Integer key;
        Integer value;

        Entry(Integer key, Integer value) {
            this.key = key;
            this.value = value;
        }

        public Integer getKey() {
            return key;
        }

        public Integer getValue() {
            return value;
        }

        public void setValue(Integer value) {
            this.value = value;
        }
    }

    private static final int INITIAL_CAPACITY = 1000; // Initial capacity for the bucket array
    private ArrayList<LinkedList<Entry>> bucketList;

    public MyHashMap() {
        bucketList = new ArrayList<>(INITIAL_CAPACITY);
        // Initialize each bucket with an empty LinkedList
        for (int i = 0; i < INITIAL_CAPACITY; i++) {
            bucketList.add(new LinkedList<>());
        }
    }

    // Hash function to calculate the bucket index
    private int getBucketIndex(Integer key) {
        return Math.abs(key.hashCode() % INITIAL_CAPACITY);
    }

    // Put (Add or Update) a key-value pair in the HashMap
    public void put(Integer key, Integer value) {
        int bucketIndex = getBucketIndex(key);
        LinkedList<Entry> bucket = bucketList.get(bucketIndex);

        // Check if the key already exists in the bucket
        for (Entry entry : bucket) {
            if (entry.getKey().equals(key)) {
                // If key exists, update the value
                entry.setValue(value);
                return;
            }
        }

        // If key doesn't exist, create a new entry and add to the bucket
        bucket.add(new Entry(key, value));
    }

    // Get the value associated with a key
    public Integer get(Integer key) {
        int bucketIndex = getBucketIndex(key);
        LinkedList<Entry> bucket = bucketList.get(bucketIndex);

        // Search for the key in the bucket
        for (Entry entry : bucket) {
            if (entry.getKey().equals(key)) {
                return entry.getValue(); // Return the value if key is found
            }
        }
        return null; // Return null if key is not found
    }

    // Remove a key-value pair from the HashMap
    public void remove(Integer key) {
        int bucketIndex = getBucketIndex(key);
        LinkedList<Entry> bucket = bucketList.get(bucketIndex);

        // Search for the key in the bucket and remove the entry if found
        for (Entry entry : bucket) {
            if (entry.getKey().equals(key)) {
                bucket.remove(entry);
                return;
            }
        }
    }

    // For debugging: Print the contents of the HashMap
    public void printHashMap() {
        for (int i = 0; i < bucketList.size(); i++) {
            if (!bucketList.get(i).isEmpty()) {
                System.out.print("Bucket " + i + ": ");
                for (Entry entry : bucketList.get(i)) {
                    System.out.print("[" + entry.getKey() + "=" + entry.getValue() + "] ");
                }
                System.out.println();
            }
        }
    }
}