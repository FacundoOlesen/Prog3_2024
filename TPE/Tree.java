package TPE;

public class Tree<T extends Comparable<T>> { //ACA TENDRIA QUE HACER EL ARBOL VALIDO PARA CUALQ OBJETO
    private TreeNode<T> root;

    public Tree() {
        this.root = null;
    }

    public void add(T value) {
        if (this.root == null) this.root = new TreeNode<>(value);
        else this.add(this.root, value);
    }

    private void add(TreeNode<T> actual, T value) {
        if (actual.getValue().compareTo(value) < 0) {
            if (actual.getLeft() == null) {
                TreeNode<T> temp = new TreeNode<>(value);
                actual.setLeft(temp);
            } else {
                add(actual.getLeft(), value);
            }
        } else if (actual.getValue().compareTo(value) > 0) {

            if (actual.getRight() == null) {
                TreeNode<T> temp = new TreeNode<>(value);
                actual.setRight(temp);
            } else {
                add(actual.getRight(), value);
            }
        }
    }

    public TreeNode<T> getRoot() {
        return this.root;
    }


}