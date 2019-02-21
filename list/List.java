package list;

public interface List<E> {
    /**
     * @return number of elements in the list
     */
    int size();

    /**
     * @return true if list is empty, false otherwise
     */
    boolean isEmpty();

    /**
     * Returns the element at the specified position
     * @throws IndexOutOfBoundsException if position is not in range
     */
    E get(int i) throws IndexOutOfBoundsException;

    /**
     * Replaces the element at the specified position in this list with the specified element.
     * @throws IndexOutOfBoundsException if position is not in range
     */
    E set(int i, E e) throws IndexOutOfBoundsException;

    /**
     *  Adds the specified element to the end of the list
     */
    void add(E e);

    /**
     * Adds the specified element at the specified position, shifting all that come after it to the right.
     * @throws IndexOutOfBoundsException if position is not in range
     */
    void add(int i, E e) throws IndexOutOfBoundsException;

    /**
     * Removes the element at the specified position, shifting all that come after it to the left.
     * @throws IndexOutOfBoundsException if position is not in range.
     */
    E remove(int i) throws IndexOutOfBoundsException;
}
