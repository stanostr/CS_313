package stack;

public interface Stack<E> {
    /**
     * Returns the number of elements in the stack
     * @return number of elements in the stack
     */
    int size();

    /**
     * Tests whether the stack is empty
     * @return true if stack is empty, false otherwise
     */
    boolean isEmpty();

    /**
     * Adds an element to the top of the stack
     * @param e element to add
     */
    void push(E e);

    /**
     * Returns, but does not remove, the element at the top of the stack
     * @return element at the top of the stack, or null if empty
     */
    E top();

    /**
     * Returns and removes the top elements in the stack
     * @return element to be removed, or null if empty
     */
    E pop();
}
