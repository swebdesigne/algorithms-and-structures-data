package structure.linklist;

public class Link {
    public int iData;
    public double dData;
    public Link next;

    public Link(int id, double dd) {
        iData = id;
        dData = dd;
    }

    public void displayLink() {
        System.out.println("{ " + iData + ". " + dData + " }");
    }
}

class LinkList {
    private Link first;

    LinkList() {
        this.first = null;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void insertFirst(int id, double dd) {
        Link newLink = new Link(id, dd);
        newLink.next = first;
        first = newLink;
    }

    public Link deleteFirst() {
        Link temp = first;
        first = first.next;
        return temp;
    }

    public Link find(int key) {
        Link current = first;
        while (current.iData != key) {
            if (current.next == null) {
                return null;
            } else {
                current = current.next;
            }
        }
        return current;
    }

    public Link delete(int key) {
        Link current = first;
        Link previous = first;
        while (current.iData != key) {
            if (current.next == null) {
                return null;
            } else {
                previous = current;
                current = current.next;
            }
        }
        if (current == first) {
            first = first.next;
        } else {
            previous.next = current.next;
        }
        return current;
    }

    public void displayList() {
        System.out.println("List ( first --> last )");
        Link current = first;
        while (current != null) {
            current.displayLink();
            current = current.next;
        }
        System.out.println("");
    }
}

class LinkListApp {
    public static void main(String[] args) {
        LinkList theList = new LinkList();
        int ii = 0;
        int thousand = 1000;
        for (int i = 0; i < 1_000_000_000; i++) {
            if (ii == thousand) {
                System.out.println(i);
                thousand += thousand;
            }
            ii++;
            theList.insertFirst(i, 2.2);
        }
        System.exit(1);
        theList.insertFirst(22, 2.99);
        theList.insertFirst(42, 3.99);
        theList.insertFirst(22, 4.99);
        theList.displayList();
        while (!theList.isEmpty()) {
            Link aLink = theList.deleteFirst();
            System.out.println("Deleted: ");
            aLink.displayLink();
            System.out.println("");
        }
        theList.displayList();
    }
}