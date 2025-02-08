package Practicando;

public class Practica {
    public double factorial(int n) {
        if (n > 1) {
            return (n * factorial(n - 1));
        } else
            return 1;
    }


    public static void main(String[] ar) {
        Practica re = new Practica();
        System.out.println(re.factorial(5));
    }
}
