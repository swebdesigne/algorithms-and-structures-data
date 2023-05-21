package algorithm.greedy;

import java.util.Arrays;

/**
 * The class describe a greedy algorithm
 */
public class Greedy {
    public int[] execute(int[] coins, int money, int price) {
        int size = 0;
        int[] rsl = new int[100];
        int remainder = money - price;
        for (int coin : coins) {
            while (remainder >= coin) {
                remainder -= coin;
                rsl[size] = coin;
                size++;
            }
        }
        return Arrays.copyOf(rsl, size);
    }

    public static void main(String[] args) {
        Arrays.stream(new Greedy().execute(new int[] {10, 5, 2, 1}, 121, 50))
                .forEach(System.out::println);
    }
}
