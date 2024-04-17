package TP2.EJ7;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {2, 4, 1, 3, 7};
        quickSort(arr, 0, arr.length);
    }

    public static void quickSort(int[] arr, int ini, int fin) {
        if (ini >= fin) return;
        int pivote = arr[ini];
        int elemIzq = ini + 1;
        int elemDer = fin;
        while (elemIzq <= elemDer) {
            while (elemIzq <= fin && arr[elemIzq] < pivote) {
                elemIzq++;
            }
            while (elemDer > ini && arr[elemDer] >= pivote) {
                elemDer--;
            }
            if (elemIzq < elemDer) {
                int temp = arr[elemIzq];
                arr[elemIzq] = arr[elemDer];
                arr[elemDer] = temp;
            }
        }

        if (elemDer > ini) {
            int temp = arr[ini];
            arr[ini] = arr[elemDer];
            arr[elemDer] = temp;
        }
        quickSort(arr, ini, elemDer - 1);
        quickSort(arr, elemDer + 1, fin);
    }
}
