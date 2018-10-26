package cn.ban.algorithms.heap;

/**
 * @author banzijian
 * @date 2018/10/26
 **/
public class MaxHeap<T extends Comparable> {
    private T[] data;
    private int count;
    private int capacity;

    public MaxHeap() {
        this(10000000);
    }

    public MaxHeap(int capacity) {
        data = (T[]) new Comparable[capacity];
        this.capacity = capacity;
    }

    public MaxHeap(T[] arr) {
        heapify(arr);
    }

    public void insert(T item) {
        data[count] = item;
        shiftUp(count);
        count++;
    }

    public T pop() {
        if (isEmpty()) {
            return null;
        }
        T result = data[0];
        swap(0, count - 1);
        shiftDown(0);
        count--;
        return result;
    }

    private void heapify(T[] arr) {
        int n = arr.length;
        data = (T[]) new Comparable[n];
        capacity = n;

        for (int i = 0; i < n; i++)
            data[i] = arr[i];
        count = n;

        for (int i = count / 2 - 1; i >= 1; i--)
            shiftDown(i);
    }

    private void shiftUp(int index) {
        while (index > 0 && data[(index - 1) / 2].compareTo(data[index]) < 0) {
            swap((index - 1) / 2, index);
            index = (index - 1) / 2;
        }
    }

    private void shiftDown(int index) {
        while (index * 2 + 1 < count - 1) {
            int j = index * 2 + 1;
            if (j + 1 < count - 1 && data[j].compareTo(data[j + 1]) < 0) {
                j++;
            }
            if (data[index].compareTo(data[j]) >= 0) {
                break;
            }
            swap(index, j);
            index = j;
        }
    }

    public int size() {
        return count;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    private void swap(int l, int r) {
        T temp = data[l];
        data[l] = data[r];
        data[r] = temp;
    }
}
