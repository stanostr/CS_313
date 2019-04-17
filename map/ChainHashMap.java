package map;
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
    @Override
    protected void createTable() {

    }

    @Override
    protected V bucketRemove(int i, K key) {
        return null;
    }

    @Override
    protected V bucketGet(int h, K key) {
        return null;
    }

    @Override
    protected V bucketPut(int h, K k, V v) {
        return null;
    }

    @Override
    public Iterable<Entry<K, V>> entrySet() {
        return null;
    }
}
