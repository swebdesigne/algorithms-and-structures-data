package algorithm.sort;

import algorithm.sort.bubble.ArrayBub;

public class SpeedTestSort {
    public static void main(String[] args) {
        ArrayBub arr = new ArrayBub(999_999);
        for (int i = arr.size(); i > 0; i--) {
            arr.insert((int) (Math.random() * 999_999));
        }
        arr.bubbleSort();
        arr.display();
    }
}
