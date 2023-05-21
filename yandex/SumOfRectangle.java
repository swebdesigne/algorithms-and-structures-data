package yandex;

import java.io.*;
import java.math.BigInteger;

/**
 * Сумма в прямоугольнике
 * Ограничение времени	3 секунды
 * Ограничение памяти	256Mb
 * Ввод	стандартный ввод или input.txt
 * Вывод	стандартный вывод или output.txt
 * Вам необходимо ответить на запросы узнать сумму всех элементов числовой матрицы N×M в прямоугольнике с левым верхним углом (x1, y1) и правым нижним (x2, y2)
 * <p>
 * Формат ввода
 * В первой строке находится числа N, M размеры матрицы (1 ≤ N, M ≤ 1000) и K — количество запросов (1 ≤ K ≤ 100000). Каждая из следующих N строк содержит по M чисел`— элементы соответствующей строки матрицы (по модулю не превосходят 1000). Последующие K строк содержат по 4 целых числа, разделенных пробелом x1 y1 x2 y2 — запрос на сумму элементов матрице в прямоугольнике (1 ≤ x1 ≤ x2 ≤ N, 1 ≤ y1 ≤ y2 ≤ M)
 * <p>
 * Формат вывода
 * Для каждого запроса на отдельной строке выведите его результат — сумму всех чисел в элементов матрице в прямоугольнике (x1, y1), (x2, y2)
 * <p>
 * Пример
 * Ввод	        Вывод
 * 3 3 2        28
 * 1 2 3        21
 * 4 5 6
 * 7 8 9
 * 2 2 3 3
 * 1 1 2 3
 */
public class SumOfRectangle {
    static class Assert {
        static void check(boolean e) {
            if (!e)
                throw new AssertionError();
        }
    }

    static class Scanner implements AutoCloseable {
        StreamTokenizer in;

        Scanner(InputStream is) {
            in = new StreamTokenizer(new BufferedReader(new InputStreamReader(is)));
        }

        int nextInt() throws Exception {
            try {
                in.nextToken();
                Assert.check(in.ttype == StreamTokenizer.TT_NUMBER);
                int value = (int) in.nval;
                Assert.check(value == in.nval);
                return value;
            } catch (IOException e) {
                throw new Exception(e);
            }
        }

        @Override
        public void close() throws Exception {

        }
    }

    static class PrintWriter implements AutoCloseable {
        OutputStream os;

        PrintWriter(OutputStream os) {
            this.os = new BufferedOutputStream(os);
        }

        void print(char c) throws Exception {
            Assert.check(c <= 127);
            try {
                os.write((int) c);
            } catch (IOException e) {
                throw new Exception(e);
            }
        }

        void print(long n) throws Exception {
            Assert.check(n >= 0);
            if (n >= 10) {
                print(n / 10);
            }
            print((char) ('0' + n % 10));
        }

        void printLn(Long n) throws Exception {
            print(n);
            os.write((int) '\n');
        }

        @Override
        public void close() throws Exception {
            try {
                os.close();
            } catch (IOException e) {
                throw new Exception(e);
            }
        }
    }

    void solve(Scanner s, PrintWriter p) throws Exception {
        int sizeI = s.nextInt();
        int sizeJ = s.nextInt();
        int nQueries = s.nextInt();
        long[][] matrix = new long[1 + sizeI][1 + sizeJ];
        for (int i = 1; i <= sizeI; i++) {
            for (int j = 1; j <= sizeJ; j++) {
                int tmp = s.nextInt();
                matrix[i][j] = matrix[i - 1][j] + matrix[i][j - 1] - matrix[i - 1][j - 1] + tmp;
            }
        }
        for (int q = 0; q < nQueries; q++) {
            int i1 = s.nextInt();
            int j1 = s.nextInt();
            int i2 = s.nextInt();
            int j2 = s.nextInt();
            System.out.println(matrix[i2][j2] - matrix[i1 - 1][j2] - matrix[i2][j1 - 1] + matrix[i1 - 1][j1 - 1]);
        }
    }

    void run() {
        try (
                Scanner in = new Scanner(System.in);
                PrintWriter out = new PrintWriter(System.out);
        ) {
            solve(in, out);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        new SumOfRectangle().run();
    }
}