package structure.linklist;

public class DLink {
    public long dData;
    public DLink next;
    public DLink prev;

    public DLink(long dData) {
        this.dData = dData;
    }

    public void displayLink() {
        System.out.println(dData + " ");
    }
}

class DoubleLinkedList {
    private DLink first;
    private DLink last;

    public DoubleLinkedList() {
        first = null;
        last = null;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void insertFirst(long dd) {
        DLink newLink = new DLink(dd);
        if (isEmpty()) {
            last = newLink;
        } else {
            first.prev = newLink;
        }
        newLink.next = first;
        first = newLink;
    }

    public void insertLast(long dd) {
        DLink newLink = new DLink(dd);
        if (isEmpty()) {
            first = newLink;
        } else {
            last.next = newLink;
            newLink.prev = last;
        }
        last = newLink;
    }

    public DLink deleteFirst() {
        DLink temp = first;
        if (first.next == null) {
            last = null;
        } else {
            first.next.prev = null;
        }
        first = first.next;
        return temp;
    }

    public DLink deleteLast() {
        DLink tmp = last;
        if (first.next == null) {
            first = null;
        } else {
            last.prev.next = null;
        }
        last = last.next;
        return tmp;
    }

    public boolean insertAfter(long key, long dd) {
        DLink current = first;
        while (current.dData != key) {
            current = current.next;
            if (current == null) {
                return false;
            }
            DLink newLink = new DLink(dd);
            if (current == last) {
                newLink.next = null;
                last = newLink;
            } else {
                newLink.next = current.next;
                current.next.prev = newLink;
            }
            newLink.prev = current;
            current.next = newLink;
        }
        return true;
    }

    public DLink deleteKey(long key) {
        DLink current = first;
        while (current.dData != key) {
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

    public void displayForward() {
        System.out.println("List first --> last");
        DLink current = first;
        while (current != null) {
            current.displayLink();
            current = current.next;
        }
        System.out.println(" ");
    }
    public void displayBackward() {
        System.out.println("List last --> first");
        DLink current = last;
        while (current != null) {
            current.displayLink();
            current = current.prev;
            System.out.println(" ");
        }
    }
}
