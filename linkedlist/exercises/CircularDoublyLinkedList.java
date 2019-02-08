package linkedlist.exercises;

/**
 * My solution to C-3.32
 * @param <E> element type
 */
public class CircularDoublyLinkedList<E> {
    //Node class is identical to DoublyLinkedList node
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
        public E getElement() { return element; } //setter for the data
        public Node<E> getPrev() { return prev; } //get previous Node
        public Node<E> getNext() { return next; } //get next Node
        public void setPrev(Node<E> prev) { this.prev = prev; }
        public void setNext(Node<E> next) { this.next = next; } //change next Node
    }

    private Node<E> tail = null;
    private int size = 0;

    //default constructor, constructs empty list
    public CircularDoublyLinkedList() {}

    public int size() { return size; }
    public boolean isEmpty() {
        return size==0;
    }

    public E first()
    {
        if(isEmpty()) return null;
        return tail.getNext().getElement();
    }

    public E last() {
        if(isEmpty()) return null;
        return tail.getElement();
    }

    //same as in CircularLinkedList
    public void rotate()
    {
        if(tail!=null)
            tail = tail.getNext();
    }

    //new method
    private void rotateBackward() {
        if(tail!=null)
            tail = tail.getPrev();
    }

    public void addFirst(E e)
    {
        if(size == 0) //when adding first element
        {
            tail = new Node<>(e, null, null);
            tail.setNext(tail); //links to itself
            tail.setPrev(tail);
            size++;
        }
        else {
            addBetween(e, tail, tail.getNext());
        }
    }

    public void addLast(E e)
    {
        addFirst(e);
        if(size>1) rotate();
    }

    public E removeFirst()
    {
        if(isEmpty()) return null;
        Node<E> head = tail.getNext();
        if(size==1)
        {
            tail = null;
            return head.getElement();
        }
        else
        {
            return remove(head);
        }
    }


    public E removeLast()
    {
        if(isEmpty()) return null;
        Node<E> temp = tail;
        if(size==1) //there was only one element
        {
            tail = null;
            return temp.getElement();
        }
        else
        {
            rotateBackward();
            return remove(temp);
        }
    }

    //no change from DoublyLinkedList
    private E remove(Node <E> node)
    {
        Node<E> predecessor = node.getPrev();
        Node<E> successor = node.getNext();
        predecessor.setNext(successor);
        successor.setPrev(predecessor);
        size--;
        return node.getElement();
    }

    //no change from DoublyLinkedList
    private void addBetween(E e, Node<E> predecessor, Node<E> successor)
    {
        Node<E> newest = new Node<>(e, predecessor, successor);
        predecessor.setNext(newest);
        successor.setPrev(newest);
        size++;
    }
}
