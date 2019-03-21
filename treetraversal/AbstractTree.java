package treetraversal;

import queue.LinkedQueue;
import queue.Queue;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class AbstractTree<E> implements Tree<E> {
    public boolean isInternal(Position<E> p) {
        return numChildren(p) > 0;
    }

    public boolean isExternal(Position<E> p) {
        return numChildren(p) == 0;
    }

    public boolean isRoot(Position<E> p) {
        return p == root();
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public int depth(Position<E> p) {
        if (isRoot(p)) return 0;
        else return 1 + depth(parent(p));
    }

    /**
     * Returns the height of the subtree rooted at Position p
     * @return height
     */
    private int height(Position<E> p) {
        int h = 0; //base case if p is a leaf/has no children
        for (Position<E> c : children(p))
            h = Math.max(h, 1 + height(c)); //recursive call
        return h;
    }

    private class ElementIterator implements Iterator<E> {
        Iterator<Position<E>> positionIterator = positions().iterator();

        @Override
        public boolean hasNext() {
            return positionIterator.hasNext();
        }

        @Override
        public E next() {
            return positionIterator.next().getElement();
        }

        @Override
        public void remove() {
            positionIterator.remove();
        }
    }

    @Override
    public Iterator<E> iterator() {
        return new ElementIterator();
    }

    /**
     * Adds positions of the subtree rooted at p to the snapshot
     */
    private void preOrderSubtree(Position<E> p, List<Position<E>> snapshot) {
        snapshot.add(p);
        for (Position<E> c : children(p))
            preOrderSubtree(c, snapshot);
    }

    /**
     * Returns an iterable collection of positions of the tree, reported in preorder
     */
    public Iterable<Position<E>> preorder() {
        //creates the Iterable collection, ArrayList in this case
        List<Position<E>> snapshot = new ArrayList<>();
        if (!isEmpty()) //if our tree is not empty
            preOrderSubtree(root(), snapshot); //use recursive algorithm
        return snapshot;
    }

    private void postOrderSubtree(Position<E> p, List<Position<E>> snapshot)
    {
        for(Position<E> c: children(p))
            postOrderSubtree(c, snapshot);
        snapshot.add(p);
    }

    /**
     * Returns an iterable collection of positions of the tree, reported in postorder
     */
    public Iterable<Position<E>> postorder()
    {
        //same as preorder but we use postOrderSubtree instead of preOrderSubtree
        List<Position<E>> snapshot = new ArrayList<>();
        if (!isEmpty())
            postOrderSubtree(root(), snapshot);
        return snapshot;
    }

    /**
     * Returns an iterable collection of positions of the tree in breadth-first order
     */
    public Iterable<Position<E>> breadthFirst()
    {
        //follows the pseudocode and no recursive calls
        List<Position<E>> snapshot = new ArrayList<>();
        if (!isEmpty()) {
            Queue<Position<E>> queue = new LinkedQueue<>();
            queue.enqueue(root());
            while(!queue.isEmpty())
            {
                Position<E> p = queue.dequeue();
                snapshot.add(p);
                for(Position<E> c: children(p))
                    queue.enqueue(c);
            }
        }
        return snapshot;
    }

    //why cant we add inorder algorithm here?
}
