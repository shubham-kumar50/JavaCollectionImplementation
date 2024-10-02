import java.util.ArrayList;
import java.util.LinkedList;

class MyHashSet<T> {
    private static final int INITIAL_CAPACITY = 1000; // Initial capacity for the bucket array
    private ArrayList<LinkedList<T>> bucketList;

    public MyHashSet() {
        bucketList = new ArrayList<>(INITIAL_CAPACITY);
        // Initialize each bucket with an empty LinkedList
        for (int i = 0; i < INITIAL_CAPACITY; i++) {
            bucketList.add(new LinkedList<>());
        }
    }

    // Hash function to calculate the bucket index
    private int getBucketIndex(T key) {
        return Math.abs(key.hashCode() % INITIAL_CAPACITY);
    }

    // Add an element to the HashSet
    public void add(T key) {
        int bucketIndex = getBucketIndex(key);
        LinkedList<T> bucket = bucketList.get(bucketIndex);
        // Add element only if it does not already exist
        if (!bucket.contains(key)) {
            bucket.add(key);
        }
    }

    // Check if the HashSet contains the element
    public boolean contains(T key) {
        int bucketIndex = getBucketIndex(key);
        LinkedList<T> bucket = bucketList.get(bucketIndex);
        return bucket.contains(key);
    }

    // Remove an element from the HashSet
    public void remove(T key) {
        int bucketIndex = getBucketIndex(key);
        LinkedList<T> bucket = bucketList.get(bucketIndex);
        bucket.remove(key);
    }

    // For debugging: Print the contents of the HashSet
    public void printHashSet() {
        for (int i = 0; i < bucketList.size(); i++) {
            if (!bucketList.get(i).isEmpty()) {
                System.out.println("Bucket " + i + ": " + bucketList.get(i));
            }
        }
    }
}