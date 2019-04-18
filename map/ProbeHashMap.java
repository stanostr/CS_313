package map;

import iterator.ArrayList;

public class ProbeHashMap<K, V> extends AbstractHashMap<K, V>  {
    private final MapEntry<K, V> DEFUNCT = new MapEntry<>(null, null);
    private MapEntry<K, V>[] table;
    public ProbeHashMap() { super(); }
    public ProbeHashMap(int cap) { super(cap); }
    public ProbeHashMap(int cap, int prime) { super(cap, prime); }

    protected void createTable()
    {
        table = (MapEntry<K, V>[]) new MapEntry[capacity];
    }

    @Override
    protected V bucketRemove(int h, K key) {
        int j = search(h, key);
        if(j<0) return null;
        V result = table[j].getValue();
        table[j] = DEFUNCT; //set defunct to let us know this entry is removed
        n--; //decrement size
        return result;
    }

    @Override
    protected V bucketGet(int h, K key) {
        int j = search(h, key);
        if(j<0) return null; //not found
        return table[j].getValue();
    }

    @Override
    protected V bucketPut(int h, K key, V value) {
        int j = search(h, key);
        if(j >= 0) //key already exists
            return table[j].setValue(value);
        int index = findSlot(h);
        table[index] = new MapEntry<>(key, value);
        n++; //increment size
        return null;
    }

    /**Returns true if location is available for placing new entry */
    private boolean isAvailable(int j)
    {
        return (table[j]==null || table[j] == DEFUNCT);
    }

    /** Finds a slot for key with hash-value h*/
    private int findSlot(int h)
    {
        int j = h; //no slot found yet
        do {
            if(isAvailable(j)) return j;
            j = (j+1) % capacity;
        } while(j!=h); //return to start
        return -1; //slot not found; should not happen.
    }

    /**Returns the index of entry with given key and its hash value or -1 if it is not found */
    private int search(int h, K key)
    {
        int j = h;
        do {
            if(isAvailable(j)) return -1; //search failed
            if(table[j].getKey().equals(key)) return j; //found at index
            j = (j+1) % capacity;
        } while(j!=h); //return to start
        return -2; //should not reach this unless we have bug
    }

    public Iterable<Entry<K, V>> entrySet()
    {
        ArrayList<Entry<K, V>> buffer = new ArrayList<>(size());
        for(int h=0; h<capacity; h++)
        {
            if(!isAvailable(h)) buffer.add(table[h]);
        }
        return buffer;
    }
}
