package map;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public abstract class AbstractHashMap<K, V> extends AbstractMap<K, V> {
    private static final int DEFAULT_PRIME = 109345121;
    private static final int DEFAULT_CAPACITY = 17;
    protected int n = 0; //number of entries, updated in concrete implementations
    protected int capacity; //length of table
    private int prime; //prime factor
    private long scale, shift;
    public AbstractHashMap(int capacity, int prime)
    {
        this.capacity = capacity;
        this.prime = prime;
        Random random = new Random();
        scale = random.nextInt(prime-1)+1; //returns random number in range 1 to prime-1
        shift = random.nextInt(prime); //returns random number in range 0 to n-1
        createTable();
    }
    public AbstractHashMap(int capacity)
    {
        this(capacity, DEFAULT_PRIME);
    }
    public AbstractHashMap()
    {
        this(DEFAULT_CAPACITY, DEFAULT_PRIME);
    }
    public int size() { return n; }
    public V get(K key) { return bucketGet(hashValue(key), key); }
    public V remove(K key) { return bucketRemove(hashValue(key), key); }
    public V put(K key, V value) {
        V returnValue =  bucketPut(hashValue(key), key, value);
        //but we also want to resize if load factor becomes >0.5
        if(n>capacity/2)
            resize(2*capacity-1); //it would be better to find a nearby prime but too complicated
        return returnValue;
    }

    private int hashValue(K key)
    {
        //MAD hash compression function
        return (int)((Math.abs(key.hashCode()*scale + shift) % prime) % capacity);
    }
    private void resize(int newCapacity)
    {
        List<Entry<K, V>> buffer = new ArrayList<>();
        for(Entry<K, V> entry: entrySet())
            buffer.add(entry);
        capacity = newCapacity;
        createTable();
        n=0;
        for(Entry<K, V> entry: buffer)
            put(entry.getKey(), entry.getValue());
    }

    //abstract methods must be implemented by subclasses
    protected abstract void createTable();
    protected abstract V bucketRemove(int i, K key);
    protected abstract V bucketGet(int h, K key);
    protected abstract V bucketPut(int h, K key, V value);
}
