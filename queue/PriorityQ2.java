package queue;

import java.util.Arrays;

public class PriorityQ2 {
    private final int maxsize;
    private final int[] array;
    private int nItems;
    private int mostLargeVal;
    private int indexOfMostLargeValue;

    public PriorityQ2(int maxsize) {
        this.maxsize = maxsize;
        this.array = new int[maxsize];
        this.nItems = 0;
        this.mostLargeVal = this.indexOfMostLargeValue = 0;
    }

    private void insert(int v) {
        array[nItems] = v;
        if (mostLargeVal < v) {
            mostLargeVal = v;
            indexOfMostLargeValue = nItems;
        }
        nItems++;
    }

    private int remove() {
        int res = array[indexOfMostLargeValue];

        for (int i = indexOfMostLargeValue; i < nItems; i++)
            if (i + 1 < nItems)
                array[i] = array[i + 1];

        nItems--;

        mostLargeVal = indexOfMostLargeValue = 0;
        for (int i = 0; i < nItems; i++)
            if (array[i] > mostLargeVal) {
                mostLargeVal = array[i];
                indexOfMostLargeValue = i;
            }

        return res;
    }

    private boolean isEmpty() {
        return nItems == 0;
    }

    public static void main(String[] args) {
        PriorityQ2 thePQ = new PriorityQ2(5);
        thePQ.insert(30);
        thePQ.insert(50);
        thePQ.insert(10);
        thePQ.insert(40);
        thePQ.insert(20);
        while (!thePQ.isEmpty()) {
            System.out.println("Most an element = " + thePQ.array[thePQ.indexOfMostLargeValue]);
            long item = thePQ.remove();
            System.out.println(item + " ");
        }
    }
}
