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

    public Integer getRoot() {
        return this.root.getValue();
    }

    public boolean hasElem(Integer elem) {
        return hasElem(this.root, elem);
    }

    private boolean hasElem(TreeNode numAComparar, Integer elem) {
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

    public boolean delete(Integer num) {
        return delete(this.root, num);
    }

    private boolean delete(TreeNode root, Integer num) {
        if (this.root == null || !this.hasElem(root, num)) return false;

        //SI EL NODO A ELIMINAR ESTA A LA DERECHA:
        TreeNode rightNode = root.getRight();
        if (rightNode != null && rightNode.getValue() == num) {
            //CASO 1: EL NODO A ELIMINAR ES UNA HOJA
            if (rightNode.getRight() == null && rightNode.getLeft() == null) {
                root.setRight(null);
                return true;
            }

            //CASO 2: EL NODO A ELIMINAR TIENE UN SOLO HIJO
            if (rightNode.getRight() != null && rightNode.getLeft() == null) {
                root.setRight(rightNode.getRight());
                return true;
            } else if (rightNode.getRight() == null && rightNode.getLeft() != null) {
                root.setRight(rightNode.getLeft());
                return true;
            }

            //CASO 3: EL NODO A ELIMINAR TIENE 2 HIJOS
            if (rightNode.getRight() != null && rightNode.getLeft() != null) {
                TreeNode NMISD = rightNode.getRight();
                while (NMISD.getLeft() != null) {
                    NMISD = NMISD.getLeft();
                }
                rightNode.setValue(NMISD.getValue());
                delete(rightNode, NMISD.getValue());
            }
        }

        //SI EL NODO A ELIMINAR ESTA A LA IZQUIERDA:
        TreeNode leftNode = root.getLeft();
        if (leftNode != null && leftNode.getValue() == num) {
            //CASO 1: EL NODO A ELIMINAR ES UNA HOJA
            if (leftNode.getRight() == null && leftNode.getLeft() == null) {
                root.setLeft(null);
                return true;
            }

            //CASO 2: EL NODO A ELIMINAR TIENE UN SOLO HIJO
            if (leftNode.getRight() != null && leftNode.getLeft() == null) {
                root.setLeft(leftNode.getRight());
                return true;

            } else if (leftNode.getRight() == null && leftNode.getLeft() != null) {
                root.setLeft(leftNode.getLeft());
                return true;
            }
            //CASO 3: EL NODO A ELIMINAR TIENE 2 HIJOS
            if (leftNode.getRight() != null && leftNode.getLeft() != null) {
                TreeNode NMISD = leftNode.getRight();
                while (NMISD.getLeft() != null) {
                    NMISD = NMISD.getLeft();
                }

                leftNode.setValue(NMISD.getValue());
                delete(leftNode, NMISD.getValue());
            }
        }

        //RECORRO NODOS
        if (num > root.getValue())
            return delete(root.getRight(), num);

        if (num < root.getValue()) {
            return delete(root.getLeft(), num);
        }

        return false;
    }


    public int getHeight(TreeNode root) {
        int rightHeight = 0;
        int leftHeight = 0;
        if (root.getRight() != null) {
            rightHeight += getHeight(root.getRight());
        }
        if (root.getLeft() != null) {
            leftHeight += getHeight(root.getLeft());
        }
        return rightHeight + 1;
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

    public TreeNode getRootNode() {
        return root;
    }
}