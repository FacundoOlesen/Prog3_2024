package TP2.EJ3;

public class ConvertidorABinario {
    public static void main(String[] args) {
        int numeroAConvertir = 26;
        System.out.println("El numero: " + numeroAConvertir + " en binario es: " + convertirABinario(numeroAConvertir, ""));
    }

    public static String convertirABinario(int num, String resultado) {
        int cociente = (num / 2);
        String resto = String.valueOf(num % 2) + resultado;
        if (num >= 1) {
            resultado = convertirABinario(cociente, resto);
        }
        return resultado;
    }
}
