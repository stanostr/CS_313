package project2_files;

public class Test {
    public static void main(String [] args)
    {
        LinkedBinaryTree<String> tree = BinaryExpressionTree.constructExpressionTree("(((9-8)*(3*(4-1)))+100)"); 
        System.out.println("Solution " + BinaryExpressionTree.valueOfExpressionTree(tree)); //109
        System.out.println("Infix expression " + BinaryExpressionTree.infixExpressionFromTree(tree)); //"(((9-8)*(3*(4-1)))+100)"

        tree = BinaryExpressionTree.constructExpressionTree("((9+2)/3)"); //3
        System.out.println("Solution " + BinaryExpressionTree.valueOfExpressionTree(tree)); //3
        System.out.println("Infix expression " + BinaryExpressionTree.infixExpressionFromTree(tree)); //"((9+2)/3)"

        tree = BinaryExpressionTree.constructExpressionTree("(102*2341)");
        System.out.println("Solution " + BinaryExpressionTree.valueOfExpressionTree(tree)); //238782
        System.out.println("Infix expression " + BinaryExpressionTree.infixExpressionFromTree(tree)); //"(102*2341)"
    }

}
