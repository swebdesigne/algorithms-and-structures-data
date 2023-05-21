package array;

import java.util.stream.IntStream;

public class OrderApp {
    public static void main(String[] args) {
        OrderArray orderArray = new OrderArray(10);
        IntStream.range(0, 10).forEach(orderArray::insert);
        System.out.println(orderArray.delete(3));
        System.out.println(orderArray.biSearch(3));
        orderArray.display();
    }
}
