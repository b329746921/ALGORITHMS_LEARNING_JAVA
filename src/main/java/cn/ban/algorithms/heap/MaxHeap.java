package cn.ban.algorithms.heap;

/**
 * 最大堆
 *
 * @author banzijian
 * @date 2018/10/26
 **/
public class MaxHeap<T extends Comparable> {
    private T[] data;
    private int count;
    private int capacity;

    public MaxHeap() {
        this(16);
    }

    public MaxHeap(int capacity) {
        data = (T[]) new Comparable[capacity];
        this.capacity = capacity;
    }

    public MaxHeap(T[] arr) {
        heapify(arr);
    }

    public void insert(T item) {
        if (count == capacity) {
            reSize();
        }
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
        while (index > 0 && data[parentIndex(index)].compareTo(data[index]) < 0) {
            swap(parentIndex(index), index);
            index = parentIndex(index);
        }
    }

    private void shiftDown(int index) {
        while (leftChildIndex(index) < count - 1) {
            int j = leftChildIndex(index);
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

    private void reSize() {
        int newCapcity = capacity << 1;
        T[] newData = (T[]) new Comparable[newCapcity];
        for (int i = 0; i < data.length; i++) {
            newData[i] = data[i];
        }
        capacity = newCapcity;
        data = newData;
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

    private int leftChildIndex(int index) {
        return index * 2 + 1;
    }

    private int rightChildIndex(int index) {
        return index * 2 + 2;
    }

    private int parentIndex(int index) {
        return (index - 1) / 2;
    }
}
