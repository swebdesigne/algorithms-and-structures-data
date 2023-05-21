package array;

import java.util.stream.IntStream;

public class OrderArray {
    private final long[] array;
    private int nElems;


    public OrderArray(int max) {
        this.array = new long[max];
        this.nElems = 0;
    }

    public int size() {
        return nElems;
    }

    public int biSearch(int searchKey) {
        int cur;
        int lowerBound = 0;
        int upperBound = nElems - 1;
        while (true) {
            cur = (lowerBound + upperBound) / 2;
            if (array[cur] == searchKey) break;
            else if (lowerBound > upperBound) return nElems;
            else {
                if (array[cur] < searchKey) lowerBound = cur + 1;
                else upperBound = cur - 1;
            }
        }
        return cur;
    }

    public void insert(long value) {
        int j;
        for (j = 0; j < nElems; j++) {
            if (array[j] > value) break;
        }
        // for (int k = nElems; k > j; k--) { array[k] = array[k - 1]; } -- typically way
        if (nElems - j >= 0) System.arraycopy(array, j, array, j + 1, nElems - j);
        array[j] = value;
        nElems++;
    }

    public boolean delete(int value) {
        int j = biSearch(value);
        if (j == nElems) return false;
        else {
            // for (int k = j; k < nElems - 1; k++) { array[k] = array[k + 1]; } -- typically way
            if (nElems - 1 - j >= 0) System.arraycopy(array, j + 1, array, j, nElems - 1 - j);
        }
        nElems--;
        return true;
    }

    public void display() {
        var ln = System.lineSeparator();
        IntStream.range(0, nElems).forEach(elem -> System.out.printf("The element equals %d" + ln, array[elem]));
    }
}
