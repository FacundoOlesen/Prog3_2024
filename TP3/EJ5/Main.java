package TP3.EJ5;


public class Main {
    public static void main(String[] args) {
        Tree tree = new Tree();

        TreeNode M = new TreeNode('M');
        tree.add(M);


        TreeNode A1 = new TreeNode('A');
        TreeNode A2 = new TreeNode('A');
        TreeNode A3 = new TreeNode('A');

        TreeNode L = new TreeNode('L');
        TreeNode N = new TreeNode('N');
        TreeNode O1 = new TreeNode('O');
        TreeNode O2 = new TreeNode('O');

        TreeNode I = new TreeNode('I');
        TreeNode S = new TreeNode('S');

        M.setLeft(A1);
        A1.setLeft(L);
        A1.setRight(N);
        N.setLeft(A2);
        N.setRight(O1);
        M.setRight(I);
        I.setRight(S);
        S.setRight(A3);
        I.setLeft(O2);


        tree.print2D(M);
        System.out.println(tree.getPalabrasConNVocales(2));
    }
}
