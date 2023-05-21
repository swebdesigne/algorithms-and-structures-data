package structure.linklist;

import java.util.Objects;

public class IFlaviy {
    private final IFlaviyLinkFirstLastList iF = new IFlaviyLinkFirstLastList();
    private final int step;

    public IFlaviy(int step) {
        this.step = step;
    }

    private void insert(int id) {
        iF.insertLast(id);
    }

    private void display() {
        iF.displayList();
    }

    public void deleteThis(int id) {
        iF.deleteThis(id);
    }

    public void deleteByIndex(int index) {
        iF.deleteByIndex(index);
    }

    public boolean isEmpty() {
        return iF.isEmpty();
    }

    public int count() {
        return iF.getCount();
    }

    public void deleteWithStep() {
        int it = 0;
        int cStep = 0;
        while (count() > 1) {
            if (cStep == step - 1) {
                deleteByIndex(it);
                cStep = 0;
            } else {
                cStep++;
            }
            if (it >= count()) {
                it = 0;
            }
            it++;
        }
    }

    public static void main(String[] args) {
        IFlaviy f = new IFlaviy(3);
        f.insert(1);
        f.insert(2);
        f.insert(3);
        f.insert(4);
        f.insert(5);
        f.insert(6);
        f.insert(7);
        f.insert(8);
        f.insert(9);
        f.insert(10);
        f.insert(11);
        f.insert(12);
        f.deleteWithStep();
        f.display();
    }

}

/* This is a double link list */
class IFlaviyLink {
    public int data;
    public IFlaviyLink next;

    public IFlaviyLink(int data) {
        this.data = data;
    }

    public void displayLink() {
        System.out.println(data + " ");
    }
}

class IFlaviyLinkFirstLastList {
    private IFlaviyLink first;
    private IFlaviyLink last;
    private int count = 0;

    public IFlaviyLinkFirstLastList() {
        first = null;
        last = null;
    }

    public int getCount() {
        return count;
    }

    public void deleteThis(int id) {
        IFlaviyLink newLink = last; // create the new value
        first = null;
        last = null;
        count = 0;
        while (Objects.nonNull(newLink)) {
            if (newLink.data == id) {
                newLink = newLink.next;
                insertFirst(newLink.data);
                break;
            }
            insertFirst(newLink.data);
            newLink = newLink.next;
        }
    }

    public boolean isEmpty() {
        return Objects.isNull(first);
    }

    public void insertFirst(int dd) {
        IFlaviyLink newLink = new IFlaviyLink(dd); // create the new value
        if (isEmpty()) { // if the list is empty
            last = newLink; // newLink <-- last
        }
        newLink.next = first; // The newLink is old value
        first = newLink; // add to first the newLink
        count++;
    }

    public void insertLast(int dd) {
        IFlaviyLink newLink = new IFlaviyLink(dd);
        if (isEmpty())
            first = newLink;
        else
            last.next = newLink;
        last = newLink;
        count++;
    }

    public int deleteFirst() {
        int tmp = first.data;
        if (Objects.isNull(first.next)) { // if we have only one element
            last = null;
        }
        first = first.next;
        return tmp;
    }

    public void displayList() {
        System.out.println("List (first ---> last): ");
        IFlaviyLink current = first;
        while (Objects.nonNull(current)) {
            current.displayLink();
            current = current.next;
        }
        System.out.println("");
    }

    public void deleteByIndex(int index) {
        IFlaviyLink newLink = last; // create the new value
        first = null;
        last = null;
        count = 0;
        int it = 0;
        while (Objects.nonNull(newLink)) {
            if (it == index) {
                newLink = newLink.next;
                insertLast(newLink.data);
                break;
            }
            insertLast(newLink.data);
            newLink = newLink.next;
            it++;
        }
    }
}
