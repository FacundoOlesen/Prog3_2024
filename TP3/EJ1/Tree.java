package TP3.EJ1;

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

    public Integer getRoot() {
        return this.root.getValue();
    }

    public boolean hasElem(Integer elem) {
        return hasElem(this.root, elem);
    }

    private boolean hasElem(TreeNode numAComparar, Integer elem) {
        if (numAComparar == null) return false;
        if (elem > numAComparar.getValue()) return hasElem(numAComparar.getRight(), elem);

        else if (elem < numAComparar.getValue()) return hasElem(numAComparar.getLeft(), elem);

        return elem == numAComparar.getValue();
    }


    public Boolean isEmpty() {
        return this.root == null;
    }

    public boolean delete(Integer num) {
        return delete(this.root, num);
    }

    private boolean delete(TreeNode root, Integer num) {
        if (root == null) return false;
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
                return true;
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
                return true;
            }


        }
        //SI EL NODO A ELIMINAR ES LA RAIZ:
        if (root != null && root.getValue() == num) {
            //CASO 1: LA RAIZ ES UNA HOJA
            if (root.getRight() == null && root.getLeft() == null) {
                this.root = null;
                return true;
            }

            //CASO 2: LA RAIZ TIENE UN SOLO HIJO
            if (root.getRight() != null && root.getLeft() == null) {
                this.root = root.getRight();
                return true;

            } else if (root.getRight() == null && root.getLeft() != null) {
                this.root = root.getLeft();
                return true;
            }

            //CASO 3: LA RAIZ TIENE 2 HIJOS
            if (root.getRight() != null && root.getLeft() != null) {
                TreeNode NMISD = root.getRight();
                while (NMISD.getLeft() != null) {
                    NMISD = NMISD.getLeft();
                }

                root.setValue(NMISD.getValue());
                delete(root, NMISD.getValue());
                return true;
            }
        }

        //RECORRO NODOS
        if (num > root.getValue()) return delete(root.getRight(), num);

        if (num < root.getValue()) return delete(root.getLeft(), num);

        return false;
    }

    public int getHeight() {
        if (root == null || (root.getRight() == null && root.getLeft() == null)) return 0;
        return getHeight(this.root);
    }

    private int getHeight(TreeNode root) {
        int rightHeight = 0;
        int leftHeight = 0;
        if (root.getLeft() != null) leftHeight = getHeight(root.getLeft());

        if (root.getRight() != null) rightHeight = getHeight(root.getRight());

        if (leftHeight > rightHeight) return leftHeight + 1;

        else return rightHeight + 1;
    }

    public void printPostOrder() {
        printPostOrder(this.root);
    }

    private void printPostOrder(TreeNode node) {
        if (node == null) {
            System.out.println("-");
            return;
        }
        printPostOrder(node.getLeft());
        printPostOrder(node.getRight());
        System.out.println(node.getValue() + " ");
    }

    public void printPreOrder() {
        printPreOrder(this.root);
    }

    private void printPreOrder(TreeNode node) {
        if (node == null) {
            System.out.println("-");
            return;
        }
        System.out.println(node.getValue() + " ");
        printPreOrder(node.getLeft());
        printPreOrder(node.getRight());
    }

    public void printInOrder() {
        printInOrder(this.root);
    }

    private void printInOrder(TreeNode node) {
        if (node == null) {
            System.out.println("-");
            return;
        }
        printInOrder(node.getLeft());
        System.out.println(node.getValue() + " ");
        printInOrder(node.getRight());
    }

    public TreeNode getRootNode() {
        return this.root;
    }

    public List<Integer> getLongestBranch() {
        if (this.root == null)
            return new ArrayList<>();
        return getLongestBranch(this.root);
    }

    private List<Integer> getLongestBranch(TreeNode node) {
        ArrayList<Integer> ramaIzq = new ArrayList<>();
        ArrayList<Integer> ramaDer = new ArrayList<>();
        if (node != null) {
            ramaIzq.add(node.getValue());
            if (node.getLeft() != null) {
                ramaIzq.addAll(getLongestBranch(node.getLeft()));
            }

            ramaDer.add(node.getValue());
            if (node.getRight() != null)
                ramaDer.addAll(getLongestBranch(node.getRight()));

            if (ramaIzq.size() >= ramaDer.size())
                return ramaIzq;

            else if (ramaDer.size() > ramaIzq.size()) {
                return ramaDer;
            }

        }
        return new ArrayList<>();
    }

    public Integer getMaxElem() {
        return getMaxElem(this.root);
    }

    private Integer getMaxElem(TreeNode node) {
        while (node.getRight() != null) {
            node = node.getRight();
        }
        return node.getValue();
    }

    public List<Integer> getElemAtLevel(int level) {
        ArrayList<Integer> res = new ArrayList<>();
        getElemAtLevel(this.root, level, 0, res);
        return res;
    }

    private void getElemAtLevel(TreeNode node, int level, int cant, ArrayList<Integer> res) {
        if (cant == level)
            res.add(node.getValue());
        if (cant <= level) {
            getElemAtLevel(node.getLeft(), level, cant + 1, res);
            getElemAtLevel(node.getRight(), level, cant + 1, res);
        }

    }

    public List<Integer> getFrontera() {
        ArrayList<Integer> res = new ArrayList<>();
        getFrontera(this.root, res);
        return res;
    }

    private void getFrontera(TreeNode node, ArrayList<Integer> res) {
        if (node != null) {
            if (node.getLeft() == null && node.getRight() == null) {
                res.add(node.getValue());
            }
            getFrontera(node.getLeft(), res);
            getFrontera(node.getRight(), res);
        }
    }
}