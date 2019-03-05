package trees;

import java.util.Iterator;

//please come back later!!!!
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
    //please come back later!!!!
    //In progress!!!

    protected Node<E> root = null;
    private int size = 0;

    @Override
    public Position<E> left(Position<E> p) throws IllegalArgumentException {
        return null;
    }

    @Override
    public Position<E> right(Position<E> p) throws IllegalArgumentException {
        return null;
    }

    @Override
    public Position<E> root() {
        return root;
    }

    @Override
    public Position<E> parent(Position<E> p) throws IllegalArgumentException {
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }

    @Override
    public Iterable<Position<E>> positions() {
        return null;
    }
}
