package stack;

public class SortedList {
    private SLLink first;

    public SortedList() {
        this.first = null;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void insert(long key) {
        SLLink newLink = new SLLink(key);
        SLLink prev = null;
        SLLink current = first;
        while (current != null && key > current.dData) {
            prev = current;
            current = current.next;
        }
        if (prev == null) {
            first = newLink;
        } else {
            newLink.next = current;
        }
    }

    public SLLink remove() {
        SLLink link = first;
        first = first.next;
        return link;
    }

    public void displayList() {
        System.out.println("list --> last: ");
        SLLink current = first;
        while (current != null) {
            current.display();
            current = current.next;
        }
        System.out.println("");
    }
}

class SLLink {
    public long dData;
    public SLLink next;

    public SLLink(long dData) {
        this.dData = dData;
    }

    public void display() {
        System.out.println(dData + " ");
    }
}
class SortedListApp {
    public static void main(String[] args) {
        SortedList theSortedList = new SortedList();
        theSortedList.insert(20);
        theSortedList.insert(40);
        theSortedList.displayList();
        theSortedList.remove();
        theSortedList.displayList();
    }
}
