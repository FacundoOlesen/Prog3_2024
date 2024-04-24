package TP3.EJ6;

import java.util.ArrayList;
import java.util.List;

public class Tree {
    static final int COUNT = 10;


    private TreeNode root;

    public TreeNode getRoot() {
        return root;
    }

    public Tree() {
        this.root = null;
    }

    public void add(Libro libro) {
        if (this.root == null) this.root = new TreeNode(libro);
        else this.add(this.root, libro);
    }

    private void add(TreeNode actual, Libro libro) {
        if (actual.getValue().getId() > libro.getId()) {
            if (actual.getLeft() == null) {
                TreeNode temp = new TreeNode(libro);
                actual.setLeft(temp);
            } else {
                add(actual.getLeft(), libro);
            }
        } else if (actual.getValue().getId() < libro.getId()) {
            if (actual.getRight() == null) {
                TreeNode temp = new TreeNode(libro);
                actual.setRight(temp);
            } else {
                add(actual.getRight(), libro);
            }
        }
    }

    public int getCantEjemplares(int id) {
        return getCantEjemplares(this.root, id);
    }

    public int getCantEjemplares(TreeNode node, int id) {
        if (node != null) {
            if (id < node.getValue().getId())
                return getCantEjemplares(node.getLeft(), id);

            if (id > node.getValue().getId())
                return getCantEjemplares(node.getRight(), id);

            if (id == node.getValue().getId())
                return node.getValue().getCantEjemplares();
        }

        return -1;
    }

    public ArrayList<Libro> getLibrosByGenero(String genero) {
        ArrayList<Libro> res = new ArrayList<>();
        getLibrosByGenero(this.root, genero, res);
        return res;
    }

    private void getLibrosByGenero(TreeNode node, String genero, ArrayList<Libro> res) {
        if (node.getValue().getGeneros().contains(genero))
            res.add(node.getValue());

        if (node.getLeft() != null)
            getLibrosByGenero(node.getLeft(), genero, res);
        if (node.getRight() != null)
            getLibrosByGenero(node.getRight(), genero, res);
    }

    public ArrayList<Libro> getLibrosEntreAnios(int desde, int hasta) {
        ArrayList<Libro> res = new ArrayList<>();
        getLibrosEntreAnios(this.root, desde, hasta, res);
        return res;
    }

    private void getLibrosEntreAnios(TreeNode node, int desde, int hasta, ArrayList<Libro> res) {
        if (node.getValue().getAnioPublicacion() >= desde && node.getValue().getAnioPublicacion() <= hasta)
            res.add(node.getValue());

        if (node.getLeft() != null)
            getLibrosEntreAnios(node.getLeft(), desde, hasta, res);
        if (node.getRight() != null)
            getLibrosEntreAnios(node.getRight(), desde, hasta, res);
    }

}