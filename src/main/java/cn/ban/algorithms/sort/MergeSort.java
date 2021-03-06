package cn.ban.algorithms.sort;

import java.util.Arrays;

import static cn.ban.algorithms.sort.util.SortUtil.*;

/**
 * 归并排序
 *
 * @author banzijian
 * @date 2018/10/25
 **/
public class MergeSort {
    public static void sort(Comparable[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    private static void sort(Comparable[] arr, int l, int r) {
        if (l >= r) {
            return;
        }
        int mid = (l + r) / 2;
        sort(arr, l, mid);
        sort(arr, mid + 1, r);
        merge(arr, l, mid, r);
    }

    private static void merge(Comparable[] arr, int l, int mid, int r) {
        //辅助空间
        Comparable[] aux = Arrays.copyOfRange(arr, l, r + 1);
        // merge arr[l,mid]和arr[mid+1,r]
        int i = l, j = mid + 1;
        for (int k = l; k <= r; k++) {
            if (i > mid) {
                arr[k] = aux[j - l];
                j++;
            } else if (j > r) {
                arr[k] = aux[i - l];
                i++;
            } else if (aux[i - l].compareTo(aux[j - l]) < 0) {
                arr[k] = aux[i - l];
                i++;
            } else {
                arr[k] = aux[j - l];
                j++;
            }
        }
    }

    public static void main(String[] args) {
        testSort("cn.ban.algorithms.sort.MergeSort", generateRandomArr(100000, 0, 50));
        testSort("cn.ban.algorithms.sort.MergeSort", generateSortedArr(100000, 50));
    }
}
