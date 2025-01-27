package TP2.EJ2;

public class BusquedaElemento {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 18, 19};
        System.out.println(busquedaBinaria(arr, 5, 0, arr.length));
    }

    public static int busquedaBinaria(int[] arr, int x, int inicio, int fin) {
        int medio;
        if (inicio > fin)
            return -1;
        else {
            medio = inicio + fin / 2;
            if (arr[medio] > x)
                return busquedaBinaria(arr, x, medio - 1, fin);
            else if (arr[medio] < x)
                return busquedaBinaria(arr, x, medio + 1, fin);
            else {
                return medio;
            }
        }
    }
}
