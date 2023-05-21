package stepik.theoryandpractics.AI;

import org.apache.commons.lang3.StringUtils;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

public class AlmostDoubleFactorial {
    /**
     * Реализуйте функцию almost_double_factorial(n), вычисляющую произведение всех нечётных натуральных чисел, не превосходящих n.
     * В качестве аргумента ей передаётся натуральное (ноль -- натуральное) число n⩽100.
     * Возвращаемое значение - вычисленное произведение.
     * Комментарий. В случае, если n = 0, требуется вернуть 1.
     * В этом задании функция print вам не понадобится. Результаты выполнения функций нужно возвращать, а не печатать!
     */
    private long almostDoubleFactorial(long a) {
        return LongStream.range(1, a + 1)
                .filter(index -> index % 2 == 1)
                .reduce((x, y) -> x * y).orElse(1);
    }

    /*
     * Хитрая сортировка
     * Пусть у нас есть следующий список, в котором элементы -- tuple из строк:
     * items = [('one', 'two'), ('three', 'four'), ('five', 'six'), ('string', 'a')]
     * Мы хотим отсортировать этот список по последней букве второго элемента каждого tuple, т.е. получить такой список:
     * sorted_items = [ ('string', 'a'), ('one', 'two'), ('three', 'four'), ('five', 'six'),]
     */
    private void sortedItems(List<List<String>> list) {
        list.sort(new Comparator<List<String>>() {
            @Override
            public int compare(List<String> o1, List<String> o2) {
                return o1.get(1).substring(o1.get(1).length() - 1).compareTo(
                        o2.get(1).substring(o2.get(1).length() - 1)
                );
            }
        });// -> the native way
//        list.sort(Comparator.comparing(o -> o.get(1).substring(o.get(1).length() - 1)));
        System.out.println(list);
    }

    private List<String> clearTheWordOfStringFromAnySymbol(List<String> str) {
        return str.stream().map(s -> s.replaceAll("[^a-zA-Z]", " ")
                .replaceAll("\\s{2,}", " ").trim()
        ).collect(Collectors.toList());
    }

    private List<String> removeTheWordWhichHasDifferentSymbolFromLetterNativeWay(List<String> str) {
        return str.stream()
                .map(s -> Arrays.stream(s.split(" "))
                        .filter(s1 -> {
                                    Pattern p = Pattern.compile("[^a-zA-Z]");
                                    Matcher m = p.matcher(s1);
                                    return !m.find();
                                }
                        ).collect(Collectors.joining(" "))
                ).collect(Collectors.toList());
    }

    private List<String> removeTheWordWhichHasDifferentSymbolFromLetter(List<String> str) {
        return str.stream()
                .map(s -> Arrays.stream(s.split(" "))
                        .filter(StringUtils::isAlpha)
                        .collect(Collectors.joining(" "))
                ).collect(Collectors.toList());
    }

    public static void main(String[] args) {
        AlmostDoubleFactorial f = new AlmostDoubleFactorial();
        System.out.println(f.almostDoubleFactorial(25));

        List<List<String>> list = new ArrayList<>();
        list.add(List.of("one", "two"));
        list.add(List.of("three", "four"));
        list.add(List.of("five", "six"));
        list.add(List.of("string", "a"));
        f.sortedItems(list);

        List<String> clear = new ArrayList<>();
        clear.add("123Hello123& 9898World()(((2323AND other creatures");
        clear.add("jlkhkjhjflhj 213131 jkkhfakl");
        System.out.println(f.removeTheWordWhichHasDifferentSymbolFromLetter(clear));
        System.out.println(f.clearTheWordOfStringFromAnySymbol(clear));

    }
}
