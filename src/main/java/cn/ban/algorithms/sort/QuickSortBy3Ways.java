package cn.ban.algorithms.sort;

import java.util.Random;

import static cn.ban.algorithms.sort.util.SortUtil.*;

/**
 * @author banzijian
 * @date 2018/10/10
 **/
public class QuickSortBy3Ways {
    public static void sort(Comparable[] arr){
        sort(arr, 0, arr.length-1);
    }

    private static void sort(Comparable[] arr, int l, int r) {
        if (l > r) {
            return;
        }
        int randomInt = (int) Math.random() * r + l;
        swap(arr, randomInt, l);
        Comparable flag = arr[l];
        // [l+1, lt]<flag [lt+1, i-1]=flag [gt, r]>flag
        int lt = l, gt = r + 1, i = l + 1;
        while (i < gt) {
            if (arr[i].compareTo(flag) < 0) {
                swap(arr, ++lt, i++);
            } else if (arr[i].compareTo(flag) == 0) {
                i++;
            } else {
                swap(arr, i, --gt);
            }
        }
        swap(arr, l, lt);
        sort(arr, l, lt - 1);
        sort(arr, gt, r);
    }

    public static void main(String[] args) {
        testSort("cn.ban.algorithms.sort.QuickSortBy3Ways", generateRandomArr(100000, 0, 50));
        testSort("cn.ban.algorithms.sort.QuickSortBy3Ways", generateSortedArr(100000, 50));
    }
}
