package queue;

public class PriorityQueueBaseOnSortedLinkedList {
    private final SortedLinkedList list;

    public PriorityQueueBaseOnSortedLinkedList() {
        this.list = new SortedLinkedList();
    }

    public void insert(int data) {
        list.insert(data);
    }

    public int pop() {
        if (list.isEmpty()) return -1;
        return list.pop();
    }

    public void print() {
        while (list.isEmpty()) {
            System.out.println(list.pop());
        }
    }
}

class SortedLinkedList {
    Link first;

    static class Link {
        public int data;
        public Link next;

        Link(int data) {
            this.data = data;
        }
    }

    public int pop() {
        Link current = first;
        first = first.next;
        return current.data;
    }

    public int peek() {
        return first.data;
    }

    public void insert(int data) {
        Link newLink = new Link(data);
        newLink.next = first;
        first = newLink;
        sortList();
    }


    public boolean isEmpty() {
        return first != null;
    }

    public boolean hasNext() {
        return first.next != null;
    }

    private void sortList() {
        Link current = first, index = null;
        int tmp;
        if (first != null) {
            while (current != null) {
                index = current.next;
                while (index != null) {
                    if (current.data > index.data) {
                        tmp = current.data;
                        current.data = index.data;
                        index.data = tmp;
                    }
                    index = index.next;
                }
                current = current.next;
            }
        }
    }

    public void display() {
        var cur = first;
        while (cur != null) {
            System.out.println("data is equals " + cur.data);
            cur = cur.next;
        }
    }
}

class SortedLinkedListApp {
    public static void main(String[] args) {
        PriorityQueueBaseOnSortedLinkedList theQueue = new PriorityQueueBaseOnSortedLinkedList();
        theQueue.insert(3);
        theQueue.insert(1);
        theQueue.insert(2);
        theQueue.print();
    }
}