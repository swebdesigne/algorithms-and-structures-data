package stepik.theoryandpractics;

import java.util.Scanner;


public class NOD {
    private int nod(int a, int b) {
        if (a == 0) return b;
        if (b == 0) return a;
        return a >= b ? nod(a % b, b) : nod(a, b % a);
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println(new NOD().nod(s.nextInt(), s.nextInt()));
        s.close();
    }
}
