package TP3.EJ4;


public class Main {
    public static void main(String[] args) {
        Tree tree = new Tree();

        TreeNode root = new TreeNode();
        tree.add(root);
        TreeNode leftRoot = new TreeNode();
        TreeNode rightRoot = new TreeNode();
        TreeNode rightRootRight = new TreeNode();
        TreeNode leftRootLeft = new TreeNode();


        TreeNode catorce = new TreeNode(14);
        TreeNode siete = new TreeNode(7);
        TreeNode menosCinco = new TreeNode(-5);
        TreeNode nueve = new TreeNode(9);
        TreeNode veinte = new TreeNode(20);


        root.setLeft(leftRoot);
        root.setRight(rightRoot);
        leftRoot.setLeft(catorce);
        leftRoot.setRight(rightRootRight);
        rightRootRight.setLeft(siete);
        rightRootRight.setRight(menosCinco);


        rightRoot.setLeft(leftRootLeft);
        rightRoot.setRight(veinte);
        leftRootLeft.setRight(nueve);


        tree.fillNodes();
        tree.print2D(root);
    }
}
