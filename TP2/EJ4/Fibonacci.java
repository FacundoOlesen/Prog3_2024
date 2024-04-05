package TP2.EJ4;

public class Fibonacci {
    public static void main(String[] args) {
        String res = "0 1";
        System.out.println(fibonacci(2, 20, 0, 1, res));
    }

    public static String fibonacci(int cant, int N, int anterior, int siguiente, String res) {
        if (cant < N) {
            int suma = siguiente + anterior;
            anterior = siguiente;
            siguiente = suma;
            cant++;
            res = fibonacci(cant, N, anterior, siguiente, res + " " + String.valueOf(suma));
        }
        return res;
    }
}
