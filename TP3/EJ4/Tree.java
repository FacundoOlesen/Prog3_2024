package TP3.EJ4;

public class Tree {
    static final int COUNT = 10;
    private TreeNode root;

    public Tree() {
        this.root = null;
    }

    public void add(TreeNode node) {
        root = node;
    }

   public void fillNodes() {
        fillNodes(this.root);
    }

    private int fillNodes(TreeNode node) {
        if (node.getLeft() == null && node.getRight() != null)
            node.setValue(fillNodes(node.getRight()));

        if (node.getRight() == null && node.getLeft() != null)
            node.setValue(-fillNodes(node.getLeft()));

        if (node.getLeft() != null && node.getRight() != null)
            node.setValue(fillNodes(node.getRight()) - fillNodes(node.getLeft()));

        return node.getValue();
    }


    //IMPRIMO ABB
    public void print2DUtil(TreeNode root, int space) {
        // Base case
        if (root == null) return;

        // Increase distance between levels
        space += COUNT;

        // Process right child first
        print2DUtil(root.getRight(), space);

        // Print current node after space
        // count
        System.out.print("\n");
        for (int i = COUNT; i < space; i++)
            System.out.print(" ");
        System.out.print(root.getValue() + "\n");

        // Process left child
        print2DUtil(root.getLeft(), space);
    }

    // Wrapper over print2DUtil()
    public void print2D(TreeNode root) {
        // Pass initial space count as 0
        print2DUtil(root, 0);
    }
}