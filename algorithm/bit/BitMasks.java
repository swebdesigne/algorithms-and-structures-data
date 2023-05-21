package algorithm.bit;

import java.util.List;
import java.util.Vector;

public class BitMasks {
    public static void main(String[] args) {
        Vector<Integer> arr = new Vector<>(List.of(1, 2, 3, 4));
        int n = arr.size();
        for (int mask = 0; mask < (1 << n); ++mask) {
            boolean first = true;
            System.out.print("{");
            for (int j = 0; j < n; ++j) {
                if ((mask & (1 << j)) == 0) {
                    if (!first) System.out.print(", ");
                    first = false;
                    System.out.print(arr.get(j));
                }
            }
            System.out.println("}");
        }
    }
}
