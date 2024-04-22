package TP3.EJ3;

import java.util.ArrayList;
import java.util.List;

public class Tree {
    public static final int K = 8;
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

    public List<Integer> getValoresMayoresAK() {
        ArrayList<Integer> res = new ArrayList<>();
        getValoresMayoresAK(this.root, res);
        return res;
    }

    private void getValoresMayoresAK(TreeNode node, ArrayList<Integer> res) {
        if (node != null) {
            if (node.getValue() > K && node.getRight() == null && node.getLeft() == null)
                res.add(node.getValue());

            if (node.getLeft() == null && node.getRight() == null)
                return;

            if (node.getValue() > K) {
                getValoresMayoresAK(node.getLeft(), res);
            }

            if (node.getValue() <= K || node.getRight() != null) {
                getValoresMayoresAK(node.getRight(), res);
            }

        }

    }
}