package algorithm.sort.oddsort;

import java.util.Arrays;

public class OddSort {

    /**
     * wiki_url - https://dev.abcdef.wiki/wiki/Odd%E2%80%93even_sort
     * Сортировка методом четно-нечетных перестановок очень полезна в
     * многопроцессорных конфигурациях, когда разные процессы погут одновременно работать
     * с разными нечетными (а затем и четными) парами. Т.к. нечетные пары независимы друг
     * от друга, каждая пара может проверяться  (с перестановкой элементов в случае необходимости)
     * отдельным процессом. Такая сортировка выполняется очень быстро.
     * @param arr - входной массив для сортировки
     */
    private void oddSort(int[] arr) {
        boolean sorted = false;
        while (!sorted) {
            sorted = true;
            for (int i = 1; i < arr.length - 1; i += 2) {
                if (arr[i]  > arr[i + 1]) {
                    int tmp = arr[i];
                    arr[i] = i + 1;
                    arr[i + 1] = tmp;
                    sorted = false;
                }
            }
            for (int i = 0; i < arr.length - 1; i += 2) {
                if (arr[i]  > arr[i + 1]) {
                    int tmp = arr[i];
                    arr[i] = i + 1;
                    arr[i + 1] = tmp;
                    sorted = false;
                }
            }
        }
        Arrays.stream(arr).forEach(System.out::println);
    }

    public static void main(String[] args) {
        int[] arr = new int[1000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * arr.length);
        }

        new OddSort().oddSort(arr);
    }
}
