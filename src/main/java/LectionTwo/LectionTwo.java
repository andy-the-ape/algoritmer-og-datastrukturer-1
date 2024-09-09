package LectionTwo;

public class LectionTwo {
    public static void main(String[] args) {
        System.out.println(
                balPar("hej(dette er en test)()()")
        );
        queueTest();
        linkedListTest();

    }

    public static boolean balPar(String text) {
        Stack stack = new Stack();
        for (char c : text.toCharArray()) {
            if (c == '(') {
                stack.push(c);
            }
            if (c == ')') {
                if (stack.top() == null) {
                    return false;
                } else {
                    stack.pop();
                }
            }
        }
        return stack.top() == null;
    }

    public static void queueTest() {
        Queue queue = new Queue();
        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);
        }
        System.out.println(queue.deQueue());
        System.out.println(queue.deQueue());
        System.out.println(queue.deQueue());
        System.out.println(queue.deQueue());
    }

    public static void linkedListTest() {
        LinkedList linkedList = new LinkedList("Hello");
        linkedList.addValueIfItDoesNotExist("World");
        linkedList.addValueIfItDoesNotExist("This");
        linkedList.addValueIfItDoesNotExist("is");
        linkedList.addValueIfItDoesNotExist("Andy");
        linkedList.addValueIfItDoesNotExist("speaking");
        System.out.println("LinkedList size = "+linkedList.getSize());
        linkedList.printList();
    }
}
