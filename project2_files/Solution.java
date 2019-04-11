package project2_files;

/**
 * Sample solution to the two methods to be written for Project 2.
 * @author Stanislav Ostrovskii
 */
public class Solution {
    private static final String DIGITS = "0123456789";
    private static final String OPERATORS = "+-/*";

    /**
     * Evaluates and returns the value associated with a binary expressiont tree.
     * @param tree a binary expression tree
     * @return the value associated with the root
     */
    public static int valueOfExpressionTree(LinkedBinaryTree<String> tree)
    {
        return evaluate(tree.root(), tree);
    }

    private static int evaluate(Position<String> p, LinkedBinaryTree<String> tree)
            throws IllegalArgumentException
    {
        if(tree.isInternal(p))
        {
            char op = p.getElement().charAt(0);
            int left = evaluate(tree.left(p), tree);
            int right = evaluate(tree.right(p), tree);
            if(op=='*') return left*right;
            if(op=='/') return left/right;
            if(op=='+') return left+right;
            if(op=='-')
            {
                System.out.println(left + " " + right);
                return left-right;
            }
            else throw new IllegalArgumentException("Invalid operator: " + op);
        }
        else return Integer.valueOf(p.getElement());
    }

    /**
     * Returns a fully parenthesized infix expression
     * represented by the binary expression tree.
     * The binary expression tree is expected to contain only
     * integers (positive or negative) and the operators: +, -, /, *
     * @param tree a binary expression tree
     * @return infix expression represented by the tree
     */
    public static String infixExpressionFromTree(LinkedBinaryTree<String> tree)
    {
        return inorder(tree, tree.root(), "");
    }

    private static String inorder(LinkedBinaryTree<String> tree, Position<String> root, String expr) {
        if(!tree.isEmpty()) {
            String element = root.getElement();
            if (OPERATORS.indexOf(element.charAt(0)) != -1 && element.length() == 1)
                expr = inorder(tree, tree.left(root), '(' + expr);
            expr += element;
            if (OPERATORS.indexOf(element.charAt(0)) != -1 && element.length() == 1)
                expr = inorder(tree, tree.right(root), expr) + ')';
        }
        return expr;
    }
}
