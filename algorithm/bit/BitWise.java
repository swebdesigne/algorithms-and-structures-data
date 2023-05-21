package algorithm.bit;

public class BitWise {
    public static void main(String[] args) {
        System.out.println(51 & 25); // 17
        System.out.println(51 | 25); // 59
        System.out.println(51 ^ 25); // 42
        System.out.println(~23); // 24
        System.out.println(12 << 2); // 48
        System.out.println(12 >> 2); // 3

        int n = 17;
        System.out.println(n | (1 << 2)); // 21
    }
}
