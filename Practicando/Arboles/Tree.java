package Practicando.Arboles;

import TP3.EJ1.TreeNode;

import java.util.ArrayList;
import java.util.IllegalFormatCodePointException;
import java.util.List;

public class Tree {
    private TreeNode root;

    public Tree() {
        this.root = null;
    }

    //Get Root
    public TreeNode getRoot() {
        return this.root;
    }

    //Has Elem
    public boolean hasElem(Integer elem) {
        return hasElem(root, elem);
    }

    private boolean hasElem(TreeNode act, Integer elem) {
        if (act == null)
            return false;

        if (elem < act.getValue())
            return hasElem(act.getLeft(), elem);

        if (elem > act.getValue())
            return hasElem(act.getRight(), elem);

        return elem == act.getValue();
    }

    //is Empty
    public boolean isEmpty() {
        return root == null;
    }

    //Add
    public void insert(Integer elem) {
        if (root == null)
            this.root = new TreeNode(elem);
        else
            this.insert(root, elem);
    }

    private void insert(TreeNode act, Integer elem) {
        if (act.getValue() > elem) {
            if (act.getLeft() == null)
                act.setLeft(new TreeNode(elem));
            else
                insert(act.getLeft(), elem);
        }

        if (act.getValue() < elem) {
            if (act.getRight() == null)
                act.setRight(new TreeNode(elem));
            else
                insert(act.getRight(), elem);
        }
    }

    //Delete (no)

    //GetHeight
    public int getHeight() {
        if (root == null || (root.getRight() == null && root.getLeft() == null))
            return 0;
        return getHeight(this.root);
    }

    private int getHeight(TreeNode act) {
        int leftHeight = 0;
        int rightHeight = 0;

        if (act.getLeft() != null)
            leftHeight = getHeight(act.getLeft());

        if (act.getRight() != null)
            rightHeight = getHeight(act.getRight());

        if (leftHeight > rightHeight)
            return leftHeight + 1;

        else
            return rightHeight + 1;
    }

    //Get longest branch
    public List<Integer> getLongestBranch() {
        if (this.root == null)
            return new ArrayList<>();
        return getLongestBranch(this.root);
    }

    private List<Integer> getLongestBranch(TreeNode act) {
        List<Integer> l = new ArrayList<>();
        List<Integer> r = new ArrayList<>();

        if (act != null) {
            l.add(act.getValue());
            if (act.getLeft() != null)
                l.addAll(getLongestBranch(act.getLeft()));

            r.add(act.getValue());
            if (act.getRight() != null)
                r.addAll(getLongestBranch(act.getRight()));

            if (l.size() > r.size())
                return l;
            else
                return r;
        }

        return new ArrayList<>();
    }

    //Get frontera
    public List<Integer> getFrontera() {
        ArrayList<Integer> res = new ArrayList<>();
        getFrontera(this.root, res);
        return res;
    }

    public void getFrontera(TreeNode act, List<Integer> res) {
        if (act != null) {
            if (act.getLeft() == null && act.getRight() == null)
                res.add(act.getValue());
        }
        getFrontera(act.getLeft(), res);
        getFrontera(act.getRight(), res);
    }

    //Get Max Elem
    public Integer getMaxElem() {
        if (this.root == null)
            return null;
        if (root.getLeft() == null && root.getRight() == null)
            return root.getValue();

        return getMaxElem(root);
    }

    private Integer getMaxElem(TreeNode act) {
        while (act.getRight() != null) {
            getMaxElem(act.getRight());
        }
        return act.getValue();
    }

    public List<Integer> getElemAtLevel(Integer level) {
        ArrayList<Integer> res = new ArrayList<>();
        return getElemAtLevel(root, level, 0, res);
    }

    private List<Integer> getElemAtLevel(TreeNode act, Integer level, Integer i, ArrayList<Integer> res) {
        if (i == level)
            res.add(act.getValue());

        if (i <= level) {
            getElemAtLevel(act.getLeft(), level, i + 1, res);
            getElemAtLevel(act.getRight(), level, i + 1, res);
        }
        return res;
    }

    //EJ 2
    public int getSumaNodosInternos() {
        return getSumaNodosInternos(this.root);
    }

    private int getSumaNodosInternos(TreeNode act) {
        if (act == null) return 0;

        if (act.getLeft() != null || act.getRight() != null) {
            return act.getValue() + getSumaNodosInternos(act.getLeft()) + getSumaNodosInternos(act.getRight());
        }

        return 0;
    }

    //EJ 3
    public List<Integer> getHojasMayoresAK(Integer K) {
        List<Integer> res = new ArrayList<>();
        return getHojasMayoresAK(K, root, res);
    }

    private List<Integer> getHojasMayoresAK(Integer K, TreeNode act, List<Integer> res) {
        if (act != null) {
            if (act.getLeft() == null && act.getRight() == null) {
                if (act.getValue() > K)
                    res.add(act.getValue());

            }
            getHojasMayoresAK(K, act.getLeft(), res);
            getHojasMayoresAK(K, act.getRight(), res);
        }
        return res;
    }

    //EJ 4
    public void fillTree() {
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

    private int fillTree(TreeNode act) {
        if (act.getLeft() != null && act.getRight() != null)
            act.setValue(fillTree(act.getRight()) - fillTree(act.getLeft()));

        else if (act.getLeft() == null && act.getRight() != null)
            act.setValue(fillTree(act.getRight()));

        else if (act.getLeft() != null && act.getRight() == null)
            act.setValue(fillTree(act.getLeft()));

        return act.getValue();
    }

    //EJ 5
    public List<String> getPalabrasConNVocales2(Integer N) {
        List<String> res = new ArrayList<>();
        return getPalabrasConNVocales2(root, N, 0, new String(), res);
    }

    private List<String> getPalabrasConNVocales2(TreeNode act, Integer N, Integer cant, String word, List<String> res) {
        if (act != null) {
            word += act.getValue();
            if (act.getValue() == 'A' || act.getValue() == 'E' || act.getValue() == 'I' || act.getValue() == 'O' || act.getValue() == 'U')
                cant++;

            if (act.getLeft() == null && act.getRight() == null) {
                if (cant == N)
                    res.add(word);
            }
            if (act.getLeft() != null)
                getPalabrasConNVocales2(act.getLeft(), N, cant, word, res);

            if (act.getRight() != null)
                getPalabrasConNVocales2(act.getRight(), N, cant, word, res);

        }
        return res;
    }


    //EJ 2 RECU
    public List<TreeNode> obtenerNivel(int k) {
        List<TreeNode> res = new ArrayList<>();
        obtenerNivel(root, 0, k, res);
        return res;
    }

    private void obtenerNivel(TreeNode act, int c, int k, List<TreeNode> res) {
        if (c == k)
            res.add(act);

        if (c <= k) {
            if (act.getRight() != null)
                obtenerNivel(act.getRight(), c + 1, k, res);

            if (act.getLeft() != null)
                obtenerNivel(act.getLeft(), c + 1, k, res);
        }

    }


    //OTRO EJ
    public List<List<Integer>> getBranchsMayoresAX(int X) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> parc = new ArrayList<>();

        getBranchsMayoresAX(root, X, 0, res, parc);
        return res;
    }

    private void getBranchsMayoresAX(TreeNode act, int X, int sum, List<List<Integer>> res, List<Integer> parc) {
        if (act != null) {
            sum += act.getValue();
            parc.add(act.getValue());
            if (act.getLeft() == null && act.getRight() == null) {
                if (sum > X) {
                    res.add(new ArrayList<>(parc));
                }
            } else {
                getBranchsMayoresAX(act.getLeft(), X, sum, res, parc);
                getBranchsMayoresAX(act.getRight(), X, sum, res, parc);
            }

            parc.remove(parc.size() - 1);
        }

    }
}
