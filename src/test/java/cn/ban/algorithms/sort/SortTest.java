package cn.ban.algorithms.sort;

import static cn.ban.algorithms.sort.util.SortUtil.*;

/**
 * @author banzijian
 * @date 2018/09/03
 **/
public class SortTest {

    public static void main(String[] args) {
        int lenght1 = 50000, left = 0, right = 5000;
        System.out.println("无序数组 数组长度: " + lenght1 + " 最小值: " + left + " 最大值: " + right);
        testSort("cn.ban.algorithms.sort.BubbleSort", generateRandomArr(lenght1, left, right));
        testSort("cn.ban.algorithms.sort.SelectionSort", generateRandomArr(lenght1, left, right));
        testSort("cn.ban.algorithms.sort.InsertionSort", generateRandomArr(lenght1, left, right));
        testSort("cn.ban.algorithms.sort.QuickSort", generateRandomArr(lenght1, left, right));
        int lenght2 = 100000, offset = 500;
        System.out.println("基本有序数组 数组长度: " + lenght2 + " 偏移量: " + offset);
        testSort("cn.ban.algorithms.sort.BubbleSort", generateSortedArr(lenght2, offset));
        testSort("cn.ban.algorithms.sort.SelectionSort", generateSortedArr(lenght2, offset));
        testSort("cn.ban.algorithms.sort.InsertionSort", generateSortedArr(lenght2, offset));
        testSort("cn.ban.algorithms.sort.QuickSort", generateSortedArr(lenght2, offset));
    }
}
