package trees;

import java.util.Iterator;

public class LinkedBinaryTree<E> extends AbstractBinaryTree<E> {
    //<b>In progress, please come back later!!</b>

    //nested Node class
    protected static class Node<E> implements Position<E>
    {
        private E element;
        private Node<E> parent;
        private Node<E> left; //left child
        private Node<E> right; //right child

        public Node(E e, Node<E> parent, Node<E> left, Node<E> right)
        {
            element = e;
            this.parent = parent;
            this.left = left;
            this.right = right;
        }

        public E getElement() { return element; }
        public Node<E> getParent() { return parent; }
        public Node<E> getLeft() { return left; }
        public Node<E> getRight() { return right; }

        public void setElement(E e) { element = e; }
        public void setParent(Node<E> parent) { this.parent = parent; }
        public void setLeft(Node<E> left) { this.left = left; }
        public void setRight(Node<E> right) { this.right = right; }
    }

    protected Node<E> createNode(E e, Node<E> parent, Node<E> left, Node<E> right)
    {
        return new Node<E>(e, parent, left, right);
    }

    protected Node<E> root = null;
    private int size = 0;

    //start of accessor methods not implemented in AbstractBinaryTree
    @Override
    public Position<E> root() {
        return root;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Position<E> left(Position<E> p) throws IllegalArgumentException {
        Node<E> node = validate(p);
        return node.getLeft();
    }

    @Override
    public Position<E> right(Position<E> p) throws IllegalArgumentException {
        Node<E> node = validate(p);
        return node.getLeft();
    }

    @Override
    public Position<E> parent(Position<E> p) throws IllegalArgumentException {
        Node<E> node = validate(p);
        return node.getLeft();
    }
    //end of accessor methods not implemented in AbstractBinaryTree

    //start of update methods for this class

    /** adds a root to an empty tree */
    public Position<E> addRoot(E e) throws IllegalStateException
    {
        //cannot add a root to a tree that already has one
        if(!isEmpty()) throw new IllegalStateException("Tree is not empty");
        root = createNode(e, null, null, null);
        size = 1;
        return root;
    }

    public Position<E> addLeft(E e) throws IllegalArgumentException
    {
        return null;
    }

    public Position<E> addRight(E e) throws IllegalArgumentException
    {
        return null;
    }

    /** Replaces element at position p, and returns replaced element */
    public E set(Position<E> p, E e) throws IllegalArgumentException
    {
        Node<E> node = validate(p);
        E temp = node.getElement();
        node.setElement(e);
        return temp;
    }


    //end of updates methods for this class

    @Override
    public Iterator<E> iterator() {
        //We are not ready to implement this yet!!!
        //we need to learn about tree traversal first
        return null;
    }

    @Override
    public Iterable<Position<E>> positions() {
        //We are not ready to implement this yet!!!
        //we need to learn about tree traversal first
        return null;
    }

    /**
     * Validates the position and returns it as a node
     * @throws IllegalArgumentException if given invalid node
     */
    private Node<E> validate(Position<E> p) throws IllegalArgumentException {
        //note that if this test fails, it is still a Position, just note a Node
        if(!(p instanceof Node))
            throw new IllegalArgumentException("Not a valid position type");
        Node<E> node = (Node<E>) p;
        if(node.getParent() == node) //when we remove Nodes we set their parent to themselves.
            throw new IllegalArgumentException("p is no longer in the tree");
        return node;
    }
}
