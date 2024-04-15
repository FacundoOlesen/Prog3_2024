package TP3.EJ1;

public class Tree {
    static final int COUNT = 10;

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

    public TreeNode getRootNode() {
        return this.root;
    }

    public Integer getRoot() {
        return this.root.getValue();
    }

    public boolean hasElem(TreeNode numAComparar, Integer elem) {
        if (numAComparar == null) return false;
        if (elem > numAComparar.getValue()) {
            return hasElem(numAComparar.getRight(), elem);
        } else if (elem < numAComparar.getValue()) {
            return hasElem(numAComparar.getLeft(), elem);
        }
        return elem == numAComparar.getValue();
    }


    public Boolean isEmpty() {
        return this.root == null;
    }

    public boolean delete(TreeNode root, Integer num) {
        if (!this.hasElem(root, num))
            return false;

        //CASO 1: EL NODO ES UNA HOJA
        if (root.getValue() == num) {
            //EL NODO ES UNA HOJA
            if (root.getRight() == null && root.getLeft() == null) {
                TreeNode padre = root;
                root.setValue(null);
                return true;
            }
        }

        //CASO 2: EL NODO TIENE UN SOLO HIJO
        //SI EL NODO A ELIMINAR ESTA A LA DERECHA:
        TreeNode rightNode = root.getRight();
        if (rightNode != null && rightNode.getValue() == num) {
            //EL NODO TIENE UN SOLO HIJO
            if (rightNode.getRight() != null && rightNode.getLeft() == null) {
                root.setRight(rightNode.getRight());
                return true;
            } else if (rightNode.getRight() == null && rightNode.getLeft() != null) {
                root.setRight(rightNode.getLeft());
                return true;
            }
        }

        //SI EL NODO A ELIMINAR ESTA A LA IZQUIERDA:
        TreeNode leftNode = root.getLeft();
        if (leftNode != null && leftNode.getValue() == num) {
            //EL NODO TIENE UN SOLO HIJO
            if (leftNode.getRight() != null && leftNode.getLeft() == null) {
                root.setLeft(leftNode.getRight());
                return true;

            } else if (leftNode.getRight() == null && leftNode.getLeft() != null) {
                root.setLeft(leftNode.getLeft());
                return true;
            }
        }

        //CASO 3: EL NODO TIENE 2 HIJOS
        if (root.getValue() == num && root.getRight() != null && root.getLeft() != null) {
            TreeNode raizSubArbolDerecho = root.getRight();
            TreeNode NMISD = raizSubArbolDerecho;
            while (NMISD.getLeft() != null) {
                NMISD = NMISD.getLeft();
            }
            //EL NMISD ES HOJA
            if (NMISD.getRight() == null && NMISD.getLeft() == null) {
                root.setValue(NMISD.getValue());
                NMISD.setValue(null);
            }
            //EL NMISD TIENE UN SOLO HIJO
            if (NMISD.getRight() != null && NMISD.getLeft() == null) {
                root.setValue(NMISD.getValue());
                NMISD.setValue(NMISD.getRight().getValue());
                NMISD.setRight(null);
                return true;
            }
            return true;
        }

        //RECORRO NODOS
        if (num > root.getValue())
            return delete(root.getRight(), num);

        if (num < root.getValue()) {
            return delete(root.getLeft(), num);
        }

        return false;
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
