package list;

public class FixedArrayList<E> implements List<E> {
    public static final int CAPACITY = 10;
    private E[] data; //generic array that we will use for storage
    private int size;

    //default constructor
    public FixedArrayList()
    {
        this(CAPACITY);
    }

    //constructor with parameters
    public FixedArrayList(int capacity)
    {
        //we first create a new array of objects with the specified capacity
        //then we cast it to the type being stored in our FixedArrayList
        data = (E[]) new Object[capacity];
    }


    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }

    @Override
    public E get(int i) {
        checkIndex(i, size-1);
        return data[i];
    }

    @Override
    //why do we return the old element? No idea. Just to remain consistent with Java's interface.
    public E set(int i, E e)
    {
        checkIndex(i, size-1);
        E temp = data[i];
        data[i] = e;
        return temp;
    }

    @Override
    public void add(E e)
    {
        if(size==data.length)
            throw new IllegalStateException("Array is full");
        data[size] = e;
        size++;
    }


    @Override
    public void add(int i, E e) throws IndexOutOfBoundsException {
        checkIndex(i, size);
        if(size==data.length)
            throw new IllegalStateException("Array is full");
        for(int k=size-1; k >= i; k--) //manual array copy for demonstration
            data[k+1] = data[k];
        data[i] = e;
        size++;
    }

    @Override
    public E remove(int i) throws IndexOutOfBoundsException {
        checkIndex(i, size-1);
        E temp = data[i];

        //shift all elements after current index one to the left
        for(int k=i; k < size-1; k++)
            data[k] = data[k+1];
        data[size-1] = null; //delete what used to be last element and decrement size
        size--;
        return temp;
    }

    /**
     * Checks whether the index is valid *
     * @param index to be checked
     * @param n top valid index
     */
    private static void checkIndex(int index, int n) throws IndexOutOfBoundsException
    {
        if(index<0 || index > n)
            throw new IndexOutOfBoundsException("Illegal index " + index);
    }
}
