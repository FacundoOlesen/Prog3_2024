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

        TreeNode right = root.getRight();
        //EL NUM ESTA EN LA RAMA DER
        if (right != null) {
            TreeNode nodoBuscado = root.getRight();
            if (nodoBuscado.getValue() == num) {
                TreeNode padre = root;
                //EL NODO ES UNA HOJA
                if (nodoBuscado.getRight() == null && nodoBuscado.getLeft() == null && nodoBuscado.getValue() == num) {
                    root.setRight(null);
                    return true;
                }

                //EL NODO TIENE UN SOLO HIJO
                if (nodoBuscado.getRight() == null && nodoBuscado.getLeft() != null && nodoBuscado.getValue() == num) {
                    root.setRight(nodoBuscado.getLeft());
                    return true;
                } else if (nodoBuscado.getRight() != null && nodoBuscado.getLeft() == null) {
                    root.setRight(nodoBuscado.getRight());
                    return true;
                }
                //EL NODO TIENE LOS DOS HIJOS
                if (padre.getRight() != null && padre.getLeft() != null && padre.getValue() == num) {
                    TreeNode padreSubArbDer = padre.getRight();
                    //OBTENER EL NODO MAYOR IZQUIERDO DEL SUB ARBOL DERECHO
                    while (padreSubArbDer.getLeft() != null) {
                        TreeNode NMI = padreSubArbDer.getLeft();
                        padreSubArbDer = NMI;
                    }
                    //ROOT = NODO MAYOR IZQUIERDO DEL SUB ARBOL DERECHO
                    padre.setValue(padreSubArbDer.getValue());
                    //BORRAR EL NODO MAS IZQUIERDO DEL SUBARBOL DERECHO DE SU LUGAR ORIGINAL.
                    padreSubArbDer.setValue(null);
                    return true;
                }
            }

        }


        TreeNode left = root.getLeft();
        //EL NUM ESTA EN LA RAMA IZQ
        if (left != null || left.getValue() == num) {
            TreeNode nodoBuscado = root.getLeft();
            if (nodoBuscado.getValue() == num) {
                TreeNode padre = root;
                //EL NODO ES UNA HOJA
                if (nodoBuscado.getLeft() == null && nodoBuscado.getRight() == null && nodoBuscado.getValue() == num) {
                    root.setLeft(null);
                    return true;
                }

                //EL NODO TIENE UN SOLO HIJO
                if (nodoBuscado.getRight() == null && nodoBuscado.getLeft() != null) {
                    root.setLeft(nodoBuscado.getLeft());
                    return true;
                } else if (nodoBuscado.getRight() != null && nodoBuscado.getLeft() == null) {
                    root.setLeft(nodoBuscado.getRight());
                    return true;
                }

                //EL NODO TIENE LOS DOS HIJOS
                if (padre.getRight() != null && padre.getLeft() != null && padre.getValue() == num) {
                    TreeNode padreSubArbDer = padre.getRight();
                    //OBTENER EL NODO MAYOR IZQUIERDO DEL SUB ARBOL DERECHO
                    while (padreSubArbDer.getLeft() != null) {
                        TreeNode NMI = padreSubArbDer.getLeft();
                        padreSubArbDer = NMI;
                    }
                    //ROOT = NODO MAYOR IZQUIERDO DEL SUB ARBOL DERECHO
                    padre.setValue(padreSubArbDer.getValue());
                    //BORRAR EL NODO MAS IZQUIERDO DEL SUBARBOL DERECHO DE SU LUGAR ORIGINAL.
                    padreSubArbDer.setValue(null);
                    return true;
                }
            }
        }
        //ITERO
        if (num > root.getValue())
            return delete(root.getRight(), num);

        if (num < root.getValue()) {
            return delete(root.getLeft(), num);
        }

        if (num == root.getValue())
            return delete(root, num);
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
