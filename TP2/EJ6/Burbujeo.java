package TP2.EJ6;

public class Burbujeo {
    public static void main(String[] args) {
        int[] arr = {2, 3, 12, 2};
        burbujeo(arr);
    }

    public static void burbujeo(int[] A) {
        int i, j, aux;
        for (i = 0; i < A.length - 1; i++) {
            for (j = 0; j < A.length - i - 1; j++) {
                if (A[j] > A[j + 1]) {
                    aux = A[j + 1];
                    A[j + 1] = A[j];
                    A[j] = aux;
                }
            }
        }
    }


}


