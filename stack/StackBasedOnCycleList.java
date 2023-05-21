package stack;

import java.util.Objects;

public class StackBasedOnCycleList {
    FirstLastList flList;

    public StackBasedOnCycleList() {
        this.flList = new FirstLastList();
    }

    public void insert(int val) {
        flList.insertFirst(val);
    }

    public void display() {
        flList.display();
    }

    public static void main(String[] args) {
        StackBasedOnCycleList stack = new StackBasedOnCycleList();
        stack.insert(1);
        stack.insert(2);
        stack.insert(3);
        stack.display();
    }
}

class ThisLink {
    public int data;
    public ThisLink next;

    public ThisLink(int data) {
        this.data = data;
    }

    public void displayLink() {
        System.out.println(data + " ");
    }
}

class FirstLastList {
    public ThisLink first;
    public ThisLink last;

    public FirstLastList() {
        this.first = null;
        this.last = null;
    }

    public boolean isEmpty() {
        return Objects.isNull(first);
    }

    public void insertFirst(int val) {
        ThisLink newLink = new ThisLink(val);
        if (isEmpty()) {
            first = newLink;
        } else {
            last.next = newLink;
        }
        last = newLink;
    }

    public int deleteFirst() {
        int temp = first.data;
        if (Objects.isNull(first.next)) {
            last = null;
        }
        first = first.next;
        return temp;
    }

    public void display() {
        System.out.println("Last (first ---> last): ");
        ThisLink current = first;
        while (Objects.nonNull(current)) {
            current.displayLink();
            current = current.next;
        }
        System.out.println("");
    }
}