package algorithm.sort.bubble;

import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.Comparator;

/**
 * Класс выполняет сортировку пузырьковым методом
 */
public class BubbleSort implements Comparator<Integer> {
    /**
     * Метод сортировки пузырьковым методом
     * Сортировка выполняется по следующим правилам:
     *  1. сравнить 2 элемента;
     *  2. если левый элемент меньше правого - поменять местами
     *  3. перейти на одну позицию вправо
     * Перестановки продолжаются до тех пор пока не будет достигнут последний правый элемент.
     * и до тех пор пока не будут отсортированы все элементы.
     *
     * Инвариант:
     *
     * Элементы данных справа от out отсортированы
     *
     * Сложность - O(n*2)
     *
     * @param array - неотсортированный массив
     * @param <T> - обобщенный тип данных
     */
    private <T> void sort(T[] array) {
        int in, out;
        for (out = array.length - 1; out > 1; out--) {
            for (in = 0; in < out; in++) {
                if (compare((Integer) array[in], (Integer) array[in + 1]) > 0) {
                    T tmp = array[in];
                    array[in] = array[in + 1];
                    array[in + 1] = tmp;
                }
            }
        }
        Arrays.stream(array).forEach(System.out::println);
    }

    public Integer[] sortReturnArr(Integer[] array) {
        int in, out;
        for (out = array.length - 1; out > 1; out--) {
            for (in = 0; in < out; in++) {
                if (compare(array[in], array[in + 1]) == 1) {
                    Integer tmp = array[in];
                    array[in] = array[in + 1];
                    array[in + 1] = tmp;
                }
            }
        }
        return array;
    }

    private int median(Integer[] arr) {
        return sortReturnArr(arr).length / 2;
    }

    @Override
    public int compare(Integer o1, Integer o2) {
        return o1.compareTo(o2);
    }

    public static void main(String[] args) throws InterruptedException {
        BubbleSort s = new BubbleSort();

        Instant start = Instant.now();

        s.sort(new Integer[] {2, 5, 1, 7, 3, 4, 6, 8, 10, 9});

        Thread.sleep(1000);
        Instant finish = Instant.now();
        long elapsed = Duration.between(start, finish).toMillis();
        System.out.println("Прошло времени, мс: " + elapsed);

        System.out.println(s.median(new Integer[] {2, 5, 1, 7, 3, 4, 6, 8, 10, 9}));
    }
}
