package algorithm.bubble;

import java.util.Arrays;
import java.util.Comparator;

public class BubbleSort implements Comparator<Integer> {
    private <T> void sort(T[] array) {
        int in, out;
        for (out = array.length - 1; out > 0; out--) {
            for (in = 0; in < out; in++) {
                if (compare((Integer) array[in], (Integer) array[in + 1]) == 1) {
                    T tmp = array[in];
                    array[in] = array[in + 1];
                    array[in + 1] = tmp;
                }
            }
        }
        Arrays.stream(array).forEach(System.out::println);
    }

    @Override
    public int compare(Integer o1, Integer o2) {
        return o1.compareTo(o2);
    }

    public static void main(String[] args) {
        new BubbleSort().sort(new Integer[] {2, 5, 1, 7, 3, 5, 4, 6, 8, 10, 9});
    }
}