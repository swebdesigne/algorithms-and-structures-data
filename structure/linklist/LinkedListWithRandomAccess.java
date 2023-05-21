package structure.linklist;

import java.util.Objects;

public class LinkedListWithRandomAccess {
    private Node first;

    void insert(int data) {
        if (first == null) first = new Node(data);
        else first.add(data);
    }

    void delete(int key) {
        first.delete(key);
    }

    boolean replace(int key, int key2) {
        return first.replace(key, key2);
    }

    boolean find(int a) {
        return first.find(a);
    }

    void display() {
        first.display();
    }

    class Node {
        private Node next;
        private int data;

        public Node() {
        }

        public Node(int data) {
            this.data = data;
        }

        private void add(int data) {
            Node newElem = new Node(data);
            newElem.next = first;
            first = newElem;
        }

        private void delete(int val) {
            Node current = first;
            first = null;
            while (Objects.nonNull(current)) {
                if (current.data == val) {
                    current = unlink(current, val);
                }
                if (Objects.isNull(current)) break;
                add(current.data);
                current = current.next;
            }
        }

        private Node unlink(Node current, int val) {
            while (Objects.nonNull(current)) {
                if (current.data != val) return current;
                current = current.next;
            }
            return null;
        }

        private boolean find(int key) {
            Node node = first;
            while (Objects.nonNull(node)) {
                if (node.data == key) {
                    return true;
                }
                node = node.next;
            }
            return false;
        }

        private boolean replace(int oldValue, int newValue) {
            Node current = first;
            first = null;
            boolean flag = false;
            while (Objects.nonNull(current)) {
                if (current.data == oldValue) {
                    current.data = newValue;
                    flag = !flag;
                }
                insert(current.data);
                current = current.next;
            }
            return flag;
        }

        private void display() {
            Node cur = first;
            while (Objects.nonNull(cur)) {
                System.out.println("Data equals " + cur.data);
                cur = cur.next;
            }
        }
    }
}

class App {
    public static void main(String[] args) {
        LinkedListWithRandomAccess theList = new LinkedListWithRandomAccess();
        theList.insert(1);
        theList.insert(2);
        theList.insert(3);
        theList.insert(3);
        theList.replace(1, 4);
        theList.delete(1);
        theList.display();
    }
}