package cn.ban.algorithms.sort.util;

import java.lang.reflect.Method;

/**
 * @author banzijian
 * @date 2018/09/03
 **/
public class SortUtil {
    public static Integer[] generateRandomArr(int length, int left, int right) {
        Integer[] arr = new Integer[length];
        for (int i = 0; i < length; i++) {
            arr[i] = (int)(Math.random() * right + left);
        }
        return arr;
    }

    public static Integer[] generateSortedArr(int length, int offset) {
        Integer[] arr = new Integer[length];
        for (int i = 0; i < length; i++) {
            arr[i] = i;
        }
        for (int i = 0; i < offset; i++) {
            int left = (int)(Math.random() * length);
            int right = (int)(Math.random() * length);
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
        }
        return arr;
    }

    public static Boolean isSorted(Comparable[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].compareTo(arr[i + 1]) > 0) {
                return false;
            }
        }
        return true;
    }

    public static void swap(Comparable[] arr, int i, int j){
        Comparable temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void testSort(String sortClassName, Comparable[] arr) {
        // 通过Java的反射机制，通过排序的类名，运行排序函数
        try {
            // 通过sortClassName获得排序函数的Class对象
            Class sortClass = Class.forName(sortClassName);
            // 通过排序函数的Class对象获得排序方法
            Method sortMethod = sortClass.getMethod("sort", new Class[]{Comparable[].class});
            // 排序参数只有一个，是可比较数组arr
            Object[] params = new Object[]{arr};

            long startTime = System.currentTimeMillis();
            // 调用排序函数
            sortMethod.invoke(null, params);
            long endTime = System.currentTimeMillis();

            assert isSorted(arr);

            System.out.println(sortClass.getSimpleName() + " : " + (endTime - startTime) + "ms");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
