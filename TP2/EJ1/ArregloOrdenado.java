package TP2.EJ1;

public class ArregloOrdenado {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 18, 19};
        System.out.println(isOrdered(arr, 0));
    }

    public static boolean isOrdered(int[] arr, int n) {
        if (n < arr.length - 1 && (arr[n] < arr[n + 1]))
            return isOrdered(arr, n + 1);
        else
            return n == arr.length - 1;
    }
}