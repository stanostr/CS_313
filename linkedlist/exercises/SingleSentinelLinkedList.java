package linkedlist.exercises;

/**
 * My solution to problem C-3.31
 * @param <E> element type
 */
public class SingleSentinelLinkedList<E> {
    private static class Node<E>
    {
        private E element;
        private Node<E> next;
        private Node<E> prev;
        public Node(E element, Node<E> prev, Node<E> next)
        {
            this.element = element;
            this.prev = prev;
            this.next = next;
        }
        public E getElement() { return element; }
        public Node<E> getPrev() { return prev; }
        public Node<E> getNext() { return next; }
        public void setPrev(Node<E> prev) { this.prev = prev; }
        public void setNext(Node<E> next) { this.next = next; }
    }

    private Node<E> sentinel;
    private int size = 0;

    public SingleSentinelLinkedList() {
        sentinel = new Node<>(null, null, null);
        sentinel.setNext(sentinel);
        sentinel.setPrev(sentinel);
    }

    public int size() { return size; }
    public boolean isEmpty() {
        return size==0;
    }

    public E first()
    {
        if(isEmpty()) return null;
        return sentinel.getNext().getElement();
    }


    public E last() {
        if(isEmpty()) return null;
        return sentinel.getPrev().getElement();
    }

    private void addBetween(E e, Node<E> predecessor, Node<E> successor)
    {
        Node<E> newest = new Node<>(e, predecessor, successor);
        predecessor.setNext(newest);
        successor.setPrev(newest);
        size++;
    }

    public void addFirst(E e)
    {
        addBetween(e, sentinel, sentinel.getNext());
    }

    public void addLast(E e)
    {
        addBetween(e, sentinel.getPrev(), sentinel);
    }

    private E remove(Node <E> node)
    {
        Node<E> predecessor = node.getPrev();
        Node<E> successor = node.getNext();
        predecessor.setNext(successor);
        successor.setPrev(predecessor);
        size--;
        return node.getElement();
    }

    public E removeFirst()
    {
        if(isEmpty()) return null;
        return remove(sentinel.getNext());
    }

    public E removeLast()
    {
        if(isEmpty()) return null;
        return remove(sentinel.getPrev());
    }

}
