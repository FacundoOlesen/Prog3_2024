package TP2.EJ6;

public class Seleccion {
    public static void main(String[] args) {
        int[] arr = {2, 7, 3, 4};
        seleccion(arr);
    }

    public static void seleccion(int[] arr) {
        int i, j, menor, pos, tmp;
        for (i = 0; i < arr.length; i++) { // tomamos como menor el primero
            menor = arr[i]; // de los elementos que quedan por ordenar
            pos = i; // y guardamos su posición
            for (j = i + 1; j < arr.length; j++) { // buscamos en el resto
                if (arr[j] < menor) { // del array algún elemento
                    menor = arr[j]; // menor que el actual
                    pos = j;
                }
            }
            if (pos != i) { // si hay alguno menor se intercambia
                tmp = arr[i];
                arr[i] = arr[pos];
                arr[pos] = tmp;
            }
        }
    }
}
