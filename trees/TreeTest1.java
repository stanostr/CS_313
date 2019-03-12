package trees;

public class TreeTest1 {
    public static void main(String[] args)
    {
        //create and fill up our tree
        LinkedBinaryTree<String> binaryTree = new LinkedBinaryTree<>();
        binaryTree.addRoot("*");
        Position<String> root = binaryTree.root();
        binaryTree.addLeft(root, "-");
        binaryTree.addRight(root, "+");
        Position<String> rootLeft = binaryTree.left(root);
        binaryTree.addLeft(rootLeft, "7");
        binaryTree.addRight(rootLeft, "4");
        Position<String> rootRight = binaryTree.right(root);
        binaryTree.addLeft(rootRight, "3");
        binaryTree.addRight(rootRight, "+");
        Position<String> rootRightRight = binaryTree.right(rootRight);
        binaryTree.addLeft(rootRightRight, "3");
        binaryTree.addRight(rootRightRight, "4");

        System.out.println(binaryTree.left(binaryTree.root()).getElement()); //line 1
        System.out.println(binaryTree.right(binaryTree.left(binaryTree.root())).getElement()); //line 2

        //second way to create the same tree
        LinkedBinaryTree<String> binaryTree2 = new LinkedBinaryTree<>();
        binaryTree2.addRoot("*");
        root = binaryTree2.root();

        LinkedBinaryTree<String> subtree = new LinkedBinaryTree<>();
        subtree.addRoot("-");
        subtree.addLeft(subtree.root(), "3");
        subtree.addRight(subtree.root(), "4");

        LinkedBinaryTree<String> subtree2 = new LinkedBinaryTree<>();
        subtree2.addRoot("3");

        LinkedBinaryTree<String> subtree3 = new LinkedBinaryTree<>();
        subtree3.addRoot("-");
        subtree3.attach(subtree3.root(), subtree, subtree2);

        LinkedBinaryTree<String> subtree4 = new LinkedBinaryTree<>();
        subtree4.addRoot("-");
        subtree4.addLeft(subtree4.root(), "7");
        subtree4.addRight(subtree4.root(), "4");

        binaryTree2.attach(root, subtree4, subtree3);

        System.out.println(binaryTree.left(binaryTree.root()).getElement()); //line 3
        System.out.println(binaryTree.right(binaryTree.left(binaryTree.root())).getElement()); //line 4
    }
}
