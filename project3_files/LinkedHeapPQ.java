package project3_files;

import java.util.Comparator;

public class LinkedHeapPQ<K, V> extends AbstractPriorityQueue<K, V> {
    private LinkedBinaryTree<Entry<K, V>> heap = new LinkedBinaryTree<>();

    public LinkedHeapPQ()
    {
        super();
    }

    public LinkedHeapPQ(Comparator<K> comp)
    {
        super(comp);
    }


    @Override
    public int size() {
        return heap.size();
    }

    @Override
    public Entry<K, V> insert(K key, V value) throws IllegalArgumentException {
        //TODO for students
        return null;
    }

    @Override
    public Entry<K, V> min() {
        //TODO for students
        return null;
    }

    @Override
    public Entry<K, V> removeMin() {
        //TODO for students
        return null;
    }

    /** Finds the "last node" in the heap in O(log n) time. */
    private Position<Entry<K, V>> lastPosition()
    {
        if(heap.size()==0) return null;
        Position<Entry<K, V>> current = heap.root();
        String path = Integer.toBinaryString(heap.size());
        if(path.length()>1) {
            path = path.substring(1); //get rid of the first character
            //follow the path
            for(int i=0; i<path.length(); i++)
            {
                if(path.charAt(i)=='0') current = heap.left(current); //go left for 0
                else current = heap.right(current); //go right for 1
            }
        }
        return current;
    }

    /** Adds a new entry to the last position in the heap and returns it. Runs in O(log n) time */
    private Position<Entry<K, V>> addNewLast(Entry<K, V> entry)
    {
        if(heap.isEmpty()) {
            return heap.addRoot(entry);
        }
        String path = Integer.toBinaryString(heap.size()+1);
        //follow the path to expecting parent
        Position<Entry<K, V>> parent = heap.root();
        if(path.length()>1) {
            //cut off first and last character, and it will be the path to the parent of new last
            path = path.substring(1, Math.max(path.length() - 1, 0));
            for (int i = 0; i < path.length(); i++) {
                if (path.charAt(i) == '0') parent = heap.left(parent); //go left for 0
                else parent = heap.right(parent); //go right for 1
            }
        }
        //if heap size was odd, we have to add as left child, else as right
        if(heap.size()%2==1) {
            return heap.addLeft(parent, entry);
        }
        else {
            return heap.addRight(parent, entry);
        }
    }
}
