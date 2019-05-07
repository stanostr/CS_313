package project3_files;

import java.util.Comparator;

public class Solution<K, V> extends AbstractPriorityQueue<K, V> {
    private LinkedBinaryTree<Entry<K, V>> heap = new LinkedBinaryTree<>();

    public Solution()
    {
        super();
    }

    public Solution(Comparator<K> comp)
    {
        super(comp);
    }


    @Override
    public int size() {
        return heap.size();
    }

    @Override
    public Entry<K, V> insert(K key, V value) throws IllegalArgumentException {
        checkKey(key);
        Entry<K, V> newest = new PQEntry<>(key, value);
        if(heap.isEmpty()) {
            heap.addRoot(newest);
            return newest;
        }
        Position<Entry<K, V>> newLast = addNewLast(newest);
        upheap(newLast);
        return newest;
    }

    @Override
    public Entry<K, V> min() {
        if(heap.isEmpty()) return null;
        else return heap.root().getElement();
    }

    @Override
    public Entry<K, V> removeMin() {
        if(heap.isEmpty()) return null;
        Entry<K, V> answer = heap.root().getElement();
        Position lastPosition = lastPosition();
        if(lastPosition!=null) {
            swap(heap.root(), lastPosition);
            heap.remove(lastPosition);
            downheap(heap.root());
        }
        return answer;
    }

    private void swap(Position<Entry<K, V>> a, Position<Entry<K, V>> b)
    {
        Entry<K, V> temp = a.getElement();
        heap.set(a, b.getElement());
        heap.set(b, temp);
    }

    private void upheap(Position<Entry<K, V>> position)
    {
        while(!heap.isRoot(position))
        {
            Position<Entry<K, V>> parent = heap.parent(position);
            if(compare(position.getElement(), parent.getElement())>=0) break;
            swap(parent, position);
            position = parent;
        }
    }

    private void downheap(Position<Entry<K, V>> position)
    {
        while(heap.left(position)!=null)
        {
            Position<Entry<K, V>> leftChild = heap.left(position);
            Position<Entry<K, V>> smallerEntry = leftChild;
            if(heap.right(position)!=null)
            {
                Position<Entry<K, V>> rightChild = heap.right(position);
                if(compare(leftChild.getElement(), rightChild.getElement())>=0)
                    smallerEntry = rightChild;
            }
            if(compare(smallerEntry.getElement(), position.getElement())>=0)
                break;
            swap(position, smallerEntry);
            position = smallerEntry;
        }
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
