package cn.ban.algorithms.sort;

import static cn.ban.algorithms.sort.util.SortUtil.*;

/**
 * 每次将相邻两数对比，不符合排序条件则交换位置
 * @author banzijian
 * @date 2018/08/30
 **/
public class BubbleSort {
    public static void sort(Comparable[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j].compareTo(arr[j + 1]) > 0) {
                    Comparable temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        testSort("cn.ban.algorithms.sort.BubbleSort", generateRandomArr(100000, 0, 50));
    }
}
