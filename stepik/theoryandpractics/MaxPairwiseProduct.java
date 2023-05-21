package stepik.theoryandpractics;

import java.util.*;
import java.io.*;

class MaxPairwiseProduct {
    static long getMaxPairwiseProductFast(int[] numbers) {
        int n_Size = numbers.length;

        int max_index1 = -1;
        for (int p = 0; p < n_Size; p++) {
            if ((max_index1 == -1) || (numbers[p] > numbers[max_index1]))
                max_index1 = p;
        }

        int max_index2 = -1;
        for (int k = 0; k < n_Size; k++) {
            if ((k != max_index1) && ((max_index2 == -1) || (numbers[k] > numbers[max_index2])))
                max_index2 = k;
        }

        return (long) numbers[max_index1] * numbers[max_index2];
    }

    public static void main(String[] args) {

        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextInt();
        }

        System.out.println(getMaxPairwiseProductFast(numbers));
    }

    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) {
            try {
                br = new BufferedReader(new InputStreamReader(stream));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }

}