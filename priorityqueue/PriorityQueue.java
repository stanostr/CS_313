package priorityqueue;

public interface PriorityQueue<K, V> {
    int size();
    boolean isEmpty();
    /**Creates and returns a new Entry, which is inserted in the appropriate place */
    Entry<K, V> insert(K key, V value)  throws IllegalArgumentException;
    /**Returns but does not remove the Entry with the smallest key */
    Entry<K, V> min();
    /**Removes and returns the Entry with the smallest key */
    Entry<K, V> removeMin();
}
