package stepik.theoryandpractics;

import java.util.function.BiFunction;
import java.util.stream.IntStream;

/*
    Чи́сла Фибона́ччи (вариант написания — Фибона́чи[2]) — элементы числовой последовательности
    0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597, 2584, 4181, 6765, 10946, 17711, … (последовательность A000045 в OEIS),
    в которой первые два числа равны 0 и 1, а каждое последующее число равно сумме двух предыдущих чисел
 */
public class Fibonacci {
    private static final int SIZE = 1000_000_000;
    private static final int NUM = 100;
// 0 1 2 3 4 5 6
//   1 1 2 3 5 8

    /**
     * Метод ищет число фибоначи. Сложность O(N)
     */
    private static int lineCompute(int[] sequence) {
        for (int i = 2; i <= sequence.length - 1; i++) {
            sequence[i] = sequence[i - 1] + sequence[i - 2];
        }
        return sequence[NUM];
    }

    /**
     * Метод ищет число фибоначи. Экспоненциальная сложность
     */
    private static int recursionCompute(int[] sequence, int index) {
        if (sequence.length < 2) return 1;
        if (index < 2) index = 2;
        if (index <= sequence.length - 1) {
            sequence[index] = sequence[index - 1] + sequence[index - 2];
            recursionCompute(sequence, index + 1);
        }
        return sequence[NUM];
    }

    private static long recursiveComputeMethod(long n, long a, long b, long c, long res) {
        if (n < 2) {
            return n;
        }
        if (a <= n) {
            res = b + c;
            c = b;
            b = res;
            return recursiveComputeMethod(n, a + 1, b, c, res);
        }
        return b;
    }

    /**
     * Метод вычисляет число фибоначи, а также решает задачу описанную внизу путем нахождения остатка 10 от вычисления latest + later
     * Пример System.out.println(computeByNum(18, (a, b) -> (a + b) % 10));
     * <p>
     * Задача:
     * <p>
     * Дано число 1 <= n <= 10^7, необходимо найти последнюю цифру n-го числа Фибоначчи.
     * <p>
     * Как мы помним, числа Фибоначчи растут очень быстро, поэтому при их вычислении нужно быть аккуратным с переполнением.
     * В данной задаче, впрочем, этой проблемы можно избежать, поскольку нас интересует только последняя цифра числа Фибоначчи: если 0 <= a, b <= 9,
     * a,b — последние цифры чисел F[i] и F[i+1] соответственно, то (a+b)mod10 — последняя цифра числа F[i+2].
     */
    private static long computeByNum(long num, BiFunction<Long, Long, Long> f) {
        long res = 1;
        long later = 1;
        long latest = 0;
        if (num > 1) {
            for (long i = 2; i <= num; ++i) {
                res = f.apply(later, latest);
                latest = later;
                later = res;
            }
        }
        return res;
    }

    /**
     * Огромное число Фибоначи по модулю
     * <p>
     * Даны целые числа 1 <= n <= 10^18  и 2 <= m 10^5
     */
    private static long get_pisano_period(long m) {
        long a = 0, b = 1, c = a + b;
        int i = 0;
        for (; i < m * m; i++) {
            c = (a + b) % m;
            a = b;
            b = c;
            if (a == 0 && b == 1) break;
        }
        return i + 1;
    }

    private static long getFibonacciHugeNaive(long n, long m) {
        long remainder = n % get_pisano_period(m);

        long first = 0;
        long second = 1;

        long res = remainder;

        for (int i = 1; i < remainder; i++) {
            res = (first + second) % m;
            first = second;
            second = res;
        }

        return res % m;
    }

    static int bigNumFib(int n) {
        if (n < 1)
            return (int) n;

        int prev = 0;
        int curr = 1;
        for (long i = 2; i <= n; i++) {
            int next = (prev + curr) % 10;
            prev = curr;
            curr = next;
        }
        return curr % 10;
    }

    public static void main(String[] args) {
        int[] sequence = new int[Fibonacci.SIZE];
        IntStream.range(0, Fibonacci.SIZE).forEach(index -> sequence[index] = index);
//        System.out.println(Fibonacci.lineCompute(sequence));
//        System.out.println(Fibonacci.recursionCompute(sequence, 2));
        System.out.println(computeByNum(SIZE, Long::sum));
//        System.out.println(Fibonacci.recursiveComputeMethod(Fibonacci.SIZE, 2, 1, 0, 0));
//        System.out.println(computeByNum(55, Integer::sum) % 2);
//        BigInteger bi = new BigInteger("2131321313131313131");
//        Scanner s = new Scanner(System.in);
//        int lastD = bigNumFib((3 + 2) % 60);
//        System.out.println(lastD == 0 ? 9 : lastD - 1);
    }
}
