package stack;

public class LinkStack {
    private final LinkList theList;

    public LinkStack() {
        this.theList = new LinkList();
    }

    public void push(int v) {
        theList.insertFirst(v);
    }

    public int pop() {
        return theList.deleteFirst();
    }

    public boolean isEmpty() {
        return theList.isEmpty();
    }
    public void displayStack() {
        System.out.println("Stack --> bottom");
        theList.displayList();
    }
}

class LinkStackApp {
    public static void main(String[] args) {
        LinkStack theStack = new LinkStack();
        theStack.push(20);
        theStack.push(40);
        theStack.displayStack();
        System.out.println(theStack.pop());
        theStack.displayStack();
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

class LinkList {
    private Link first;

    LinkList() {
        this.first = null;
    }

    public boolean isEmpty() {
        return this.first == null;
    }

    public void insertFirst(int id) {
        Link newLink = new Link(id);
        newLink.next = this.first;
        first = newLink;
    }

    public int deleteFirst() {
        Link tmp = first;
        first = first.next;
        return tmp.id;
    }

    public void displayList() {
        Link current = first;
        while (current != null) {
            current.displayLink();
            current = current.next;
        }
    }

}