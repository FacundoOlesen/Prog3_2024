package Practicando;

public class CuboPrac {
    public int calcular(int x, int n) {
        if (n <= 0) {
            return 1;
        } else {
            return x * calcular(x, n - 1);
        }
    }


    public static void main(String[] args) {
        CuboPrac re = new CuboPrac();
        System.out.println(re.calcular(5, 3));
    }
}
