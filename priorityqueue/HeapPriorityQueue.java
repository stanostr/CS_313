package priorityqueue;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

//this is taken directly from the book Code Fragment 9.5. Only comments have been changed.
public class HeapPriorityQueue<K, V> extends AbstractPriorityQueue<K, V> {
    protected List<Entry<K, V>> heap = new ArrayList<>();

    public HeapPriorityQueue() { super(); }
    public HeapPriorityQueue(Comparator<K> comparator)
    {
        super(comparator);
    }
    //these methods return the position of the desired element within the ArrayList
    protected int parent(int j) { return (j-1)/2; } //truncated integer division
    protected int left(int j) { return (2*j)+1; }
    protected int right(int j) { return (2*j)+2; }

    protected boolean hasLeft(int j)
    {
        return left(j)<heap.size();
    }

    protected boolean hasRight(int j)
    {
        return right(j)<heap.size();
    }

    /** Exchanges the elements with the given provided indices */
    protected void swap(int i, int j)
    {
        Entry<K, V> temp = heap.get(j);
        heap.set(j, heap.get(i));
        heap.set(i, temp);
    }


    protected void upheap(int j)
    {
        while(j>0) //loops till we reach root or break out of loop
        {
            int p = parent(j);
            if(compare(heap.get(j), heap.get(p))>=0) break; // we are done
            swap(j, p);
            j=p;
        }
    }

    /** Moves the entry at index j lower, if necessary, to restore the heap property. */
    protected void downheap(int j)
    {
        while(hasLeft(j))
        {
            //start of find smallest child
            int leftIndex = left(j);
            int smallChildIndex = leftIndex;
            if(hasRight(j)) {
                int rightIndex = right(j);
                if(compare(heap.get(smallChildIndex), heap.get(j)) >= 0)
                    smallChildIndex = rightIndex;
            }
            //end of find smallest child

            //compares smallest child to the current entry
            if(compare(heap.get(smallChildIndex), heap.get(j)) >= 0)
                break; //we are done because heap-order satisfied
            swap(j, smallChildIndex);
            j = smallChildIndex;
        }
    }

    @Override
    public int size() {
        return heap.size();
    }

    @Override
    public Entry<K, V> insert(K key, V value) throws IllegalArgumentException {
        checkKey(key);
        Entry<K, V> newest = new PQEntry<>(key, value);
        heap.add(newest);
        upheap(heap.size()-1);
        return newest;
    }

    @Override
    public Entry<K, V> min() {
        if(heap.isEmpty()) return null;
        else return heap.get(0); //root/first element always min
    }

    /** Returns and removes an entry with minimal key (if any) */
    @Override
    public Entry<K, V> removeMin() {
        if(heap.isEmpty()) return null;
        Entry<K, V> answer = heap.get(0); //value of root
        swap(0, heap.size()-1); //put minimal item at the end of list, move end of list to root
        heap.remove(heap.size()-1); //remove it from the list
        downheap(0); //fix the new root
        return answer;
    }
}
