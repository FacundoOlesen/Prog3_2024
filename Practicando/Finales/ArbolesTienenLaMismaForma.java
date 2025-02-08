package Practicando.Finales;

import TP3.EJ1.Tree;
import TP3.EJ1.TreeNode;

public class ArbolesTienenLaMismaForma {
    public ArbolesTienenLaMismaForma() {
    }

    public boolean tienenLaMismaForma(Tree arbol1, Tree arbol2) {
        return tienenLaMismaFormaVisit(arbol1.getRootNode(), arbol2.getRootNode());
    }

    private boolean tienenLaMismaFormaVisit(TreeNode arbol1, TreeNode arbol2) {
        if (arbol1 == null && arbol2 == null) return true;
        if (arbol1 == null || arbol2 == null) return false;

        return tienenLaMismaFormaVisit(arbol1.getLeft(), arbol2.getLeft()) && tienenLaMismaFormaVisit(arbol1.getRight(), arbol2.getRight());
    }

    public static void main(String[] args) {
        Tree arbol1 = new Tree();
        arbol1.add(1);
        arbol1.add(2);


        Tree arbol2 = new Tree();
        arbol2.add(1);
        arbol2.add(2);


        ArbolesTienenLaMismaForma a = new ArbolesTienenLaMismaForma();

         System.out.println(a.tienenLaMismaForma(arbol1, arbol2));
    }
}
