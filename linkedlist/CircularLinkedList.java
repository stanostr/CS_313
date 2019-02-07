package linkedlist;

public class CircularLinkedList<E> {
    //Node class is identical to SinglyLinkedList
    private static class Node<E>
    {
        private E element;
        private Node<E> next;
        //constructor
        public Node(E element, Node<E> next)
        {
            this.element = element;
            this.next = next;
        }
        public E getElement() { return element; } //get the data in the node
        public Node<E> getNext() { return next; } //get next Node
        public void setNext(Node<E> next) { this.next = next; } //change next Node
    }

    //note how we removed the head variable
    private Node<E> tail = null;
    private int size = 0;

    //default constructor, constructs empty list
    public CircularLinkedList() {}

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

    public void rotate()
    {
        if(tail!=null)
            tail = tail.getNext();
    }

    public void addFirst(E e)
    {
        if(size == 0)
        {
            //because we now have only one element tail is both head and tail
            tail = new Node<>(e, null);
            tail.setNext(tail); //links to itself
        }
        else {
            Node<E> newest = new Node<>(e, tail.getNext());
            tail.setNext(newest);
        }
        size++;
    }

    public void addLast(E e)
    {
        addFirst(e);
        tail = tail.getNext();
    }

    public E removeFirst()
    {
        if(isEmpty()) return null;
        Node<E> head = tail.getNext();
        if(head==tail) tail = null; //head==tail means only one element
        else tail.setNext(head.getNext());
        size--;
        return head.getElement();
    }

    //still no efficient way to remove last
}
