package map;

import java.util.ArrayList;
import java.util.List;

//TODO incomplete!
public class ChainHashMap<K, V> extends AbstractHashMap<K, V> {
    //A fixed capacity ARRAY of unsorted maps as our underlying data structure
    private UnsortedTableMap<K, V>[] table;
    //constructors
    public ChainHashMap() { super(); }
    public ChainHashMap(int cap)
    {
        super(cap);
    }
    public ChainHashMap(int cap, int prime)
    {
        super(cap, prime);
    }

    /**
     * Called within superclass constructors and resize method
     */
    @Override
    protected void createTable() {
        table = (UnsortedTableMap<K, V>[]) new UnsortedTableMap[capacity];
    }

    /** Returns value associated with key k in bucket with hash value h, null if not find */
    @Override
    protected V bucketGet(int h, K key) {
        UnsortedTableMap<K, V> bucket = table[h];
        if(bucket == null) return null;
        return bucket.get(key);
    }

    @Override
    protected V bucketPut(int h, K key, V value) {
        UnsortedTableMap<K, V> bucket = table[h];
        if(bucket==null) {
            table[h] = new UnsortedTableMap<>();
            bucket = table[h];
        }
        int oldSize = bucket.size();
        V result = bucket.put(key, value);
        n += (bucket.size() - oldSize); //size may or may not have increased!
        return result;
    }

    @Override
    protected V bucketRemove(int h, K key) {
        UnsortedTableMap<K, V> bucket = table[h];
        if(bucket==null) return null;
        int oldSize = bucket.size();
        V result = bucket.remove(key);
        n -= (oldSize - bucket.size()); //size may have decreased!
        return result;
    }


    /** Returns and iterable collection (ArrayList) of all the entries of the map. */
    @Override
    public Iterable<Entry<K, V>> entrySet() {
        List<Entry<K, V>> buffer = new ArrayList<>(size());
        for(int h=0; h<capacity; h++)
        {
            if(table[h] != null)
                for(Entry<K, V> entry: table[h].entrySet())
                    buffer.add(entry);
        }
        return buffer;
    }
}
