package cn.ban.algorithms.sort;

import static cn.ban.algorithms.sort.util.SortUtil.*;

/**
 * @author banzijian
 * @date 2018/09/11
 **/
public class QuickSort {
    public static void sort(Comparable[] arr){
        sort(arr, 0, arr.length-1);
    }

    private static void sort(Comparable[] arr, int l, int r){
        if (r < l) {
            return;
        }
        int p = partition(arr, l, r);
        sort(arr, l, p-1);
        sort(arr, p+1, r);
    }

    private static int partition(Comparable[] arr, int l, int r){
        Comparable flag = arr[l];
        //arr[l+1]-arr[j]  arr[j+1]-arr[i-1]
        int j = l;
        for (int i = l+1; i <= r; i++) {
            if (flag.compareTo(arr[i]) < 0) {
                Comparable temp = arr[j + 1];
                arr[j + 1] = arr[i];
                arr[i] = temp;
                j++;
            }
        }
        Comparable temp = arr[j];
        arr[j] = arr[l];
        arr[l] = temp;
        return j;
    }

    public static void main(String[] args) {
        testSort("cn.ban.algorithms.sort.QuickSort", generateRandomArr(100000, 0, 5000));
        testSort("cn.ban.algorithms.sort.QuickSort", generateSortedArr(100000, 50));
    }
}
