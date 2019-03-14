package treetraversal;

import java.util.ArrayList;
import java.util.List;

public  abstract class AbstractBinaryTree<E> extends AbstractTree<E>
        implements BinaryTree<E> {
    /** Returns the position of p's sibling or null if none exists */
    public Position<E> sibling(Position<E> p)
    {
        Position<E> parent = parent(p);
        if(parent==null) return null; //p is root and has no parent or siblings
        if(p == left(parent)) return right(parent); //if p is left, return right*
        else return left(parent); //p must be right, so return left
    }

    /** returns the number of children of Position p */
    public int numChildren(Position<E> p) //note that numChildren is introduced in Tree interface
    {
        int count = 0;
        if(left(p)!=null) count++;
        if(right(p)!=null) count++;
        return count;
    }

    /** returns an iterable collection of the Positions that are p's children
     * Note that this is a <b>snapshot</b> iterator!
     */
    public Iterable<Position<E>> children(Position<E> p)
    {
        //here we use a java.util.ArrayList, but we could just as well use our own implementation
        List<Position<E>> snapshot = new ArrayList<>(2);
        if(left(p)!=null) snapshot.add(left(p));
        if(right(p)!=null) snapshot.add(right(p));
        return snapshot;
    }

    private void inorderSubtree(Position<E> p, List<Position<E>> snapshot)
    {
        if(left(p)!=null)
            inorderSubtree(left(p), snapshot);
        snapshot.add(p);
        if(right(p)!=null)
            inorderSubtree(right(p), snapshot);
    }

    public Iterable<Position<E>> inorder()
    {
        List<Position<E>> snapshot = new ArrayList<>();
        if(!isEmpty())
        {
            inorderSubtree(root(), snapshot);
        }
        return snapshot;
    }

    @Override
    public Iterable<Position<E>> positions() {
        return inorder();
    }
}
