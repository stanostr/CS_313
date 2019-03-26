package priorityqueue;
import iterator.ArrayList;
import iterator.List;

import java.util.Comparator;

/**
 * A sorted priority queue implementation:
 * insert runs in O(n)
 * min and remove min run in O(1).
 */
public class SortedPriorityQueue<K, V> extends AbstractPriorityQueue<K, V> {
    //The only way I found to achieve the same runtime as the books methods
    //without changing any data structures is to use an ArrayList to hold
    //the data in descending order (min last).
    private List<Entry<K, V>> list = new ArrayList<>();

    //default constructor, creates empty list and initializes Comparator to a DefaultComparator
    public SortedPriorityQueue() { super(); }
    //creates an empty priority queue but uses the given comparator instead of default
    public SortedPriorityQueue(Comparator<K> comp)
    {
        super(comp);
    }

    @Override
    public int size() {
        return list.size();
    }

    //Inserting is now more difficult because we have to insert in the right place.
    @Override
    public Entry<K, V> insert(K key, V value) throws IllegalArgumentException {
        checkKey(key);
        Entry<K, V> newest = new PQEntry<>(key, value);
        if(list.size()==0)
            list.add(newest);
        else {
            //tries to find appropriate insertion location in the ArrayList
            for (int i = 0; i < list.size(); i++) {
                if (compare(list.get(i), newest) <= 0) {
                    list.add(i, newest);
                    return newest;
                }
            }
            //if we reached here, means new element is min
            list.add(list.size(), newest);
        }
        return newest;
    }

    //fetching min is much easier now because we are sorted, minimal is always at the end of list.
    @Override
    public Entry<K, V> min() {
        if(list.isEmpty()) return null;
        return list.get(list.size()-1); //O(1)
    }

    //removing is much easier because we are sorted, minimal is always first.
    @Override
    public Entry<K, V> removeMin() {
        if(list.isEmpty()) return null;
        return list.remove(list.size()-1); //O(1) as we don't have to shift anything
    }
}