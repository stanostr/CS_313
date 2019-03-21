package priorityqueue;
//note that we use the version of DoublyLinkedList that has an iterator
import iterator.DoublyLinkedList;

import java.util.Comparator;
import java.util.Iterator;

public class UnsortedPriorityQueue<K, V> extends AbstractPriorityQueue<K, V> {
    //This doubly linked list will hold our entries
    private DoublyLinkedList<Entry<K, V>> list = new DoublyLinkedList<>();

    //default constructor, creates empty list and initializes Comparator to a DefaultComparator
    public UnsortedPriorityQueue() { super(); }
    //creates an empty priority queue but uses the given comparator instead of default
    public UnsortedPriorityQueue(Comparator<K> comp)
    {
        super(comp);
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public Entry<K, V> insert(K key, V value) throws IllegalArgumentException {
        checkKey(key); //if invalid throws IllegalArgumentException
        Entry<K, V> newest = new PQEntry<>(key, value);
        list.addLast(newest);
        return newest;
    }

    //to find min, we have to iterate over the DoublyLinkedList.
    //This takes O(n), where n = size of list.
    @Override
    public Entry<K, V> min() {
        Entry<K, V> min = list.first();
        for(Entry<K, V> entry: list)
        {
            if(compare(entry, min) < 0 ) min = entry;
        }
        return min;
    }

    //This is the only way to do this, since our DoublyLinkedList's remove method is private,
    //we have to use the iterator, twice! Obviously, this runs in 2n = O(n), where n = size of list.
    //This is very inefficient and only here for demonstration/pedagogical purposes
    @Override
    public Entry<K, V> removeMin() {
        Entry<K, V> min = min(); //O(n)
        Iterator<Entry<K, V>> iterator = list.iterator();
        while(iterator.hasNext()){ //O(n)
            Entry<K, V> e =iterator.next();
            if(e.equals(min)) {
                iterator.remove();
                return e;
            }
        }
        //should not happen unless list is empty or
        //we encounter multithreading issue (discussed in our study of iterators).
        return null;
    }
}
