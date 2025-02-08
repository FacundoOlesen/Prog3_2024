package Practicando.Finales;

import TP3.EJ1.Tree;
import TP3.EJ1.TreeNode;

public class HojasMayorA0 {
    private Tree arbol;

    public HojasMayorA0(Tree arbol) {
        this.arbol = arbol;
    }

    public boolean mayorA0(Integer K) {
        return mayorA0(arbol.getRootNode(), K);
    }

    private boolean mayorA0(TreeNode act, Integer K) {
        if (act != null) {
            if (act.getLeft() == null && act.getRight() == null)
                return K - act.getValue() > 0;
            return mayorA0(act.getLeft(), K - act.getValue()) || mayorA0(act.getRight(), K - act.getValue());
        }
        return false;
    }


    public boolean nodosInternosMayorAK(Integer K) {
        return nodosInternosMayorAK(null, arbol.getRootNode(), K);
    }

    private boolean nodosInternosMayorAK(TreeNode padre, TreeNode act, Integer K) {
        if (act != null) {
            if (act.getRight() != null || act.getLeft() != null) {
                if (padre != null) {
                    if (padre.getValue() - act.getValue() > K)
                        return false;
                }
            }
            return nodosInternosMayorAK(act, act.getLeft(), K) && nodosInternosMayorAK(act, act.getRight(), K);
        }
        return true;
    }


    public static void main(String[] args) {
        Tree arbol = new Tree();
        arbol.add(10);
        arbol.add(8);
        arbol.add(4);
        arbol.add(2);
        arbol.add(9);
        arbol.add(13);
        arbol.add(12);
        arbol.add(11);
        arbol.add(20);

        HojasMayorA0 h = new HojasMayorA0(arbol);
        System.out.println(h.nodosInternosMayorAK(3));
        System.out.println(h.mayorA0(2));


    }
}
