package cn.ban.algorithms.sort;

import javax.swing.*;

import static cn.ban.algorithms.sort.util.SortUtil.*;

/**
 *
 * @author banzijian
 * @date 2018/09/03
 **/
public class InsertionSort {
    public static void sort(Comparable[] arr) {
        for (int i = 1; i < arr.length; i++) {
            Comparable temp = arr[i];
            int j;
            for (j = i; j > 0 && temp.compareTo(arr[j - 1]) < 0; j--) {
                arr[j] = arr[j - 1];
            }
            arr[j] = temp;
        }
    }

    public static void main(String[] args) {
        testSort("cn.ban.algorithms.sort.InsertionSort", generateRandomArr(100000, 0, 5000));
        testSort("cn.ban.algorithms.sort.InsertionSort", generateSortedArr(100000, 50));
    }
}
