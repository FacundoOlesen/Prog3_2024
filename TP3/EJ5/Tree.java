package TP3.EJ5;

import java.util.ArrayList;
import java.util.List;

public class Tree {
    static final int COUNT = 10;
    private TreeNode root;

    public Tree() {
        this.root = null;
    }

    public void add(TreeNode node) {
        root = node;
    }


    public List<String> getPalabrasConNVocales(int N) {
        int cant = 0;
        ArrayList<String> res = new ArrayList<>();
        String word = "";
        getPalabrasConNVocales(this.root, N, cant, word, res);
        return res;
    }

    private List<String> getPalabrasConNVocales(TreeNode node, int N, int cant, String word, ArrayList<String> res) {
        if (node != null) {
            word += node.getValue();

            if (node.getValue() == 'A' || node.getValue() == 'E' || node.getValue() == 'I' || node.getValue() == 'O' || node.getValue() == 'U')
                cant++;

            if (node.getLeft() != null)
                getPalabrasConNVocales(node.getLeft(), N, cant, word, res);

            if (node.getRight() != null)
                getPalabrasConNVocales(node.getRight(), N, cant, word, res);

            if (cant == N && node.getLeft() == null && node.getRight() == null) {
                res.add(word);
            }
        }
        return res;
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