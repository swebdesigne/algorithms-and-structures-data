package queue;

public class LinkQueue {
    private final FirstLastList theList;

    public LinkQueue() {
        this.theList = new FirstLastList();
    }

    public boolean isEmpty() {
        return theList.isEmpty();
    }

    public void insert(int v) {
        theList.insertLast(v);
    }

    public int remove() {
        return theList.deleteFirst();
    }

    public void displayQueue() {
        System.out.println("front --> rear");
        theList.displayList();
    }
}

class LinkQueueApp {
    public static void main(String[] args) {
        LinkQueue theQueue = new LinkQueue();
        theQueue.insert(20);
        theQueue.insert(40);
        theQueue.displayQueue();
        theQueue.remove();
        theQueue.displayQueue();
    }
}

class Link {
    public int id;
    public Link next;

    Link(int id) {
        this.id = id;
    }

    public void displayLink() {
        System.out.println(id + " ");
    }
}

class FirstLastList {
    private Link first;
    private Link last;

    FirstLastList() {
        this.first = null;
        this.last = null;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void insertLast(int id) {
        Link newLink = new Link(id);
        if (isEmpty()) {
            first = newLink;
        } else {
            last.next = newLink;
        }
        last = newLink;
    }

    public int deleteFirst() {
        int tmp = first.id;
        if (first.next == null) {
            last = null;
        }
        first = first.next;
        return tmp;
    }

    public void displayList() {
        Link current = first;
        while (current != null) {
            current.displayLink();
            current = current.next;
        }
        System.out.println(" ");
    }
}

