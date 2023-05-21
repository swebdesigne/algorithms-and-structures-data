package queue;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class Store {
    private final Map<Integer, QueuePeople> boxOffice;

    public Store(Map<Integer, QueuePeople> boxOffice) {
        this.boxOffice = boxOffice;
    }

    private static Integer mostEmptyQueue(Map<Integer, QueuePeople> map) {
        if (map.isEmpty()) return -1;
        int index = 0;
        int count = map.get(0).size();
        boolean flag = false;
        for (Map.Entry<Integer, QueuePeople> m : map.entrySet()) {
            int key = m.getKey();
            int tmp = m.getValue().size();
            if (tmp > 0) flag = true;
            if (tmp < count) {
                count = tmp;
                index = key;
            }
            if (tmp == count) {
                index = (int) (Math.random() * 2) == 1 ? key : index;
            }
        }
        return index == 0 && !flag ? (int) (Math.random() * map.size()) :index;
    }

    private static void addPerson(Map<Integer, QueuePeople> map, ThePerson person) {
        int index = mostEmptyQueue(map);
        if (index == -1) return;
        map.computeIfPresent(index, (k, v) -> {
            v.insert(person);
            return v;
        });
    }

    public static void main(String[] args) {
        Map<Integer, QueuePeople> map = new HashMap<>();
        ThePerson[] persons = new ThePerson[]{
                new ThePerson(2, 1),
                new ThePerson(1, 2),
                new ThePerson(3, 3),
                new ThePerson(1, 4),
                new ThePerson(1, 5),
                new ThePerson(1, 6),
                new ThePerson(1, 7)
        };
        map.put(0, new QueuePeople(4));
        map.put(1, new QueuePeople(5));
        map.put(2, new QueuePeople(5));
        for (ThePerson person : persons) {
            Store.addPerson(map, person);
        }
        new Store(map).boxOffice.forEach((k, v) -> {
            System.out.println(v.getViewQueue());
        });
    }
}

class ThePerson {
    private int time;
    private final int id;

    ThePerson(int time, int id) {
        this.time = time;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setTime(int t) {
        time = t;
    }

    public int getTime() {
        return time;
    }
}

class QueuePeople {
    private final int maxSize;
    private final ThePerson[] arr;
    private int front;
    private int rear;
    private int nElems;

    QueuePeople(int maxSize) {
        this.maxSize = maxSize;
        this.arr = new ThePerson[maxSize];
        this.front = this.nElems = 0;
        this.rear = -1;
    }

    public void insert(ThePerson v) {
        if (rear == nElems) {
            rear = -1;
        }
        arr[++rear] = v;
        nElems++;
    }

    public ThePerson remove() {
        ThePerson person = arr[front++];
        nElems--;
        return person;
    }

    public ThePerson peek() {
        return arr[front];
    }

    public boolean isEmpty() {
        return nElems == 0;
    }

    public int size() {
        return nElems;
    }

    public boolean isFull() {
        return nElems == maxSize;
    }

    public void display() {
        Arrays.stream(arr).forEach(thePerson ->
                System.out.printf(
                        "Person id is %s, time is %s m",
                        thePerson.getId(),
                        thePerson.getTime())
        );
    }

    public String getViewQueue() {
        int time = 0;
        StringBuilder str = new StringBuilder();
        str.append("[ \n\t");
        for (ThePerson person : arr) {
            Optional<ThePerson> op = Optional.ofNullable(person);
            if (op.isPresent()) {
                str.append("id = ")
                        .append(person.getId())
                        .append(", time = ")
                        .append(person.getTime())
                        .append(", \n\t");
                time += person.getTime();
            }
        }
        str.append("\r]").append(" fullTime = ").append(time).append("\n");
        return str.toString();
    }
}

