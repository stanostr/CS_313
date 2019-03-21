package priorityqueue;
//note that we use the version of DoublyLinkedList that has an iterator
import iterator.DoublyLinkedList;

import java.util.Comparator;
import java.util.Iterator;

//TODO Incomplete! Please come back later!
public class SortedPriorityQueue<K, V> extends AbstractPriorityQueue<K, V> {
    //This doubly linked list will hold our entries
    private DoublyLinkedList<Entry<K, V>> list = new DoublyLinkedList<>();

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
        //TODO
        return null;
    }

    //fetching min is much easier now because we are sorted, minimal is always first.
    @Override
    public Entry<K, V> min() {
        if(list.isEmpty()) return null;
        return list.first();
    }

    //removing is much easier because we are sorted, minimal is always first.
    @Override
    public Entry<K, V> removeMin() {
        if(list.isEmpty()) return null;
        return list.removeFirst();
    }
}