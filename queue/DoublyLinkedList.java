package queue;

public class DoublyLinkedList<E> implements Deque<E> {
    private static class Node<E>
    {
        private E element;
        private Node<E> next;
        private Node<E> prev;
        //constructor
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

    private Node<E> header;
    private Node<E> trailer;
    private int size = 0;

    //default constructor, constructs empty list
    public DoublyLinkedList() {
        header = new Node<>(null, null, null);
        trailer = new Node<>(null, header, null);
        header.setNext(trailer);
    }

    @Override
    public int size() { return size; }

    @Override
    public boolean isEmpty() {
        return size==0;
    }

    @Override
    public E first()
    {
        if(isEmpty()) return null;
        return header.getNext().getElement();
    }

    @Override
    public E last() {
        if(isEmpty()) return null;
        return trailer.getPrev().getElement();
    }

    /**
     * Note that this a private helper method.
     * Users of the class do not have access to this method,
     * as there is no such operation on a doubly (or singly) linked list
     */
    private void addBetween(E e, Node<E> predecessor, Node<E> successor)
    {
        Node<E> newest = new Node<>(e, predecessor, successor);
        predecessor.setNext(newest);
        successor.setPrev(newest);
        size++;
    }

    @Override
    public void addFirst(E e)
    {
        addBetween(e, header, header.getNext());
    }

    @Override
    public void addLast(E e)
    {
        addBetween(e, trailer.getPrev(), trailer);
    }

    /**
     * Note how this is also a private helper method,
     * there is no general-case remove operation for a doubly linked list
     */
    private E remove(Node <E> node)
    {
        Node<E> predecessor = node.getPrev();
        Node<E> successor = node.getNext();
        predecessor.setNext(successor);
        successor.setPrev(predecessor);
        size--;
        return node.getElement();
    }

    @Override
    public E removeFirst()
    {
        if(isEmpty()) return null;
        return remove(header.getNext());
    }

    @Override
    public E removeLast()
    {
        if(isEmpty()) return null;
        return remove(trailer.getPrev());
    }
}

