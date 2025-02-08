package Practicando.Arboles;

import TP3.EJ5.TreeNode;

public class Main {
    public static void main(String[] args) {
        Tree tree = new Tree();


        /*
        tree.add(6);
        tree.add(10);
        tree.add(12);
        tree.add(9);
        tree.add(25);
        tree.add(23);
        tree.add(28);
        //tree.add(21);*/

         /*tree.add(10);
        tree.add(5);
        tree.add(2);
        tree.add(30);
        tree.add(25);
        tree.add(45);
        tree.add(8);
        tree.add(7);
        tree.add(9);
        tree.add(55);
        tree.add(54);
        tree.add(56);
        tree.add(50);
        tree.add(51);*/

        tree.insert(6);
        tree.insert(2);
        tree.insert(1);
        tree.insert(4);
        tree.insert(15);
        tree.insert(14);
        tree.insert(16);
        tree.insert(17);




        /*tree.add(6);
        tree.add(2);
        tree.add(1);
        tree.add(4);
        tree.add(7);
        tree.add(9);
        tree.add(8);
        tree.add(10);
        tree.add(11);*/


        //tree.add(9);

        System.out.println("ESTA EL NUM? " + tree.hasElem(4));
        System.out.println("LONGEST BRANCH " + tree.getLongestBranch());
        System.out.println("SUMA NODOS INTERNOS " + tree.getSumaNodosInternos());
        System.out.println("HOJAS MAYORES A K: " + tree.getHojasMayoresAK(0));
        System.out.println("ELEM AT LEVEL: " + tree.obtenerNivel(122));
 //       tree.fillTree();


         TP3.EJ5.Tree treeVocales = new TP3.EJ5.Tree();

        TreeNode M = new TreeNode('M');
        treeVocales.add(M);


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

        System.out.println("PALABRAS CON N VOCALES: " + treeVocales.getPalabrasConNVocales(2));
        System.out.println("BRANCHS MAYORES A X: " + tree.getBranchsMayoresAX(2));

    }
}