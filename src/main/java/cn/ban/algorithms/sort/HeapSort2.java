package cn.ban.algorithms.sort;

import cn.ban.algorithms.heap.MaxHeap;

import static cn.ban.algorithms.sort.util.SortUtil.*;

/**
 * @author banzijian
 * @date 2018/10/26
 **/
public class HeapSort2 {
    public static void sort(Comparable[] arr) {
        MaxHeap<Comparable> heap = new MaxHeap(arr);
        for (int i = arr.length-1; i >= 0; i--) {
            arr[i] = heap.pop();
        }
    }

    public static void main(String[] args) {
        testSort("cn.ban.algorithms.sort.HeapSort2", generateRandomArr(10000000, 0, 10000000));
        testSort("cn.ban.algorithms.sort.HeapSort2", generateSortedArr(10000000, 50));
    }
}
