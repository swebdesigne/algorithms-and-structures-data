package algorithm.greedy;

import java.util.Arrays;

public class Greedy {
    public int[] execute(int[] coins, int money, int price) {
        int size = 0;
        int[] rsl = new int[100];
        int remainder = money - price;
        for (int i = 0; i < coins.length; i++) {
            while (remainder >= coins[i]) {
                remainder -= coins[i];
                rsl[size] = coins[i];
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
