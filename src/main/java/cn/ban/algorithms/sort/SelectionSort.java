package cn.ban.algorithms.sort;

import static cn.ban.algorithms.sort.util.SortUtil.*;

/**
 * 选出剩余数中最小值依次放在前面
 * @author banzijian
 * @date 2018/09/03
 **/
public class SelectionSort {
    public static void sort(Comparable[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            for (int j = i+1; j < arr.length; j++) {
                if (arr[minIndex].compareTo(arr[j]) > 0) {
                    minIndex = j;
                }
            }
            Comparable temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }

    public static void main(String[] args) {
        testSort("cn.ban.algorithms.sort.SelectionSort", generateRandomArr(100000, 0, 50));
    }
}
