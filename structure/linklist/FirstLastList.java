package structure.linklist;

/*
 * Двусторонний список
 * */
public class FirstLastList {
    private Link first;
    private Link last;

    public FirstLastList() {
        first = null;
        last = null;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void insertFirst(int id, double dd) {
        Link newLink = new Link(id, dd);
        if (isEmpty()) {
            last = newLink;
        }
        newLink.next = first;
        first = newLink;
    }
    public void insertLast(int id, double dd) {
        Link newLink = new Link(id, dd);
        if (isEmpty()) {
            first = newLink;
        } else {
            last.next = newLink;
        }
        last = newLink;
    }
    public double deleteFirst() {
        double temp = first.dData;
        if (first.next == null) {
            last = null;
        }
        first = first.next;
        return temp;
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
 class FirstLastApp {
     public static void main(String[] args) {
         FirstLastList theLast =  new FirstLastList();
         theLast.insertFirst(22, 22.2);
         theLast.insertFirst(23, 22.3);
         theLast.insertLast(10, 10.1);
         theLast.insertLast(11, 10.2);
         theLast.displayList();
         theLast.deleteFirst();
         theLast.displayList();
     }
 }