package TP2.EJ3;

public class ConvertidorABinario {
    public static void main(String[] args) {
        int numeroAConvertir = 26;
        System.out.println("El numero: " + numeroAConvertir + " en binario es: " + convertirABinario(numeroAConvertir, ""));
    }

    public static String convertirABinario(int num, String res) {
        if (num >= 1) {
            res = convertirABinario((num / 2), String.valueOf(num % 2)) +res;
        }
        return res;
    }
}
