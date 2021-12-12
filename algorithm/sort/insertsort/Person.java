package algorithm.sort.insertsort;

import java.util.Arrays;
import java.util.Iterator;

public class Person {
    private String lastName;
    private String firstName;
    private int age;

    public Person(String lastName, String firstName, int age) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.age = age;
    }

    public void display() {
        System.out.printf(" Last name : %s, first name: %s, age: ", lastName, firstName, age);
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public String toString() {
        return "Person{"
                + "lastName='" + lastName + '\''
                + ", firstName='" + firstName + '\''
                + ", age=" + age
                + '}';
    }
}

class ArrayInOb {
    private Person[] a;
    private int nElems;

    public ArrayInOb(int max) {
        this.a = new Person[max];
        this.nElems = 0;
    }

    public void insert(String last, String first, int age) {
        a[nElems] = new Person(last, first, age);
        nElems++;
    }

    public void display() {
        Iterator iterator = Arrays.stream(a).iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    public void insertSort() {
        int in, out;
        for (out = 1; out < nElems; out++) {
            Person tmp = a[out];
            in = out;
            while (in > 0 && a[in - 1].getLastName().compareTo(tmp.getLastName()) > 0) {
                a[in] = a[in - 1];
                --in;
            }
            a[in] = tmp;
        }
    }
}

class ObjectStorApp {
    public static void main(String[] args) {
        int maxSize = 3;
        ArrayInOb arr = new ArrayInOb(maxSize);
        arr.insert("Igor", "Sivolobov", 34);
        arr.insert("Alina", "Sivolobova", 35);
        arr.insert("Fedor", "Sivolobov", 9);
        arr.display();
        System.out.println(System.lineSeparator());
        arr.insertSort();
        arr.display();
    }
}
