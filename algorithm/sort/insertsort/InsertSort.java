package algorithm.sort.insertsort;

import algorithm.sort.bubble.BubbleSort;

import java.net.InetSocketAddress;
import java.util.Arrays;
import java.util.Stack;
import java.util.stream.Collectors;

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
     * <p>
     * Инвариант
     * <p>
     * В конце каждого прохода, непосредственно после вставки элемента из tmp, элементы данных с индексами,
     * меньшими outer, являются частично отсортированными.
     * <p>
     * Сложность - O(n*2)
     *
     * @param a - неотсортированный массив
     * @return - отсортированный массив
     */
    public Integer[] insertSort(Integer[] a) {
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

    public Integer[] noDups(Integer[] arr) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == null) continue;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] == null) continue;
                if (arr[i].equals(arr[j])) {
                    arr[j] = null;
                    count++;
                }
            }
        }
        int jj = 0;
        Integer[] newArray = new Integer[arr.length - count];
        for (Integer integer : arr) {
            if (integer == null) continue;
            newArray[jj] = integer;
            jj++;
        }
        return newArray;
    }
}

class Main {
    public static void main(String[] args) {
        InsertSort sort = new InsertSort();
        BubbleSort bls = new BubbleSort();

        Integer[] array = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0, 5, 6, 7};

        Arrays.stream(sort.insertSort(array))
                .forEach(System.out::println);
        System.exit(0);
        System.out.println(System.lineSeparator());

        Integer[] i = new Integer[1_000_000];
        for (int j = 0; j < i.length; j++) {
            i[j] = (int) (Math.random() * i.length);
        }

        Arrays.stream(sort.noDups(i))
                .forEach(System.out::println);
        Stack<String> s = new Stack<>();
    }
}