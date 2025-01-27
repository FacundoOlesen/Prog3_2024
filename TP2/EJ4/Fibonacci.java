package TP2.EJ4;

public class Fibonacci {
    public static void main(String[] args) {
        System.out.println(fibonacci(11));
    }

    public static String fibonacci(int N) {
        int cant = 2;
        int anterioranterior = 0;
        int anterior = 1;
        String res = String.valueOf(anterioranterior) + " " + String.valueOf(anterior);
        return doFibonacci(cant, N, anterioranterior, anterior, res);
    }

    private static String doFibonacci(int cant, int N, int anterioranterior, int anterior, String res) {
        if (cant < N) {
            int suma = anterior + anterioranterior;
            anterioranterior = anterior;
            anterior = suma;
            cant++;
            res = doFibonacci(cant, N, anterioranterior, anterior, res + " " + String.valueOf(suma));
        }
        return res;
    }
}
