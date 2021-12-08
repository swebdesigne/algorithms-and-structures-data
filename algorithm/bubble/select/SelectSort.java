package algorithm.bubble.select;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Класс выполняет сортировку методом выбора
 */
public class SelectSort implements Comparator<Integer> {
    public int[] selectSort(int[] array) {
        int out, in, min;
        for (out = 0; out < array.length - 1; out++) {
            min = out;
            for (in = out + 1; in < array.length; in++) {
                if (compare(array[min], array[in]) == 1) {
                    min = in;
                }
                int tmp = array[out];
                array[out] = array[min];
                array[min] = tmp;
            }
        }
        return array;
    }

    @Override
    public int compare(Integer o1, Integer o2) {
        return o1.compareTo(o2);
    }

    public static void main(String[] args) {
        Arrays.stream(new SelectSort().selectSort(new int[] {10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0}))
                .forEach(System.out::println);
    }
}
