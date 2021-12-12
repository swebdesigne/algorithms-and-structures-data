package algorithm.sort.insertsort;

import java.util.Arrays;

/**
 * Класс выполняет сортировку методом выбора
 */
public class InsertSort {
    /**
     * метод сортировки методом вставки
     * Во внешнем цикле for счетчик начинает с позиции 1 и двигается вправо.
     * Он отмечает крайний левый неотсортированный элемент.
     * Во внутреннем цикле while счеткчик in начинает с позиции out и двигается влево,
     * либо - пока tmp не станет меньше элемента массива, либо когда дальнейшее
     * смещение массива станет невозможным. При каждом проходе по циклу while
     * слеующий отсортированный элемент сдвигается на одну позицю вправо.
     *
     * Инвариант
     *
     * В конце каждого прохода, непосредственно после вставки элемента из tmp, элементы данных с индексами,
     * меньшими outer, являются частично отсортированными.
     *
     * Сложность - O(n*2)
     *
     * @param a - неотсортированный массив
     * @return - отсортированный массив
     */
    private int[] insertSort(int[] a) {
        int in, out;
        for (out = 1; out < a.length; out++) {
            var tmp = a[out];
            in = out;
            while (in > 0 && a[in - 1] >= tmp) {
                a[in] = a[in - 1];
                --in;
            }
            a[in] = tmp;
        }
        return a;
    }
}

class Main {
    public static void main(String[] args) {
        Arrays.stream(new int[] {10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0})
                .forEach(System.out::println);
    }
}