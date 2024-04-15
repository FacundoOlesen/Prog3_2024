package Practicando;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {20, 10, 9};
        BubbleSort b = new BubbleSort();
        b.bubbleSortAdapt(arr);
    }

    public void bubbleSortAdapt(int[] arr) {
        boolean swapped = true;
        int j = 0;
        int tmp;
        while (swapped) {
            swapped = false;
            j++;
            for (int i = 0; i < arr.length - j; i++) {
                if (arr[i] > arr[i + 1]) {
                    tmp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = tmp;
                    swapped = true;
                }
            }
        }
    }
}
