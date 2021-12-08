package algorithm.bubble;

import java.util.Arrays;

public class ArrayBub {
    private long[] array;
    private int nElems;

    public ArrayBub(int max) {
        this.array = new long[max];
        this.nElems = 0;
    }

    public int size() {
        return array.length;
    }

    public void insert(int value) {
        array[nElems] = value;
        nElems++;
    }

    public void display() {
        Arrays.stream(array).forEach(x -> System.out.println(x + " "));
        System.out.println(" ");
    }

    public int binaryFind(long index) {
        int curIn;
        int lowerBound = 0;
        int upperBound = nElems - 1;
        while (true) {
            curIn = (lowerBound + upperBound) / 2;
            if (array[curIn] == index) {
                return curIn;
            } else if (lowerBound > upperBound) {
                return -1;
            } else {
                if (array[curIn] < index) {
                    lowerBound = curIn + 1;
                } else {
                    upperBound = curIn - 1;
                }
            }
        }
    }

    public void delete(int index) {
        for (int i = index; i < nElems - 1; i++) {
            array[i] = array[i + 1];
        }
        array[nElems - 1] = 0;
        nElems--;
    }

    public void bubbleSort() {
        int in, out;
        for (out = nElems - 1; out > 0; out--) {
            for (in = 0; in < out; in++) {
                if (array[in] > array[in + 1]) {
                    long tmp = array[in];
                    array[in] = array[in + 1];
                    array[in + 1] = tmp;
                }
            }
        }
    }

    @Override
    public String toString() {
        return "ArrayBub{"
                + "array=" + Arrays.toString(array)
                + ", nElems=" + nElems
                + '}';
    }
}

class BubbleSortApp {
    public static void main(String[] args) {
        ArrayBub arr = new ArrayBub(10);
        for (int i = arr.size(); i > 0; i--) {
            arr.insert(i);
        }
        arr.bubbleSort();
        System.out.println("index = " + arr.binaryFind(5));
        int delete = arr.binaryFind(7);
        System.out.println("deleting the element = " + delete);
        arr.delete(delete);
        System.out.println(arr.toString());
        System.out.println();
    }
}
