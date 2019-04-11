package map;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class UnsortedTableMap<K, V> extends AbstractMap<K, V> {
    /**Uses an ArrayList for underlying storage */
    ArrayList<MapEntry<K, V>> table = new ArrayList<>();

    /**Default constructor constructs empty Map*/
    public UnsortedTableMap() {}
    @Override
    public int size() { return table.size(); }

    /**Private method to return the index of the entry with equal key within ArrayList
     * or -1 if it is not found. Note that it takes O(n) in the worst-case */
    private int findIndex(K key)
    {
        int n = table.size();
        for(int i=0; i<n; i++)
        {
            if(table.get(i).getKey().equals(key))
                return i;
        }
        return -1;
    }

    @Override
    public V get(K key)
    {
        int i = findIndex(key);
        if(i==-1) return null;
        else return table.get(i).getValue();
    }

    @Override
    public V put(K key, V value)
    {
        int i = findIndex(key);
        if(i==-1) {
            //if key is not present, add a new entry at the end of ArrayList
            table.add(new MapEntry<>(key, value));
            return null; //our convention
        }
        else return table.get(i).setValue(value);
    }

    /** Removes an entry with the given key and returns its value */
    public V remove(K key)
    {
        int i = findIndex(key);
        if(i==-1) return null; //not found
        V val = table.get(i).getValue(); //save value to be removed
        if(i != table.size()-1) //if removed entry is not last in list
            table.set(i, table.get(table.size()-1)); //move last entry to location of the removed
        table.remove(table.size()-1); //last entry now safe to delete
        return val;
    }

    @Override
    public Iterable<Entry<K, V>> entrySet()
    {
        return new EntryIterable();
    }

    private class EntryIterable implements Iterable<Entry<K, V>> {
        public Iterator<Entry<K, V>> iterator() { return new EntryIterator(); }
    }

    private class EntryIterator implements Iterator<Entry<K, V>> {
        private int i=0;

        @Override
        public boolean hasNext() {
            return i<table.size();
        }

        @Override
        public Entry<K, V> next() {
            if(i>=table.size()) throw new NoSuchElementException("No next element");
            return table.get(i++);
        }
        //remove not supported
    }
}
