package structure.linklist;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ListIterator {
    private ILink current;
    private ILink prev;
    private ILinkList ourList;

    public ListIterator(ILinkList iLinkList) {
        ourList = iLinkList;
        reset();
    }

    public void reset() {
        current = ourList.getFirst();
        prev = null;
    }

    public boolean atEnd() {
        return current.next == null;
    }

    public void nextLink() {
        prev = current;
        current = current.next;
    }

    public ILink getCurrent() {
        return current;
    }

    public void insertAfter(int data) {
        ILink newLink = new ILink(data);
        if (ourList.isEmpty()) {
            ourList.setFirst(newLink);
            current = newLink;
        } else {
            newLink.next = current.next;
            current.next = newLink;
            nextLink();
        }
    }

    public void insertBefore(int data) {
        ILink newLink = new ILink(data);
        if (prev == null) {
            newLink.next = ourList.getFirst();
            ourList.setFirst(newLink);
            reset();
        } else {
            newLink.next = prev.next;
            prev.next = newLink;
            current = newLink;
        }
    }

    public int deleteCurrent() {
        int value = current.data;
        if (prev == null) {
            ourList.setFirst(current.next);
            reset();
        } else {
            prev.next = current.next;
            if (atEnd()) {
                reset();
            } else {
                current = current.next;
            }
        }
        return value;
    }
}

class InterIterApp {
    public static void main(String[] args) throws IOException {
        ILinkList theList = new ILinkList();
        ListIterator iter1 = theList.getIterator();
        int value;
        iter1.insertAfter(20);
        iter1.insertAfter(40);
        iter1.insertAfter(80);
        iter1.insertAfter(60);
        while (true) {
            System.out.println("Enter first letter of show. reset. ");
            System.out.println("next. get. before. after. delete.");
            System.out.flush();
            int choice = getChar();
            switch (choice) {
                case 's':
                    if (!theList.isEmpty()) {
                        theList.displayList();
                    } else {
                        System.out.println("List is empty");
                    }
                    break;
                case 'r':
                    iter1.reset();
                    break;
                case 'n':
                    if (!theList.isEmpty() && !iter1.atEnd()) {
                        iter1.nextLink();
                    } else {
                        System.out.println("Cant`t go to next link");
                    }
                    break;
                case 'g':
                    if (!theList.isEmpty()) {
                        value = iter1.getCurrent().data;
                        System.out.println("Returned " + value);
                    } else {
                        System.out.println("List is empty");
                    }
                    break;
                case 'b':
                    System.out.println("Enter value to insert: ");
                    System.out.flush();
                    value = getInt();
                    iter1.insertBefore(value);
                    break;
                case 'a':
                    System.out.println("Enter value to insert: ");
                    System.out.flush();
                    value = getInt();
                    iter1.insertAfter(value);
                    break;
                case 'd':
                    if (!theList.isEmpty()) {
                        value = iter1.deleteCurrent();
                        System.out.println("Deleted " + value);
                    } else {
                        System.out.println("Cant delete");
                    }
                    break;
                default:
                    System.out.println("Invalid entry");
            }
        }
    }

    public static String getString() throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader bfr = new BufferedReader(isr);
        String s = bfr.readLine();
        return s;
    }

    public static char getChar() throws IOException {
        String s = getString();
        return s.charAt(0);
    }

    public static int getInt() throws IOException {
        String s = getString();
        return Integer.parseInt(s);
    }
}

class ILink {
    public int data;
    public ILink next;

    ILink(int data) {
        this.data = data;
    }

    public void displayLink() {
        System.out.println(data + " ");
    }
}

class ILinkList {
    private ILink first;

    public ILinkList() {
        first = null;
    }

    public ILink getFirst() {
        return first;
    }

    public void setFirst(ILink f) {
        first = f;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public ListIterator getIterator() {
        return new ListIterator(this);
    }

    public void displayList() {
        ILink current = first;
        while (current != null) {
            current.displayLink();
            current = current.next;
        }
        System.out.println("");
    }
}