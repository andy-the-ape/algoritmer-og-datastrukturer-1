package LectionTwo;

public class LinkedList {
    LinkNode head;
    public LinkedList(Object o) {
        this.head = new LinkNode(o);
    }
    public int getSize() {
        int count = 0;
        LinkNode testHead = head;
        while (testHead != null) {
            testHead = testHead.next;
            count++;
        }
        return count;
    }
    public void printList() {
        LinkNode testHead = head;
        while (testHead != null) {
            System.out.println(testHead.o);
            testHead = testHead.next;
        }
    }
    public boolean checkForValue(Object o) {
        LinkNode testHead = head;
        while (testHead != null) {
            if (testHead.o.equals(o)) {
                return true;
            }
            testHead = testHead.next;
        }
        return false;
    }
    public void addValueIfItDoesNotExist(Object o) {
        if (!checkForValue(o)) {
            LinkNode newNode = new LinkNode(o);
            if (head == null) {
                head = newNode;
            } else {
                LinkNode current = head;
                while (current.next != null) {
                    current = current.next;
                }
                current.next = newNode;
            }
        } else {
            System.out.println("Value "+o+" already exists in the LinkedList.");
        }
    }
}
