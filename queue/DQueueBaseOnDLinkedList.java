package queue;

public class DQueueBaseOnDLinkedList {
    private int data;
    private TheDLink theDLink;

    public void insert(int data) {
        theDLink.insertFirst(data);
    }

    public int popLast() {
        return theDLink.deleteLast().getData();
    }

    public int popFirst() {
        return theDLink.deleteFirst().getData();
    }
}

class TheDLink {
    private Node first;
    private Node last;

    public TheDLink() {
        this.first = null;
        this.last = null;
    }

    static class Node {
        private Node next;
        private Node prev;
        private final int data;

        public Node(int data) {
            this.data = data;
        }

        public int getData() {
            return this.data;
        }
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void insertFirst(int data) {
        Node newNode = new Node(data);
        if (isEmpty()) {
            last = newNode;
        } else {
            first.prev = newNode;
        }
        newNode.next = first;
        first = newNode;
    }

    public void insertLast(int data) {
        Node newNode = new Node(data);
        if (isEmpty()) {
            first = newNode;
        } else {
            last.next = newNode;
            newNode.prev = last;
        }
    }

    public Node deleteFirst() {
        Node tmp = first;
        if (first.next == null) {
            last = null;
        } else {
            first.next.prev = null;
        }
        first = first.next;
        return tmp;
    }

    public Node deleteLast() {
        Node tmp = last;
        if (first.next == null) {
            first = null;
        } else {
            last.prev.next = null;
        }
        last = last.next;
        return tmp;
    }

    public Node deleteKey(int key) {
        Node current = first;
        while (current.data != key) {
            current = current.next;
            if (current == null) {
                return null;
            }
            if (current == first) {
                first = current.next;
            } else {
                current.prev.next = current.next;
            }
            if (current == last) {
                last = current.prev;
            } else {
                current.prev.next = current.prev;
            }
        }
        return current;
    }
}
