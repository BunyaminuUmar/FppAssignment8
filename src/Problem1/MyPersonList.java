package Problem1;

import java.util.Arrays;

public class MyPersonList {
    private final int INITIAL_LENGTH = 4;
    private Person[] currentArray;
    private int numOfElements;

    public MyPersonList() {
        currentArray = new Person[INITIAL_LENGTH];
        numOfElements = 0;
    }

    // Add element at the end
    public void add(Person person) {
        if (person == null) return;
        if (numOfElements == currentArray.length)
            resize();
        currentArray[numOfElements++] = person;
    }

    public Person get(int i) {
        if (i < 0 || i >= numOfElements) {
            return null;
        }
        return currentArray[i];
    }

    private void resize() {
        System.out.println("Resizing");
        int len = currentArray.length;
        int newLen = 2 * len;
        Person[] newArray = new Person[newLen];
        System.arraycopy(currentArray, 0, newArray, 0, len);
        currentArray = newArray;
    }

    public boolean isEmpty() {
        return (numOfElements == 0);
    }

    public boolean find(String lastName) {
        if (lastName == null) return false;
        for (int i = 0; i < numOfElements; i++) {
            if (currentArray[i].getLastName().equals(lastName)) return true;
        }
        return false; // element not in the list
    }


    public void insert(Person person, int pos) {
        if (pos > numOfElements || pos < 0) return;
        if (numOfElements == currentArray.length) {
            resize();
        }
        Person[] temp = new Person[currentArray.length];
        System.arraycopy(currentArray, 0, temp, 0, pos);
        temp[pos] = person;
        System.arraycopy(currentArray, pos, temp, pos + 1, currentArray.length - (pos + 1));
        currentArray = temp;
        ++numOfElements;
    }

    public boolean remove(String lastName) {
        if (numOfElements == 0) return false;
        if (lastName == null) return false;
        int index = -1;
        for (int i = 0; i < numOfElements; ++i) {
            if (currentArray[i].getLastName().equals(lastName)) {
                index = i;
                break;
            }
        }
        if (index == -1) return false;
        Person[] temp = new Person[currentArray.length];
        System.arraycopy(currentArray, 0, temp, 0, index);
        System.arraycopy(currentArray, index + 1, temp, index, currentArray.length - (index + 1));
        currentArray = temp;
        --numOfElements;
        return true;
    }


    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < numOfElements - 1; i++) {
            sb.append(currentArray[i] + ",");
        }
        sb.append(currentArray[numOfElements - 1] + "]");
        return sb.toString();
    }

    public int size() {
        return numOfElements;
    }

    public Object clone() {
        Person[] temp = Arrays.copyOf(currentArray, numOfElements);
        return temp;
    }

    public static void main(String[] args) {
        MyPersonList personList = new MyPersonList();
        Person person1 = new Person("Bunyaminu", "Umar", 30);
        Person person2 = new Person("Nuhu", "Ayisha", 25);
        Person person3 = new Person("Husseini", "Abdullah", 35);

        personList.add(person1);
        personList.add(person2);
        personList.add(person3);

        System.out.println("Finding Bunyaminu: " + personList.find("Bunyaminu"));

        personList.remove("Bunyaminu");

        System.out.println(personList);
    }
}
