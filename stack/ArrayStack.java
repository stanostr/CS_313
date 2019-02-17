package stack;

/**
 * Array-based stack implementation
 * @param <E> the type of the elements in the stack
 */
public class ArrayStack<E> implements Stack<E> {
    //instance variables of our array-based stack
    public static final int CAPACITY = 1000; //default array size
    private E[] data;
    private int t = -1; //index of the top element in the stack
    public ArrayStack(int capacity) {
        //the next line creates an array of Objects with size = capacity,
        //and then casts it to type E
        data = (E[]) new Object[capacity];
    }

    //default constructor sets capacity to 1000
    public ArrayStack()
    {
        this(CAPACITY);
    }

    @Override
    public int size() {
        return t+1;
    }

    @Override
    public boolean isEmpty() {
        return t<0;
    }

    @Override
    public void push(E e) throws IllegalStateException
    {
        if(size()==data.length) throw new IllegalStateException("Stack is full");
        data[++t] = e; //increments t before storing new item
    }

    @Override
    public E top() {
        if(isEmpty()) return null;
        return data[t];
    }

    @Override
    public E pop() {
        if(isEmpty()) return null;
        E result = data[t]; //save the return value
        data[t] = null; //"delete" the element, note this is optional but saves memory
        t--; //decrement the size
        return result;
    }
}
