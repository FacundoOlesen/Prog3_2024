package TP3.EJ2;

import java.util.ArrayList;
import java.util.List;

public class Tree {

    private TreeNode root;

    public Tree() {
        this.root = null;
    }

    public void add(Integer value) {
        if (this.root == null) this.root = new TreeNode(value);
        else this.add(this.root, value);
    }

    private void add(TreeNode actual, Integer value) {
        if (actual.getValue() > value) {
            if (actual.getLeft() == null) {
                TreeNode temp = new TreeNode(value);
                actual.setLeft(temp);
            } else {
                add(actual.getLeft(), value);
            }
        } else if (actual.getValue() < value) {
            if (actual.getRight() == null) {
                TreeNode temp = new TreeNode(value);
                actual.setRight(temp);
            } else {
                add(actual.getRight(), value);
            }
        }
    }

    public int sumaNodosInternos() {
        return sumaNodosInternos(this.root);
    }

    private int sumaNodosInternos(TreeNode node) {
        if (node == null)
            return 0;
        if (node.getRight() != null || node.getLeft() != null) {
            return node.getValue() + sumaNodosInternos(node.getLeft()) + sumaNodosInternos(node.getRight());
        }
        return 0;
    }

}