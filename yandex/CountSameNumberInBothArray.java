package yandex;

import java.util.Scanner;

public class CountSameNumberInBothArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] arr = scanner.nextLine().split(" ");
        String[] line = scanner.nextLine().split(" ");
        int res = 0;
        for (int i = 0; i <= arr.length - 1; i++) {
            for (int j = 0; j <= line.length - 1; j++) {
                if (line[j] != null && line[j].equals(arr[i])) {
                    line[j] = null;
                    res++;
                }
            }
        }
        System.out.println(res);
        scanner.close();
    }
}
