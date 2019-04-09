package project2_files;

public class TestForExtraCredit {
    public static void main(String [] args)
    {
        LinkedBinaryTree<String> tree = BinaryExpressionTree2.constructExpressionTree("(((9-8.5)*(3*(4-1.5)))+100.7)");
        System.out.println("Solution " + BinaryExpressionTree2.valueOfExpressionTree(tree));
        System.out.println("Infix expression " + BinaryExpressionTree2.infixExpressionFromTree(tree));

        LinkedBinaryTree<String> tree2 = BinaryExpressionTree2.constructExpressionTree("(((9-8)*(3*(4-1)))+100)");
        System.out.println("Solution " + BinaryExpressionTree2.valueOfExpressionTree(tree2));
        System.out.println("Infix expression " + BinaryExpressionTree2.infixExpressionFromTree(tree2));
        
        System.out.println("Expected 104.45  and 109");
    }
}
