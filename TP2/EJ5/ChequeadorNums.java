package TP2.EJ5;

public class ChequeadorNums {
    public static void main(String[] args) {
        int[] arr = {-3, -1, 0, 2, 4, 6, 10};
        System.out.println(existe(arr, 0));
    }

    public static boolean existe(int[] arr, int ini) {
        boolean esIgual = arr[ini] == ini;
        if (ini < arr.length - 1 && !esIgual) {
            return existe(arr, ini + 1);
        }
        return esIgual;
    }
}
