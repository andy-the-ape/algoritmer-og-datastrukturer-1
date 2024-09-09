package LectionTwo;

public class Queue {
    Object[] array;
    public Queue() {
        array = new Object[10];
    }
    public String enqueue(Object o) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == null) {
                array[i] = o;
                return "Succesfully queued "+o+" at place "+i+" in the queue";
            }
        }
        return "Error: The queue is full";
    }
    public Object deQueue() {
        if (array[0] == null) {
            return null;
        } else {
            Object o = array[0];
            for (int i = 0; i < array.length-1; i++) {
                array[i] = array[i+1];
            }
            return o;
        }
    }
}
