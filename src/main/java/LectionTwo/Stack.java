package LectionTwo;

import java.util.ArrayList;

public class Stack {
    ArrayList<Object> array;
    public Stack() {
        array = new ArrayList<>();
    }
    public Object pop() {
        if (array.isEmpty()) {
            return null;
        } else {
            Object lastEntry = array.get(array.size()-1);
            array.remove(array.size()-1);
            return lastEntry;
        }
    }
    public void push(Object o) {
        array.add(o);
    }
    public Object top() {
        if (array.isEmpty()) {
            return null;
        } else {
            return array.get(array.size()-1);
        }
    }
}
