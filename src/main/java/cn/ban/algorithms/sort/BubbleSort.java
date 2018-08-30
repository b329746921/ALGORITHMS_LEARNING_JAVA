package cn.ban.algorithms.sort;

/**
 * @author banzijian
 * @date 2018/08/30
 **/
public class BubbleSort {
    public static void sort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {4, 6, 1, 3};
        sort(arr);
        for (int i : arr) {
            System.out.println(i);
        }
    }
}
