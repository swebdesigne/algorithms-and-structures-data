package stack;

class ISLink {
    public long dData;
    public ISLink next;

    public ISLink(long dd) {
        dData = dd;
    }
}

class SortedLost {
    private ISLink first;

    SortedLost(ISLink[] linkArr) {
        this.first = null;
        for (ISLink isLink : linkArr) {
            insert(isLink);
        }
    }

    private void insert(ISLink isLink) {
        ISLink prev = null;
        ISLink cur = first;
        while (cur != null && isLink.dData > cur.dData) {
            prev = cur;
            cur = cur.next;
        }
        if (prev == null) {
            first = isLink;
        } else {
            prev.next = isLink;
        }
    }
    public ISLink remove() {
        ISLink temp = first;
        first = first.next;
        return temp;
    }
}